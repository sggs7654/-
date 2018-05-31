import java.text.SimpleDateFormat;

public class Main {
    public static void main(String args[])throws Exception{
        User u = new User();
        u.setId("15");
        ProxyCompany proxyCompany = new ProxyCompany(u);
        proxyCompany.getBusinessInfo();
        proxyCompany.getBusinessInfo();
        System.out.println(proxyCompany.log);
    }
}

class AbsCompany{
    String BusinessInfo;

    public void setBusinessInfo(String businessInfo) {
        BusinessInfo = businessInfo;
    }

    public String getBusinessInfo() throws Exception {
        return BusinessInfo;
    }
}
class ProxyCompany extends AbsCompany {
    String log;
    private User user;
    float cost;

    public void setUser(User user) {
        this.user = user;
    }

    ProxyCompany(User _user){
        setUser(_user);
        cost = 0;
        log = "";
        setBusinessInfo("Secret");
    }

    boolean checkUser(){return true;}

    @Override
    public String getBusinessInfo() throws Exception{
        if(!checkUser()){
            throw new RuntimeException("User check fail");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String record = df.format(System.currentTimeMillis()).toString();
        record = record + " user:" + user.getId().toString() + "perform a query operation\r\n";
        log.concat(record);
        cost += 37.669;
        return super.getBusinessInfo();
    }

    public float CalculateCost(){return cost;}
}

class RealCompany extends AbsCompany{}

class User{
    String name;
    String id;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}


