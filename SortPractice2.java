// 1. 각 문자열을 정렬 후 해쉬맵에 넣는다. 정열된 문자는 key에 원본은 value에 넣는다.
// 2. 해쉬맵의 키가 이미 있으면 추가, 없으면 key 생성해서 넣는다.
// 3. 해쉬맵의 값들을 리스트로 변경한다.

import java.util.ArrayList;
import java.util.HashMap;

public class SortPractice2 {
    public static ArrayList<ArrayList<String>> solution(String[] strs) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs){
            char[] arr = str.toCharArray();
            sort(arr);
            String key = String.valueOf(arr);

            if (map.containsKey(key)){
                map.get(key).add(str);
            } else{
                ArrayList list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }


        return new ArrayList<>(map.values());
    }

    public static void sort(char[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j-1]){
                    char tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }

    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"};
        System.out.println(solution(strs));
    }
}
