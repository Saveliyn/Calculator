package listeners;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NullListener implements ActionListener {

    private JTextField inputField;

    public NullListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = inputField.getText();
        if (str.substring((str.length()-1)).equals("/")) {
            inputField.setText("НА НОЛЬ ДЕЛИТЬ НЕЛЬЗЯ!");

        } else {
            JButton btn = (JButton) e.getSource();
            inputField.setText(inputField.getText() + btn.getText());
        }
    }
}