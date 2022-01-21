import java.time.LocalDate;
import java.util.Date;

public class Appliance extends Product{
    private  String model;
    private double Weight;
    private LocalDate prodDate;

    public Appliance(String name, String brand, double price, String model, double weight, LocalDate prodDate) {
        super(name, brand, price);
        this.model = model;
        Weight = weight;
        this.prodDate = prodDate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public LocalDate getProdDate() {
        return prodDate;
    }

    public void setProdDate(LocalDate prodDate) {
        this.prodDate = prodDate;
    }
}
