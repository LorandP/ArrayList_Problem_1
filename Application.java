import javax.swing.plaf.synth.SynthTextAreaUI;
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
        String sizeOfArray = "";
        String text = "";
        int counter = 1;

        size = Integer.parseInt(getInput(input, "Enter the amount of lines that you want to add: "));
        //sizeOfArray = Integer.toString(size);
        String[] numbersAsStrings;

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
                //line.add(0, size);
                //linesAndColumns.add(0, line);
                System.out.println();
                counterOfLine++;


            } catch (NumberFormatException ex) {
                System.out.format("You have entered a number that is too big. \n" +
                        "Please enter the numbers for line %d again.", counterOfLine);
            }
        }
        List<List<Integer>> queryList = new ArrayList<List<Integer>>();
        queryList = queryTheLines(linesAndColumns);
        verifyQuery(linesAndColumns, queryList);
        //  -------  TEST -----
        //System.out.println(queryList.get(1));
        /*
        for (int index = 0; index < queryList.size(); index++) {
            System.out.println(queryList.get(index));
            /*ArrayList<Integer> list = (ArrayList<Integer>)linesAndColumns.get(index);
                for (Integer obj : list){
                        System.out.println(obj);
                }
        }*/

    }

    private List<List<Integer>> queryTheLines(List<List<Integer>> linesAndColumns) {
        List<List<Integer>> listOfQueries = new ArrayList<List<Integer>>();
        Scanner input = new Scanner(System.in);
        int size = 0;
        int counterOfQueries = 0;
        //int line = 0;
        // int numberInLine = 0;
        boolean stringContainsNumbers = true;

        System.out.println("To query the lines, enter the number of the line and the the number of the position you want to query from.\n");
        size = Integer.parseInt(getInput(input, "Enter the amount of queries that you want to execute: "));

        while (counterOfQueries < size) {
            try {
                List<Integer> line = new ArrayList<Integer>();
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
                        line.add(Integer.parseInt(numberOfQueries[index]));
                        //line = Integer.parseInt(numberOfQueries[0]);
                        //numberInLine = Integer.parseInt(numberOfQueries[1]);
                    } else {
                        System.out.format("You have entered a string of characters. \n" +
                                "Please enter the numbers again.\n");
                        counterOfQueries--;
                        break;
                    }
                }
                listOfQueries.add(line);
            } catch (NumberFormatException e) {
                System.out.format("You have entered a number that is too big.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Please enter two numbers.");
            }
            counterOfQueries++;
        }
        return listOfQueries;
    }

    private void verifyQuery(List<List<Integer>> linesOfNumbers, List<List<Integer>> listOfQueries) {
        int position = 0;

        //System.out.println(listOfQueries.get(0).get(0) + " " +listOfQueries.get(0).get(1));
        //System.out.println("Index 0 Value 0 = " + linesOfNumbers.get(0).get(0));
        //System.out.println("Index 0 value 1 = " + linesOfNumbers.get(0).get(1));
        try {

            for (int index = 0; index < listOfQueries.size(); index++) {
                for (int index2 = 0; index2 < linesOfNumbers.size(); index2++) {
                    if (listOfQueries.get(index).get(0).equals(index2)) {
                        //System.out.println(linesOfNumbers.get(index2));
                        //System.out.println(index2);
                        //System.out.println();
                        //System.out.println(listOfQueries.get(index).get(1));


                        ArrayList<Integer> numbersList = (ArrayList<Integer>) linesOfNumbers.get(index2);
                        //ArrayList<Integer> query = (ArrayList<Integer>) listOfQueries.get(index);
                        //position = listOfQueries.get(2);
                        for (int index3 = 0; index < numbersList.size();index3++) {
                           // System.out.print(indexOfNumber + " - " + number + " | ");
                            //System.out.print(indexOfNumber + " ");
                            if (listOfQueries.get(index).get(1).equals(index3)) {
                                System.out.println("Number = " + numbersList.get(index3));
                                break;
                            } else {
                                System.out.println("ERROR!");
                            }
                        }
                    }
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
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
