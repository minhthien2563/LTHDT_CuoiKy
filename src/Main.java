import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductList product = new ProductList();
        Scanner input = new Scanner(System.in);
        
        product.createProduct();

        int choose;
        do {
            System.out.println("Quan ly hang hoa");
            System.out.println("\t0 -- Thoat chuong trinh (X)");
            System.out.println("\t1 -- Them hang hoa");
            System.out.println("\t2 -- Sua hang hoa");
            System.out.println("\t3 -- Xoa hang hoa");
            System.out.println("\t4 -- Tim kiem hang hoa");
            System.out.println("\t5 -- In danh sach hang hoa");
            System.out.println("\t6 -- Thong ke san pham");
            
            System.out.println("Lua chon cua ban?");
            choose = input.nextInt();
            input.nextLine();

            switch(choose) {
                case 1: {
                    System.out.println("Ban lua chon them loai hang hoa nao?\n\t1 -- Thuc an\t2 -- Sanh su \t3 -- Dien tu");
                    int select = input.nextInt();

                    if (select > 0 || select < 4)
                        product.addProduct(select);
                    break;
                }
                case 2: {
                    System.out.print("Hay nhap ma san pham ban muon thay doi thong tin: ");
                    product.editProduct(input.nextLine());
                    break;
                    
                }
                case 3: {
                    System.out.print("Hay nhap ma san pham ban can xoa: ");
                    product.removeProduct(input.nextLine());
                    break;
                }
                case 4: {
                    System.out.print("Hay nhap ma san pham ban can tim kiem: ");
                    product.findProduct(input.nextLine());
                    break;
                }
                case 5: {
                    product.printAllProducts();
                    break;
                }
                case 6: {
                    System.out.println("Ban lua chon xem thong ke loai nao?\n\t1 -- Ban duoc\t2 -- Khong ban duoc");
                    product.statisticProduct(input.nextInt());
                    break;
                }
            }
        } while (choose != 0);
    }
}
