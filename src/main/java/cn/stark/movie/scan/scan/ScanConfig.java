package cn.stark.movie.scan.scan;

import cn.stark.movie.scan.util.PropertiesUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class ScanConfig {

    private String address;

    /**
     * 深度 默认为3
     */
    private int deep = 3;

    /**
     * 后缀
     */
    private List<String> suffix;

    public ScanConfig(String address, List<String> suffix) {
        this.address = address;
        this.suffix = suffix;
    }

    private final static String CONFIG = "scan-config.properties";

    private final static String ADDRESS = "address";

    private final static String SUFFIX = "suffix";

    public static List<ScanConfig> get() {
        String address = PropertiesUtil.get(CONFIG, ADDRESS, "");
        String suffix = PropertiesUtil.get(CONFIG, SUFFIX, "");
        List<String> stringList = Arrays.asList(suffix.split(";"));
        String[] a = address.split(";");
        List<ScanConfig> scanConfigs = new ArrayList<>();
        for (String tmp : a){
            if (StringUtils.isBlank(tmp)) {
                continue;
            }
            scanConfigs.add(new ScanConfig(tmp, stringList));
        }
        return scanConfigs;
    }

}
