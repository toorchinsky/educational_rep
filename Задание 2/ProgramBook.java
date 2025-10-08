public class ProgramBook {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "11111");
        phoneBook.add("Иванов", "22222");
        phoneBook.add("Петров", "33333");
        phoneBook.add("Сидоров", "44444");

        phoneBook.showAll();

        System.out.println("Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Петров: " + phoneBook.get("Петров"));
    }
}
