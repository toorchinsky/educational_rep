public class Program {
    public static void main(String[] args){

        Circle circle = new Circle(5.7, "blue", "red");
        circle.getInfo();

        Rectangle rectangle = new Rectangle(8.24, 4.65, "black", "white");
        rectangle.getInfo();

        Triangle triangle = new Triangle(4.5, 6.2, 5.5, "yellow", "orange");
        triangle.getInfo();
    }
}