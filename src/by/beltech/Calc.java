package by.beltech;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by JenkaBY on 07.02.2017.
 */
public class Calc {
    private Double firstNumber;
    private Double secondNumber;
    private String action;
    private boolean isAllowed = true;
    private final static ArrayList<String> ALLOWED_ACTIONS;

    static {
        ALLOWED_ACTIONS = new ArrayList<>();
        ALLOWED_ACTIONS.add("+");
        ALLOWED_ACTIONS.add("-");
        ALLOWED_ACTIONS.add("*");
        ALLOWED_ACTIONS.add("/");
        ALLOWED_ACTIONS.add("sqrt");
        ALLOWED_ACTIONS.add("pow");
    }

    public void run() {
        CalcHelper calcHelper = new CalcHelper();

        String enteredLine;

        while (isAllowed) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                reader = new BufferedReader(new InputStreamReader(System.in));
                calcHelper.printEnterFirstNumber();

                enteredLine = reader.readLine();
                if (isExit(enteredLine)) break;

                firstNumber = calcHelper.parse(enteredLine);


                calcHelper.printEnterSecondNumber();
                enteredLine = reader.readLine();

                if (isExit(enteredLine)) break;
                secondNumber = calcHelper.parse(enteredLine);

                calcHelper.printAction(ALLOWED_ACTIONS);
                action = reader.readLine();

                if (isExit(enteredLine)) break;

                Double result = doAction(firstNumber, secondNumber, action);
                if (result == null) {throw new IllegalArgumentException();}
                else {
                    calcHelper.printResult(firstNumber,secondNumber, action,result);
                }
                    Thread.sleep(1000);
                System.out.println("----------------------------------------------");
            } catch (NumberFormatException e) {
                isAllowed = true;
                System.out.println("Your entered NUMBER is INCORRECT. Please try again.");
            } catch (IllegalArgumentException e) {
                isAllowed = true;
                System.out.println("Your entered ACTION is INCORRECT. Please try again.");
            } catch (IOException e) {
                System.out.println("Something went wrong.");
                isAllowed = false;
            } catch (Exception e) {
                isAllowed = false;
                System.out.println("Something went wrong.");
            } finally {
                if (!isAllowed) {
                    try {
                        reader.close();
                        System.out.println("Closing Calculator...");
                    } catch (IOException e) {
                        System.out.println("Something went wrong.");
                    }
                }
            }

        }
    }

    private boolean isExit(String text) {
        if (text.compareToIgnoreCase("exit") == 0) {
            isAllowed = false;
            return true;
        } else return false;

    }

    public Double doAction(Double firstNumber, Double secondNumber, String action) {
        if (action.compareToIgnoreCase(ALLOWED_ACTIONS.get(0)) == 0) {
            return firstNumber + secondNumber;
        }
        if (action.compareToIgnoreCase(ALLOWED_ACTIONS.get(1)) == 0) {
            return firstNumber - secondNumber;
        }
        if (action.compareToIgnoreCase(ALLOWED_ACTIONS.get(2)) == 0) {
            return firstNumber * secondNumber;
        }
        if (action.compareToIgnoreCase(ALLOWED_ACTIONS.get(3)) == 0) {
            return firstNumber / secondNumber;
        }
        if (action.compareToIgnoreCase(ALLOWED_ACTIONS.get(4)) == 0) {
            return Math.sqrt(firstNumber);
        }
        if (action.compareToIgnoreCase(ALLOWED_ACTIONS.get(5)) == 0) {
            return Math.pow(firstNumber, secondNumber);
        } else return null;
    }
}
