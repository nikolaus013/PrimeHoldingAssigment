import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws IOException {

        Cart cart = new Cart();

        //Adding dummy data, for testing
        FoodAndBeverages foodAndBeverage = new FoodAndBeverages("drink", "coca cola", 50, LocalDate.of(2022,1,22));
        cart.addToCart(foodAndBeverage, 3);

        FoodAndBeverages foodAndBeverage1 = new FoodAndBeverages("drink", "fanta", 50, LocalDate.of(2022,1,21));
        cart.addToCart(foodAndBeverage1, 3);

        FoodAndBeverages foodAndBeverage2 = new FoodAndBeverages("drink", "apple juice", 50, LocalDate.of(2022,1,30));
        cart.addToCart(foodAndBeverage2, 3);


        Appliance appliance = new Appliance("laptop", "HP", 700, "pavillion", 1.1, LocalDate.of(2021,5,10));
        cart.addToCart(appliance, 2);

        Appliance appliance1 = new Appliance("laptop", "lenovo", 1200, "thinkpad", 0.9, LocalDate.of(2021,5,10));
        cart.addToCart(appliance1, 1);

        Clothes clothes = new Clothes("shirt", "Gucci", 150, Size.L, "dark blue");
        cart.addToCart(clothes, 2);

        Clothes clothes1 = new Clothes("dress", "Zara", 70, Size.L, "black");
        cart.addToCart(clothes1, 3);


        cart.checkout();
        cart.printReceipt();
    }

}
