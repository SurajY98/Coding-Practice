public class Palindrome {
    public static void main(String[] args) {
        String s1 = "madamx";
        int left = 0;
        int right = s1.length()-1;

        boolean palindrome = true;

        while (left < right){
            if (s1.charAt(left) != s1.charAt(right)){
                palindrome = false;
                break;
            }
            left++;
            right--;
        }
       System.out.println(palindrome);
    }
}
