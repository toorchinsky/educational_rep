class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean isFull;
    
    public Cat(String name) {
        super(name);
        this.isFull = false;
        catCount++;
    }
    
    public void run(int distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }
    
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать");
    }
    
    public void eat(FoodBowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            this.isFull = true;
        }
    }
    
    public boolean isFull() {
        return isFull;
    }
    
    public static int getCatCount() {
        return catCount;
    }
}