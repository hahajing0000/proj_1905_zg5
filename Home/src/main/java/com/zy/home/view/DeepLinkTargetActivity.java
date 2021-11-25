package com.zy.home.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.zy.home.R;
import com.zy.home.utils.AESUtils;
import com.zy.home.utils.MD5Utils;
import com.zy.home.utils.RSAUtils;
import com.zy.home.utils.SHAUtils;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;
import java.util.Base64.Encoder;

public class DeepLinkTargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_link_target);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            String test="我是1905佩奇";
//            byte[] encode = Base64.getEncoder().encode(test.getBytes());
//            String target=new String(encode);
//
//            byte[] decode = Base64.getDecoder().decode(encode);
//            String decodeTarget=new String(decode);
//            decodeTarget.toString();
//        }

//        String txt="我是佩奇";
//        byte[] encode = android.util.Base64.encode(txt.getBytes(), android.util.Base64.DEFAULT);
//        String encodeStr=new String(encode);
//
//        byte[] decode = android.util.Base64.decode(encodeStr, android.util.Base64.DEFAULT);
//        String decodeStr=new String(decode);

//        String str="123456佩奇";
//
//        String encrypt = AESUtils.getInstance().encrypt(str, "123");
//        String decrypt = AESUtils.getInstance().decrypt(encrypt, "123");
//
//        Log.d("123", String.format("encrypt => %s\n decrypt => %s\n",encrypt,decrypt));

        String str="123456佩奇";

        try {
//            PublicKey publicKey = RSAUtils.getPublicKey("publicKey");
//            PrivateKey privateKey = RSAUtils.getPrivateKey("publicKey");

//            KeyPair keyPair = RSAUtils.generateRSAKeyPair(1024);
//            PublicKey publicKey = keyPair.getPublic();
//            PrivateKey privateKey = keyPair.getPrivate();
//
//            byte[] encrypt = RSAUtils.encrypt(str, publicKey);
//            String encryptStr=new String(encrypt,"UTF-8");
//            byte[] decrypt = RSAUtils.decrypt(encrypt, privateKey);
//            String decryptStr=new String(decrypt,"UTF-8");
//            Log.d("123", String.format("encrypt => %s\n decrypt => %s\n",encryptStr,decryptStr));

            String md5 = MD5Utils.md5(str);
            String md5_2=MD5Utils.md5(str+" ");
            String sha1 = SHAUtils.sha1(str);
            String sha224 = SHAUtils.sha224(str);
            String sha384 = SHAUtils.sha384(str);
            String sha512 = SHAUtils.sha512(str);

            Log.d("123", "onCreate: ");


        } catch (Exception e) {
            e.printStackTrace();
        }


        String username = getIntent().getData().getQueryParameter("username");
        String pwd = getIntent().getData().getQueryParameter("pwd");

        Toast.makeText(this, String.format("username=%s pwd=%s",username,pwd), Toast.LENGTH_SHORT).show();
    }
}