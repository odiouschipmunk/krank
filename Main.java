import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {
    static JFrame mainframe = new JFrame("java");
    static JLabel text = new JLabel("What would you like to do today?");
    static JTextField textField = new JTextField();
    static JButton button = new JButton("Enter");
    static JButton see = new JButton("See all that you have to do today");
    static JButton back = new JButton("Back");

    public static void main(String[] args) {
        mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainframe.setUndecorated(true);
        mainMenu();

        ArrayList<String> todos = new ArrayList<String>();

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                todos.add(textField.getText());
                
            }

        });

        see.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mainframe.getContentPane().removeAll();
                mainframe.repaint();
                System.out.println(todos.toString());
                back.setBounds(450, 500, 200, 40);

                
                mainframe.add(back);
                back.addActionListener(new ActionListener(){

                    public void actionPerformed(ActionEvent e) {
                        mainMenu();
                    }
                    
                });
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
}