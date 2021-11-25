package com.zy.home.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.provider.Settings;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zy.home.R;

import java.security.KeyStore;
import java.util.concurrent.Executor;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import static androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG;
import static androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL;

public class BiometricActivity extends AppCompatActivity {

    private FingerprintManager fingerprintManager;

    //    private static final int REQUEST_CODE = 1001;
//    private Executor executor;
//    private BiometricPrompt biometricPrompt;
//    private BiometricPrompt.PromptInfo promptInfo;

    private Button biometricLogin;

    private CancellationSignal mCancellationSignal;
    private FingerprintManager.AuthenticationCallback callback;
    private KeyStore keyStore;
    private Cipher mCipher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometric);

//        promptInfo = new BiometricPrompt.PromptInfo.Builder()
//                .setTitle("Biometric login for my app")
//                .setSubtitle("Log in using your biometric credential")
//                .setNegativeButtonText("Use account password")
////                .setAllowedAuthenticators(BIOMETRIC_STRONG | DEVICE_CREDENTIAL)
//                .build();
//
//        BiometricManager biometricManager = BiometricManager.from(this);
//        switch (biometricManager.canAuthenticate(BIOMETRIC_STRONG | DEVICE_CREDENTIAL)) {
//            case BiometricManager.BIOMETRIC_SUCCESS:
//                Log.d("MY_APP_TAG", "App can authenticate using biometrics.");
//                break;
//            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
//                Log.e("MY_APP_TAG", "No biometric features available on this device.");
//                break;
//            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
//                Log.e("MY_APP_TAG", "Biometric features are currently unavailable.");
//                break;
//            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
//                // Prompts the user to create credentials that your app accepts.
//                final Intent enrollIntent = new Intent(Settings.ACTION_BIOMETRIC_ENROLL);
//                enrollIntent.putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
//                        BIOMETRIC_STRONG | DEVICE_CREDENTIAL);
//                startActivityForResult(enrollIntent, REQUEST_CODE);
//                break;
//        }
//
//        executor = ContextCompat.getMainExecutor(this);
//        biometricPrompt = new BiometricPrompt(BiometricActivity.this,
//                executor, new BiometricPrompt.AuthenticationCallback() {
//            @Override
//            public void onAuthenticationError(int errorCode,
//                                              @NonNull CharSequence errString) {
//                super.onAuthenticationError(errorCode, errString);
//                Toast.makeText(getApplicationContext(),
//                        "Authentication error: " + errString, Toast.LENGTH_SHORT)
//                        .show();
//            }
//
//            @Override
//            public void onAuthenticationSucceeded(
//                    @NonNull BiometricPrompt.AuthenticationResult result) {
//                super.onAuthenticationSucceeded(result);
//                Toast.makeText(getApplicationContext(),
//                        "Authentication succeeded!", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAuthenticationFailed() {
//                super.onAuthenticationFailed();
//                Toast.makeText(getApplicationContext(), "Authentication failed",
//                        Toast.LENGTH_SHORT)
//                        .show();
//            }
//        });
//
//
//
//        // Prompt appears when user clicks "Log in".
//        // Consider integrating with the keystore to unlock cryptographic operations,
//        // if needed by your app.
//        Button biometricLoginButton = findViewById(R.id.biometric_login);
//        biometricLoginButton.setOnClickListener(view -> {
//            biometricPrompt.authenticate(promptInfo);
//        });
        biometricLogin = (Button) findViewById(R.id.biometric_login);

        if (testFingerprint()){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                callback = new FingerprintManager.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationError(int errorCode, CharSequence errString) {
                        //多次指纹密码验证错误后，进入此方法；并且，不可再验（短时间）
                        //errorCode是失败的次数
                        Toast.makeText(BiometricActivity.this, "尝试次数过多，请稍后重试", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                        //指纹验证失败，可再验，可能手指过脏，或者移动过快等原因。
                    }

                    @Override
                    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {

                        Log.d("123", "onAuthenticationSucceeded: ...");
                        //指纹密码验证成功
                        Toast.makeText(BiometricActivity.this, "Success", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        //指纹验证失败，指纹识别失败，可再验，错误原因为：该指纹不是系统录入的指纹。
                        Toast.makeText(BiometricActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                };

            }
        }

        biometricLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mCancellationSignal = new CancellationSignal();
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    //底部弹框
                    fingerprintManager.authenticate(new FingerprintManager.CryptoObject(mCipher), mCancellationSignal, 0, callback, null);
                }
            }
        });

    }

    private boolean testFingerprint() {
        KeyguardManager keyguardManager = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            keyguardManager = getSystemService(KeyguardManager.class);
        }
        fingerprintManager = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            fingerprintManager = getSystemService(FingerprintManager.class);

            if (fingerprintManager != null) {
                if (!fingerprintManager.isHardwareDetected()) {
                    Toast.makeText(this, "您的手机不支持指纹功能", Toast.LENGTH_SHORT).show();
                    return false;
                } else if (keyguardManager != null) {
                    if (!keyguardManager.isKeyguardSecure()) {
                        Toast.makeText(this, "您还未设置锁屏，请先设置锁屏并添加一个指纹", Toast.LENGTH_SHORT).show();
                        return false;
                    } else if (!fingerprintManager.hasEnrolledFingerprints()) {
                        Toast.makeText(this, "您至少需要在系统设置中添加一个指纹", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                } else {
                    Toast.makeText(this, "键盘管理初始化失败", Toast.LENGTH_SHORT).show();
                    return false;
                }
            } else {
                Toast.makeText(this, "指纹管理初始化失败", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }
    private static final String DEFAULT_KEY_NAME = "default_key";
    // 初始化密钥库
    private void initKey() {
        try {
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
            KeyGenParameterSpec.Builder builder = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                builder = new KeyGenParameterSpec.Builder(DEFAULT_KEY_NAME,
                        KeyProperties.PURPOSE_ENCRYPT |
                                KeyProperties.PURPOSE_DECRYPT)
                        .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                        .setUserAuthenticationRequired(true)
                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7);
                keyGenerator.init(builder.build());
                keyGenerator.generateKey();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 初始化密钥
    private void initCipher() {
        try {
            SecretKey key = (SecretKey) keyStore.getKey(DEFAULT_KEY_NAME, null);
            Cipher cipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/"
                    + KeyProperties.BLOCK_MODE_CBC + "/"
                    + KeyProperties.ENCRYPTION_PADDING_PKCS7);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            setCipher(cipher);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setCipher(Cipher cipher) {
        mCipher = cipher;
    }

}