import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.List;

class Product {
    int productId;
    String name;
    double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double discountedPrice) {
    }

    public static Product createProduct(int productId, String name, double price) {
        return new Product(productId, name, price);
    }
}

class PaymentGateway {
    // Simulate a simple payment processing logic
    public double processPayment(double amount, double totalBill) {
    // Check if the payment amount is valid (greater than or equal to the total bill)
        if (amount >= totalBill) {
            // Calculate change
            double change = amount - totalBill;

            if (change >= 0) {
                System.out.println("Processing payment of $" + amount);
                System.out.println("Payment successful!");
                if (change > 0) {
                    System.out.println("Change: $" + change);
                }

                return change;
            }
        }

        // Payment amount is insufficient or other errors
        System.out.println("Payment failed. Please try again or use another payment method.");
        return -1; // Return -1 to indicate payment failure
    }

}



class DoublyLinkedList {
    Node head;
    Node tail;
    int size;

    class Node {
        Product product;
        Node prev;
        Node next;

        Node(Product product) {
            this.product = product;
            this.prev = null;
            this.next = null;
        }
    }

    public void addToEnd(Product product) {
        Node newNode = new Node(product);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(int productId) {
        Node currentNode = head;

        while (currentNode != null) {
            if (currentNode.product.getProductId() == productId) {
                if (currentNode.prev != null) {
                    currentNode.prev.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode.prev;
                }
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public void display() {
        Node currentNode = head;
        System.out.println("Product List:");

        while (currentNode != null) {
            System.out.println(currentNode.product.getName() + " - $" + currentNode.product.getPrice());
            currentNode = currentNode.next;
        }
    }

    public int getSize() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void clear() {
    }
}

class User {
    private String username;
    private String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class BillingSystem {
    HashMap<String, User> users;
    private HashMap<Integer, Product> productCatalog;
    private DoublyLinkedList bill;
    private PaymentGateway paymentGateway;
    User loggedInUser;
    List<Product> productsToAdd;

    public BillingSystem() {
        // Initialize the payment gateway
        productCatalog = new HashMap<>();
        bill = new DoublyLinkedList();
        paymentGateway = new PaymentGateway();
        users = new HashMap<>();
        loggedInUser = null;
    }

    public void addProductToCatalog(Product product) {
        int productId = product.getProductId();
        
        if (productCatalog.containsKey(productId)) {
            throw new RuntimeException("The product ID " + productId + " has already been taken. Please enter a new ID.");
        }
        
        productCatalog.put(productId, product);
    }

    public void addMultipleProductsToCatalog(List<Product> products) {
    for (Product product : products) {
        int productId = product.getProductId();

        if (productCatalog.containsKey(productId)) {
            throw new RuntimeException("The product ID " + productId + " has already been taken. Please enter a new ID.");
        }

        productCatalog.put(productId, product);
    }
}


    public boolean addToBill(int productId) {
        if (productCatalog.containsKey(productId)) {
            Product product = productCatalog.get(productId);
            bill.addToEnd(product);
            return true;
        } else {
            System.out.println("Product not found in the catalog. Please add the product to the catalog first.");
            return false;
        }
    }

    public double calculateTotalBill() {
        double total = 0.0;
        DoublyLinkedList.Node currentNode = bill.getHead();

        while (currentNode != null) {
            total += currentNode.product.getPrice();
            currentNode = currentNode.next;
        }

        return total;
    }

    public void displayBill() {
        DoublyLinkedList.Node currentNode = bill.getHead();
        System.out.println("Bill:");

        while (currentNode != null) {
            System.out.println(
                    "Product: " + currentNode.product.getName() +
                            " - Price: ₹" + currentNode.product.getPrice() 
                            );
            currentNode = currentNode.next;
        }

        System.out.println("Total: ₹" + calculateTotalBill());
    }

    public void clearBill() {
        bill.clear();
    }

    public boolean removeProductFromBill(int productId) {
        return bill.remove(productId);
    }

    public double processPayment(double amount, double totalBill1) {
    double change = paymentGateway.processPayment(amount, calculateTotalBill());

    // You can handle the change here, for example, print it or perform other actions if needed.

    return change;
}




    public void displayProductCatalog() {
        System.out.println("=========================================");
        System.out.println("|  ID  |    Name    |    Price (₹)    |");
        System.out.println("=========================================");

        for (Product product : productCatalog.values()) {
            System.out.printf("|%5d |%12s |%15.2f |\n",
                    product.getProductId(),
                    product.getName(),
                    product.getPrice());
        }

        System.out.println("=========================================");
    }

    public boolean signup(String username, String password, String email) {
        if (!users.containsKey(username)) {
            if (isValidGmailEmail(email)) {
                User newUser = new User(username, password, email);
                users.put(username, newUser);
                return true;
            } else {
                System.out.println("Invalid email format. Please use an @gmail.com email address.");
            }
            // } else {
            // System.out.println("Username already exists. Please choose a different
            // one.");
        }
        return false;
    }

    public void displayAllProducts() {
        System.out.println("=========================================");
        System.out.println("|  ID  |    Name    |    Price (₹)    |");
        System.out.println("=========================================");

        for (Product product : productCatalog.values()) {
            System.out.printf("|%5d |%12s |%15.2f |\n",
                    product.getProductId(),
                    product.getName(),
                    product.getPrice());
        }

        System.out.println("=========================================");
    }


    private boolean isValidGmailEmail(String email) {
        boolean atFound = false;
        boolean dotFound = false;

        for (char c : email.toCharArray()) {
            if (c == '@') {
                if (atFound || dotFound) {
                    return false; // More than one '@' or a dot before '@'
                }
                atFound = true;
            } else if (c == '.') {
                if (!atFound) {
                    return false; // Dot before '@'
                }
                dotFound = true;
            }
        }

        return atFound && dotFound;
    }


    public boolean login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            if (user.getPassword().equals(password)) {
                loggedInUser = user;
                return true;
            }
        }
        return false;
    }

    public void logout() {
        loggedInUser = null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public boolean isUserLoggedIn() {
        return loggedInUser != null;
    }
}

class BillingSystemApp01002 {
    public static void main(String[] args) {
        BillingSystem billingSystem = new BillingSystem();
        Scanner scanner = new Scanner(System.in);

         List<Product> productsToAdd = new ArrayList<>();
        productsToAdd.add(new Product(1, "Apple", 0.99));
        productsToAdd.add(new Product(2, "Milk", 2.49));
        productsToAdd.add(new Product(3, "Soap", 1.99));
        productsToAdd.add(new Product(4, "Bread", 1.49));
        productsToAdd.add(new Product(5, "Eggs", 3.99));
        productsToAdd.add(new Product(6, "Toothpaste", 2.99));
        productsToAdd.add(new Product(7, "Shampoo", 4.99));
        productsToAdd.add(new Product(8, "Rice", 5.49));
        productsToAdd.add(new Product(9, "Potato", 0.79));
        productsToAdd.add(new Product(10, "Orange", 1.29));

    billingSystem.addMultipleProductsToCatalog(productsToAdd);

        while (true) {
            if (!billingSystem.isUserLoggedIn()) {
                System.out.println("Welcome to the Product Billing System!");
                System.out.println("1. Login");
                System.out.println("2. Sign Up");
                System.out.println("3. Exit");
                System.out.print("Please choose an option: ");
                try{
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter your username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter your password: ");
                        String password = scanner.nextLine();

                        if (billingSystem.login(username, password)) {
                            System.out.println("Login successful!");
                        } else {
                            System.out.println("Login failed. Please check your credentials.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter a new username: ");
                        String newUsername = scanner.nextLine();
                        System.out.print("Enter a password: ");
                        String newPassword = scanner.nextLine();
                        System.out.println("Enter a new email-id");
                        String newEmail = scanner.nextLine();

                        if (billingSystem.signup(newUsername, newPassword, newEmail)) {
                            System.out.println("Signup successful!");

                            // } else {
                            // System.out.println("Username already exists. Please choose a different
                            // one.");
                        }
                        break;
                    case 3:
                        System.out.println("Exiting the application.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                    }
                } catch(InputMismatchException e){
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.nextLine(); // Clear the invalid input from the scanner
                }
                
            } else {
                System.out.println("Welcome, " + billingSystem.getLoggedInUser().getUsername() + "!");
                System.out.println("Billing System Menu:");
                System.out.println("1.Add Product to Catalog");
                // System.out.println("2.Get discount on product");
                System.out.println("2. Add Product to Bill");
                System.out.println("3. Calculate Total Bill");
                System.out.println("4. Display Bill");
                System.out.println("5. Display All Products");
                System.out.println("6. Payment");
                System.out.println("7. Log Out");
                System.out.print("Please choose an option: ");

                try{
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        System.out.print("Enter Product ID: ");
                        int productId = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Product Name: ");
                        String productName = scanner.nextLine();
                        System.out.print("Enter Product Price: ");
                        double productPrice = scanner.nextDouble();
                        scanner.nextLine();

                        Product newProduct = Product.createProduct(productId, productName, productPrice);
                        billingSystem.addProductToCatalog(newProduct);
                        System.out.println("Product added to the catalog!");
                        break;

                    case 2:
                        System.out.print("Enter the Product ID to add to the bill: ");
                        int productIdToAdd = scanner.nextInt();
                        scanner.nextLine();
                        billingSystem.displayProductCatalog();

                        if (billingSystem.addToBill(productIdToAdd)) {
                            System.out.println("Product added to the bill!");
                        } else {
                            System.out.println("Failed to add the product to the bill. Product ID not found.");
                        }
                        break;

                    case 3:
                        double totalBill = billingSystem.calculateTotalBill();
                        System.out.println("---------------------------------------------");
                        System.out.println("Total Bill: $" + totalBill + "|");
                        System.out.println("---------------------------------------------");
                        break;

                    case 4:
                        billingSystem.displayBill();
                        // billingSystem.displayProductCatalog();
                        break;

                    case 6:
                        double totalBill1 = billingSystem.calculateTotalBill();
                        System.out.println("Total Bill: $" + totalBill1);
                        System.out.print("Enter payment amount: $");
                        double paymentAmount = scanner.nextDouble();
                        scanner.nextLine();

                        double change = billingSystem.processPayment(paymentAmount, totalBill1);

                        if (change >= 0) {
                            System.out.println("Thank you for your purchase.");
                            billingSystem.clearBill(); // Clear the bill after successful payment
                        } else {
                            System.out.println("Payment failed. Please try again or use another payment method.");
                        }

                        break;

                        case 5:
                            billingSystem.displayAllProducts();
                            break;

                        case 7:
                        billingSystem.logout();
                        System.out.println("Logged out successfully.");
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            } catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from the scanner
            }
            }
        }
    }
}

class CustomHashMap<K, V> {
    private Object[] keys;
    private Object[] values;
    private int capacity;
    private int size;

    public CustomHashMap(int capacity) {
        this.capacity = capacity;
        keys = new Object[capacity];
        values = new Object[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        int index = key.hashCode() % capacity;
        while (keys[index] != null && !keys[index].equals(key)) {
            index = (index + 1) % capacity;
        }
        keys[index] = key;
        values[index] = value;
        size++;
    }

    public V get(K key) {
        int index = key.hashCode() % capacity;
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return (V) values[index];
            }
            index = (index + 1) % capacity;
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = key.hashCode() % capacity;
        while (keys[index] != null) {
            if (keys[index].equals(key)) {
                return true;
            }
            index = (index + 1) % capacity;
        }
        return false;
    }
    
}
