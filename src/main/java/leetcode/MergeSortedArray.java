package leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortedArray {
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 4, 5, 7, 0, 0, 0, 0, 0, 0};
        int[] nums2 = {2, 4, 6, 9, 10, 11};

        merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
        System.out.println(Arrays.stream(nums1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(",")));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1, j = n - 1, curr = m + n - 1; j >= 0; curr--) {
            nums1[curr] = i >= 0 && nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
    }
}
