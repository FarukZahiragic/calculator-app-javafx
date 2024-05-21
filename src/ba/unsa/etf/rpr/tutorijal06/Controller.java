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
}
