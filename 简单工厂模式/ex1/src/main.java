import java.util.ResourceBundle;
public class main {
    public static void main(String[] args) throws Exception {
        ResourceBundle rb = ResourceBundle
                .getBundle("shape");
        String type = rb.getString("TYPE");
        ShapeFactory shapefactory = new ShapeFactory();
        shape shapeA = shapefactory.createShape(type);
        shapeA.draw();
        shapeA.erase();
    }
}

abstract class shape{
    void draw(){}
    void erase(){}
}

class Circle extends shape{
    void draw(){
        System.out.println("Circle draw");
    }
    void erase(){
        System.out.println("Circle erase");
    }
}

class Rectangle extends shape{
    void draw(){
        System.out.println("Rectangle draw");
    }
    void erase(){
        System.out.println("Rectangle erase");
    }
}

class Triangle extends shape{
    void draw(){
        System.out.println("Triangle draw");
    }
    void erase(){
        System.out.println("Triangle erase");
    }
}

class ShapeFactory{
    shape createShape(String type) throws UnsupportedShapException{
        shape a;
        switch(type){
            case "Circle":
                a = new Circle();
                break;
            case "Triangle":
                a = new Triangle();
                break;
            case "Rectangle":
                a = new Rectangle();
                break;
            default:
                throw new UnsupportedShapException();
        }
        return a;
    }
}

class UnsupportedShapException extends RuntimeException{
    UnsupportedShapException(){
        super();
    }
}
