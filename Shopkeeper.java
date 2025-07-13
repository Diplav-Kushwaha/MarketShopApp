package MarketShopApp;

import java.util.List;
import java.util.Iterator;
import java.time.LocalDate;
import java.util.ArrayList;

public class Shopkeeper {

    private List<Product> inventory;
    public Shopkeeper(){
        inventory=new ArrayList<>();
    }
    public void addProduct(Product product){
        inventory.add(product);
        System.out.println("Product added successfully!");
    }
    public void removeProductByName(String name){
        Iterator<Product> iterator=inventory.iterator();
        boolean found=false;
        while(iterator.hasNext()){
            Product prod=iterator.next();
            if (prod.getName().equalsIgnoreCase(name)){
                iterator.remove();
                found=true;
                System.out.println("Product '"+name+"' removed successfully!");
            }
        }
        if (!found) {
            System.out.println("Product not found with name: "+name);
        }
    }
    public void removeExpiredProducts() {
        LocalDate today=LocalDate.now();
        Iterator<Product> iterator=inventory.iterator();
        while(iterator.hasNext()){
            Product prod=iterator.next();
            if(prod.getExpiryDate().isBefore(today)){
                iterator.remove();
                System.out.println("Removed expired product: "+prod.getName());
            }
        }
    }
    public void searchByName(String name){
        boolean found=false;
        for(Product prod : inventory){
            if(prod.getName().equalsIgnoreCase(name)){
                System.out.println(prod);
                found=true;
            }
        }
        if(!found){
            System.out.println("Product not found with name: "+name);
        }
    }
    public void searchByCompany(String company){
        boolean found=false;
        for(Product prod : inventory){
            if(prod.getCompany().equalsIgnoreCase(company)){
                System.out.println(prod);
                found=true;
            }
        }
        if(!found){
            System.out.println("Product not found from company: "+company);
        }
    }
    public void searchByPrice(double min, double max){
        boolean found=false;
        for(Product prod : inventory){
            if(prod.getSellingPrice() >= min && prod.getSellingPrice() <= max){
                System.out.println(prod);
                found=true;
            }
        }
        if(!found){
            System.out.println("Products not found in price range "+min+" - "+max);
        }
    }
    public List<Product> getInventory(){
        return inventory;
    }
    public void showAllProducts(){
        if (inventory.isEmpty()){
            System.out.println("No products in inventory.");
        }else{
            System.out.println("==============All Products in Inventory============");
            for(Product prod: inventory) {
                System.out.println(prod);
            }
        }
    }
}
