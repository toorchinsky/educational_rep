class MyArrayDataException extends Exception {
    public MyArrayDataException(int b, int c) {
        super("Нечисловое значение в ячейке: " + b + " " + c);
    }
}