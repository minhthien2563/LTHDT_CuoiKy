import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;


public abstract class Management {
    String code;
    String name;
    int in_stock;
    Double price;

    private void setCode(String Code) {
        this.code = Code;
    }

    private void setName(String Name) {
        if (!Name.isEmpty())
            this.name = Name;
    }

    private void setInStock(int Amount) {
        if (Amount >= 0)
            this.in_stock = Amount;
    }

    private void setPrice(Double Amount) {
        if (Amount > 0)
            this.price = Amount;
    }

    protected void insertProduct() {
        Scanner input = new Scanner(System.in);

        System.out.print("Hay nhap ma hang: ");
        setCode(input.nextLine());

        System.out.print("Hay nhap ten hang: ");
        setName(input.nextLine());

        System.out.print("Hay nhap so luong ton kho: ");
        setInStock(input.nextInt());
        input.nextLine();

        System.out.print("Hay nhap gia hang: ");
        setPrice(input.nextDouble());
    }

    protected void setProduct() {
        System.out.println("[!] Neu khong muon dieu chinh mot gia tri thong tin nao hay BO TRONG.");
        System.out.println("Ma san pham dang duoc sua la " + this.code);

        Scanner input = new Scanner(System.in);

        System.out.println("Ten hang hien tai la " + this.name + ", ban muon dieu chinh thanh gi?");
        String Name = input.nextLine();
        if(!Name.isEmpty()) setName(Name);

        System.out.println("So luong ton kho hien tai la " + this.in_stock + ", ban muon dieu chinh thanh bao nhieu?");
        int In_Stock = input.nextInt();
        input.nextLine();
        if (In_Stock != 0 && In_Stock != in_stock) setInStock(In_Stock); 

        System.out.println("Gia hang hien tai la " + this.price + ", ban muon dieu chinh thanh bao nhieu?");
        Double Price = input.nextDouble();
        input.nextLine();
        if (Price != 0 && Price != price) setPrice(Price);
    }

    public String toString() {
        return "\n+ Ma hang: " + this.code + "\t| Ten hang: " + this.name + "\t| So luong ton kho: " + this.in_stock + "\t| Gia hang: " + this.price;
    }

    /*
        + getSalesLevel
        If callback return TRUE is product reached sales
        If callback return FALSE is product do not reached sales
    */
    public abstract boolean getSalesLevel();
    public abstract double getVat();

    public static long betweenDates(LocalDate localDate, LocalDate input_date)
    {
        return ChronoUnit.DAYS.between(localDate.now(), input_date.now());
    }

    public String formatDate(LocalDate Date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        return Date.format(formatter);
    }
}