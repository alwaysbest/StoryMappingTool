package nju.software.util;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Time       : 2019/1/9 5:41 PM
 * Author     : tangdaye
 * Description: 字符串工具类测试
 */
public class StringUtilTest {
    @Test
    public void test1() {
        String md5 = StringUtil.getMD5("123456");
        assertEquals("a448410bdcbb4d7cfb32830909f6aa08", md5);
    }

    @Test
    public void test2() {
        String str = StringUtil.generateRandomString(4);
        System.out.println(str);
        assertEquals(4, str.length());
    }
}
