public class Main {
    public static void main(String args[]){
        Chart c1 = new Chart();
        System.out.println(c1.setColor("red"));
        Chart c2 = c1.clone();
        System.out.println(c2.setColor("red"));
    }
}

class Chart{
    private boolean lock;
    private double No;
    private String Color;
    private DataSet dataSet;

    public Chart(){
        dataSet = new DataSet();
        lock = true;
    }

    public double getNo() {
        return No;
    }

    public String getColor() {
        return Color;
    }

    public String getDataSet() {
        return dataSet.data;
    }

    public boolean setColor(String color) {
        if(!lock) {
            Color = color;
            return true;
        }else {
            return false;
        }
    }

    public boolean setNo(double no) {
        if(!lock) {
            No = no;
            return true;
        }else {
            return false;
        }
    }

    public boolean setData(String data) {
        if(!lock){
            dataSet.setData(data);
            return true;
        }else {
            return false;
        }
    }

    public Chart clone(){
        Chart cloneChart = new Chart();
        cloneChart.lock = false;
        cloneChart.setColor(getColor());
        cloneChart.setNo(getNo());
        cloneChart.setData(getDataSet());
        return cloneChart;
    }
}
class DataSet{
    String data;

    public void setData(String data) {
        this.data = data;
    }
}
