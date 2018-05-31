abstract class LoginWay {
    void login(){}
}

class LoginWithQQ extends LoginWay{
    void login(){
        System.out.println("Login with QQ");
    }
}

class LoginWithWeChat extends LoginWay{
    void login(){
        System.out.println("Login with Wechat");
    }
}

class LoginWithWeibo extends LoginWay{
    void login(){
        System.out.println("Login with Weibo");
    }
}

class LoginWithAliPay extends LoginWay{
    void login(){
        System.out.println("Login with AliPay");
    }
}

class LoginWithBaidu extends LoginWay{
    void login(){
        System.out.println("Login with Baidu");
    }
}