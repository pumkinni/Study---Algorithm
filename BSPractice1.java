
public class BSPractice1 {
    public static int solution(int[] arr, int target) {

        int left = 0;
        int right = arr.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return mid;
            }

            if (target < arr[mid]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -left -1;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30));  // 5
        System.out.println(solution(arr, 3));   // -3
        System.out.println(solution(arr, 11));  // -5
        System.out.println(solution(arr, 35));  // -7
    }
}
