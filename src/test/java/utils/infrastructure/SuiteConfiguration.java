package utils.infrastructure;

import java.net.MalformedURLException;
import java.net.URL;

public class SuiteConfiguration {


    public static final URL HUB_URL;
    public static final String DEVICE_NAME;
    public static final String AUTOMATION_NAME;
    public static final String PACKAGE_NAME;
    public static final String ACTIVITY_NAME;
    public static final String PLATFORM_VERSION;
    public static final String PLATFORM_NAME;
    static {
        HUB_URL = setHubUrl(System.getProperty("HUB_URL", PropertyLoader.loadProperty("hub.url")));
        DEVICE_NAME = PropertyLoader.loadProperty("device.name");
        AUTOMATION_NAME = PropertyLoader.loadProperty("automation.name");
        PACKAGE_NAME = PropertyLoader.loadProperty("app.package");
        ACTIVITY_NAME = PropertyLoader.loadProperty("app.activity");
        PLATFORM_VERSION = PropertyLoader.loadProperty("platform.version");
        PLATFORM_NAME = PropertyLoader.loadProperty("platform.name");
    }

    private static URL setHubUrl(String hubUrl) {
        URL url = null;
        try {
            url = new URL(hubUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
}

