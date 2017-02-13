import java.awt.*;
import java.util.*;

/**
 * Created by Lori on 2/10/2017.
 */
public class Application {

    private String arrayListProblem() {

        ArrayList<Integer> returnedList = new ArrayList<Integer>();
        Collection listOfArrayList = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        double numberFromInput = 0.0;
        String value = " ";
        int counterOfLine = 1;

        while (!value.equals("quit")) {
            try {
                System.out.format("Enter the numbers for line - %d - or type 'quit' to exit: ", counterOfLine);
                String[] numbersAsStrings = input.nextLine().split("\\s");

                for (int index = 0; index < numbersAsStrings.length; index++) {
                    if (numbersAsStrings[index].equals("quit")) {
                        value = numbersAsStrings[index];
                        Arrays.fill(numbersAsStrings, null);
                        break;
                    } else {
                        returnedList = insertingNumbersInArrayList(numbersAsStrings);
                    }
                }

                /*for (int index = 0; index < returnedList.size(); index++) {
                    System.out.print(returnedList.get(index) + " ");

                }*/
                System.out.println();
                counterOfLine++;
            } catch (NumberFormatException ex) {
                System.out.println("You have entered a number that is too big, or a string of characters. \n" +
                        "Please enter the numbers for the line again.");
            }

            listOfArrayList.add(returnedList);
        }

        listOfArrayList.remove(listOfArrayList.size() - 1);
        System.out.println();
        System.out.println(" -- The collection --\n");


        for (Iterator it = listOfArrayList.iterator(); it.hasNext(); ) {
            System.out.print(it.next() + "\n");
        }

        return "";
    }

    private ArrayList<Integer> insertingNumbersInArrayList(String[] numbers) {
        ArrayList<Integer> lineNumbers = new ArrayList<Integer>();

        for (int index = 0; index < numbers.length; index++) {
            lineNumbers.add(Integer.parseInt(numbers[index]));
        }
        lineNumbers.add(0, lineNumbers.size());
        return lineNumbers;
    }

    private void queryingTheArrayList(ArrayList<Integer> listOfNumbers) {
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.arrayListProblem();
    }
}
