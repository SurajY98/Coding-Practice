import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighestNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,20,40,30,50,50,70,70);

        Integer secondHighestNum = list.stream().distinct()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst()
                .orElse(null);

        System.out.println(secondHighestNum);
    }
}
