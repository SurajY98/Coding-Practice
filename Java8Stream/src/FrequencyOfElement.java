import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,2,4,3,2,5,3,5,1,2,4,6,7,5,4,5,6,7,8);

        Map<Integer, Long> frequencyMap = list.stream().collect(Collectors
                .groupingBy(Function.identity(), Collectors.counting()));

//        Frequency wise descending order
        List<Integer> result = list.stream().sorted((a,b) -> {
            int freqCompare  = frequencyMap.get(b).compareTo(frequencyMap.get(a));
            if(freqCompare  != 0) { //Equal Frequency suppose 1 freq 2 and 4 freq also 2 in this case
                return freqCompare;
            }
            return Integer.compare(a,b); //
        }).collect(Collectors.toList());

        System.out.println(result);
    }
}
//Interviewer: Why do we use Integer.compare() instead of a - b?
//Answer: Integer.compare(a, b) is the recommended approach because it's clearer and avoids integer overflow.
//If a and b are very large values, a - b can overflow, while Integer.compare() safely handles all integer values.