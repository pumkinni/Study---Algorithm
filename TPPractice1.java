
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
