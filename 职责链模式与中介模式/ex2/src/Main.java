public class Main {
    public static void main(String args[]){
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setPrice(150000);
        purchaseRequest.setThings("Television");
        Direct direct = new Direct();
        DivisionManager divisionManager = new DivisionManager();
        ViceGeneralManager viceGeneralManager = new ViceGeneralManager();
        GeneralManager generalManager = new GeneralManager();
        direct.setSuccesssor(divisionManager);
        divisionManager.setSuccesssor(viceGeneralManager);
        viceGeneralManager.setSuccesssor(generalManager);
        direct.handleRequest(purchaseRequest);
    }
}

class PurchaseRequest{
    int price;
    String things;
    boolean status;

    public void setPrice(int price) {
        this.price = price;
    }

    public void setThings(String things) {
        this.things = things;
    }

    PurchaseRequest(){
        status = false;
    }
}

abstract class Leader{
    Leader Successsor;

    public void setSuccesssor(Leader successsor) {
        Successsor = successsor;
    }

    abstract void handleRequest(PurchaseRequest purchaseRequest);
}

class Direct extends Leader{
    void handleRequest(PurchaseRequest purchaseRequest){
        if(purchaseRequest.price < 10000){
            purchaseRequest.status = true;
            System.out.println("Direct approval request:" + purchaseRequest.things + ".  Price:" + purchaseRequest.price);
        } else {
            System.out.println("Request beyond authority, transfer to DivisionManager");
            Successsor.handleRequest(purchaseRequest);
        }
    }
}

class DivisionManager extends Leader{
    void handleRequest(PurchaseRequest purchaseRequest){
        if(purchaseRequest.price < 50000){
            purchaseRequest.status = true;
            System.out.println("DivisionManager approval request:" + purchaseRequest.things + ".  Price:" + purchaseRequest.price);
        } else {
            System.out.println("Request beyond authority, transfer to ViceGeneralManager");
            Successsor.handleRequest(purchaseRequest);
        }
    }
}

class ViceGeneralManager extends Leader{
    void handleRequest(PurchaseRequest purchaseRequest){
        if(purchaseRequest.price < 100000){
            purchaseRequest.status = true;
            System.out.println("ViceGeneralManager approval request:" + purchaseRequest.things + ".  Price:" + purchaseRequest.price);
        } else {
            System.out.println("Request beyond authority, transfer to GeneralManager");
            Successsor.handleRequest(purchaseRequest);
        }
    }
}

class GeneralManager extends Leader{
    void handleRequest(PurchaseRequest purchaseRequest){
        if(purchaseRequest.price < 200000){
            purchaseRequest.status = true;
            System.out.println("GeneralManager approval request:" + purchaseRequest.things + ".  Price:" + purchaseRequest.price);
        } else {
            System.out.println("Request beyond authority, transfer to CenterMeeting");
        }
    }
}