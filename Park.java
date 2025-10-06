public class Park{
        public class Attractions{
            private String attractionName;
            private String workHours;
            private int attractionPrice;

            public Attractions(String attractionName, String workHours, int attractionPrice){
                this.attractionName = attractionName;
                this.workHours = workHours;
                this.attractionPrice = attractionPrice;
            }
            public void printAttractions() {
                System.out.println(attractionName);
                System.out.println(workHours);
                System.out.println(attractionPrice);
            }
        }
        
    }