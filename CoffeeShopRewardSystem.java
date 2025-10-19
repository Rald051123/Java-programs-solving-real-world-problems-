public class CoffeeShop {

    // Inner Customer class
    static class Customer {
        // Instance variables
        private String name;
        private int points;

        // Static variable
        private static int totalCustomers = 0;

        // The constructor (default, has no parameter)
        public Customer() {
            this.name = "Unknown";
            this.points = 0;
            totalCustomers++;
        }

        // Parameterized constructor (has name and points)
        public Customer(String name, int points) {
            this.name = name;
            this.points = points;
            totalCustomers++;
        }

        // Parameterized constructor (name only)
        public Customer(String name) {
            this.name = name;
            this.points = 0;
            totalCustomers++;
        }

        // Method to add points
        public void addPoints(int additionalPoints) {
            this.points += additionalPoints;
            System.out.println(this.name + " earned " + additionalPoints + " points. Total points: " + this.points);
        }

        // Method to redeem a free single drink
        public void redeemReward() {
            if (this.points >= 100) {
                this.points -= 100;
                System.out.println("Congratulations " + this.name + "! You redeemed a free drink!");
                System.out.println("Remaining Points: " + this.points + "\n");
            } else {
                System.out.println(this.name + " does not have enough points to redeem a drink.\n");
            }
        }

        // Display the customers information
        public void displayCustomerInfo() {
            System.out.println("Customer Name: " + this.name + ", Points: " + this.points);
        }

        // Static method to display the total customers
        public static void displayTotalCustomers() {
            System.out.println("Total Registered Customers: " + totalCustomers);
        }

        // Static method to get how many rewards a customer can redeem
        public static void getAllowedRewardsRedemption(Customer customer) {
            int allowed = customer.points / 100;
            System.out.println(customer.name + " can redeem " + allowed + " free drink(s).");
        }
    }

    // Customers
    public static void main(String[] args) {
        // 1. Create customers
        Customer c1 = new Customer("Joseph", 200);
        Customer c2 = new Customer("Peter");
        Customer c3 = new Customer();

        // 2. Peter earns points
        c2.addPoints(150);  // pastries and beverages
        c2.addPoints(20);   // water

        // 3. Redeem rewards
        System.out.println("\n--- Redeeming Rewards ---");
        c1.redeemReward();
        c2.redeemReward();
        c3.redeemReward();

        // 4. Display info and total customers
        System.out.println("\n--- Customer Information ---");
        c1.displayCustomerInfo();
        c2.displayCustomerInfo();
        c3.displayCustomerInfo();
        Customer.displayTotalCustomers();

        // 5. Fourth customer (Diane)
        System.out.println("\n--- New Customer ---");
        Customer c4 = new Customer("Diane");
        c4.addPoints(50);
        Customer.displayTotalCustomers();

        // 6. Get allowed reward redemptions
        System.out.println("\n--- Reward Redemption Check ---");
        Customer.getAllowedRewardsRedemption(c1);
        Customer.getAllowedRewardsRedemption(c2);
        Customer.getAllowedRewardsRedemption(c3);
        Customer.getAllowedRewardsRedemption(c4);
    }
}
