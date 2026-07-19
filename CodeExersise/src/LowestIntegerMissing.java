import java.util.HashSet;
import java.util.Set;

public class LowestIntegerMissing {

    public static int getLowestInteger(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int num : arr){
            if (num > 0){
                set.add(num);
            }
        }

        int smallest = 1;
        while (true){
            if(!set.contains(smallest)){
                return smallest;
            }
        smallest++;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        System.out.println(getLowestInteger(arr));
    }
}
