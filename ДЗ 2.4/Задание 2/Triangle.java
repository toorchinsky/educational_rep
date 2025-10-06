public class Triangle implements ShapeCalculation{
    
    double a;
    double b;
    double c;
    String borderColor;
    String backgroundColor;
    private static String type = "Треугольник";

    public Triangle(double a, double b, double c, String borderColor, String backgroundColor){
        this.a = a;
        this.b = b;
        this.c = c;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    };

    public double perimeterCalculation(){
        return a + b + c;
    };

    public double areaCalculation(){
        double p = perimeterCalculation() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    };
    public String getBackgroundColor(){
        return backgroundColor;
    };
    public String getBorderColor(){
        return borderColor;
    };
    public String getType(){
        return type;
    };

}
