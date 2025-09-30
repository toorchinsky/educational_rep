class FoodBowl {
    private int foodAmount;
    
    public FoodBowl(int initialFood) {
        if (initialFood < 0) {
            this.foodAmount = 0;
        } else {
            this.foodAmount = initialFood;
        }
    }
    
    public int getFoodAmount() {
        return foodAmount;
    }
    
    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
        }
    }
    
    public boolean decreaseFood(int amount) {
        if (amount > 0 && foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }
}