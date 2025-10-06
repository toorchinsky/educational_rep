public class Program {

    public static void main(String[] args) {
        String[][] array = {
        {"1", "2", "3", "4"},
        {"5", "6", "7", "8"},
        {"9", "10", "11", "12"},
        {"13", "14", "15", "16"}
    };

    try {
        arrayConversion(array);
    } catch (MyArraySizeException e) {
        System.out.println("Массив неверного размера");
    } catch (MyArrayDataException e) {
        System.out.println(e.getMessage());
    }


    try{
        System.out.println(array[0][5]);
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Недопустимый индекс массива");
    }
    
    }

    public static int arrayConversion(String[][] array) throws MyArraySizeException, MyArrayDataException {
        
        if (array.length != 4) {
            throw new MyArraySizeException();
        } else {
            for(int a = 0; a < array.length; a++){
                if (array[a].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }

        int result = 0;

        for(int b = 0; b < array.length; b++){
            for(int c = 0; c < array[b].length; c++){
                try {
                    result += Integer.parseInt(array[b][c]);
                } catch (NumberFormatException  e) {
                    throw new MyArrayDataException(b, c);
                }
            }
        }
        return result;
    }
}