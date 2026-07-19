import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int num : arr){
            set.add(num);
        }
        int maxLength = 0;
        for (int num : arr){
            if (!set.contains(num-1)){
                int curr = num;
                int length = 1;

                while (set.contains(curr + 1)){
                    curr++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        int[] arr = {100,4,200,1,6,3,2};
        System.out.println(longestConsecutive(arr));
    }
}
