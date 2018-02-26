import java.util.ArrayList;
import java.util.Scanner;

public class IsSumInList {

    IsSumInList() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How big is the list?");
        System.out.print("Size: ");
        int size = scanner.nextInt();
        ArrayList<Integer> arrayList = new ArrayList<>(size);

        System.out.println();
        for (int i = 0; i < size; ++i) {
            System.out.print("Enter number for position " + (i + 1) + ": ");
            arrayList.add(scanner.nextInt());
        }

        System.out.println("\nWhat number do you want to test with?");
        System.out.print("Number: ");
        int number = scanner.nextInt();

        if (testTheOrderedArray(arrayList, number, 0, arrayList.size() - 1)) {
            System.out.println("Number " + number + " is in the array given.");
        } else System.out.println("Number " + number + " is not in the array given.");
    }

    private static boolean testTheOrderedArray(ArrayList<Integer> arrayList, int number, int a, int b) {
        int test = arrayList.get(a) + arrayList.get(b);

        if (a == b) {
            return false;
        } else if (test == number) {
            return true;
        } else if (test > number) {
            return testTheOrderedArray(arrayList, number, a, --b);
        } else return testTheOrderedArray(arrayList, number, ++a, b);

    }
}
