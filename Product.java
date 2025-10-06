public class Product {
    
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