import java.time.LocalDate;
import java.util.Date;

public class FoodAndBeverages extends Product{
    private LocalDate expDate;

    public FoodAndBeverages(String name, String brand, double price, LocalDate expDate) {
        super(name, brand, price);
        this.expDate = expDate;
    }


    public LocalDate getExpDate() {
        return expDate;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }
}
