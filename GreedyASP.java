// 알고리즘 - 그리디 알고리즘
// Activity Selection Problem

import java.util.ArrayList;
import java.util.Collections;

class Activity {
    String name;
    int start;
    int end;

    public Activity(String name, int start, int end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}

public class GreedyASP {
    public static void selectActivity(ArrayList<Activity> list) {
        // 종료시간 기준 오름차순 정렬 - 또는 클래스에 comparator 상속받아서 미리 설정 가능
        Collections.sort(list, (x,y) -> x.end - y.end);

        ArrayList<Activity> result = new ArrayList<>();

        int curTime = 0;
        for (Activity item : list){
            if (curTime <= item.start){
                result.add(item);
                curTime = item.end;
            }
        }

        for (Activity item:result){
            System.out.print(item.name + " ");
        }
    }

    public static void main(String[] args) {
        // Test code
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity("A", 1, 5));
        list.add(new Activity("B", 4, 5));
        list.add(new Activity("C", 2, 3));
        list.add(new Activity("D", 4, 7));
        list.add(new Activity("E", 6, 10));
        selectActivity(list);
    }
}
