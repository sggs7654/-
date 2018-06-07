public class Main {
    public static void main(String args[]){
        Fan fan = new Fan();
        Light light = new Light();
        Switch s = new Switch();
        s.turnupFan(fan);
        s.turnoffFan(fan);
        s.turnupLight(light);
        s.turnoffLight(light);
    }
}
class Switch{
    void turnupFan(Fan fan){
        FanComman fanComman = new FanComman();
        fanComman.turnUp(fan);
    }
    void turnoffFan(Fan fan){
        FanComman fanComman = new FanComman();
        fanComman.turnOff(fan);
    }
    void turnupLight(Light light){
        LightComman lightComman = new LightComman();
        lightComman.turnUp(light);
    }
    void turnoffLight(Light light){
        LightComman lightComman = new LightComman();
        lightComman.turnOff(light);
    }
}
abstract class Command{
}
class FanComman extends Command{
    Fan fan;

    void turnUp(Fan fan) {
        fan.status = "up";
        System.out.println("Turn up fan.");
    }
    void turnOff(Fan fan) {
        fan.status = "off";
        System.out.println("Turn off fan.");
    }
}
class LightComman extends Command{
    Light light;

    void turnUp(Light light) {
        light.status = "up";
        System.out.println("Turn up Light.");
    }
    void turnOff(Light light) {
        light.status = "off";
        System.out.println("Turn off Light.");
    }
}
class Fan{
    String status;
}
class Light{
    String status;
}
