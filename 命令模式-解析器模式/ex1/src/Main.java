import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String args[]){
        AddressBook addressBook = new AddressBook();
        AddCommand addCommand = new AddCommand(addressBook);
        CheckCommand checkCommand = new CheckCommand(addressBook);
        DeleteCommand deleteCommand = new DeleteCommand(addressBook);
        AddButton addButton = new AddButton(addCommand);
        CheckButton checkButton = new CheckButton(checkCommand);
        DeleteButton deleteButton = new DeleteButton(deleteCommand);
        while (true){
            System.out.println("请选择功能");
            System.out.println("1. 添加联系人    2. 删除联系人    3. 查找联系人    0.退出");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            if(n==1){
                addButton.click();
            }else if(n==2){
                deleteButton.click();
            }else if(n==3){
                checkButton.click();
            }else{
                break;
            }
        }
    }
}

class Button{
    Command command;
    Button(Command _command){
        command = _command;
    }
    void click(){
        command.excute();
    }
}
class AddButton extends Button{
    AddButton(Command _command){
        super(_command);
    }
}
class DeleteButton extends Button{
    DeleteButton(Command _command){
        super(_command);
    }
}
class CheckButton extends Button{
    CheckButton(Command _command){
        super(_command);
    }
}
class Command{
    AddressBook addressBook;
    Command(AddressBook _addressBook){
        addressBook = _addressBook;
    }
    void excute(){}
}
class AddCommand extends Command{
    AddCommand(AddressBook _addressBook){
        super(_addressBook);
    }

    @Override
    void excute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入新联系人的姓名:");
        String name = sc.nextLine();
        System.out.println("请输入新联系人的电话:");
        String tel = sc.nextLine();
        addressBook.add(name,tel);
    }
}
class DeleteCommand extends Command{
    DeleteCommand(AddressBook _addressBook){
        super(_addressBook);
    }

    @Override
    void excute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的联系人的姓名:");
        String name = sc.nextLine();
        addressBook.delete(name);
    }
}
class CheckCommand extends Command{
    CheckCommand(AddressBook _addressBook){
        super(_addressBook);
    }

    @Override
    void excute() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的联系人的姓名:");
        String name = sc.nextLine();
        String tel = addressBook.check(name);
        System.out.println(tel);
    }
}
class AddressBook{
    Vector<Contacts> contacts;
    AddressBook(){
        contacts = new Vector<Contacts>();
    }
    void add(String _name, String _tel){
        Contacts newContact = new Contacts(_name,_tel);
        contacts.addElement(newContact);
    }
    void delete(String _name){
        for(int i = 0; i < contacts.size();i++){
            if(contacts.get(i).name.equals(_name)){
                contacts.remove(i);
                break;
            }
        }
    }
    String check(String _name){
        for(int i = 0; i < contacts.size();i++){
            if(contacts.get(i).name.equals(_name)){
                return contacts.get(i).tel;
            }
        }
        return "Address Book doesn't have this contact.";
    }
}
class Contacts{
    String name;
    String tel;
    Contacts(String _n,String _t){
        name = _n;
        tel = _t;
    }
}
