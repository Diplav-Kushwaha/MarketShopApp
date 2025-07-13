package MarketShopApp;

import java.util.Scanner;
import java.time.LocalDate;

public class MarketShopApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Shopkeeper shopkeeper = new Shopkeeper();
        Customer customer = new Customer();

        shopkeeper.addProduct(new Product("Soap", "Dove", 20, 30, 50, LocalDate.of(2025, 12, 31)));

        boolean exit = false;
        System.out.println("====================== Welcome to Market Shop ===========================");

        while(!exit){
            System.out.println("\nChoose user type:");
            System.out.println("1. Shopkeeper");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    shopkeeperMenu(shopkeeper, sc);
                    break;
                case "2":
                    customerMenu(shopkeeper, customer, sc);
                    break;
                case "3":
                    System.out.println("Thanks for using Market Shop! Goodbye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    public static void shopkeeperMenu(Shopkeeper shopkeeper, Scanner sc) {

        boolean back = false;
        while (!back) {
            System.out.println("\n==========Shopkeeper Menu=========");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product by Name");
            System.out.println("3. Search Product by Name");
            System.out.println("4. Search Product by Company");
            System.out.println("5. Search Product by Price Range");
            System.out.println("6. Show All Products");
            System.out.println("7. Remove Expired Products");
            System.out.println("8. Back to Main Menu");
            System.out.print("Enter your choice: ");
            String option = sc.nextLine();

            switch(option){
                case "1":
                    System.out.print("Enter product name: ");
                    String name=sc.nextLine();
                    System.out.print("Enter company: ");
                    String company=sc.nextLine();
                    System.out.print("Enter cost price: ");
                    double cost=Double.parseDouble(sc.nextLine());
                    System.out.print("Enter selling price: ");
                    double sell=Double.parseDouble(sc.nextLine());
                    System.out.print("Enter quantity: ");
                    int qty=Integer.parseInt(sc.nextLine());
                    System.out.print("Enter expiry date (YYYY-MM-DD): ");
                    LocalDate date=LocalDate.parse(sc.nextLine());

                    Product newProduct=new Product(name, company, cost, sell, qty, date);
                    shopkeeper.addProduct(newProduct);
                    break;

                case "2":
                    System.out.print("Enter product name to remove: ");
                    String removeName=sc.nextLine();
                    shopkeeper.removeProductByName(removeName);
                    break;

                case "3":
                    System.out.print("Enter product name to search: ");
                    String searchName=sc.nextLine();
                    shopkeeper.searchByName(searchName);
                    break;

                case "4":
                    System.out.print("Enter company name to search: ");
                    String companySearch=sc.nextLine();
                    shopkeeper.searchByCompany(companySearch);
                    break;

                case "5":
                    System.out.print("Enter min price: ");
                    double min=Double.parseDouble(sc.nextLine());
                    System.out.print("Enter max price: ");
                    double max=Double.parseDouble(sc.nextLine());
                    shopkeeper.searchByPrice(min, max);
                    break;

                case "6":
                    shopkeeper.showAllProducts();
                    break;

                case "7":
                    shopkeeper.removeExpiredProducts();
                    break;

                case "8":
                    back = true;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
    public static void customerMenu(Shopkeeper shopkeeper, Customer customer, Scanner sc){

        boolean back=false;
        while(!back){
            System.out.println("\n========Customer Menu=========");
            System.out.println("1. Purchase Product");
            System.out.println("2. Return Product");
            System.out.println("3. View Cart");
            System.out.println("4. Generate Final Bill");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            String option=sc.nextLine();

            switch (option) {
                case "1":
                    customer.purchaseProduct(shopkeeper, sc);
                    break;

                case "2":
                    customer.returnProduct(sc);
                    break;

                case "3":
                    customer.viewCart();
                    break;

                case "4":
                    customer.viewCart();
                    customer.printBill();
                    Bill bill=new Bill(customer.getCart());
                    bill.generateSummary();
                    back=true;
                    break;

                case "5":
                    back=true;
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
