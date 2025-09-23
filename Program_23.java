public class Program_23 {
    public static void main(String[] args) {
        Product product1 = new Product ("LADA Vesta", "10.09.2025", "АвтоВАЗ", "Россия", 1500000, false);
        product1.printProduct();
        // Задание 2
        Product[] productsArray = new Product[5];
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025", "Samsung Corp.", "Korea", 5599, true);
        productsArray[1] = new Product("Samsung S24 Ultra", "01.02.2024", "Samsung Corp.", "Korea", 4599, false);
        productsArray[2] = new Product("Samsung S23 Ultra", "01.02.2023", "Samsung Corp.", "Korea", 3599, false);
        productsArray[3] = new Product("Samsung S22 Ultra", "01.02.2022", "Samsung Corp.", "Korea", 2599, false);
        productsArray[4] = new Product("Samsung S21 Ultra", "01.02.2021", "Samsung Corp.", "Korea", 1599, false);

        Park park = new Park();
        Park.Attractions attraction1 = park.new Attractions("Колесо обозрения", "10:00-22:00", 400);
        // attraction1.printAttractions();

    }

    // Задание 1
    public static class Product{
        private String name;
        private String productionDate;
        private String manufacturer;
        private String countryOrigin;
        private int price;
        private boolean reservationStatus;
        public Product(String name, String productionDate, String manufacturer, String countryOrigin, int price, boolean reservationStatus) {
            this.name = name;
            this.productionDate = productionDate;
            this.manufacturer = manufacturer;
            this.countryOrigin = countryOrigin;
            this.price = price;
            this.reservationStatus = reservationStatus;
        }

        public void printProduct() {
            System.out.println(name);
            System.out.println(productionDate);
            System.out.println(manufacturer);
            System.out.println(countryOrigin);
            System.out.println(price);
            System.out.println(reservationStatus);
        }


    }

    // Задание 3
    public static class Park{
        public class Attractions{
            private String attractionName;
            private String workHours;
            private int attractionPrice;

            public Attractions(String attractionName, String workHours, int attractionPrice){
                this.attractionName = attractionName;
                this.workHours = workHours;
                this.attractionPrice = attractionPrice;
            }
            // public void printAttractions() {
            //     System.out.println(attractionName);
            //     System.out.println(workHours);
            //     System.out.println(attractionPrice);
            // }
        }
        
    }


}
