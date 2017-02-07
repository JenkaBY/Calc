package by.beltech;

import java.util.ArrayList;

/**
 * Created by JenkaBY on 07.02.2017.
 */
public class CalcHelper {

    public CalcHelper() {
        printFirst();
    }

    public void printAction(ArrayList<String> allowedAction) {
        StringBuilder actions = new StringBuilder();
        for (int i = 0; i < allowedAction.size(); i++) {
            actions.append("\"" + allowedAction.get(i) + "\"");
            if (i < allowedAction.size() - 1) actions.append(", ");
        }
        print("Enter an ACTION with the entered numbers (allowed actions are " + actions.toString() + ") and press <Enter>:");
    }

    private void printEnterNumber(String ordinal) {
        print("Enter your " + ordinal.toUpperCase() + " number and press <Enter>:");
    }

    public void printEnterFirstNumber() {
        printEnterNumber("first");
    }

    public void printEnterSecondNumber() {
        printEnterNumber("second");
    }

    private void print(String text) {
        System.out.println(text);
    }

    public String preprocess(String str) {
        return str.replaceAll("[\\s+]", "").replaceAll("[,]", ".").toLowerCase();
    }

    private String postProcess(Double result){
        return result.toString();
    }

    public void printResult(Double firstNumber,Double secondNumber,String action, Double result){
        if (action.compareToIgnoreCase("sqrt") == 0){
            print( action+ " " + postProcess(firstNumber) + " = "+ postProcess(result));
        } else {
            print(postProcess(firstNumber) +" " + action + " "+postProcess(secondNumber) +" = "+ postProcess(result));
        }
    }

    public void printFirst() {
        print("Hello! I'm glad that you're using my Simple Calculator!\nTo exit enter 'exit'");
    }

    public Double parse(String text) throws NumberFormatException {

        return Double.parseDouble(preprocess(text));
    }
}
