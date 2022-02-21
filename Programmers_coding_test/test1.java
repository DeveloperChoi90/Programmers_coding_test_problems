package Programmers_coding_test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class test1 {
    public static void main(String[] args) {
        int[] arr = {1, 52, 125, 10, 25, 201, 244, 192, 128, 23, 203, 98, 154, 255};
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        Arrays.stream(arr).sorted();
        Set<Integer> set_num = new HashSet<Integer>();
        for(int num : arr) set_num.add(num);
        Integer[] new_arr = set_num.toArray(new Integer[0]);
        int mid = new_arr.length/2;
        System.out.println(mid);
        return new_arr[mid - 1] + 1;
    }
}