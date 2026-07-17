import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlShortner {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int CODE_LENGTH = 6;

    private final Map<String, String> shortToLong = new HashMap<>();
    private final Map<String,String> longToShort = new HashMap<>();

    Random random = new Random();

    public String shortUrl(String longUrl){
        if(longToShort.containsKey(longUrl)){
            return longToShort.get(longUrl);
        }

        String shortCode;

        do{
            shortCode = generateCode();
        }while (shortToLong.containsKey(shortCode));
        shortToLong.put(shortCode, longUrl);
        longToShort.put(longUrl, shortCode);

        return shortCode;
    }

    public String restoreUrl(String shortCode){
        return shortToLong.getOrDefault(shortCode, " Url not found");
    }

    public String generateCode(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<CODE_LENGTH; i++){
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        UrlShortner urlShortner = new UrlShortner();
        String url = "httpd://www.chatgpt.com";
        String shortURl = urlShortner.shortUrl(url);
        System.out.println("Short Url :- " + shortURl);

        String fullUrl = urlShortner.restoreUrl(shortURl);
        System.out.println("Full Url for short code :- "  + fullUrl);

    }
}
