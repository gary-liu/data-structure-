package com.mimi.datastruct.sort;


import org.junit.Test;

/**
 * create by gary 2020/1/6
 * 技术交流请加QQ:498982703
 */
public class InsertSort {

    /*不引入第三个变理使用变量 a,b 值 交换*/

    @Test
    public void testExchange() {
        int a = 2 ,b =3;
        a = a+b ;//5
        b = a - b;//5-3 = 2
        a = a - b;//5-2= 3
        System.out.println("a:"+a);
        System.out.println("b:" + b);
    }

    /*引入第三方变量 交换a,b 的值 */
    @Test
    public void testExchange2() {
        int a = 2,b = 3;
        int c =a ;//c = 2
        a=b ;//a = 3
        b= c;// b= 2
        System.out.println("a:" + a);
        System.out.println("b:" + b);

    }


}
