/**
 * @author wangfx
 */
package com.falsee.coding.interview.guide.q1;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 *
 */
public class Q1 {

    public static void main(String[] args) {
        int[] a = {4,3,5,4,3,3,6,7};
        int[] res = getMaxWindow(a, 3);
        for (int i : res) {
            System.out.print(i + ",");
        }

    }
    public static int[] getMaxWindow(int[] arr, int w) {
        if(arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }








}
