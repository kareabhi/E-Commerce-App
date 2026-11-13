import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        products.add(new Product(1, "Laptop", 55000));
        products.add(new Product(2, "Mobile", 20000));
        products.add(new Product(3, "Headphones", 1500));
        products.add(new Product(4, "Watch", 3000));

        while (true) {
            System.out.println("\n--- E-Commerce App ---");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                for (Product p : products) p.showProduct();
            } else if (choice == 2) {
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                for (Product p : products) {
                    if (p.getId() == id) {
                        cart.add(p);
                        System.out.println(p.getName() + " added to cart!");
                    }
                }
            } else if (choice == 3) {
                double total = 0;
                System.out.println("\n--- Your Cart ---");
                for (Product p : cart) {
                    p.showProduct();
                    total += p.getPrice();
                }
                System.out.println("Total: Rs." + total);
            } else if (choice == 4) {
                System.out.println("Order Placed Successfully! Thank You!");
                cart.clear();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid Choice!");
            }
        }
        sc.close();
    }
}
