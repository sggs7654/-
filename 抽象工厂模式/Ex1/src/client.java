import java.util.ResourceBundle;
public class client {
    public static void main(String args[])throws Exception{
        ResourceBundle rb = ResourceBundle
                .getBundle("logType");
        String logType = rb.getString("TYPE");
        absFactory logFactory = absFactory.buildFactory(logType);
        absLog log = logFactory.buildLog();
        log.display();
    }
}

