import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UrlShortener {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SHORT_URL_LENGTH = 6;

    // URL -> Short Code
    private static final Map<String, String> urlToCode = new HashMap<>();
    // Short Code -> URL
    private static final Map<String,String> codeToUrl = new HashMap<>();

    Random random = new Random();

    public String shortenUrl(String url){
        String shortCode;
        // If URL is already shortened, return existing code
        if (urlToCode.containsKey(url)){
            return urlToCode.get(url);
        }
        do {
            shortCode = generateCode();
        }while (codeToUrl.containsKey(shortCode));
        codeToUrl.put(shortCode,url);
        urlToCode.put(url,shortCode);
        return shortCode;
    }

    public String restoreUrl(String shortCode){
//        return codeToUrl.get(shortCode);
        return codeToUrl.getOrDefault(shortCode,"Url not found");
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
        System.out.println(shortUrl);

        System.out.println(urlShortener.restoreUrl(shortUrl));
    }
}
