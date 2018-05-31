public abstract class absFactory {
    static absFactory buildFactory(String type)throws Exception{
        Class cls = Class.forName(type);
        Object obj = cls.newInstance();
        absFactory f = (absFactory) obj;
        return f;
    }
    abstract absLog buildLog();
}

class fileLogFactory extends absFactory{
    absLog buildLog(){
        absLog log = new fileLog();
        return log;
    }
}

class dbLogFactory extends absFactory{
    absLog buildLog(){
        absLog log = new dbLog();
        return log;
    }
}

class consoleLogFactory extends absFactory{
    absLog buildLog(){
        absLog log = new consoleLog();
        return log;
    }
}
