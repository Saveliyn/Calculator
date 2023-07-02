package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenBracketListener implements ActionListener {


    private JTextField inputField;

    public static int countBracket;

    public OpenBracketListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inputField.getText().length()==1 && inputField.getText().equals("0")) {
            inputField.setText("");
        } else if(!isOperator(inputField.getText().substring(inputField.getText().length()-1))) {
            inputField.setText(inputField.getText() + "*");
        }
        JButton btn = (JButton) e.getSource();
        inputField.setText(inputField.getText()  + btn.getText());
        countBracket++;
    }

    static boolean isOperator(String str) {
        if (str.equals("*")||str.equals("/")||str.equals("+")||str.equals("-") || str.equals("^")||str.equals("(")) {
            return true;
        } else {
            return false;
        }
    }
}