import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// Class representing an inventory item
class InventoryItem {
    int itemId;
    String itemName;
    String itemCategory;

    public InventoryItem(int itemId, String itemName, String itemCategory) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemCategory = itemCategory;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId + ", Title: " + itemName + ", Category: " + itemCategory;
    }
}

public class InventorySearchSystem {

    // Searches for an item using linear search algorithm
    public static InventoryItem linearSearchItem(InventoryItem[] inventory, int searchId) {
        for (InventoryItem currentItem : inventory) {
            if (currentItem.itemId == searchId) {
                return currentItem;
            }
        }
        return null; // Return null if item not found
    }

    // Searches for an item using binary search algorithm (requires sorted array)
    public static InventoryItem binarySearchItem(InventoryItem[] inventory, int searchId) {
        int leftIndex = 0;
        int rightIndex = inventory.length - 1;

        while (leftIndex <= rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            if (inventory[middleIndex].itemId == searchId) {
                return inventory[middleIndex];
            } else if (inventory[middleIndex].itemId < searchId) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return null; // Return null if item not found
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println();

        // Get the number of items to store from user
        System.out.print("How many items would you like to add to inventory? ");
        int itemCount = userInput.nextInt();
        userInput.nextLine(); // Clear the newline character from buffer

        InventoryItem[] inventoryItems = new InventoryItem[itemCount];

        // Collect details for each inventory item
        for (int i = 0; i < itemCount; i++) {
            System.out.print("Enter ID for item #" + (i + 1) + ": ");
            int id = userInput.nextInt();
            userInput.nextLine(); // Clear buffer

            System.out.print("Enter name for item #" + (i + 1) + ": ");
            String name = userInput.nextLine();

            System.out.print("Enter category for item #" + (i + 1) + ": ");
            String category = userInput.nextLine();

            inventoryItems[i] = new InventoryItem(id, name, category);
        }

        // Sort the inventory by ID for binary search to work properly
        Arrays.sort(inventoryItems, new Comparator<InventoryItem>() {
            @Override
            public int compare(InventoryItem firstItem, InventoryItem secondItem) {
                return Integer.compare(firstItem.itemId, secondItem.itemId);
            }
        });

        // Get the item ID to search from user
        System.out.print("Enter the ID of the item to search: ");
        int targetItemId = userInput.nextInt();

        // Perform and display results of linear search
        InventoryItem linearSearchResult = linearSearchItem(inventoryItems, targetItemId);
        if (linearSearchResult != null) {
            System.out.println("Linear Search Result: " + linearSearchResult);
        } else {
            System.out.println("Item not found using linear search.");
        }

        // Perform and display results of binary search
        InventoryItem binarySearchResult = binarySearchItem(inventoryItems, targetItemId);
        if (binarySearchResult != null) {
            System.out.println("Binary Search Result: " + binarySearchResult);
        } else {
            System.out.println("Item not found using binary search.");
        }

        userInput.close();
    }
}
