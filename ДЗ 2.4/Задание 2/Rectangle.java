public class Rectangle implements ShapeCalculation{

    double length;
    double width;
    String borderColor;
    String backgroundColor;
    private static String type = "Прямоугольник";

    public Rectangle(double length, double width, String borderColor, String backgroundColor){
        this.length = length;
        this.width = width;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    };

    public String getType(){
        return type;
    };
    public double perimeterCalculation(){
        return (length + width) * 2;
    };
    public double areaCalculation(){
        return length * width;
    };
    public String getBackgroundColor(){
        return backgroundColor;
    };
    public String getBorderColor(){
        return borderColor;
    };

}