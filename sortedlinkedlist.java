/**
 * Class that takes in an array of integers from a scanner and sorts it using a linked list,
 * from the smallest to largest.
 *
 * <P> This program continuously prompts the user for a integer input until the user enters "done". 
 * The integers are stored in a linked list and then sorted from smallest to largest. 
 * Prints the sorted linked list when the user enters "done".
 * 
 * @author Eric Dahle
 * @version 1.0
 * @since Week 4 of CSC6301
 */

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class sortedlinkedlist {
/**
 * Main entry point of the program.
 * <p> Uses the {@code userInput} method to receive a collection of integers to be stored in a linked list arranged from smallest to largest.
 * <p> Prints the sorted list after the user enters "done".
 * 
 * @param args Command-line arguments (not used in this program).
 */
    public static void main(String[] args) {
        List<Integer> list = userInput();
        System.out.println("Sorted Linked List: " + list);
    }

/**
 * Prompts the user to enter an integer or "done" when finished. 
 * 
 * <p> If the user enters an integer, the integer is added to the linked list using the {@code sortList} method. 
 * If the user enters "done", input collection is stopped and the sorted linked list is printed.
 * 
@return A sorted list of integers arranged from smallest to largest.
*/

    public static List<Integer> userInput() {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new LinkedList<>();

        while (true) {
            System.out.print("Enter an integer or \"done\" when finished: ");

            if (sc.hasNextInt()) {
                int input = sc.nextInt();
                sortList(list, input); // Reusing the list iterater from the sortList method
            } else {
                String input = sc.next();
                if (input.equalsIgnoreCase("done")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer or \"done\".");
                }
            }
        }

        sc.close();
        return list;
    }

    /**
     * Inserts an element into a sorted linked list.
     * 
     * <p> This method iterates through the linked list and inserts the element into the correct position sorting from smallest to largest.
     * 
     * @param list The linked list to insert the element into.
     * @param value The element to insert.
     */

    public static void sortList(List<Integer> list, int value) {
        ListIterator<Integer> listIterator = list.listIterator();

        while (listIterator.hasNext()) {
            if (listIterator.next() > value) { 
                listIterator.previous(); 
                listIterator.add(value);
                return;
            }
        }

        listIterator.add(value);
    }
}
