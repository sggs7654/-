public class Main {
    public static void main(String[] args) throws Exception {
        IThirdpartyAuthenticationProvider lgw = new IThirdpartyAuthenticationProvider();
        LoginWithWeChat wx = new LoginWithWeChat();
        lgw.Login(wx);
    }
}

class IDatabaseProvider{ }
class IThirdpartyAPIProvider{ }

class IThirdpartyAuthenticationProvider{
    void Login(LoginWay w){
        System.out.println("Login...");
        w.login();
    }
}