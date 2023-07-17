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
    static DefaultListModel<String> listModel = new DefaultListModel<String>();

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        mainframe.setLocationRelativeTo(null);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainframe.setLayout(new BorderLayout());
        mainMenu();

        ArrayList<String> todos = new ArrayList<String>();

        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                todos.add(textField.getText());
                for (var i = 0; i < todos.size(); i++) {
                    listModel.add(i, todos.get(i));
                }
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

    public static DefaultListModel<String> createListModel() {

        return listModel;
    }

    public static void report() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        mainframe.getContentPane().removeAll();
        mainframe.repaint();
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        Container contentPane = mainframe.getContentPane();
        back.setBounds(450, 500, 200, 40);

        ListModel<String> listModel = createListModel();
        ListSelectionDocument listSelectionDocument = new ListSelectionDocument();

        JList<String> list = new JList<String>();
        list.setCellRenderer(new CheckboxListCellRenderer<String>());
        list.setModel(listModel);
        list.addListSelectionListener(listSelectionDocument);
        list.setBounds(1500, 500, 500, 400);

        contentPane.add(list);
        for(var i=0;i<listModel.getSize();i++){
            listModel.
        }
        back.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }

        });

        mainframe.add(back, BorderLayout.SOUTH);
        mainframe.validate();
        contentPane.setVisible(true);
        mainframe.setVisible(true);
    }
}