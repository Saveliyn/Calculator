package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CloseBracketListener implements ActionListener {

    private JTextField inputField;
    //public static int closeBracket;

    public CloseBracketListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = inputField.getText().substring((inputField.getText().length()-1));
        if (str.equals("*")||str.equals("/")||str.equals("+")||str.equals("-") || str.equals("^")) {

        } else {
            if(str.equals("(")|| OpenBracketListener.isOperator(str)){
                inputField.setText(inputField.getText() + "0");
            }

            if (OpenBracketListener.countBracket>0) {
                JButton btn = (JButton) e.getSource();
                inputField.setText(inputField.getText() + btn.getText());
                OpenBracketListener.countBracket = OpenBracketListener.countBracket-1;
            }

        }
    }
}