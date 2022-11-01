package utils.infrastructure;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(PropertyLoader.class.getResourceAsStream("/props/general.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = null;

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}
