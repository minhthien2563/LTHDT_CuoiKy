import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Food extends Management {
    private LocalDate mfg;
    private LocalDate exp;
    private String producer;

    public Food(String Code, String Name, int In_Stock, Double Price, LocalDate Mfg, LocalDate Exp, String Producer) {
        code = Code;
        name = Name;
        in_stock = In_Stock;
        price = Price;
        mfg = Mfg;
        exp = Exp;
        producer = Producer;
    }

    public Food() {
    }

    private void setExp(LocalDate Exp) {
        if (Exp.isAfter(mfg))
            this.exp = Exp;
    }

    private void setMfg(LocalDate Mfg) {
        this.mfg = Mfg;
    }

    private void setProducer(String Producer) {
        this.producer = Producer;
    }

    public double getVat() {
        return 5/100;
    }

    @Override
    public void insertProduct() {
        super.insertProduct();

        Scanner input = new Scanner(System.in);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        
        System.out.println("Hay nhap ngay san xuat:\n\t\tCu phap: DD-MM-YYYY");
        setMfg(LocalDate.parse(input.nextLine(), formatter));

        System.out.println("Hay nhap ngay het han:\n\t\tCu phap: DD-MM-YYYY");
        setExp(LocalDate.parse(input.nextLine(), formatter));

        System.out.print("Hay nhap nha cung cap: ");
        setProducer(input.nextLine());
    }

    @Override
    public void setProduct() {
        super.setProduct();

        Scanner input = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
        System.out.println("Ngay san xuat hien tai la " + this.mfg + ", ban muon dieu chinh thanh gi?");
        setMfg(LocalDate.parse(input.nextLine(), formatter));

        System.out.println("Ngay het han hien tai la " + this.exp + ", ban muon dieu chinh thanh gi?");
        setExp(LocalDate.parse(input.nextLine(), formatter));
    }

    @Override
    public boolean getSalesLevel() {
        if (in_stock > 0)
            if (LocalDate.now().isAfter(mfg)) {
                return false;
            }
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\t| Ngay san xuat: " + formatDate(this.mfg) + "\t| Ngay het han: " + formatDate(this.exp) + "\t| Nha cung cap: " + this.producer;
    }
}
