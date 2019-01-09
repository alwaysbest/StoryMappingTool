package nju.software.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;


/**
 * Time       : 2019/1/9 5:25 PM
 * Author     : tangdaye
 * Description: 字符串工具类
 */
public class StringUtil {
    @Value("${md5.salt}")
    private static String salt;

    public static String getMD5(String password) {
        return DigestUtils.md5Hex(password + salt);
    }

    public static String generateRandomString(int length) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * (62));
            builder.append(chars.charAt(randomIndex));
        }
        return builder.toString();
    }

}
