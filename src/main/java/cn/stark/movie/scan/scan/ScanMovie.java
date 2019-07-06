package cn.stark.movie.scan.scan;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ScanMovie {

    private ScanConfig scanConfig;

    private int deep;

    public ScanMovie(ScanConfig scanConfig) {
        this.scanConfig = scanConfig;
        deep = 0;
    }


    public List<FileInfo> scanFile() {
        File file = new File(scanConfig.getAddress());
        List<FileInfo> fileInfo = new LinkedList<>();
        scanFile(fileInfo, file);
        return fileInfo;
    }


    private void scanFile(List<FileInfo> fileInfo, File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null || deep >= scanConfig.getDeep()) {
                return;
            }
            for (File f : files) {
                scanFile(fileInfo, f);
            }
        } else {
            String suffix = getSuffix(file.getName());

            if (scanConfig.getSuffix().contains(suffix)) {
                FileInfo fInfo = new FileInfo(scanConfig.getAddress(), getName(file.getName()), file.getAbsolutePath(), suffix, file.length(), getMd5(file));
                fileInfo.add(fInfo);
            }
        }
    }

    private String getSuffix(String name) {
        return name.substring(name.lastIndexOf(".") + 1);
    }

    private String getName(String name) {
        return name.substring(0, name.lastIndexOf("."));
    }

    private String getMd5(File file) {
        try (InputStream inputStream = FileUtils.openInputStream(file)) {
            byte[] bytes = new byte[1024 * 1024];
            IOUtils.read(inputStream, bytes);
            return DigestUtils.md5Hex(bytes);
        } catch (IOException e) {
            return file.getName();
        }
    }
}
