package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TopPriorityOperatorListener implements ActionListener {
    private JTextField inputField;

    public TopPriorityOperatorListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = inputField.getText().substring((inputField.getText().length()-1));
        if (str.equals("*")||str.equals("/")||str.equals("+")||str.equals("-") || str.equals("^") || str.equals("%") || str.equals("√") || str.equals("∛")) {

        } else {
            if(str.equals("(")){
                inputField.setText(inputField.getText() + "0");
            }
            JButton btn = (JButton) e.getSource();
            inputField.setText(inputField.getText() + btn.getText());
        }
    }
}