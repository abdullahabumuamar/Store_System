
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        ArrayList<Product> itemList = new ArrayList<>();
        ArrayList<Customer> customerList = new ArrayList<>();

        while (true) {
            
            showMenu();
            try {
                int select = kb.nextInt();
                if (select == 1) {
                    addItem(kb, itemList);
                } else if (select == 2) {
                    addCustomer(kb, customerList);
                } else if (select == 3) {
                    addToCart(kb, customerList, itemList);
                } else if (select == 4) {
                    showCustomerCart(kb, customerList);
                } else if (select == 5) {
                    emptyCustomerCart(kb, customerList);
                } else if (select == 6) {
                    searchItemByName(kb, itemList);
                } else if (select == 7) {
                    System.out.println("good bye");
                    System.exit(0);
                } else {
                    System.out.println("Error: Invalid value, Input an integer number from 1 to 7, try a gain!!");
                    kb.nextLine();
                    returnMainMenu(kb);
                }
            } catch (Exception e) {
                System.out.println("Error: Invalid value, try a gain!!");
                kb.nextLine();
                returnMainMenu(kb);
            }
        }
    }

    public static void showMenu() {
        System.out.println("Store System Menu: ");
        System.out.print(
                "1. Add a new Item to Store \n"
                + "2. Add a new Customer to Store \n"
                + "3. Add an item to Customer shopping cart \n"
                + "4. View the items in the Customer shopping cart \n"
                + "5. Empty Customer shopping cart \n"
                + "6. Search for a product name inside the store \n"
                + "7. Exit the program \n"
                + "Enter the Operation Number [1 - 7]: "
        );
    }

    public static void addItem(Scanner kb, ArrayList<Product> itemList) {
        System.out.println("Add Item Operation:");
        System.out.print("The Item number: ");
        int itemNumber = kb.nextInt();
        kb.nextLine();
        System.out.print("The Item Name: ");
        String itemName = kb.nextLine();
        System.out.print("The Item Price: ");
        double itemPrice = kb.nextDouble();
        System.out.print("The Item Quantity: ");
        int itemQuantity = kb.nextInt();
        kb.nextLine();
        System.out.print("Choose the item type: (B) Book, (S) Shoes, (G) Game: ");
        String itemTypeSelected = kb.nextLine();
        ProductType itemType = null;
        if (itemTypeSelected.equalsIgnoreCase("B")) {
            System.out.println("Enter the Book data: ");
            System.out.print("Please Enter Author Name: ");
            String authorName = kb.nextLine();
            System.out.print("Please Enter Book language: ");
            String language = kb.nextLine();
            itemType = new Book(authorName, language);
        } else if (itemTypeSelected.equalsIgnoreCase("S")) {
            System.out.println("Enter the Shoes data: ");
            System.out.print("Please Enter Shoes Style: ");
            String style = kb.nextLine();
            System.out.print("Please Enter Shoes Color: ");
            String color = kb.nextLine();
            System.out.print("Please Enter Shoes Size: ");
            int size = kb.nextInt();
            kb.nextLine();
            itemType = new Shoes(style, color, size);
        } else if (itemTypeSelected.equalsIgnoreCase("G")) {
            System.out.println("Enter the Game data:");
            System.out.print("Please Enter Release Date: ");
            String releaseDate = kb.nextLine();
            System.out.print("Please Enter Company Name: ");
            String companyName = kb.nextLine();
            System.out.print("Please Enter Rating: ");
            double rating = kb.nextDouble();
            kb.nextLine();
            itemType = new Game(releaseDate, companyName, rating);
        }
        Product item = new Product(itemNumber, itemQuantity, itemName, itemPrice, itemType);
        itemList.add(item);
        System.out.println("Item Added Successfully");
        System.out.print("Do you want to add another item?? (Y, N): ");
        String addAnother = kb.nextLine();
        if (addAnother.equalsIgnoreCase("Y")) {
            addItem(kb, itemList);
        }
    }

    public static void addCustomer(Scanner kb, ArrayList<Customer> customerList) {
        System.out.println("Add Customer Operation: ");
        System.out.print("Enter The Customer number : ");
        int customerNumber = kb.nextInt();
        kb.nextLine();
        System.out.print("Enter The Customer Name: ");
        String customerName = kb.nextLine();
        Customer customer = new Customer(customerNumber, customerName, new ArrayList<>());
        customerList.add(customer);
        System.out.println("Customer was added with empty shopping cart Successfully");
        System.out.print("Do you want to add another customer?(Y,N): ");
        String addAnother = kb.nextLine();
        if (addAnother.equalsIgnoreCase("Y")) {
            addCustomer(kb, customerList);
        }
    }

    public static void addToCart(Scanner kb, ArrayList<Customer> customerList, ArrayList<Product> itemList) {
        System.out.println("Add Item to Customer Shopping Cart Operation:");
        System.out.print("Please Enter the Customer number: ");
        int customerNumber = kb.nextInt();
        for (Customer customer : customerList) {
            if (customer.id == customerNumber) {
                System.out.println(customer);
                System.out.println("Item in the Store: ");
                for (int i = 0; i < itemList.size(); i++) {
                    System.out.println(">>> " + (i + 1) + " " + itemList.get(i).toString());
                }
                System.out.println(">>> 0. Return the main menu");
                System.out.print("Enter Your Choice: ");
                int itemChoice = kb.nextInt();

                if (itemChoice > 0) {
                    System.out.print("Item Quantity: ");
                    int itemQuantity = kb.nextInt();
                    kb.nextLine();
                    Product item = itemList.get(itemChoice - 1);
                    if (item.quantity >= itemQuantity) {
                        Cart cart = new Cart(item, itemQuantity);
                        customer.cart.add(cart);
                        item.quantity -= itemQuantity;

                        System.out.println("This item was added successfully");
                    } else {
                        System.out.println("Sorry the required quantity is not available, the quantity available is [" + item.quantity + "], please try again!!");
                    }

                    System.out.println("Do you want to add another item to shopping cart?? (Y, N): ");
                    String addAnother = kb.nextLine();
                    if (addAnother.equalsIgnoreCase("Y")) {
                        addToCart(kb, customerList, itemList);
                    }
                }
                break;

            }

        }
    }

    public static void showCustomerCart(Scanner kb, ArrayList<Customer> customerList) {
        System.out.println("View the items in Customer shopping cart Operation: ");
        System.out.print("Enter Customer number: ");
        int customerNumber = kb.nextInt();
        kb.nextLine();
        for (Customer customer : customerList) {
            if (customer.id == customerNumber) {
                System.out.println(customer.toCart());
                break;
            }
        }
        returnMainMenu(kb);
    }

    public static void emptyCustomerCart(Scanner kb, ArrayList<Customer> customerList) {
        System.out.println("Empty Customer shopping Operation");
        System.out.print("Customer number: ");
        int customerNumber = kb.nextInt();
        kb.nextLine();
        for (Customer customer : customerList) {
            if (customer.id == customerNumber) {
                customer.cart.clear();
                break;
            }
        }
        System.out.println("The cart of this customer was cleaned successfully");
        returnMainMenu(kb);
    }

    public static void searchItemByName(Scanner kb, ArrayList<Product> itemList) {
        System.out.println("Search for a product name inside the store Operation: ");
        System.out.print("Enter the name product you want to search for:  ");
        kb.nextLine();
        String itemName = kb.nextLine();
        for (Product item : itemList) {
            if (item.name.equalsIgnoreCase(itemName)) {
                System.out.println(item);
                break;
            }
        }
        returnMainMenu(kb);
    }

    public static void returnMainMenu(Scanner kb) {
        System.out.println("Enter (M) to return the menu: ");
        kb.nextLine();
    }
    

}
