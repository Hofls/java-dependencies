package hofls.com.github.caller;

import org.asteriskjava.pbx.PBX;
import org.asteriskjava.pbx.PBXFactory;
import org.asteriskjava.pbx.Trunk;
import org.asteriskjava.pbx.internal.core.AsteriskPBX;

public class Caller {

    public static void init() throws Exception {
        PBXFactory.init(new AsteriskSettings());
        AsteriskPBX asteriskPbx  = (AsteriskPBX) PBXFactory.getActivePBX();
        asteriskPbx.createAgiEntryPoint();
    }

    public static void dial() throws Exception {
        PBX pbx = PBXFactory.getActivePBX();
        Trunk trunk = pbx.buildTrunk("default");
        // todo
    }

}
