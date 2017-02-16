import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Lori on 2/10/2017.
 */
public class Application {
    /**
     * This method instantiates three other methods, the first is used to insert lines of numbers into an Array List.
     * The second queries a specific line and number by their index from the Array list and the third verifies if the line
     * and number requested by the second method exists and if it does it will display it.
     */
    private void arrayListProblem() {
        List<List<Integer>> linesAndColumns;
        List<List<Integer>> queries;

        linesAndColumns = insertingLines();
        queries = queryTheLines(linesAndColumns);
        verifyQuery(linesAndColumns, queries);
    }

    /**
     * This method is used to insert a number of lines from standard input and insert them into an arraylist and after that
     * insert each arraylist into a list.
     *
     * @return the list of arraylist.
     */
    private List<List<Integer>> insertingLines() {
        List<List<Integer>> linesAndColumns = new ArrayList<List<Integer>>();
        List<Integer> numberOfLines = new ArrayList<Integer>();
        List<List<Integer>> queryList = new ArrayList<List<Integer>>();
        Scanner input = new Scanner(System.in);
        int counterOfLine = 1;
        int size = 0;

        size = Integer.parseInt(getInput(input, "Enter the amount of lines that you want to add: "));
        numberOfLines.add(size);
        linesAndColumns.add(numberOfLines);

        while (counterOfLine <= size) {
            try {

                List<Integer> line = new ArrayList<Integer>();
                System.out.format("Enter the numbers for line %d : ", counterOfLine);
                String[] numbersAsStrings = input.nextLine().split("\\s");

                for (int index = 0; index < numbersAsStrings.length; index++) {
                    if (numbersAsStrings[index].matches("[0-9]+")) {
                        line.add(Integer.parseInt(numbersAsStrings[index]));
                    } else {
                        System.out.format("You have entered a string of characters. \n" +
                                "Please enter the numbers for line %d again.\n", counterOfLine);
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
                        "Please enter the numbers for line %d again.\n", counterOfLine);
            }
        }
        return linesAndColumns;
    }

    /**
     * This method is used to query the lines and numbers by their index from the list of arraylist.
     * First asks for the number of queries, after which it asks for two numbers.
     * One for the index of the line(arraylist) and one for the index of the number in that line and inserts them both into an arraylist,
     * after which it inserts them into a list.
     *
     * @param linesAndColumns the list of arraylist.
     * @return a list of arraylist filled with the queries.
     */
    private List<List<Integer>> queryTheLines(List<List<Integer>> linesAndColumns) {
        List<List<Integer>> listOfQueries = new ArrayList<List<Integer>>();
        Scanner input = new Scanner(System.in);
        int size = 0;
        int counterOfQueries = 0;
        boolean stringContainsNumbers = true;

        System.out.println("To query the lines, enter the number of the line and the the number of the position you want to query from.\n");
        size = Integer.parseInt(getInput(input, "Enter the amount of queries that you want to execute: "));

        while (counterOfQueries < size) {
            try {

                List<Integer> line = new ArrayList<Integer>();
                System.out.print("Enter line and position: ");
                String[] numberOfQueries = input.nextLine().split("\\s");

                System.out.println();
                for (int index = 0; index < numberOfQueries.length; index++) {
                    if (numberOfQueries[index].matches("[0-9]+")) {
                        if (numberOfQueries.length > 2) {
                            System.out.println("Please enter no more then 2 numbers.");
                            counterOfQueries--;
                            break;
                        }
                        if (numberOfQueries.length < 2) {
                            System.out.println("Please enter 2 numbers.");
                            counterOfQueries--;
                            break;
                        }
                        line.add(Integer.parseInt(numberOfQueries[index]));

                    } else {
                        System.out.format("You have entered a string of characters. \n" +
                                "Please enter the numbers again.\n");
                        counterOfQueries--;
                        break;
                    }
                }
                if (!line.isEmpty()) {
                    listOfQueries.add(line);
                }
                counterOfQueries++;
            } catch (NumberFormatException e) {
                System.out.format("You have entered a number that is too big.\n");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter two numbers.");
            }

        }
        return listOfQueries;
    }

    /**
     * This method is used to verify the existence of the numbers that are requested by the query.
     * If the numbers were found it display them in the order of the queries.
     *
     * @param linesOfNumbers the list of arraylist that contain all the numbers.
     * @param listOfQueries  the list of arraylist that contain the queries.
     */
    private void verifyQuery(List<List<Integer>> linesOfNumbers, List<List<Integer>> listOfQueries) {
        int position = 0;
        boolean check = false;
        int indexOfNumber = 0;

        try {
            for (int index = 0; index < listOfQueries.size(); index++) {
                check = false;

                for (int index2 = 1; index2 < linesOfNumbers.size(); index2++) {
                    if (listOfQueries.get(index).get(0).equals(index2)) {
                        ArrayList<Integer> numbersList = (ArrayList<Integer>) linesOfNumbers.get(index2);

                        for (int index3 = 0; index3 < numbersList.size(); index3++) {
                            if (listOfQueries.get(index).get(1).equals(index3)) {
                                System.out.println("Number = " + numbersList.get(index3));
                                check = true;
                                break;
                            }
                        }
                    }
                    indexOfNumber = 0;
                }
                if (check == false) {
                    System.out.println("ERROR!");
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println();
        }
    }

    /**
     * This method is used to get the input from the user and use the isInteger method which verifies if the input
     * is a number or not.
     *
     * @param input         the user input.
     * @param promptMessage a message that will prompt before the user inputs a value.
     * @return the input of the user in a string format.
     */
    private String getInput(Scanner input, String promptMessage) {
        System.out.print(promptMessage);
        String text = "";

        while (true) {
            text = input.nextLine();
            if (isInteger(text)) {
                break;
            }
            System.out.print("Entered value is not a number.\n" + promptMessage);

        }
        return text;
    }

    /**
     * This method verifies if a string is a number.
     *
     * @param string a string which contains a number or an array of characters.
     * @return true if it is a number and false otherwise.
     */

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
