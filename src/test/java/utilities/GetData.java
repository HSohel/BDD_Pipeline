package utilities;

import java.io.IOException;
import java.util.Properties;

public class GetData {

    public static String getPropertyValue(String propertyName) throws IOException {
        Properties prop;
        ReadConfigFiles objReadConfigFiles=new ReadConfigFiles();
        prop= objReadConfigFiles.getPropertyValue();
        return prop.getProperty(propertyName);
    }
}
