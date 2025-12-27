//https://leetcode.com/problems/encode-and-decode-tinyurl/description/
public class Codec {
Map<String, String> codeDB = new HashMap<>(), urlDB = new HashMap<>();
    static final String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static int SHORT_URL_LENGTH=6;
    public static String BASE_DOMAIN="https://tinyurl.com/";
    private String getCode(){
        char[] code=new char[SHORT_URL_LENGTH];
        for(int i=0;i<SHORT_URL_LENGTH;i++){
            code[i]=chars.charAt((int)(Math.random()*62));
        }
        return BASE_DOMAIN+String.valueOf(code);
    }
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(urlDB.containsKey(longUrl)) return urlDB.get(longUrl);

        String shortUrl=getCode();
        while(codeDB.containsKey(shortUrl))
            shortUrl=getCode();

        codeDB.put(shortUrl, longUrl);
        urlDB.put(longUrl, shortUrl);

        return shortUrl;
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeDB.get(shortUrl);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
