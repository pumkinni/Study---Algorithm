// Practice
// 정수 num 이 주어졌을 때,
// num 숫자에서 두 자리를 최대 한번만 교체하여 얻을 수 있는 최대값을 출력하세요.

// 입출력 예시
// num: 2736
// 출력: 7236

// 입력: 7116
// 출력: 7611

// 방법1
// 가장 큰 자리수가 최대값을 가지고 있는지 확인 후 아니면 바꾸어 준다.
// 방법2
// 뒤에서 부터 각 자리수의 max값을 구한 후 기존 값과 앞에서 부터 비교하여 다르면 그 값의 인덱스와 바꿀자리의 인덱스를 바꾼다.
public class GreedyPractice5 {
    public static int solution(int num) {
        if (num == 0 || num < 0){
            return 0;
        }

        if (num / 10 == 0){
            return num;
        }

        char[] chars = String.valueOf(num).toCharArray();
        int[] maxIdx = new int[chars.length];
        int maxV = -1;
        int maxI = chars.length-1;


        for (int i = chars.length-1; i >= 0; i--) {
            if (chars[i] > maxV){
                maxIdx[i] = i;
                maxI = i;
                maxV = chars[i];
            } else {
                maxIdx[i] = maxI;
            }
        }

        for (int i = 0; i < maxIdx.length; i++) {
            if (maxIdx[i] != i){
                char tmp = chars[i];
                chars[i] = chars[maxIdx[i]];
                chars[maxIdx[i]] = tmp;
                break;
            }
        }


        return Integer.valueOf(String.valueOf(chars));
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(2736));
        System.out.println(solution(7116));
        System.out.println(solution(91));
    }
}
