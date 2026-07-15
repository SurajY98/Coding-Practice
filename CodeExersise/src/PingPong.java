import java.util.ArrayList;
import java.util.List;

public class PingPong {
    public static List<String> generatePingPong(){
        List<String> list = new ArrayList<>();

        for(int i=0; i<100; i++){
            if(i%3 == 0 && i%5 == 0){
                list.add("PingPong");
            }else if (i%3 == 0){
                list.add("Ping");
            } else if (i%5 == 0) {
                list.add("Pong");
            }else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
    public static void main(String[] args) {
        List<String> num = generatePingPong();
        for (String value : num){
            System.out.println(value);
        }
    }
}
