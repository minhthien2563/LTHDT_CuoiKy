import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ProductList {
    private ArrayList<Management> product_list = new ArrayList<Management>();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-M-yyyy");
    
    public void createProduct() {
        Management food1 = new Food("TA-0", "Xuc xich", 2, 10000.0, LocalDate.parse("2-2-2022", formatter), LocalDate.parse("2-5-2022", formatter), "Duc xuc xich");
        product_list.add(food1);

        Management food2 = new Food("TA-1", "Banh bao", 100, 20000.0, LocalDate.parse("1-3-2022", formatter), LocalDate.parse("4-5-2022", formatter), "ABC");
        product_list.add(food2);

        Management food3 = new Food("TA-2", "Banh my", 10, 15000.0, LocalDate.parse("4-3-2022", formatter), LocalDate.parse("5-3-2022", formatter), "Ba bay");
        product_list.add(food3);

        Management crockery1 = new Crockery("CR-0", "Chen", 5, 6000.0, "Cau dat", LocalDate.parse("5-3-2002", formatter));
        product_list.add(crockery1);
        
        Management crockery2 = new Crockery("CR-1", "Dia", 13, 10000.0, "Cau dat", LocalDate.parse("5-3-2002", formatter));
        product_list.add(crockery2);

        Management crockery3 = new Crockery("CR-2", "Muong", 7, 3000.0, "Cau dat", LocalDate.parse("5-3-2002", formatter));
        product_list.add(crockery3);

        Management electrical1 = new Electrical("EL-0", "Bong den", 8, 100000.0, 6, 3.0);
        product_list.add(electrical1);

        Management electrical2 = new Electrical("EL-1", "Noi com", 31, 300000.0, 24, 2.3);
        product_list.add(electrical2);

        Management electrical3 = new Electrical("EL-2", "May giat", 20, 2000000.0, 12, 3.0);
        product_list.add(electrical3);

        Management electrical4 = new Electrical("EL-3", "May lanh", 100, 1500000.0, 36, 20.0);
        product_list.add(electrical4);
    }


    private boolean checkValidCode(String Code) {
        for(Management index : product_list) {
            if (Code.equals(index.code)) {
                return true;
            }       
        }
        return false;
    }

    protected void addProduct(int choose) {
        if (choose == 1) {
            Management food = new Food();

            food.insertProduct();
            
            if (checkValidCode(food.code))
                System.out.println("\t(!) Ma san pham nay da ton tai, hay thu lai.");
            else
                product_list.add(food);
        } else if (choose == 2) {
            Management crockery = new Crockery();

            crockery.insertProduct();

            if (checkValidCode(crockery.code))
                System.out.println("\t(!) Ma san pham nay da ton tai, hay thu lai.");
            else
                product_list.add(crockery);
        } else if (choose == 3) {
            Management electrical = new Electrical();

            electrical.insertProduct();

            if (checkValidCode(electrical.code))
                System.out.println("\t(!) Ma san pham nay da ton tai, hay thu lai.");
            else
                product_list.add(electrical);
        }
    }

    protected void editProduct(String Code) {
        if (checkValidCode(Code)) {
            for (int i = 0; i < product_list.size(); i++) {
                Management index = product_list.get(i);
                if (index.code.equals(Code)) {
                    index.setProduct();
                    product_list.set(i, index);
                    break;
                }
            }
        } else System.out.println("[!] Ma san pham khong ton tai.");
    }

    protected void removeProduct(String Code) {
        if (checkValidCode(Code)) {
            for(Management index : product_list) {
                if (Code.equals(index.code)) {
                    product_list.remove(index);
                    System.out.println("Da xoa san pham chua ma hang " + Code + " ra khoi danh sach.");
                    break;
                }
            }
        }
    }

    protected void findProduct(String Code) {
        boolean find = false;
        if (checkValidCode(Code)) {
            for(Management index : product_list) {
                if (Code.equals(index.code)) {
                    System.out.println(index.toString());
                    find = true;
                }
            }
        }
        if (!find)
            System.out.println("Khong tim thay san pham tuong ung voi ma nay.");
    }

    protected void printAllProducts() {
        for(Management index : product_list) {
            System.out.println("\n" + index.toString());
        }
    }

    protected void statisticProduct(int choose) {
        for (Management index : product_list) {
            if (choose == 1) {
                if (index.getSalesLevel())
                    System.out.println(index.toString());
            } else {
                if (!index.getSalesLevel())
                    System.out.println(index.toString());
            }
        }
        
    }
}
