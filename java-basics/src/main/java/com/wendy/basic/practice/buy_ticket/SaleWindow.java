package com.wendy.basic.practice.buy_ticket;

import lombok.Setter;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/8/5 10:16
 * @Version 1.0
 */
@Setter
public class SaleWindow implements Runnable {
    private Integer ticketNum;

    public SaleWindow(Integer ticketNum) {
        this.ticketNum = ticketNum;
    }

    @Override
    public void run() {
        while (ticketNum > 0) {
            this.ticketNum--;
            System.out.println(Thread.currentThread().getName() + "卖了1张票，剩余车票张数：" + ticketNum);
        }
    }
}
