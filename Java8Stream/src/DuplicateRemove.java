import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateRemove {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,2,1,2,4,3,4,1);

        Set<Integer> uniqSet = new HashSet<>(list);
        System.out.print("Normal " + uniqSet);
        System.out.println();
        System.out.println("........................................");

//        Using the Stream API
        Set<Integer> uniqueSet = new HashSet<>(); // In this case 2 is 3 time so 2 will print 2 time
        Set<Integer> duplicateSet = new HashSet<>();  // using this above problem will resolve
        list.stream().filter(n -> !uniqueSet.add(n))
                .filter(duplicateSet::add)
                .forEach(System.out::println);
    }
}
