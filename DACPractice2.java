

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class DACPractice2 {
    public static Node solution(Node[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divideList(lists, 0, lists.length-1);

    }

    public static Node divideList(Node[] lists, int left, int right){
        if (left == right){
            return lists[left];
        }

        int mid = (left + right) / 2;
        Node l1 = divideList(lists, left, mid);
        Node l2 = divideList(lists, mid+1, right);

        Node merge = merge(l1, l2);

        return merge;
    }

    public static Node merge(Node l1, Node l2){

        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }

        Node merge = new Node(0);
        Node cur = merge;

        while (l1 != null && l2 != null){
            if (l1.val > l2.val){
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        if (l1 != null){
            cur.next = l1;
        }

        if (l2 != null){
            cur.next = l2;
        }

        return merge.next;
    }


    // 문제에 주어진 2차원 배열을 링크드 리스트로 구성
    public static void setUpLinkedList(Node[] node, int[][] lists) {
        for (int i = 0; i < lists.length; i++) {
            node[i] = new Node(lists[i][0]);
        }

        for (int i = 0; i < lists.length; i++) {
            Node cur = node[i];
            for (int j = 1; j < lists[i].length; j++) {
                cur.next = new Node(lists[i][j]);
                cur = cur.next;
            }
        }
    }

    // 결과 출력 부분
    public static void printList(Node node) {
        Node cur = node;
        while (cur.next != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public static void main(String[] args) {
        // Test code
        int[][] lists = {{2, 3, 9}, {1, 5, 7}, {3, 6, 7, 11}};
        Node[] node = new Node[lists.length];
        setUpLinkedList(node, lists);
        Node combinedNode = solution(node);
        printList(combinedNode);
    }
}
