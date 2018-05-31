public class Main {
    public static void main(String args[])throws Exception{
        DataOperationAdapter d = new DataOperationAdapter();
        d.sort();
        d.search();
    }
}
interface DataOperation{
    void sort();
    void search();
}

class DataOperationAdapter implements DataOperation{
    public void sort(){
        QuickSort.quickSort();
    }
    public void search(){
        BinarySearch.BinarySearch();
    }
}

class QuickSort{
    static void quickSort(){
        System.out.println("QuickSort");
    }
}

class BinarySearch{
    static void BinarySearch(){
        System.out.println("BinarySearch");
    }
}
