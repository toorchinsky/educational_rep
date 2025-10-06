public class Circle implements ShapeCalculation{

    double radius;
    String borderColor;
    String backgroundColor;
    private static String type = "Круг";

    public Circle(double radius, String borderColor, String backgroundColor){
        this.radius = radius;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    }

    public String getType(){
        return type;
    };

    public double perimeterCalculation(){
        return 2 * Math.PI * radius;
    };

    public double areaCalculation(){
        return radius * radius * Math.PI;
    };

    public String getBorderColor(){
        return borderColor;
    };

    public String getBackgroundColor(){
        return backgroundColor;
    };
}