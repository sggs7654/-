public abstract class absFactory {
    static absFactory buildFactory(String type)throws Exception{
        Class cls = Class.forName(type);
        Object obj = cls.newInstance();
        absFactory f = (absFactory) obj;
        return f;
    }
    abstract absDoc buildDoc();
}

class InventoryDocFactory extends absFactory{
    absDoc buildDoc(){
        absDoc doc = new InventoryDoc();
        return doc;
    }
}

class ProcurementDocFactory extends absFactory{
    absDoc buildDoc(){
        absDoc doc = new ProcurementDoc();
        return doc;
    }
}

class TaxDocFactory extends absFactory{
    absDoc buildDoc(){
        absDoc doc = new TaxDoc();
        return doc;
    }
}
