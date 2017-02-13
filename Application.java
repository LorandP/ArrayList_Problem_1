import java.awt.*;
import java.util.*;

/**
 * Created by Lori on 2/10/2017.
 */
public class Application {

    private String arrayListProblem() {

        ArrayList<Integer> returnedList = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        returnedList = insertingNumbers();

        for (int index = 0; index < returnedList.size();index++)
        {
            System.out.print(returnedList.get(index)+" ");
        }


        return "";
    }

    private ArrayList<Integer> insertingNumbers ()
    {
        ArrayList<Integer> lineNumbers = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        String value = " ";
        double numberFromInput = 0.0;
        int counterOfLine = 0;

        while (!value.equals("quit")) {
            try {
                System.out.format("Enter the numbers for line - %d - or type 'quit' to exit: ", counterOfLine);
                String[] numbersAsStrings = input.nextLine().split("\\s");

                for (int index = 0; index < numbersAsStrings.length; index++) {
                    if (numbersAsStrings[index].equals("quit")) {
                        value = numbersAsStrings[index];
                        break;
                    } else {
                        numberFromInput = Double.parseDouble(numbersAsStrings[index]);
                        if (numberFromInput > Integer.MAX_VALUE) {
                            System.out.println("Please enter a smaller number: ");
                            counterOfLine--;
                            break;
                        } else {
                            lineNumbers.add(Integer.parseInt(numbersAsStrings[index]));
                        }
                    }
                }
                counterOfLine++;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter a number or 'quit' if you want to exit!");
            }
        }
        lineNumbers.add(0, lineNumbers.size());
        return lineNumbers;
    }

    private void queryingTheArrayList(ArrayList<Integer> listOfNumbers)
    {}

    public static void main(String[] args) {
        Application application = new Application();
        application.arrayListProblem();
    }
}
