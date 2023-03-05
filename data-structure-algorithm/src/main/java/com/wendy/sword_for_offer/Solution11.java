package com.wendy.sword_for_offer;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/11/12 14:04
 * @Version 1.0
 */
public class Solution11 {
    public static void main(String[] args) {
        //int[] numbers = {2, 2, 2, 0, 1};
        int[] numbers = {2, 1};
        System.out.println(minArray(numbers));
    }

    static public int minArray(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }
        int leng = numbers.length;
        int mid = leng / 2;
        int[] left = new int[mid];
        int[] right = new int[leng - mid];
        System.arraycopy(numbers, 0, left, 0, mid);

        System.arraycopy(numbers, mid, right, 0, leng - mid);
        int a = minArray(left);
        int b = minArray(right);
        return a > b ? b : a;
    }
}
