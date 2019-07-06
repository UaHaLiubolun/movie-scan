package cn.stark.movie.scan.http;

import cn.stark.movie.scan.pojo.bean.MovieBean;
import cn.stark.movie.scan.scan.FileInfo;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface DouBanHttp {

    @GET("/douban/title")
    Call<MovieBean> getMovieBean(@Query("title") String title);

    @POST("/save")
    Call<String> save(@Body List<FileInfo> fileInfos);
}
