
public class TPPractice3 {
    public static String solution(String s) {
        if (s == null){
            return null;
        }
        if (s.length() < 2){
            return s;
        }

        s = removeSpaces(s);
        char[] cArr = s.toCharArray();
        reverseString(cArr, 0, s.length()-1);

        reverseWords(cArr, cArr.length);


        return new String(cArr);
    }

    public static String removeSpaces(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int p1 = 0;
        int p2 = 0;

        while (p2 < length){
            while (p2 < length && chars[p2] == ' '){
                p2++;
            }

            while (p2 < length && chars[p2] != ' '){
                chars[p1++] = chars[p2++];
            }

            while (p2 < length && chars[p2] == ' '){
                p2++;
            }

            if (p2 < length){
                chars[p1++] = ' ';
            }
        }
        return new String(chars).substring(0, p1);
    }

    public static void reverseString(char[] cArr, int i, int j) {
        while (i<j){
            char tmp = cArr[i];
            cArr[i] = cArr[j];
            cArr[j] = tmp;
            i++;
            j--;
        }
    }

    public static void reverseWords(char[] cArr, int length) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < length){
            while (p1 < p2 || p2<length && cArr[p1] == ' '){
                p1++;
            }
            while (p2 < p1 || p2 < length && cArr[p2] != ' '){
                p2++;
            }

            reverseString(cArr, p1, p2-1);

        }


    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello      java    "));

    }
}
