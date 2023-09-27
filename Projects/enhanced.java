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

    public Contact search(String name) {
        TreeNode result = searchRecursive(root, name);
        return (result != null) ? result.contact : null;
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

    public boolean delete(String name) {
        TreeNode deletedNode = deleteRecursive(root, name);
        return deletedNode != null;
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

 class PhonebookApp1 {
    private static final int ADD_CONTACT = 1;
    private static final int SEARCH_CONTACT = 2;
    private static final int DISPLAY_CONTACTS = 3;
    private static final int EDIT_CONTACT = 4;
    private static final int DELETE_CONTACT = 5;
    private static final int EXIT = 6;

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

            int choice = getChoice(sc);

            switch (choice) {
                case ADD_CONTACT:
                    addContact(phonebook, sc);
                    break;
                case SEARCH_CONTACT:
                    System.out.print("Enter contact name to search: ");
                    String searchName = sc.nextLine();
                    Contact foundContact = phonebook.search(searchName);
                    if (foundContact != null) {
                        System.out.println("Contact found: " + foundContact.name + " - " + foundContact.phoneNumber);
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;
                case DISPLAY_CONTACTS:
                    System.out.println("\nAll Contacts:");
                    phonebook.displayInOrder();
                    break;
                case EDIT_CONTACT:
                    editContact(phonebook, sc);
                    break;
                case DELETE_CONTACT:
                    deleteContact(phonebook, sc);
                    break;
                case EXIT:
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

    private static int getChoice(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input. Enter your choice (1-6): ");
            sc.next();
        }
        return sc.nextInt();
    }

    private static void addContact(Phonebook phonebook, Scanner sc) {
        sc.nextLine();
        System.out.print("Enter contact name: ");
        String name = sc.nextLine();
        String phoneNumber = getValidPhoneNumber(sc);
        phonebook.insert(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    private static void editContact(Phonebook phonebook, Scanner sc) {
        sc.nextLine();
        System.out.print("Enter contact name to edit: ");
        String editName = sc.nextLine();
        boolean deleted = phonebook.delete(editName);
        if (deleted) {
            addContact(phonebook, sc);
            System.out.println("Contact edited successfully.");
        } else {
            System.out.println("Contact not found. Please enter a valid contact name to edit.");
        }
    }

    private static void deleteContact(Phonebook phonebook, Scanner sc) {
        System.out.print("Enter contact name to delete: ");
        String deleteName = sc.nextLine();
        boolean deleted = phonebook.delete(deleteName);
        if (deleted) {
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found. Please enter a valid contact name to delete.");
        }
    }

    private static String getValidPhoneNumber(Scanner sc) {
        String phoneNumber;
        do {
            System.out.print("Enter phone number (exactly 10 digits, positive integers only): ");
            phoneNumber = sc.nextLine();
        } while (!phoneNumber.matches("\\d{10}")); // Validate input as 10-digit positive integers
        return phoneNumber;
    }
}

