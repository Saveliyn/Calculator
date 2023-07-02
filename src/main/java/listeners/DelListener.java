package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelListener implements ActionListener {

    private JTextField inputField;

    public DelListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        inputField.setText(inputField.getText().substring(0, (inputField.getText().length()-1)));
    }
}