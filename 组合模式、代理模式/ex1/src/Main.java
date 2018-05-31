import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[])throws Exception{

    }
}

class VirusSearcher{
    void search(AbsCon root){
        if(root.ChildNum > 0){
            Folder folder = (Folder)root;
            for(int i = 0; i < root.ChildNum; i++){
                search(folder.getChild(i));
            }
        }else{
            check(root);
        }
    }
    void check(AbsCon catalog){}
}

class AbsCon{
    int ChildNum;
    String data;
}

class TextFile extends AbsCon{
    TextFile(String _data){
        ChildNum = 0;
        data = _data;
    }
}
class VideoFile extends AbsCon{
    VideoFile(String _data){
        ChildNum = 0;
        data = _data;
    }
}
class GraphFile extends AbsCon{
    GraphFile(String _data){
        ChildNum = 0;
        data = _data;
    }
}
class Folder extends AbsCon{
    private List<AbsCon> childList;
    Folder(String _data){
        ChildNum = 0;
        data = _data;
        childList = new ArrayList<>();
    }

    void add(AbsCon _f){
        childList.add(_f);
    }

    void delete(int index){
        childList.remove(index);
    }

    AbsCon getChild(int index){
        return childList.get(index);
    }
}
