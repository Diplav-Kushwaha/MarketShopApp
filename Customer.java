package MarketShopApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Customer{

    private Map<Product, Integer> cart;
    private Stack<Product> returnHistory;

    public Customer(){
        cart=new HashMap<>();
        returnHistory=new Stack<>();
    }
    public void purchaseProduct(Shopkeeper shopkeeper, Scanner sc){

        shopkeeper.showAllProducts();
        System.out.print("Enter product name to purchase: ");
        String productName = sc.nextLine();
        boolean found=false;

        for(Product prod : shopkeeper.getInventory()){
            if(prod.getName().equalsIgnoreCase(productName)){
                System.out.print("Enter quantity to purchase: ");
                int qty=Integer.parseInt(sc.nextLine());

                try{
                    if (prod.getQuantity()>=qty){
                        prod.setQuantity(prod.getQuantity()-qty);
                        cart.put(prod, cart.getOrDefault(prod, 0)+qty);
                        System.out.println("Product added to cart!");
                        found = true;
                        break;
                    }else{
                        throw new Exception("Insufficient stock available.");
                    }
                }catch(Exception e){
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }
        if(!found){
            System.out.println("Product not found in inventory.");
        }
    }

    public void returnProduct(Scanner sc) {
        if(cart.isEmpty()){
            System.out.println("Cart is empty. Nothing to return.");
            return;
        }

        System.out.print("Enter product name to return: ");
        String returnName=sc.nextLine();
        boolean found=false;

        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            Product prod=entry.getKey();
            int qty=entry.getValue();

            if (prod.getName().equalsIgnoreCase(returnName)) {
                System.out.print("Enter quantity to return: ");
                int returnQty=Integer.parseInt(sc.nextLine());

                if(returnQty <= qty){
                    cart.put(prod, qty-returnQty);
                    prod.setQuantity(prod.getQuantity()+returnQty);
                    returnHistory.push(prod);
                    System.out.println("Returned "+returnQty+" items of "+prod.getName());

                    if(cart.get(prod)==0){
                        cart.remove(prod);
                    }
                    found = true;
                    break;
                }else{
                    System.out.println("You only purchased "+qty+" items.");
                }
            }
        }
        if(!found){
            System.out.println("Product not found in cart.");
        }
    }
    public void viewCart(){
        if(cart.isEmpty()){
            System.out.println("Your cart is empty.");
        }else{
            System.out.println("==============Cart Items===========");
            for(Map.Entry<Product, Integer> entry : cart.entrySet()){
                Product prod=entry.getKey();
                int qty=entry.getValue();
                System.out.println(prod.getName()+" x "+qty+" = ₹"+(prod.getSellingPrice()*qty));
            }
        }
    }
    public void printBill() {

        double total = 0;
        System.out.println("============= FINAL BILL =============");

        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            Product prod=entry.getKey();
            int qty=entry.getValue();
            double subtotal=prod.getSellingPrice()*qty;
            total += subtotal;
            System.out.println(prod.getName()+" ("+qty+" x ₹"+prod.getSellingPrice()+") = ₹"+subtotal);
        }
        System.out.println("Total Amount: ₹"+total);
        System.out.println("=======================================");
    }
    public Map<Product, Integer> getCart(){
        return cart;
    }
}
