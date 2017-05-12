package com.example.oschina.module.net;

import android.support.annotation.Nullable;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
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
    Call<ResponseBody> parsingGets(@Url String url, @Nullable@QueryMap Map<String, String> map);

    @GET
    Call<ResponseBody> parsingGet(@Nullable@Header("Cookie") String cookie, @Url String url, @Nullable@QueryMap Map<String, String> map);
   @FormUrlEncoded
   @POST
    Call<ResponseBody> parsingPost(@Url String url, @Nullable@FieldMap Map<String, String> map);
}
