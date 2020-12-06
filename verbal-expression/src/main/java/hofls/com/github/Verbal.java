package hofls.com.github;

import ru.lanwen.verbalregex.VerbalExpression;

public class Verbal {

    public static boolean isUrl(String url) {
        VerbalExpression urlRegex = VerbalExpression.regex()
                .startOfLine().then("http").maybe("s")
                .then("://")
                .maybe("www.").anythingBut(" ")
                .endOfLine()
                .build();
        System.out.println(urlRegex.toString());
        return urlRegex.test(url);
    }

}
