/*
 * module: fundermental
 * file: FindSequenceMiddleNumber.java
 * date: 3/18/20 9:08 AM
 * author: VectorJu
 */

/**
 * @create 2020-03-18 09:08
 * @desc 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 一般如果题目要求时间复杂度在O(log(n))，大部分都是可以使用二分的思想来进行求解。
 * 如果只有一个有序数组，我们需要找中位数，那肯定需要判断元素是奇数个还是偶数个，
 * 如果是奇数个那最中间的就是中位数，如果是偶数个的话，那就是最中间两个数的和除以2。
 * 那如果是两个数组，也是一样的，我们先求出两个数组长度之和。如果为奇数，就找中间的那个数，也就是 (长度之和+1)/2 。
 * 如果为偶数，那就找 长度之和/2。比如下面的 (9+5)/2 = 7，那我们最终就是找到排列第7位的值。
 * 此时，问题其实已经转化为“找到两个数组中第k小的元素”。
 * 找到了第7位之后，第8位我们已经知道了，然后第7位和第8位的和，除以2就是我们要找的中位数
 * 在的问题是，我们如何用二分的思想来找到中间排列第7位的数。
 * 这里有一种不太好想到的方式，是用删的方式，
 * 因为如果我们可以把多余的数排除掉，最终剩下的那个数，是不是就是我们要找的数？
 * 对于上面的数组，我们可以先删掉 7/2=3 个数。
 * 那这里，可以选择删上面的，也可以选择删下面的。
 * 那这里因为 i<j，所以我们选择删除上面的3个数。
 **/
package com.xlab.service_java_infrastructure.algorithm;

public class FindSequenceMiddleNumber {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                int len1 = nums1.length;
                int len2 = nums2.length;
                int total = len1 + len2;
                int left = (total + 1) / 2;
                int right = (total + 2) / 2;
                return (findK(nums1, 0, nums2, 0, left) + findK(nums1, 0, nums2, 0, right)) / 2.0;

    }

    //找到两个数组中第k小的元素
    public int findK(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length)
                return nums2[j + k - 1];
        if (j >= nums2.length)
                return nums1[i + k - 1];
        if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }
        //计算出每次要比较的两个数的值，来决定 "删除"" 哪边的元素
        int mid1 = (i + k / 2 - 1) < nums1.length ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int mid2 = (j + k / 2 - 1) < nums2.length ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        //通过递归的方式，来模拟删除掉前K/2个元素
        if (mid1 < mid2) {
                return findK(nums1, i + k / 2, nums2, j, k - k / 2);
            }
        return findK(nums1, i, nums2, j + k / 2, k - k / 2);
    }

    public static void main(String[] args) {
        int[] candidates1 = new int[]{1,3,5,7,9,11,12,13,14};
        int[] candidaates2 = new int[]{2,4,6,8,10};
        FindSequenceMiddleNumber findSequenceMiddleNumber = new FindSequenceMiddleNumber();
        long start = System.nanoTime();
        double result = findSequenceMiddleNumber.findMedianSortedArrays(candidates1,candidaates2);
        System.out.println(result);
        System.out.println("costs " + (System.nanoTime() - start));
    }
}

