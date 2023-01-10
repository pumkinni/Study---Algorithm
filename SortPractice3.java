// Practice3
// intervals 라는 구간으로 이루어진 배열이 주어졌을 때,
// 오버랩 되는 구간을 합치는 프로그램을 작성하세요.

// 입출력 예시
// 입력: [2, 6], [1, 3], [15, 18], [8, 10]
// 출력: [1, 6] [8, 10] [15, 18]

// 방법 1
// 각 입력들의 구간을 배열을 만들어 채워준다.

// 방법 2
// index 0 의 값들을 기준으로 오름차순 정렬을 한 후
// 앞 배열의 index1 > 뒤 배열의 index0이면 index1을 index0으로 바꾸어 합쳐준다.

import java.util.*;

public class SortPractice3 {

    public static ArrayList<int[]> solution(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();


        for (int[] interval : intervals){
            for (int i = interval[0]; i < interval[1] + 1; i++) {
                map.put(i, map.getOrDefault(i,0)+1);
            }
        }


        int start = 0;
        int end = 0;
        int pre = 0;
        for (int num : map.keySet()){
            if (pre == 0){
                start = num;
            } else {
                if (num == pre + 1) {
                    end = num;
                } else {
                    list.add(new int[]{start, end});
                    start = num;
                }
            }
            pre = num;
        }
        list.add(new int[]{start, end});

        return list;
    }

    public static void sort(int[][] intervals) {

    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        for (int[] item: solution(intervals)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();

    }
}
