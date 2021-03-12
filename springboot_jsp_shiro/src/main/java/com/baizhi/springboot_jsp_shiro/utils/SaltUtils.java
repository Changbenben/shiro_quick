package com.baizhi.springboot_jsp_shiro.utils;

import java.util.Random;

public class SaltUtils {
    /**
     * 生成n位随机盐
     * @param n
     * @return
     */
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890-=[],./".toCharArray();
        StringBuilder sb= new StringBuilder() ;
        for (int i = 0; i < n; i++) {
                sb.append(chars[new Random().nextInt(chars.length)]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSalt(4));
    }

}


