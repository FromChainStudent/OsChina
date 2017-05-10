package com.example.oschina.net;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public interface RetrofitInter {
    @GET
    Call<ResponseBody> parsingGets(@Url String url, @QueryMap Map<String, String> map);

    @GET
    Call<ResponseBody> parsingGet(@Header("Cookie") String cookie, @Url String url, @QueryMap Map<String, String> map);
    @FormUrlEncoded
    @POST
    Call<ResponseBody> parsingPost(@Url String url, @QueryMap Map<String, String> map);
}
