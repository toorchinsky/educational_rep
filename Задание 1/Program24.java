public class Program24 {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Бобик");
        dogBobik.run(150);
        dogBobik.swim(5);
        
        Cat catMurzik = new Cat("Мурзик");
        catMurzik.run(100);
        catMurzik.swim(10);
        
        FoodBowl bowl = new FoodBowl(50);
        Cat[] cats = {
            new Cat("Мурзик"),
            new Cat("Барсик"), 
            new Cat("Васька")
        };
        
        for (Cat cat : cats) {
            cat.eat(bowl, 20);
        }
        
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isFull());
        }
        
        System.out.println("Всего животных: " + Animal.getTotalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
    }
}