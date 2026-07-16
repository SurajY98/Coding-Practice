import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArraysFrequency {
    public static void main(String[] args) {
        List<Integer> inputArray = Arrays.asList(2,2,1,2,4,3,4,1);

//        Frequency count
        Map<Integer, Long> frequencyMap =  inputArray.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

//        Sort according to frequency
        List<Integer> result = inputArray.stream().sorted(
                (a, b) -> frequencyMap.get(b).compareTo(frequencyMap.get(a))).toList();
        System.out.println(result);
    }
}
