import java.util.HashMap;
import java.util.Map;

public class PalindromPermutation{
    public static Boolean isPalindromPermutation(String input){
        input = input.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : input.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        int oddCount = 0;

        for(int count : map.values()){
            if(count % 2 != 0){
                oddCount++;
            }
        }

        return oddCount <= 1;
    }

    public static void main(String[] args){
        System.out.println(isPalindromPermutation("daily"));
    }
}