package cn.stark.movie.scan.http;

import cn.stark.movie.scan.util.PropertiesUtil;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpServiceGenerate {

    private static Retrofit retrofit;

    private static DouBanHttp douBanHttp;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(PropertiesUtil.get("scan-config.properties", "movie-manage-url", ""))
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
