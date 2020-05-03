package com.mimi.datastruct.hash7map;

import org.junit.Test;

import java.util.HashMap;

/**
 * create by gary 2020/2/7
 * 技术交流请加QQ:498982703
 */
public class HashMap7Test {

    public static void main(String[] args) {

        HashMap<String, Object> map = new HashMap<>();

        map.put("gary", "123");
        Object result = map.put("gary", "1");
        System.out.println(result);
        System.out.println(map.get("gary"));


    }

    /*将一个数转换为小于等于他的2幂次方*/
    @Test
    public void testHi() {
        System.out.println(Integer.highestOneBit(6));
        System.out.println(Integer.highestOneBit(16));
        System.out.println(Integer.highestOneBit(10));
    }
}
