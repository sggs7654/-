import java.util.Collection;
import java.util.Date;

public abstract class absDoc {
    String No;
    Date date;
    String author;
    String customerNo;
    String price;
    String goType;
    Collection<absDoc> getInDocs;
    Collection<absDoc> Docs;
    void add(){}
    void delete(){}
    void addDetail(){}
    void delDetail(){}
    void print(){}
    void check(){}
    abstract void display();
}

class InventoryDoc extends absDoc{
    String No;
    Date date;
    String author;
    String costCenter;
    Collection<absDoc> getInDocs;
    Collection<absDoc> Docs;
    void add(){}
    void delete(){}
    void addDetail(){}
    void delDetail(){}
    void print(){}
    void check(){}
    void display(){
        System.out.println("fileLog Recording...");
    }
}

class ProcurementDoc extends absDoc{
    void display(){
        System.out.println("dbLog Recording...");
    }
}

class TaxDoc extends absDoc{
    String No;
    Date date;
    String author;
    String taxType;
    Collection<absDoc> getInDocs;
    Collection<absDoc> Docs;
    void add(){}
    void delete(){}
    void addDetail(){}
    void delDetail(){}
    void print(){}
    void check(){}
    void display(){
        System.out.println("consoleLog Recording...");
    }
}