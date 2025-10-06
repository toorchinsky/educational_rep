public interface ShapeCalculation {
    double perimeterCalculation();
    double areaCalculation();
    String getBackgroundColor();
    String getBorderColor();
    String getType();

    default void getInfo(){
        System.out.println("Тип фигуры: " + getType() + "\n" + "Площадь: " + areaCalculation() + "\n" + "Периметр: " + perimeterCalculation() + "\n" + "Цвет фона: " + getBackgroundColor() + "\n" + "Цвет границы: " + getBorderColor());
    };
}
