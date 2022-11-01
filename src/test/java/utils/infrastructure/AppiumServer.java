package utils.infrastructure;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
    private static AppiumDriverLocalService service;

    public static void startServer() {
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .usingPort(4723)
                .withArgument(GeneralServerFlag.BASEPATH, "/wd/hub/");
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static void stopServer() {
        try {
            service.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}