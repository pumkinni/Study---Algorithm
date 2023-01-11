public class DACFindMax {

    public static int getMax(int[] arr, int left, int right) {
        if (left == right){
            return arr[left];
        }

        int mid = (left + right) / 2;
        left = getMax(arr, left, mid);
        right = getMax(arr, mid+1, right);

        return left > right ? left : right;
    }


    public static void main(String[] args) {
        int arr[] = {6, 2, 92, 8, 1, 4, 17, 5};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
