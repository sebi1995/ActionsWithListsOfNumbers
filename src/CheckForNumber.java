import java.util.*;
import java.util.regex.Pattern;

class CheckForNumber {

    CheckForNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter list size.");
        System.out.print("List size: ");
        int size = scanner.nextInt();
        System.out.println();
        System.out.println("Do you wish the list of numbers to be random?");
        System.out.println("Enter Y/y for random, anything else for not random.");
        System.out.print("Random: ");
        String random = scanner.next();

        ArrayList<Integer> arrayList;
        if (random.equals("Y") || random.equals("y")) {
            arrayList = randomList(size);
        } else {
            arrayList = new ArrayList<>(size);
            for (int i = 0; i < size; ++i) {
                System.out.print("Position " + (i + 1) + ": ");
                arrayList.add(i, scanner.nextInt());
            }
        }

        for (int i :
                arrayList) {
            System.out.print(i + " ");
        }

        System.out.println("How do you want to check for your number?");
        System.out.println("Enter 1 for the inefficient way.");
        System.out.println("Enter 2 for the efficient way.");
        System.out.println("Enter 3 for hashMap method.");
        System.out.println("Enter anything else to exit.");

        String number = scanner.next();
        System.out.println("Please enter a number you want to test with.");
        System.out.print("Number: ");
        int num = scanner.nextInt();

        boolean isItThere = false;

        switch (number) {
            case "1":
                isItThere = getInefficientAnswer(arrayList, num);
                break;
            case "2":
                isItThere = getEfficientAnswer(arrayList, num);
                break;
            case "3":
                isItThere = getHashMapAnswer(arrayList, num);
                break;
            default:
                System.exit(0);
        }
        if (isItThere) {
            System.out.println("Your number: " + num + " is in the list!");
        } else System.out.println("Your number: " + num + " is not in the list!");
    }

    private boolean getInefficientAnswer(ArrayList<Integer> arrayList, int number) {
        for (Integer anArrayList : arrayList)
            if (anArrayList.equals(number)) return true;
        return false;
    }

    private boolean getEfficientAnswer(ArrayList<Integer> arrayList, int num) {
        int listSize = arrayList.size();
        int listSize2 = arrayList.size() / 2;

        int startPoint = listSize2;
        int endPoint = listSize;

        if (arrayList.get(listSize2) == num) {
            return true;
        } else {
            do {
                startPoint = (num > arrayList.get(startPoint)) ? arrayList.indexOf(arrayList.get(listSize2)) : 0;
                endPoint = (num > arrayList.get(listSize2)) ? listSize : listSize2;
            } while (endPoint - startPoint > 5);

            for (int i = startPoint; i < endPoint; ++i)
                if (arrayList.get(i) == num) return true;
        }
        return false;
    }

    private boolean getHashMapAnswer(ArrayList<Integer> arrayList, int num) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; ++i) hashMap.put(i, arrayList.get(i));
        return hashMap.containsValue(num);
    }

    private ArrayList<Integer> randomList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; ++i)
            arrayList.add(i, (i + 1));
        return arrayList;
    }
}
