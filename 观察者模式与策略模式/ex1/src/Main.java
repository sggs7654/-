import java.util.Enumeration;
import java.util.Vector;

public class Main {
    public static void main(String args[]){
        TemperatureSensor temperatureSensor = new TemperatureSensor();
        WarningLights warningLights = new WarningLights();
        Alarm alarm = new Alarm();
        EscapeDoor escapeDoor = new EscapeDoor();
        temperatureSensor.attach(warningLights);
        temperatureSensor.attach(alarm);
        temperatureSensor.attach(escapeDoor);
        System.out.println(temperatureSensor.getStatus());
        temperatureSensor.update();
        temperatureSensor.setStatus("Dangerous");
        System.out.println(temperatureSensor.getStatus());
        temperatureSensor.update();
    }
}

abstract class AbstractSubject{
    Vector<AbstractObserver> ObsCon;
    abstract void attach(AbstractObserver ob);
    abstract void detach(AbstractObserver ob);
    abstract void Notify();
}

abstract class AbstractObserver{
    public String status;
    abstract void update();
}

class TemperatureSensor extends AbstractSubject{
    String status;
    TemperatureSensor(){
        ObsCon = new Vector<AbstractObserver>();
        status = "Safe";
    }
    void attach(AbstractObserver ob){
        ObsCon.addElement(ob);
    }
    void detach(AbstractObserver ob){
        ObsCon.removeElement(ob);
    }
    void Notify(){
        Enumeration obs = ObsCon.elements();
        while(obs.hasMoreElements()){
            AbstractObserver ob = (AbstractObserver)obs.nextElement();
            ob.status = "Dangerous";
            ob.update();
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void update(){
        if(status.equals("Dangerous")){
            Notify();
        }
    }
}

class WarningLights extends AbstractObserver{
    void update(){
        if(status.equals("Dangerous")){
            flicker();
        }
    }
    void flicker(){
        System.out.println("WarningLights flickering");
    }
}

class Alarm extends AbstractObserver{
    void update(){
        if(status.equals("Dangerous")){
            shout();
        }
    }
    void shout(){
        System.out.println("Alarm shouting");
    }
}

class EscapeDoor extends AbstractObserver{
    void update(){
        if(status.equals("Dangerous")){
            open();
        }
    }
    void open(){
        System.out.println("EscapeDoor opening");
    }
}