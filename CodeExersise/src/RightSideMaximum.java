import java.util.Arrays;

public class RightSideMaximum {

    public static int[] findRightMaximum(int[] arr){
        int n = arr.length;
        int[] result = new int[n];
        int maxValue = arr[n-1];
        for (int i = n-1; i >=0; i--){
            if (arr[i] > maxValue){
                maxValue = arr[i];
            }
            result[i] = maxValue;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,3,9,8,7};
        int[] arr1 = {4, 9, 1, 3, 7, 8};
        int[] result = findRightMaximum(arr1);
        System.out.println(Arrays.toString(result));
    }
}
