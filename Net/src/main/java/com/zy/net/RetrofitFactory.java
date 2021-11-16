package com.zy.net;

import android.util.Log;

import com.zy.net.common.Constanct;
import com.zy.net.protocol.resp.TokenRespEntity;
import com.zy.net.retrofit.calladapter.LiveDataCallAdapterFactory;
import com.zy.net.retrofit.convertfactory.CustomGsonConverterFactory;
import com.zy.net.service.api.TokenApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.net
 * @ClassName: RetrofitFactory
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/15 13:17
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/15 13:17
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RetrofitFactory {
    private static RetrofitFactory instance=null;

    private Retrofit retrofit=null;
    private RetrofitFactory(){
        retrofit=createRetrofit();
    }

    /**
     * 创建Retrofit实例
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/15 13:31
     */
    private Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BaseUrl)
                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .client(createOkHttpClient())
                .build();

    }

    /**
     * 创建OkHttp实例
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/15 13:45
     */ 
    private OkHttpClient createOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(Constanct.TIMEOUT, TimeUnit.MINUTES)
                .readTimeout(Constanct.TIMEOUT,TimeUnit.MINUTES)
                .writeTimeout(Constanct.TIMEOUT,TimeUnit.MINUTES)
                .addNetworkInterceptor(createOkHttpNetInterceptor())
                .addInterceptor(createTokenInterceptor())
                .addInterceptor(createHeadsInterceptor())
                .build();
        return okHttpClient;
    }

    /**
     * 创建请求头拦截器
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/15 13:41
     */ 
    private Interceptor createHeadsInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                return chain.proceed(chain.request());
            }
        };
    }

    /**
     * 处理Token拦截器   ？？？？？
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/15 13:40
     */ 
    private Interceptor createTokenInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                //复用Token
                //如果token已经申请到了  直接将token放入请求头  （Token不存在 Token过期）否则获取
                //建议：你可以使用RAS（私钥 公钥） DES（秘钥串） 加密算法对token进行加密处理 然后存储  秘钥
                Response response = chain.proceed(request);
                if (response.code()==401){
                    //获取到的token
                   String token= doTokenTask();

                    Request newReq = request.newBuilder().addHeader("Authorization", "bearer " + token).build();
                    return chain.proceed(newReq);
                }

                return response;
            }


        };
    }

    /**
     * 处理token请求
     * @param
     * @return
     * @author zhangyue
     * @time 2021/11/15 14:26
     */ 
    private String doTokenTask() {
        TokenApi tokenApi = create(TokenApi.class);
        Call<TokenRespEntity> tokenService = tokenApi.getToken("password", Constanct.getAuthCode(), "");
        try {
            retrofit2.Response<TokenRespEntity> result = tokenService.execute();
            if (result!=null&&result.body()!=null){
                return  result.body().getAccess_token();
            }
        } catch (IOException e) {
            Log.e("123",e.getMessage());
        }
        return "";
    }

    /**
     * 创建日志拦截器
     * @param 
     * @return 
     * @author zhangyue
     * @time 2021/11/15 13:40
     */ 
    private Interceptor createOkHttpNetInterceptor() {
        HttpLoggingInterceptor interceptor=new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public static class Holder{
        private static RetrofitFactory INSTANCE=new RetrofitFactory();
    }

    public static RetrofitFactory getInstance(){
        return Holder.INSTANCE;
    }


    /**
     * 根据API接口获取对应实例
     * @param
     * @return 
     * @author zhangyue
     * @time 2021/11/15 14:28
     */ 
    public <T> T create(Class<?> service){
        return (T)retrofit.create(service);
    }


}
