import java.util.stream.IntStream;

public class arrayHasSameBeginAndEnd {
    public static boolean arraySameBeginAndEnd(int[] array, int index){

        for (int i = 0; i < index; i++){
            if (array[i] != array[array.length-index + i]){ //so it will start from array.length-index length=7,index=2,i=0 7-2+0+=5
                return false;
            }
        }
        return true;
    }

    public static boolean arraySameBeginAndEndStream(int[] nums, int x){
        return IntStream.range(0, x).allMatch(i -> nums[i] == nums[nums.length - x + i]); // allMatch return true/false
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 45, 99, 13, 5, 6};
        System.out.println(arraySameBeginAndEnd(arr, 1));
        System.out.println(arraySameBeginAndEnd(arr,2));
        System.out.println(arraySameBeginAndEnd(arr,3));
        System.out.println(arraySameBeginAndEnd(arr,0));
        System.out.println("Using Stream API");
        System.out.println(arraySameBeginAndEndStream(arr, 1));
        System.out.println(arraySameBeginAndEndStream(arr,2));
        System.out.println(arraySameBeginAndEndStream(arr,3));
        System.out.println(arraySameBeginAndEndStream(arr,0));
    }
}
