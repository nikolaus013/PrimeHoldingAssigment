import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;

public class Cart {
    private double totalPrice;
    private double subTotal;
    private LocalDate purchaseDate;

    private Map<Product,Double>  products;

    public Cart() {
        totalPrice = 0;
        products = new HashMap<>();
        purchaseDate = LocalDate.now();
        subTotal = 0;
    }

    public Cart(double totalPrice, double subTotal, LocalDate purchaseDate, Map<Product, Double> products) {
        this.totalPrice = totalPrice;
        this.subTotal = subTotal;
        this.purchaseDate = purchaseDate;
        this.products = products;
    }

    //Function that checks if the given day is weekend
    public static boolean isWeekend(final LocalDate ld)
    {
        DayOfWeek day = DayOfWeek.of(ld.get(ChronoField.DAY_OF_WEEK));
        return day == DayOfWeek.SUNDAY || day == DayOfWeek.SATURDAY;
    }

    //Function that calculates discount on given price
    public double discountCalculator(double price, int discountPercentage) {
        double discount = 0;
        double toBePaid = 0;
        discount = (price * discountPercentage) / 100;
        toBePaid = price - discount;
        return toBePaid;
    }

    //Adds product and quantity to map
    public void addToCart(Product product,double quantity){
        products.put(product,quantity);

    }

    /*
    Function that calculates Total price, with discount, that needs to be paid.
    Subtotal price withouth discount and ammount of money saved by discount.
    Also it checks instance of product so the discount can be calculated
     */
    public void checkout(){
        for (Map.Entry<Product, Double> p: products.entrySet()){
            Product productType = p.getKey();
            double quantityOfProduct = p.getValue();
            if(productType instanceof Appliance){
                if(isWeekend(purchaseDate) && productType.getPrice()>999){
                    subTotal += productType.getPrice() * quantityOfProduct;
                    double discountedPrice = discountCalculator(productType.getPrice(),5);
                    totalPrice += discountedPrice*quantityOfProduct;

                } else{
                    subTotal += productType.getPrice() * quantityOfProduct;
                    totalPrice += productType.getPrice() * quantityOfProduct;
                }
            }
            if(productType instanceof Clothes){
                if(!isWeekend(purchaseDate)){
                    subTotal += productType.getPrice() * quantityOfProduct;
                    double discountedPrice = discountCalculator(productType.getPrice(),10);
                    totalPrice += discountedPrice*quantityOfProduct;

                }else{
                    subTotal += productType.getPrice() * quantityOfProduct;
                    totalPrice += productType.getPrice() * quantityOfProduct;
                }

            }



            if(productType instanceof FoodAndBeverages){
                if(((FoodAndBeverages) productType).getExpDate().compareTo(purchaseDate) < 5){
                    subTotal += productType.getPrice() * quantityOfProduct;
                    double discountedPrice = discountCalculator(productType.getPrice(),10);
                    totalPrice += discountedPrice*quantityOfProduct;

                }else if(((FoodAndBeverages) productType).getExpDate().compareTo(purchaseDate) == 0){
                    subTotal += productType.getPrice() * quantityOfProduct;
                    double discountedPrice = discountCalculator(productType.getPrice(),50);
                    totalPrice += discountedPrice*quantityOfProduct;

                }
                else{
                    subTotal += productType.getPrice() * quantityOfProduct;
                    totalPrice += productType.getPrice() * quantityOfProduct;
                }
            }
        }
    }

    /*
    Goes thorugh products checks the discounts for printing.
    Prints Total ammount thats needed to be paid, also shows subtotal and money saved(Discount).
     */

    public void printReceipt(){
        System.out.println("Date  :" + purchaseDate + "\n");
        System.out.println("---Products---" + "\n");

        for (Map.Entry<Product, Double> p: products.entrySet()) {
            Product product = p.getKey();
            double quantityOfProduct = p.getValue();

            if(product instanceof Appliance){
                if(isWeekend(purchaseDate) && product.getPrice()>999){
                    double discountedPrice = discountCalculator(product.getPrice(),5);
                    System.out.println(product.getName() + " - " + product.getBrand());
                    System.out.println(quantityOfProduct + " x " + product.getPrice());
                    System.out.println("#discount " + 5 + "% -$" + discountedPrice + "\n");

                } else{
                    System.out.println(product.getName() + " - " + product.getBrand());
                    System.out.println(quantityOfProduct + " x " + product.getPrice() + "\n");
                }
            }
            if(product instanceof Clothes){
                if(!isWeekend(purchaseDate)){
                    double discountedPrice = discountCalculator(product.getPrice(),10);

                    System.out.println(product.getName() + " - " + product.getBrand());
                    System.out.println(quantityOfProduct + " x " + product.getPrice());
                    System.out.println("#discount " + 10 + "% -$" + discountedPrice + "\n");

                }else{
                    System.out.println(product.getName() + " - " + product.getBrand());
                    System.out.println(quantityOfProduct + " x " + product.getPrice() + "\n");
                }
            }

            if(product instanceof FoodAndBeverages){
                if(((FoodAndBeverages) product).getExpDate().compareTo(purchaseDate) < 5){
                    double discountedPrice = discountCalculator(product.getPrice(),10);

                    System.out.println(product.getName() + " - " + product.getBrand());
                    System.out.println(quantityOfProduct + " x " + product.getPrice());
                    System.out.println("#discount " + 10+ "% -$" + discountedPrice + "\n");

                }else if(((FoodAndBeverages) product).getExpDate().compareTo(purchaseDate) == 0){
                    double discountedPrice = discountCalculator(product.getPrice(),50);

                    System.out.println(product.getName() + " - " + product.getBrand());
                    System.out.println(quantityOfProduct + " x " + product.getPrice());
                    System.out.println("#discount " + 50+ "% -$" + discountedPrice + "\n");

                }
                else{
                    System.out.println(product.getName() + " - " + product.getBrand());
                    System.out.println(quantityOfProduct + " x " + product.getPrice() + "\n");
                }
            }
        }

        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("SUBTOTAL:  $" + subTotal);
        System.out.println("DISCOUNT:  $" + (totalPrice-subTotal) + "\n");
        System.out.println("TOTAL:   $" + totalPrice );

    }
}
