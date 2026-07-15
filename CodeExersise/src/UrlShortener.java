import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlShortener {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    Map<String, String> shortToLongMap = new HashMap<>();

    Map<String,String> longToShortMap = new HashMap<>();

    Random random = new Random();

    public String shortenUrl(String url){
        String shortCode;
        if (longToShortMap.containsKey(url)){
            return longToShortMap.get(url);
        }
        do {
            shortCode = generateCode();
        }while (shortToLongMap.containsKey(shortCode));
        shortToLongMap.put(shortCode,url);
        longToShortMap.put(url,shortCode);
        return shortCode;
    }

    public String restoreUrl(String shortCode){
//        return shortToLongMap.get(shortCode);
        return shortToLongMap.getOrDefault(shortCode,"Url not found");
    }

    public String generateCode(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < SHORT_URL_LENGTH; i++){
           int index = random.nextInt(CHARACTERS.length());
           sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
    public static void main(String[] args) {

        UrlShortener urlShortener = new UrlShortener();
        String shortUrl = urlShortener.shortenUrl("https://google.com");
        String shortUrl1 = urlShortener.shortenUrl("https://chatgpt.com/g/g-p-6a55f42192848191aed76a886b6e8b58-accenture-interview-questions/c/6a561687-70f4-83ee-8fc2-ed023e9db770");
        System.out.println(shortUrl1);

        System.out.println(urlShortener.restoreUrl(shortUrl1));
    }
}
