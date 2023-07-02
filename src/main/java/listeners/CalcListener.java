package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcListener implements ActionListener {

    private JTextField inputField;

    public CalcListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inputField.getText().substring(0, 1).equals("-")) {
            StringBuffer str = new StringBuffer(inputField.getText());
            str.insert(0, "0");
            inputField.setText(str.toString());
        }

        if (OpenBracketListener.countBracket>0) {
            for (int i = 0; i < OpenBracketListener.countBracket; i++) {
                inputField.setText(inputField.getText()+")");
            }
        }
        for (int i = 0; i < (inputField.getText().length()) ; i++) {
            String str = inputField.getText().substring(inputField.getText().length()-1);
            if(str.equals("*")||str.equals("/")||str.equals("+")||str.equals("-")||str.equals("^")||str.equals("(")){
                inputField.setText(inputField.getText().substring(0, (inputField.getText().length()-1)));
            }
        }

        double res = Calculation.parse(inputField.getText());
        if (res == 0.000006){
            inputField.setText("Невозможное действие с процентом");
        }
        else if (res % 1 == 0) {
            inputField.setText((Integer.toString((int)res)));
        } else {
            inputField.setText((Double.toString(res)));
        }
    }


}