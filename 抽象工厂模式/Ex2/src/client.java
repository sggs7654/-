import java.util.ResourceBundle;
public class client {
    public static void main(String args[])throws Exception{
        ResourceBundle rb = ResourceBundle
                .getBundle("docType");
        String docType = rb.getString("TYPE");
        absFactory docFactory = absFactory.buildFactory(docType);
        absDoc doc = docFactory.buildDoc();
        doc.display();
    }
}