package utilities;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {
    private static final String CONFIG_PROPERTIES = FilePaths.USER_DIR_PATH + "/src/main/resources/config.properties";

    private static Properties properties;

    public static void loadProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(CONFIG_PROPERTIES));
    }

    public static String getProperty(String property) throws IOException {
        loadProperties();
        return properties.getProperty(property);

    }

    public static void loadProperties(String path) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(path));
    }

    public static String getProperty(String propertyPath,String property) throws IOException {
        loadProperties(propertyPath);
        return properties.getProperty(property);

    }

}
