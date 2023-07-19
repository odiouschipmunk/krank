import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {
    static JFrame mainframe = new JFrame("java");
    static JLabel text = new JLabel("What would you like to do today?");
    static JTextField textField = new JTextField();
    static JButton button = new JButton("Enter");
    static JButton see = new JButton("See all that you have to do today");
    static JButton back = new JButton("Back");
    static ArrayList<String> todos = new ArrayList<String>();

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        mainframe.setLocationRelativeTo(null);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainframe.setLayout(new BorderLayout());
        mainMenu();

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                todos.add(textField.getText());

            }

        });

        see.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                try {
                    report();
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                        | UnsupportedLookAndFeelException e1) {
                    e1.printStackTrace();
                }
            }
        });
        mainframe.add(see);
        mainframe.add(textField);
        mainframe.add(text);
        mainframe.add(button);

        mainframe.setLayout(null);
        mainframe.setVisible(true);

    }

    public static void mainMenu() {
        mainframe.getContentPane().removeAll();
        mainframe.repaint();
        text.setBounds(350, 350, 1000, 20);
        textField.setBounds(550, 350, 100, 20);
        button.setBounds(475, 450, 150, 20);
        see.setBounds(770, 500, 300, 150);
        mainframe.add(text);
        mainframe.add(textField);
        mainframe.add(button);
        mainframe.add(see);
    }

    public static void report() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        mainframe.getContentPane().removeAll();
        mainframe.repaint();
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        ArrayList<JCheckBox> checkboxes = new ArrayList<>();

        for (String element : todos) {
            JCheckBox box = new JCheckBox(element);
            checkboxes.add(box);
            panel.add(box);
            System.out.println("box "+element+" added");
        }
       
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }

        });
        back.setBounds(450, 500, 200, 40);
        mainframe.add(panel);
        
        mainframe.add(back);
        mainframe.validate();
        panel.validate();
        panel.setVisible(true);
        mainframe.setVisible(true);
    }
}