public class Main {
    public static void main(String args[])throws Exception{
        Director director = new Director();
        Mode mode = director.getProduct("CompleteModeBuilder");
        System.out.println(mode.CollectList);
    }
}

class Director{
    ModeBuilder b;
    Mode getProduct(String type)throws Exception{
        Class cls = Class.forName(type);
        Object obj = cls.newInstance();
        ModeBuilder builder = (ModeBuilder) obj;
        Mode mode = builder.buildMode();
        return mode;
    }
}

abstract class ModeBuilder{
    abstract Mode buildMode();
}

class CompleteModeBuilder extends ModeBuilder{
    Mode buildMode(){
        Mode mode = new Mode();
        mode.MainWindow = true;
        mode.ControlBar = true;
        mode.Menu = true;
        mode.PlayList = true;
        mode.CollectList = false;
        return mode;
    }
}
class ShortModeBuilder extends ModeBuilder{
    Mode buildMode(){
        Mode mode = new Mode();
        mode.MainWindow = true;
        mode.ControlBar = true;
        mode.Menu = false;
        mode.PlayList = false;
        mode.CollectList = false;
        return mode;
    }
}
class MemoryModeBuilder extends ModeBuilder{
    Mode buildMode(){
        Mode mode = new Mode();
        mode.MainWindow = true;
        mode.ControlBar = true;
        mode.Menu = false;
        mode.PlayList = false;
        mode.CollectList = true;
        return mode;
    }
}
class NetworkModeBuilder extends ModeBuilder{
    Mode buildMode(){
        Mode mode = new Mode();
        mode.MainWindow = true;
        mode.ControlBar = true;
        mode.Menu = true;
        mode.PlayList = true;
        mode.CollectList = true;
        return mode;
    }
}

class Mode{
    boolean MainWindow;
    boolean Menu;
    boolean ControlBar;
    boolean PlayList;
    boolean CollectList;
}