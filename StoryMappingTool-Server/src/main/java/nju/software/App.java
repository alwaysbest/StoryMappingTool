package nju.software;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Time       : 2018/12/25 11:328 PM
 * Author     : tangdaye
 * Description: SpringBoot 运行入口
 */
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.getProperties().put("proxySet", true);
        System.getProperties().put("http.proxyHost", "219.219.113.223");
        System.getProperties().put("http.proxyPort", "81");
        System.getProperties().put("socksProxySet", true);
        System.getProperties().put("socksProxyHost", "219.219.113.223");
        System.getProperties().put("socksProxyPort", "81");
    }
}
