package components;

import javax.swing.*;
import java.awt.*;

public class OperatorJButton extends JButton {

    public OperatorJButton(String text) {
        super(text);
        setFont(new Font("TimesRoman", Font.BOLD, 25));
        setBackground(new Color(255, 255, 255));
    }
}