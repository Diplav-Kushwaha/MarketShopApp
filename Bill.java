package MarketShopApp;

import java.util.Map;

public class Bill {
    private Map<Product, Integer> cart;

    public Bill(Map<Product, Integer> cart){
        this.cart = cart;
    }
    public void generateSummary(){
        double totalSelling=0;
        double totalCost=0;

        System.out.println("=========== Shopkeeper Billing Summary ===========");

        for(Map.Entry<Product, Integer> entry : cart.entrySet()){

            Product p=entry.getKey();
            int qty=entry.getValue();
            double cost=p.getCostPrice()*qty;
            double sell=p.getSellingPrice()*qty;
            totalCost +=cost;
            totalSelling +=sell;

            System.out.println(p.getName()+" ("+qty+" items): Cost = ₹"+cost+", Sell = ₹"+sell);
        }

        System.out.println("==========================================");
        System.out.println("Total Cost Price  = ₹"+totalCost);
        System.out.println("Total Selling Price = ₹"+totalSelling);

        double profit=totalSelling-totalCost;
        if(profit>0){
            System.out.println("Total Profit = ₹"+profit);
        }else if(profit<0){
            System.out.println("Total Loss = ₹"+(-profit));
        }else{
            System.out.println("Break-even: No profit, no loss.");
        }

        System.out.println("==========================================");
    }
}