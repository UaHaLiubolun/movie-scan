package cn.stark.movie.scan.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static String get(String properties, String name) {
        try {
            InputStream in = ClassLoader.getSystemResourceAsStream(properties);
            Properties p = new Properties();
            p.load(in);
            return p.getProperty(name);
        } catch (Exception e) {
            return null;
        }
    }

    public static String get(String properties, String key, String d) {
        return get(properties, key) == null ? d : get(properties, key);
    }

    public static String getDefault(String key, String d) {
        return get("scan-config.properties", key, d);
    }
}
