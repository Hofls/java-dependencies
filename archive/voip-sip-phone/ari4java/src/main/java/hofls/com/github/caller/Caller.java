package hofls.com.github.caller;


import ch.loway.oss.ari4java.ARI;
import ch.loway.oss.ari4java.AriVersion;

public class Caller {

    public static void init() throws Exception {
        ARI ari = ARI.build(
                "http://33.111.77.143:8080/",
                "test-app",
                "hofls",
                "qwerty",
                AriVersion.IM_FEELING_LUCKY);
    }

    public static void dial() throws Exception {

    }

}
