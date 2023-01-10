// 2차원 행렬에서 이진 탐색으로 데이터 찾기

// 방법 1
// 행의 인덱스를 이진 탐색으로 찾고, 열의 인덱스를 이진 탐색을 찾기
// 방법 2
// 배열을 각각 인덱스를 매겨서 row = 인덱스 / col 길이, col = 인덱스 % col 길이 로두고 이진 탐색

public class BSPractice3 {
    public static boolean solution(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length;
        int idx = 0;

        // 행 구하기
        while (left <= right){
            int mid = (left + right) / 2;
            if (matrix[mid][0] <= target && target <= matrix[mid][matrix.length]){
                idx = mid;
                break;
            } else if (matrix[mid][0] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // 열 구하기
        int[] arr = matrix[idx];
        left = 0;
        right = arr.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] == target){
                return true;
            }
            if (arr[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test code
        int[][] matrix = {{1, 3, 7, 8}, {10, 11, 15, 20}, {21, 30, 35, 60}};
        System.out.println(solution(matrix, 3));    // true
        System.out.println(solution(matrix, 13));   // false
        System.out.println(solution(matrix, 35));   // true
    }
}
