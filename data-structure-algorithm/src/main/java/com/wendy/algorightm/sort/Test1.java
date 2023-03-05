package com.wendy.algorightm.sort;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/11/3 21:19
 * @Version 1.0
 */
public class Test1 {
    public static void main(String[] args) {
        //每天要存储的钱是2.5元
        double dayMoney = 2.5;
        //存钱的初始化值是0
        double daySum = 0;
        //从第一天开始存储
        int dayCount = 1;
        //因为不知道是多少天，所以我用死循环，
        while(daySum<100) {
            //累加钱
            daySum += dayMoney;
            if(daySum>=100){
                break;
            }
            if(dayCount%5 == 0) {
                daySum -= 6;
            }
            dayCount++;
        }
        System.out.println("共花了"+dayCount+"天存储了100元");
    }
}
