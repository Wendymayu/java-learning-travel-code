package com.wendy.basic.net.ip;

import java.net.InetAddress;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/31 13:30
 * @Version 1.0
 */
public class InetAddressDemo {
    public static void main(String[] args) throws Exception {
        InetAddressDemo demo = new InetAddressDemo();
        demo.getByNameTest();
        demo.getByAddressTest();
        demo.getByLocalHostTest();

        demo.getTest();
        demo.typeTest();
    }

    private void getByNameTest() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress);
    }

    private void getByAddressTest() throws Exception {
        byte[] address = {14, (byte) 215, (byte) 177, 38};
        InetAddress inetAddress = InetAddress.getByAddress(address);
        System.out.println(inetAddress);
    }

    private void getByLocalHostTest() throws Exception {
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
    }

    private void getTest() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.getHostName());
        System.out.println(inetAddress.getCanonicalHostName());
        System.out.println(inetAddress.getAddress());
        System.out.println(inetAddress.getHostAddress());
    }

    private void reachableTest() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.isReachable(1000));
    }

    private void typeTest()throws Exception {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.isAnyLocalAddress());
        System.out.println(inetAddress.isLoopbackAddress());
        System.out.println(inetAddress.isLinkLocalAddress());
        System.out.println(inetAddress.isSiteLocalAddress());
        System.out.println(inetAddress.isMulticastAddress());
        System.out.println(inetAddress.isMCGlobal());
        System.out.println(inetAddress.isMCNodeLocal());
        System.out.println(inetAddress.isMCLinkLocal());
        System.out.println(inetAddress.isMCSiteLocal());
        System.out.println(inetAddress.isMCOrgLocal());
    }

}
