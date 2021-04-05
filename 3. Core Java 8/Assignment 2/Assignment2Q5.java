package Assignment2;


class Rectangle extends Shape {
    @Override
    public String draw() {
    	return "Rectangle Drawn";
    }
}

class Line extends Shape{
    @Override
    public String draw() {
    	return "Line Drawn";
    }
}

class Cube extends Shape {
    @Override
    public String draw() {
    	return "Cube Drawn";
    }
}
abstract class Shape {
    abstract public String draw();
}
public class Assignment2Q5{
    public static void main(String[] args) {
    	Rectangle rectangle = new Rectangle();
    	System.out.println(rectangle.draw());
    	
    	Line line = new Line();
    	System.out.println(line.draw());
    	
    	Cube cube = new Cube();
    	System.out.println(cube.draw());
    }
}
