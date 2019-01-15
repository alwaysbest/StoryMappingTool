package nju.software.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    public static Date string2Date(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        try {
            return sdf.parse(str);
        } catch (ParseException e) {
            return new Date();
//            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<Integer>();
        int[] a = {7, 3, 2, 4, 6, 5, 1};
        for (int i = 0; i < 7; i++) {
            int j = 0;
            for (; j < test.size(); j++) {
                if (test.get(j) >= a[i]) {
                    break;
                }
            }
            test.add(j, a[i]);
        }
        System.out.println(test);
    }


}
