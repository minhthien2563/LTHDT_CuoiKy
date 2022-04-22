import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Electrical extends Management {
    private int insurance_month;
    private Double power;

    public Electrical() {}

    public Electrical(String Code, String Name, int In_Stock, Double Price, int Insurance_month, Double Power) {
        code = Code;
        name = Name;
        in_stock = In_Stock;
        price = Price;
        insurance_month = Insurance_month;
        power = Power;
    }

    private void setInsurance(int Month) {
        if (Month >= 0) 
            this.insurance_month = Month;
    }

    private void setPower(Double Power) {
        if (Power > 0)
            this.power = Power;
    }

    @Override
    public boolean getSalesLevel() {
        if (in_stock < 3)
            return true;
        else
            return false;
    }

    @Override
    public double getVat() {
        return 10/100;
    }

    @Override
    public void insertProduct() {
        super.insertProduct();
        
        Scanner input = new Scanner(System.in);

        System.out.print("Hay nhap thoi gian bao hanh san pham (thang): ");
        setInsurance(input.nextInt());

        System.out.print("Hay nhap cong suat cua san pham: ");
        setPower(input.nextDouble());
    }

    @Override
    public String toString() {
        return super.toString() + "\t| Thoi gian bao hanh: " + insurance_month + "\t| Cong suat: " + power;
    }
}
