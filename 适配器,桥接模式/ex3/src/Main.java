import java.util.ResourceBundle;

public class Main {
    public static void main(String args[])throws Exception{
        UnixLog log = new UnixLog();
    }
}

interface AbsLog{}
class RefineLog implements AbsLog{
    Language language;
    Output output;

    RefineLog()throws Exception{
        ResourceBundle rb = ResourceBundle
                .getBundle("XML");
        String languageInfo = rb.getString("LANGUAGE");
        String outputInfo = rb.getString("OUTPUT");
        Class clsL = Class.forName(languageInfo);
        Class clsO = Class.forName(outputInfo);
        Object objL = clsL.newInstance();
        Object objO = clsO.newInstance();
        language = (Language) objL;
        output = (Output) objO;
    }
}

class UnixLog extends RefineLog{
    UnixLog()throws Exception{
        super();
    }
}

class WinLog extends RefineLog{
    WinLog()throws Exception{
        super();
    }
}

class Language{}
class Chinese extends Language{}
class English extends Language{}
class Output{}
class CompleteMode extends Output{}
class ShortMode extends Output{}
