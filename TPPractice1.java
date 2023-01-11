// Practice
// a, b, c, d 로 이루어진 알파벳 문자열에 대해서
// 다음과 같은 규칙으로 문자열을 정리한 후 남은 문자열을 반환하는 프로그램을 작성하세요.
// 양쪽의 문자를 비교한 후 같으면 삭제하는데, 연속해서 같은 문자가 등장하면 함께 삭제한다.
// 최종적으로 남은 문자열을 반환하세요.

// 입출력 예시
// 입력 s: "ab"
// 출력: "ab"

// 입력 s: "aaabbaa"
// 출력: (없음)

// start 는 젤 왼쪽, end 는 젤 오른쪽에 둔다.
// 1. start 의 문자와 end 의 문자를 비교
// (1)start 위치 문자 == end 위치 문자 이면 start ++;, end--;를 하며
// (1)을 시행 후 start 의 움직이기 전 문자와 움직인 후의 문자가 같다면 계속해서 움직인다. end 도 마찬가지
// start 위치 문자 != end 위치 문자 이면 break 후 반환
public class TPPractice1 {
    public static String solution(String s) {
        // 예외 처리
        if (s == null || s.length() == 0){
            return null;
        }
        int start = 0;
        int end = s.length() - 1;

        while (true){
            if (start == end){
                break;
            }
            if (s.charAt(start) == s.charAt(end)){
                char c = s.charAt(start);
                start++;
                end--;
                while (s.charAt(start) == c){
                    start++;
                    if (start > end){
                        return "(없음)";
                    }
                }

                if (start == end){
                    return String.valueOf(s.charAt(start));
                }
                while (s.charAt(end) == c){
                    end--;
                }
            } else {
                break;
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("ab"));         // ab
        System.out.println(solution("aba"));         // b
        System.out.println(solution("aaabbaa"));    //
        System.out.println(solution("aabcddba"));   // cdd
    }
}
