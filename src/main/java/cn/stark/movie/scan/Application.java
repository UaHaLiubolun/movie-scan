package cn.stark.movie.scan;


import cn.stark.movie.scan.http.DouBanHttp;
import cn.stark.movie.scan.http.HttpServiceGenerate;
import cn.stark.movie.scan.scan.FileInfo;
import cn.stark.movie.scan.scan.ScanConfig;
import cn.stark.movie.scan.scan.ScanMovie;
import retrofit2.Call;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<ScanConfig> scanConfigs = ScanConfig.get();
        List<FileInfo> fileInfos = new LinkedList<>();
        scanConfigs.forEach(scanConfig -> {
            ScanMovie scanMovie = new ScanMovie(scanConfig);
            fileInfos.addAll(scanMovie.scanFile());
        });
        fileInfos.forEach(fileInfo -> System.out.println(fileInfo.getName()));
        DouBanHttp douBanHttp = HttpServiceGenerate.douBanHttp();
        Call<String> stringCall = douBanHttp.save(fileInfos);
        try {
            System.out.println(stringCall.execute().body());
        }catch (IOException e) {

        }
    }
}
