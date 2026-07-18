import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SortArrayFrequencyOfOccurrence {
    public static void main(String[] args) {
        int[] arr = {2,2,1,2,4,3,4,1};

//        Step 1 count the frequency
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i = 0; i <arr.length; i++){
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i],0)+1);
        }
//        Step 2: Convert int[] to Integer[]
        Integer[] result = Arrays.stream(arr).boxed().toArray(Integer[]::new);
//        Step 2: Sort based on frequency
        Arrays.sort(result, (a,b)->{
            int compare = frequencyMap.get(b) - frequencyMap.get(a);
            if (compare != 0)
                return compare;

            return Integer.compare(a,b); //When two numbers have the same frequency, we need a secondary sorting rule. which number come first get place first.
        });

        System.out.println(Arrays.toString(result));
    }
}

//Why convert int[] to Integer[]?
//Arrays.sort(int[]) does not accept a custom comparator.
//Comparators work only with object types like Integer.
