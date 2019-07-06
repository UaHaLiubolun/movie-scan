package cn.stark.movie.scan.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpServiceGenerate {

    private static Retrofit retrofit;

    private static DouBanHttp douBanHttp;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        douBanHttp = retrofit.create(DouBanHttp.class);
    }

    public static Retrofit retrofit() {
        return retrofit;
    }

    public static DouBanHttp douBanHttp() {
        return douBanHttp;
    }
}
