import java.util.Enumeration;
import java.util.Vector;

public class Main {
    public static void main(String args[]){
        WTO wto = new WTO();
        ConcreteCountry China = new ConcreteCountry();
        ConcreteCountry USA = new ConcreteCountry();
        China.joinOrg(wto);
        USA.joinOrg(wto);
        wto.declare("We are family:)");
        China.getMessage();
        USA.getMessage();
    }
}

abstract class UN{
    Vector<MemberCountry> memberList;
    void declare(String msg){
        Enumeration vEnum = memberList.elements();
        while(vEnum.hasMoreElements()){
            MemberCountry c = (MemberCountry) vEnum.nextElement();
            c.messageBox = msg;
        }
    }
    void addMember(MemberCountry c){
        memberList.addElement(c);
    }
    UN(){
        memberList = new Vector<MemberCountry>();
    }
}

abstract class MemberCountry{
    Vector<UN> orgnizations;
    String messageBox;
    MemberCountry(){
        orgnizations = new Vector<UN>();
    }
    void getMessage(){
        System.out.println(messageBox);
    }
    void joinOrg(UN org){
        orgnizations.addElement(org);
        org.addMember(this);
    }
}

class ConcreteCountry extends MemberCountry{}

class WTO extends UN{}
class WFC extends UN{}
class WHO extends UN{}