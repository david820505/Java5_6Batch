package day4.Ass3;


import java.util.Comparator;

public class GroupShape {
    public static void main(String[] args) {
        Square s1 = new Square(5);
        Rectangle r1 = new Rectangle(4,6);
        Circle c1 = new Circle(3.0);

        System.out.println("Rectangle Area : " + r1.calArea());
        System.out.println("Square Area : " + s1.calArea());
        System.out.println("Circle Area : " + Math.round(c1.calArea()*100.0)/100.0);

        //Compare
        String compare1 = compare(s1,r1);
        System.out.println("The largest Area is: " + compare1);
    }

    public static String compare(Shape a, Shape b){
        if(a.calArea() > b.calArea()){
            return a.toString();
        }else if(b.calArea() > a.calArea()){
            return b.toString();
        }

        return "Equal";
    }
}

class CompareArea implements Comparator<Shape>{

    @Override
    public int compare(Shape o1, Shape o2) {
        if(o1.calArea() > o2.calArea()){
            return -1;
        }else if(o1.calArea() == o2.calArea()){
            return 0;
        }else{
            return 1;
        }
    }
}

class Square implements Shape{
    double length;
    double area;

    public Square(double l){
        length = l;
        area = length*length;
    }

    @Override
    public double calArea() {
        return area;
    }

    @Override
    public String toString(){
        return "Square: " + length;
    }
}


class Rectangle implements Shape{
    double length;
    double breadth;
    double area;

    public Rectangle(double l, double b){
        length = l;
        breadth = b;
        area = length * breadth;
    }

    @Override
    public double calArea() {
        return area;
    }
    @Override
    public String toString(){
        return "Rectangle: (" + length + ","+ breadth + ")";
    }
}


class Circle implements Shape{
    double radius;
    double area;
    public Circle(double r){
        radius = r;
        area = (22.0/7.0) * radius * radius;
    }

    @Override
    public double calArea() {
        return area;
    }
    @Override
    public String toString(){
        return "radius: (" + area + ")";
    }
}

interface Shape{
    public double calArea();
}
