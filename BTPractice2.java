
import java.util.ArrayList;

public class BTPractice2 {
    public static ArrayList<Integer> result;

    public static ArrayList<Integer> solution(int n) {
        result = new ArrayList<>();

        checkNext(n,0, 0);



        return result;
    }

    public static void checkNext(int n, int num, int depth){
        if (depth == n){
            result.add(num);
            return;
        }

        for (int i = 0; i < 10; i++) {
            int newNum = i + num * 10;

            if (checkPrime(newNum)){
                checkNext(n, newNum, depth+1);
            }
        }
    }

    public static boolean checkPrime(int num){
        if (num < 2){
            return false;
        }

        for (int i = 2; i <= num/2; i++) {
            if (num % i == 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));
    }
}
