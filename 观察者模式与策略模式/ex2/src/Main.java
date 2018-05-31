import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String args[])throws Exception{
        Sales sales = new Sales();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要订购的打印机的台数:");
        int num = sc.nextInt();
        System.out.println(num + "台打印机的价格为:");
        System.out.println(sales.sell(num));
    }
}

class Sales{
    AbsPriceCalculater calculater;
    Sales() throws Exception{
        ResourceBundle rb = ResourceBundle
                .getBundle("calculater");
        String strategy = rb.getString("CALCULATER");
        Class cls = Class.forName(strategy);
        Object obj = cls.newInstance();
        AbsPriceCalculater c = (AbsPriceCalculater) obj;
        calculater = c;
    }
    float sell(int num){
        return calculater.getPrice(num);
    }
}

abstract class AbsPriceCalculater{
    abstract float getPrice(int num);
}

class OriginalPrice extends AbsPriceCalculater{
    float getPrice(int num){
        return num*5000;
    }
}

class ReducePricePerUnit extends AbsPriceCalculater{
    float getPrice(int num){
        return num*4950;
    }
}

class Discount95 extends AbsPriceCalculater{
    float getPrice(int num){
        return (float)(num*5000*0.95);
    }
}