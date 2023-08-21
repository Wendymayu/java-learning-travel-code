package com.wendy.basic.practice.buy_ticket;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/8/5 10:18
 * @Version 1.0
 */
public class SouthStation {
    private Integer windowNum;

    private Integer ticketNum;

    public SouthStation(Integer windowNum, Integer ticketNum) {
        this.windowNum = windowNum;
        this.ticketNum = ticketNum;
    }

    public void sellTicket() {
        SaleWindow saleWindow = new SaleWindow(ticketNum);
        for (int i = 0; i < windowNum; i++) {
            Thread thread = new Thread(saleWindow, "窗口" + i);
            thread.start();
        }
    }
}
