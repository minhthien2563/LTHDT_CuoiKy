import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;


public class Crockery extends Management {
    private String producer;
    private LocalDate input_date;

    public Crockery(){}

    public Crockery(String Code, String Name, int In_Stock, Double Price, String Producer, LocalDate Input_Date) {
        code = Code;
        name = Name;
        in_stock = In_Stock;
        price = Price;
        producer = Producer;
        input_date = Input_Date;
    }

    private void setProducer(String Producer) {
        this.producer = Producer;
    }

    private void setInputDate(LocalDate Date) {
        this.input_date = Date;
    }

    private String getInputDate() {
        return formatDate(input_date);
    }

    private void insertInputDate(int choose) {
        
        if (choose == 0) {
            setInputDate(LocalDate.now());
        } else {
            Scanner input_d = new Scanner(System.in);
            System.out.println("Hay nhap thoi gian:\n\t\tCu phap: DD-MM-YYYY");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
            setInputDate(LocalDate.parse(input_d.nextLine(), formatter));
        }
    }

    @Override
    public double getVat() {
        return 10/100;
    }

    @Override
    public boolean getSalesLevel() {
        if (in_stock > 50) {
            if (betweenDates(LocalDate.now(), input_date) > 10) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void insertProduct() {
        super.insertProduct();
        
        Scanner input = new Scanner(System.in);

        System.out.print("Hay nhap nha san xuat: ");
        setProducer(input.nextLine());

        System.out.println("Hay lua chon cach nhap ngay nhap kho\n(0. Lay tu dong / 1. Nhap thu cong)");
        insertInputDate(input.nextInt());
    }

    @Override
    public String toString() {
        return super.toString() + "\t| Nha san xuat: " + this.producer + "\t| Ngay nhap hang: " + formatDate(this.input_date);
    }
}