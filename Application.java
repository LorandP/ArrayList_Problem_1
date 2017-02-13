import java.awt.*;
import java.util.*;

/**
 * Created by Lori on 2/10/2017.
 */
public class Application {

    private void arrayListProblem() {

        ArrayList<Integer> returnedList = new ArrayList<Integer>();
        Collection listOfArrayList = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int counterOfLine = 1;
        boolean validEntry = false;
        int size = 0;

        while(!validEntry) {
            try {
                System.out.print("Enter the amount of lines that you want to add: ");
                size = Integer.parseInt(input.nextLine());
                validEntry = true;
            }
            catch (NumberFormatException ex){
                System.out.println("Entered value is not a number.");
            }
        }
        String[] numbersAsStrings = new String[size];

        while (counterOfLine <= size) {
            try {
                System.out.format("Enter the numbers for line %d : ", counterOfLine);
                numbersAsStrings = input.nextLine().split("\\s");

                for (int index = 0; index < numbersAsStrings.length; index++) {
                    if (numbersAsStrings[index].matches("[0-9]+")) {
                        returnedList = insertingNumbersInArrayList(numbersAsStrings);
                    } else {
                        System.out.format("You have entered a string of characters. \n" +
                                "Please enter the numbers for line %d again.", counterOfLine);
                        counterOfLine--;
                        break;
                    }
                }
                System.out.println();
                counterOfLine++;
            } catch (NumberFormatException ex) {
                System.out.format("You have entered a number that is too big. \n" +
                        "Please enter the numbers for line %d again.", counterOfLine);
            }

            listOfArrayList.add(returnedList);
        }
    }

    private ArrayList<Integer> insertingNumbersInArrayList(String[] numbers) {
        ArrayList<Integer> lineNumbers = new ArrayList<Integer>();

        for (int index = 0; index < numbers.length; index++) {
            lineNumbers.add(Integer.parseInt(numbers[index]));
        }
        lineNumbers.add(0, lineNumbers.size());
        return lineNumbers;
    }

    private void queryTheLines(Collection listOfLines) {
        Scanner input = new Scanner(System.in);


        System.out.println("To query the lines, enter the line and the position you want to query from.");


    }

    public static void main(String[] args) {
        Application application = new Application();
        application.arrayListProblem();
    }
}
