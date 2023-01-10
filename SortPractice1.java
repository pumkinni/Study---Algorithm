
import java.util.Arrays;

public class SortPractice1 {
    // 계수 정렬
    public static void solution(int[] arr) {
        // 예외처리
        if (arr == null || arr.length == 0){
            return;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int[] numCnt = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            numCnt[arr[i]] ++;
        }
        int idx = 0;
        for (int i = 0; i < numCnt.length; i++) {
            while (numCnt[i] > 0){
                arr[idx] = i;
                numCnt[i] --;
                idx ++;
            }
        }


    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {2, 0, 2, 1, 1, 0};
        solution(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        arr = new int[]{2, 0, 1};
        solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
