package rd.jfxexample.util;

public class StringUtil {
    public static String rotateString(String source) {
        return source.substring(1) + source.charAt(0);
    }
}
