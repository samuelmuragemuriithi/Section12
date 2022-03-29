package com.awesam;

import java.util.Map;

public class Main {
private static StockList stockList=new StockList();
    public static void main(String[] args) {
	    StockItem temp=new StockItem("Bread",0.86,100);
        stockList.addStock(temp);
        temp=new StockItem("Cake",1.10,7);
        stockList.addStock(temp);
        temp=new StockItem("Car",12.50,2);
        stockList.addStock(temp);
        temp=new StockItem("Chair",62.0,10);
        stockList.addStock(temp);
        temp=new StockItem("Cup",0.5,200);
        stockList.addStock(temp);
        temp = new StockItem("Cup", 0.45, 7);
        stockList.addStock(temp);
        temp=new StockItem("Door",72.95,4);
        stockList.addStock(temp);
        temp=new StockItem("Juice",2.50,36);
        stockList.addStock(temp);
        temp=new StockItem("Phone",96.99,35);
        stockList.addStock(temp);
        temp=new StockItem("Towel",2.40,80);
        stockList.addStock(temp);
        temp=new StockItem("Vase",8.76,40);
        stockList.addStock(temp);


        System.out.println(stockList);

        for (String s:stockList.items().keySet()){
            System.out.println(s);
        }
        Basket samsBasket=new Basket("John");
        sellItem(samsBasket,"Car",1);
        System.out.println(samsBasket);
        sellItem(samsBasket,"Car",1);
        System.out.println(samsBasket);
       if (sellItem(samsBasket,"Car",1)!=1) System.out.println("There is no more cars in stock");;
        sellItem(samsBasket,"Spanner",5);
        //System.out.println(samsBasket);
        sellItem(samsBasket,"Juice",4);
        sellItem(samsBasket,"Cup",12);
        sellItem(samsBasket,"Bread",1);
        //System.out.println(samsBasket);
       // System.out.println(stockList);

        Basket basket=new Basket("Customer");
        sellItem(basket,"Cup",100);
        sellItem(basket,"Juice",5);
        sellItem(basket,"Cup",1);
        System.out.println(basket);

        sellItem(samsBasket,"Car",1);
        sellItem(samsBasket,"Cup",9);
        sellItem(samsBasket,"Car",1);
        System.out.println("Cars removed: "+removeItem(samsBasket,"Car",1));
        System.out.println(samsBasket);

        //Remove all items
        sellItem(samsBasket,"Bread",1);
        sellItem(samsBasket,"Cup",3);
        sellItem(samsBasket,"Juice",4);
        sellItem(samsBasket,"Cup",3);
        System.out.println("\nDisplay before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        System.out.println("Cars removed: "+removeItem(samsBasket,"Car",1));
        System.out.println(samsBasket);

       StockItem car= stockList.items().get("Car");
       if (car!=null){
           car.adjustStock(2000);
       }
        if (car!=null){
            car.adjustStock(-1000);
        }
      //  for (Map.Entry<String,Double>price:stockList.priceList().entrySet()){
      //      System.out.println(price.getKey()+" costs "+price.getValue());
       // }
        checkOut(samsBasket);
        System.out.println(samsBasket);
    }
    public static int sellItem(Basket basket,String item,int quantity){
        StockItem stockItem=stockList.get(item);
        if (stockItem==null){
            System.out.println("We don't sell "+ item);
            return 0;
        }
        if (stockList.reserveStock(item,quantity)!=0){
            return basket.addToBasket(stockItem,quantity);
        }
        return 0;
    }
    public static int removeItem(Basket basket,String item,int quantity){
        StockItem stockItem=stockList.get(item);
        if (stockItem==null){
            System.out.println("We don't sell "+ item);
            return 0;
        }
        if (basket.removeFromBasket(stockItem,quantity)==quantity){
            return stockList.unreservedStock(item,quantity);
        }
        return 0;
    }
    public static void checkOut(Basket basket){
        for (Map.Entry<StockItem,Integer>item:basket.items().entrySet()){
            stockList.sellStock(item.getKey().getName(),item.getValue());
        }
        basket.clearBasket();
    }
}
