package utilities;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigFiles {


    public Properties getPropertyValue() throws IOException {
        Properties prop = new Properties();
        InputStream inputstream = null;

        try {
            String propFileName = "config.properties";
            inputstream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputstream != null) {
                prop.load(inputstream);
            } else {
                throw new FileNotFoundException("Property File " + propFileName + " not found in the classpath");
            }

        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
        } finally {
            inputstream.close();
        }

        return prop;
    }
}
