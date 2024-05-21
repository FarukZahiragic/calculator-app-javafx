package ba.unsa.etf.rpr.tutorijal06;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Controller {


    public Label display;

    public void addDigit(ActionEvent event) {
        if(display.getText().equals("0")) {
            //String replacement = display.getText().replaceFirst("^0+(?!$)", "");
            display.setText("");
        }
        display.setText(display.getText() + ((Button) event.getSource()).getText());
    }

    public void evaluate(ActionEvent actionEvent) throws ScriptException {
        String expression = display.getText().replaceFirst("^0+(?!$)", "");
        expression = expression.replace("x", "*").replace("%", "/100");
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        try {
            display.setText((engine.eval(expression)).toString());
        } catch (ScriptException e) {
            display.setText("");
        }
    }
/*
    public void zeroClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("0"));
    }

    public void oneClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("1"));
    }

    public void twoClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("2"));
    }

    public void threeClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("3"));
    }

    public void fourClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("4"));
    }

    public void fiveClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("5"));
    }

    public void sixClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("6"));
    }

    public void sevenClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("7"));
    }

    public void eightClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("8"));
    }

    public void nineClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("9"));
    }

    public void remainderClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("%"));

    }

    public void multiplicationClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("x"));
    }

    public void divisionClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("/"));
    }

    public void minusClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("-"));
    }

    public void plusClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("+"));
    }

    public void equalsClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("="));
    }

    public void dotClick(ActionEvent actionEvent) {
        display.setText(display.getText().concat("."));
    }


 */
}
