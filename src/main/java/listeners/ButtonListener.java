package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField inputField;

    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(inputField.getText().length()==1 && inputField.getText().equals("0")) {
            inputField.setText("");
        }
        JButton btn = (JButton) e.getSource();
        inputField.setText(inputField.getText()  + btn.getText());
    }
}