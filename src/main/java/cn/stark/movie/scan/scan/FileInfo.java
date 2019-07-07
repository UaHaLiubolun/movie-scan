package cn.stark.movie.scan.scan;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileInfo {

    private String root;

    private String name;

    private String address;

    private String suffix;

    private long size;

    private String md5;

    private double time;

}
