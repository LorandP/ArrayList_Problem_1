import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Lori on 2/10/2017.
 */
public class Application {

    private void arrayListProblem() {
        List<List<Integer>> linesAndColumns = new ArrayList<List<Integer>>();
        Scanner input = new Scanner(System.in);
        int counterOfLine = 1;
        int size = 0;

        size = Integer.parseInt(getInput(input, "Enter the amount of lines that you want to add: "));
        String[] numbersAsStrings = new String[size];

        while (counterOfLine <= size) {
            try {
                List<Integer> line = new ArrayList<Integer>();
                System.out.format("Enter the numbers for line %d : ", counterOfLine);
                numbersAsStrings = input.nextLine().split("\\s");

                for (int index = 0; index < numbersAsStrings.length; index++) {
                    if (numbersAsStrings[index].matches("[0-9]+")) {
                        line.add(Integer.parseInt(numbersAsStrings[index]));
                    } else {
                        System.out.format("You have entered a string of characters. \n" +
                                "Please enter the numbers for line %d again.", counterOfLine);
                        counterOfLine--;
                        break;
                    }
                }
                line.add(0, line.size());
                linesAndColumns.add(line);
                System.out.println();
                counterOfLine++;
            } catch (NumberFormatException ex) {
                System.out.format("You have entered a number that is too big. \n" +
                        "Please enter the numbers for line %d again.", counterOfLine);
            }
        }
        queryTheLines(linesAndColumns);

        //  -------  TEST -----
       /* boolean contains = true;
        int indexOfNumber = 0;
        System.out.println();
        System.out.println(" -- The List --\n");
        for (int index = 0; index < linesAndColumns.size(); index++) {
                ArrayList<Integer> list = (ArrayList<Integer>)linesAndColumns.get(index);
                for (Integer obj : list){
                    if (line == index && indexOfNumber == num) {
                        System.out.println(obj);
                        contains = true;
                        break;
                    }
                    else
                        contains = false;
                    indexOfNumber++;
                }
            indexOfNumber = 0;
        }
        if (contains == false)
            System.out.println("ERROR");*/
    }

    private void queryTheLines(List<List<Integer>> linesAndColumns) {
        Scanner input = new Scanner(System.in);
        int size = 0;
        int counterOfQueries = 0;
        int line = 0;
        int numberInLine = 0;
        boolean contains = true;
        int indexOfNumber = 0;
        boolean stringContainsNumbers = true;

        System.out.println("To query the lines, enter the number of the line and the the number of the position you want to query from.\n");
        size = Integer.parseInt(getInput(input, "Enter the amount of queries that you want to execute: "));

        //String[] numberOfQueries = new String[size];

        while (counterOfQueries < size) {
            try {
                System.out.println("size = "+size);
                System.out.println("counter of queries = "+counterOfQueries);
                System.out.print("Enter line and position: ");
                String[] numberOfQueries = input.nextLine().split("\\s");
                //System.out.format("Len= %d  [0]= %s  [1]= %s",numberOfQueries.length, numberOfQueries[0], numberOfQueries[1]);

                System.out.println();
                if (numberOfQueries.length > 2) {
                    System.out.println("Please enter no more then 2 numbers.");
                    counterOfQueries--;
                }

                for (int index = 0; index < numberOfQueries.length; index++) {
                    if (numberOfQueries[index].matches("[0-9]+")) {
                        line = Integer.parseInt(numberOfQueries[0]);
                        numberInLine = Integer.parseInt(numberOfQueries[1]);
                    } else {
                        System.out.format("You have entered a string of characters. \n" +
                                "Please enter the numbers again.\n");
                        stringContainsNumbers = false;
                        counterOfQueries--;
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.format("You have entered a number that is too big.");
            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Please enter two numbers.");
            }
            counterOfQueries++;
        }

        if (stringContainsNumbers) {
            for (int index = 0; index < linesAndColumns.size(); index++) {
                ArrayList<Integer> list = (ArrayList<Integer>) linesAndColumns.get(index);
                for (Integer obj : list) {
                    if (line == index && indexOfNumber == numberInLine) {
                        System.out.println(obj);
                        contains = true;
                        break;
                    } else
                        contains = false;
                    indexOfNumber++;
                }
                indexOfNumber = 0;
            }
            if (contains == false)
                System.out.println("ERROR");
        }
    }

    private String getInput(Scanner input, String promptMessage) {
        System.out.print(promptMessage);
        String text = "";
        while (true) {
            text = input.nextLine();
            if (isInteger(text))
                break;
            ;
            System.out.print("Entered value is not a number.\n" + promptMessage);
        }
        return text;
    }

    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.arrayListProblem();
    }
}
