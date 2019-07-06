package cn.stark.movie.scan.pojo.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class MovieBean {

    private String id;

    private List<String> casts;

    private String cover;

    private Date date;

    private List<String> directors;

    private String movieId;

    private String rate;

    private String star;

    private String title;

    private String url;
}
