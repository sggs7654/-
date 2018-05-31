public class Main {
    public static void main(String args[]){
        EncryptFacade cipher = new EncryptFacade();
        cipher.encrypt("SecretCode.txt");
    }
}

class EncryptFacade{
    private FileReader fileReader;
    private FileEncrypter fileEncrypter;
    private FileWriter fileWriter;
    EncryptFacade(){
        fileEncrypter = new FileEncrypter();
        fileReader = new FileReader();
        fileWriter = new FileWriter();
    }
    void encrypt(String fileName){
        fileReader.readFile(fileName);
        fileEncrypter.encryptFile(fileName);
        fileWriter.writeFile(fileName);
        System.out.println("File has been perfect encrypt!");
    }
}
class FileReader{
    void readFile(String fileName){
        System.out.println("Read file:" + "\""+fileName + "\"" + "......Success!");
    }
}
class FileEncrypter{
    void encryptFile(String fileName){
        System.out.println("Encrypt file:" + "\""+fileName + "\"" + "......Done!");
    }
}
class FileWriter{
    void writeFile(String fileName){
        System.out.println("Write file:" + "\""+fileName + "\"" + "......Finished!");
    }
}
