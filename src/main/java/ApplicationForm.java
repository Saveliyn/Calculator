import components.NumberJButton;
import components.OperatorJButton;
import listeners.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {

    private JTextField inputField;


    public ApplicationForm(String title) throws HeadlessException {
        super(title);
        setBounds(1100, 100, 350, 370); //ПОМЕНЯТЬ!!!
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
//        testListener();

        setJMenuBar(createMenu());

        setLayout(new BorderLayout());

        add(createTopPanel(), BorderLayout.NORTH);
        add(createCenterPanel(), BorderLayout.CENTER);


        setVisible(true);
    }

    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");

        menuBar.add(menuFile);
        menuBar.add(new JMenuItem("Help"));
        menuBar.add(new JMenuItem("About"));

        menuFile.add(new JMenuItem("Clear"));
        JMenuItem exitItem = menuFile.add(new JMenuItem("Exit"));
        menuBar.add(exitItem);

/*        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });  */
        exitItem.addActionListener(new ExitButtonListener());



        return menuBar;
    }

    private JPanel createTopPanel() {
        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField);
        inputField.setFont(new Font("Arial", Font.PLAIN, 25));
        inputField.setMargin(new Insets(8, 0, 8, 0));
        inputField.setBackground(new Color(255, 255, 255));

        inputField.setText("0");


        return top;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField);

        centerPanel.add(createDigitsPanel(buttonListener), BorderLayout.CENTER);
        centerPanel.add(createOperatorsPanel(buttonListener), BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();

        digitsPanel.setLayout(new GridLayout(4, 3));

        for (int i = 0; i < 9; i++) {
            String buttonTitle = String.valueOf(i + 1);
            JButton btn = new NumberJButton(buttonTitle);
            btn.addActionListener(buttonListener);
            digitsPanel.add(btn);
        }

        JButton point = new NumberJButton(".");
        digitsPanel.add(point);
        point.addActionListener(new PointListener(inputField));

        JButton o = new NumberJButton("0");
        digitsPanel.add(o);
        o.addActionListener(new NullListener(inputField));

        JButton clear = new OperatorJButton("C");
        digitsPanel.add(clear);
        clear.addActionListener(new ClearButtonActionListener(inputField));


        return digitsPanel;
    }

    private JPanel createOperatorsPanel(ActionListener buttonListener) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JButton calc = new OperatorJButton("=");
        panel.add(calc);
        calc.addActionListener(new CalcListener(inputField));

        JButton minus = new OperatorJButton("-");
        minus.addActionListener(new OperatorListener(inputField));
        panel.add(minus);

        JButton plus = new OperatorJButton("+");
        plus.addActionListener(new OperatorListener(inputField));
        panel.add(plus);

        JButton multiply = new OperatorJButton("*");
        multiply.addActionListener(new OperatorListener(inputField));
        panel.add(multiply);

        JButton divide = new OperatorJButton("/");
        divide.addActionListener(new OperatorListener(inputField));
        panel.add(divide);

        JButton degree = new OperatorJButton("^");
        degree.addActionListener(new OperatorListener(inputField));
        panel.add(degree);

        JButton root = new OperatorJButton("√");
        root.addActionListener(new TopPriorityOperatorListener(inputField));
        panel.add(root);

        JButton cube = new OperatorJButton("∛");
        cube.addActionListener(new TopPriorityOperatorListener(inputField));
        panel.add(cube);

        JButton openBracket = new OperatorJButton("(");
        openBracket.addActionListener(new OpenBracketListener(inputField));
        panel.add(openBracket);

        JButton closeBracket = new OperatorJButton(")");
        closeBracket.addActionListener(new CloseBracketListener(inputField));
        panel.add(closeBracket);

        JButton percent = new OperatorJButton("%");
        percent.addActionListener(new TopPriorityOperatorListener(inputField));
        panel.add(percent);

        JButton del = new OperatorJButton("<");
        del.addActionListener(new DelListener(inputField));
        panel.add(del);




        return panel;
    }

    private void testListener() {
        Button button = new Button("Кнопка");
        button.addActionListener(new TestButtonListener());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("СОБЫТИЕ!");
            }
        });
//                button.addActionListener(e -> System.out.println("СОБЫТИЕ ЧЕРЕЗ ЛЯМБДУ!"));
        super.add(button);
    }
}
