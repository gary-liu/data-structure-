package com.mimi.datastruct.binary;

import org.junit.Test;

/**
 * create by gary 2020/2/7
 * 技术交流请加QQ:498982703
 *
 * 不同进制的组成
 * 二进制
 * 由0，1 组成 。以0b开头(b可以是大写也可以是小写)
 * 八进制
 * 由0,1..7组成  以0开头
 * 十进制
 * 由0,1,2..9组成 。整数默认是十进制的1
 * 十六进制
 * 由0,1..9 a，b,c ,d e,f （大小写均可）.以 0x开头(x可以是大写也可以是小写)
 */
public class BinaryTest {

    /*100在各种不同进制中所表示的数据是什么*/
    @Test
    public void transTest() {
        int a = 100;//十进制
        System.out.println(a);
        System.out.println("=============");
        int b = 0b100;//二进制
        System.out.println(b);

        System.out.println("==============");
        int c = 0100;//八进制
        System.out.println(c);
        System.out.println("==============");
        int d = 0x100;//十六进制
        System.out.println(d);


    }

    /*任意进制到十进制之间的转换
    *
    * 系数：每一个位上的数字（157，个位系数是：7 ，十位系数是5 百位系数是1）
    * 基数：几进制基数就是几（十进制基数就是10)
    * 权:一个数据从右往左数，从0开始，对每一位数据进行编号
    * 那么这个编号就是这个位置上数字的权
    * 157
    * 210
    *
    * 规律：
    * 任意进制到十进制的转换都等于这个数据的各个位上的系数乘以基数的权次幂相加的和
    * 十进制：
    * 157 = 7*10^0+ 5*10^1+1*10^2
    * 二进制
    * 0b100 = 0*2^0+0*2^1+1*2^2=0+0+4= 4
    *八进制
    * 0101 = 1*8^0+0*8^1+1*8^2= 1+0+64=65
    * 十六进制
    * 0x101 = 1*16^0 + 0*1^1+1*16^2 = 1+0+256=257
    *
    * 十进制转换成二进制 八进制 十六进制
     * 规则：除基数取余数，直到商为0，余数反转
    *
    * */
    @Test
    public void transTo10Test() {
        int a =0144;
        System.out.println(a );
        int b= 0x64;
        System.out.println(b);

    }


}
