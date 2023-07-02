package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointListener implements ActionListener {

    private JTextField inputField;

    public PointListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inputField.getText().substring((inputField.getText().length()-1)).equals(".")) {

        }
        else {
            if(!checkPoints(inputField.getText())) {
                JButton btn = (JButton) e.getSource();
                inputField.setText(inputField.getText() + btn.getText());
            }
        }

    }

    private boolean checkPoints(String str) {
        int i = 1;

        while (i<(str.length()-2)) {
            String str2 = str.substring((str.length()-i-1), (str.length() - i));
            if (str2.equals(".")){
                return true;
            } else if(OpenBracketListener.isOperator(str2)) {
                return false;
            }
            i++;
        }
        return false;
    }


}