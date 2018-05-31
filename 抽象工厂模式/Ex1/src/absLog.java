public abstract class absLog {
    abstract void display();
}

class fileLog extends absLog{
    void display(){
        System.out.println("fileLog Recording...");
    }
}

class dbLog extends absLog{
    void display(){
        System.out.println("dbLog Recording...");
    }
}

class consoleLog extends absLog{
    void display(){
        System.out.println("consoleLog Recording...");
    }
}