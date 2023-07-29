import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    static JFrame mainframe = new JFrame("java");
    static JLabel text = new JLabel("What would you like to do today?");
    static JTextField textField = new JTextField();
    static JButton button = new JButton("Enter");
    static JButton see = new JButton("See all that you have to do today");
    static JButton back = new JButton("Back");
    static ArrayList<String> todos = new ArrayList<>();

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        mainframe.setLocationRelativeTo(null);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainframe.setLayout(new BorderLayout());
        mainMenu();

        button.addActionListener(e -> todos.add(textField.getText()));

        see.addActionListener(e -> {
            try {
                report();
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                    | UnsupportedLookAndFeelException e1) {
                e1.printStackTrace();
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
        mainframe.setLayout(new FlowLayout());        
        back.setBounds(250, 750, 300, 50);
                back.addActionListener(e -> {
                    mainMenu();
                });

        JPanel panel = new JPanel();
        ArrayList<JCheckBox> checkboxes = new ArrayList<>();
        
        for(String element : todos) {
            JCheckBox box = new JCheckBox(element, false);
            checkboxes.add(box);
            panel.add(box);
        }

        JButton finish=new JButton("Finish");
        finish.addActionListener(e -> {

            for(var i=0;i<checkboxes.size();i++){
                if(checkboxes.get(i).isSelected()){
                    
                    mainframe.remove(checkboxes.get(i));
                    panel.remove(checkboxes.get(i));
                    checkboxes.remove(i);
                    mainframe.repaint();
                    mainframe.validate();
                }
            }
        });
        finish.setBounds(500, 600, 400, 100);
        mainframe.add(back);   
        mainframe.add(panel);
        mainframe.add(finish);

        mainframe.validate();
        mainframe.setVisible(true);
    }


 
}