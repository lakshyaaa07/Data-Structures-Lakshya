import java.util.Scanner;

class Contact {
    String name;
    String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}

class TreeNode {
    Contact contact;
    TreeNode left;
    TreeNode right;

    public TreeNode(Contact contact) {
        this.contact = contact;
        left = null;
        right = null;
    }
}

class Phonebook {
    private TreeNode root;

    public Phonebook() {
        root = null;
    }

    public void insert(Contact contact) {
        root = insertRecursive(root, contact);
    }

    private TreeNode insertRecursive(TreeNode root, Contact contact) {
        if (root == null) {
            root = new TreeNode(contact);
            return root;
        }

        if (contact.name.compareToIgnoreCase(root.contact.name) < 0) {
            root.left = insertRecursive(root.left, contact);
        } else if (contact.name.compareToIgnoreCase(root.contact.name) > 0) {
            root.right = insertRecursive(root.right, contact);
        }

        return root;
    }

    public void search(String name) {
        TreeNode result = searchRecursive(root, name);
        if (result != null) {
            System.out.println("Contact found: " + result.contact.name + " - " + result.contact.phoneNumber);
        } else {
            System.out.println("Contact not found.");
        }
    }

    private TreeNode searchRecursive(TreeNode root, String name) {
        if (root == null || root.contact.name.equalsIgnoreCase(name)) {
            return root;
        }

        if (name.compareToIgnoreCase(root.contact.name) < 0) {
            return searchRecursive(root.left, name);
        }

        return searchRecursive(root.right, name);
    }

    public void displayInOrder() {
        displayInOrderRecursive(root);
    }

    private void displayInOrderRecursive(TreeNode root) {
        if (root != null) {
            displayInOrderRecursive(root.left);
            System.out.println(root.contact.name + " - " + root.contact.phoneNumber);
            displayInOrderRecursive(root.right);
        }
    }

    public void delete(String name) {
        TreeNode deletedNode = deleteRecursive(root, name);
        if (deletedNode == null) {
            System.out.println("Contact not found. Please enter a valid contact name to delete.");
        } else {
            System.out.println("Contact deleted successfully.");
        }
    }

    private TreeNode deleteRecursive(TreeNode root, String name) {
        if (root == null) {
            return root;
        }

        if (name.compareToIgnoreCase(root.contact.name) < 0) {
            root.left = deleteRecursive(root.left, name);
        } else if (name.compareToIgnoreCase(root.contact.name) > 0) {
            root.right = deleteRecursive(root.right, name);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.contact = minValueNode(root.right).contact;
            root.right = deleteRecursive(root.right, root.contact.name);
        }

        return root;
    }

    private TreeNode minValueNode(TreeNode root) {
        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
}

public class PhonebookApp {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPhonebook Menu:");
            System.out.println("1. Add a Contact");
            System.out.println("2. Search for a Contact");
            System.out.println("3. Display All Contacts (In Order)");
            System.out.println("4. Edit a Contact");
            System.out.println("5. Delete a Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = sc.nextLine();
                    String phoneNumber;
                    do {
                        System.out.print("Enter phone number (exactly 10 digits, positive integers only): ");
                        phoneNumber = sc.nextLine();
                    } while (!phoneNumber.matches("\\d{10}")); // Validate input as 10-digit positive integers
                    phonebook.insert(new Contact(name, phoneNumber));
                    System.out.println("Contact added successfully.");
                    break;
                case 2:
                    System.out.print("Enter contact name to search: ");
                    String searchName = sc.nextLine();
                    phonebook.search(searchName);
                    break;
                case 3:
                    System.out.println("\nAll Contacts:");
                    phonebook.displayInOrder();
                    break;
                case 4:
                    System.out.print("Enter contact name to edit: ");
                    String editName = sc.nextLine();
                    phonebook.delete(editName);
                    System.out.print("Enter new contact name: ");
                    String newName = sc.nextLine();
                    String newPhoneNumber;
                    do {
                        System.out.print("Enter new phone number (exactly 10 digits, positive integers only): ");
                        newPhoneNumber = sc.nextLine();
                    } while (!newPhoneNumber.matches("\\d{10}")); // Validate input as 10-digit positive integers
                    phonebook.insert(new Contact(newName, newPhoneNumber));
                    System.out.println("Contact edited successfully.");
                    break;
                case 5:
                    System.out.print("Enter contact name to delete: ");
                    String deleteName = sc.nextLine();
                    phonebook.delete(deleteName);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting Phonebook.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        sc.close();
    }
}
