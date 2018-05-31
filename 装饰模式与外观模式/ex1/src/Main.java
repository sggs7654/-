public class Main {
    public static void main(String args[]){
        String text = "SecretCode";
        SimpleCipher c1 = new SimpleCipher();
        System.out.println(c1.encrypt(text));
        AdvancedCipher c2 = new AdvancedCipher(c1);
        ComplexCipher c3 = new ComplexCipher(c2);
        System.out.println(c3.encrypt(text));
    }
}

interface Cipher{
    String info();
    String encrypt(String text);
}

class SimpleCipher implements Cipher{
    public String info(){
        return "SimpleCipher";
    }
    public String encrypt(String text){
        return ("SimpleEncrypt{" + text + "}");
    }
}

class CipherDecorator implements Cipher{
    Cipher cipher;
    CipherDecorator(Cipher _cipher){
        cipher = _cipher;
    }
    public String info() {
        return "CipherDecorator";
    }
    public String encrypt(String text) {
        return null;
    }
}

class AdvancedCipher extends CipherDecorator{
    AdvancedCipher(Cipher _cipher){
        super(_cipher);
    }
    public String info() {
        return "AdvancedCipher";
    }
    public String encrypt(String text) {
        String text2 = cipher.encrypt(text);
        return ("AdvancedEncrypt{" + text2 + "}");
    }
}

class ComplexCipher extends CipherDecorator{
    ComplexCipher(Cipher _cipher){
        super(_cipher);
    }
    public String info() {
        return "ComplexCipher";
    }
    public String encrypt(String text) {
        String text2 = cipher.encrypt(text);
        return ("ComplexEncrypt{" + text2 + "}");
    }
}
