package com.wendy.basic.net.ip;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/12/31 14:46
 * @Version 1.0
 */
public class NetworkInterfaceDemo {
    public static void main(String[] args) throws Exception {
        NetworkInterfaceDemo networkInterfaceDemo = new NetworkInterfaceDemo();
        networkInterfaceDemo.getByNameTest();

        networkInterfaceDemo.getByInetAddressTest();

        networkInterfaceDemo.getNetworkInterfacesTest();
    }

    private void getByNameTest() throws Exception {
        NetworkInterface ni = NetworkInterface.getByName("eth0");
        if (ni == null) {
            System.out.println("No such interface: eth0");
        } else {
            System.out.println(ni);
        }
    }

    private void getByInetAddressTest() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
        NetworkInterface ni = NetworkInterface.getByInetAddress(inetAddress);
        if (ni == null) {
            System.out.println("No such interface: eth0");
        } else {
            System.out.println(ni);
        }
    }

    private void getNetworkInterfacesTest() throws Exception {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            NetworkInterface ni = networkInterfaces.nextElement();
            if (ni == null) {
                System.out.println("No such interface: eth0");
            } else {
                System.out.println(ni);
            }
        }
    }
}
