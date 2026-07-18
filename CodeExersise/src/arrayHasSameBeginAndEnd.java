public class arrayHasSameBeginAndEnd {
    public static boolean arraySameBeginAndEnd(int[] array, int index){

        for (int i = 0; i < index; i++){
            if (array[i] != array[array.length-index + i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 45, 99, 13, 5, 6};
        System.out.println(arraySameBeginAndEnd(arr, 1));
        System.out.println(arraySameBeginAndEnd(arr,2));
        System.out.println(arraySameBeginAndEnd(arr,3));
        System.out.println(arraySameBeginAndEnd(arr,0));
    }
}
