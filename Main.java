import javax.swing.*;
import javax.swing.border.Border;

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

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, UnsupportedLookAndFeelException {
        mainframe.setLocationRelativeTo(null);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        mainframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainframe.setLayout(new FlowLayout());
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
                back.setBounds(450, 500, 200, 40);

                Container contentPane = mainframe.getContentPane();
                contentPane.setLayout(new BorderLayout());

                ListModel<String> listModel = createListModel();
                ListSelectionDocument listSelectionDocument = new ListSelectionDocument();

                JList<String> list = new JList<String>();
                list.setCellRenderer(new CheckboxListCellRenderer<String>());
                list.setModel(listModel);
                list.addListSelectionListener(listSelectionDocument);

                JTextArea listSelectionTextArea = new JTextArea(listSelectionDocument);
                Border loweredBevelBorder = BorderFactory.createLoweredBevelBorder();
                listSelectionTextArea.setBorder(loweredBevelBorder);

                contentPane.add(list, BorderLayout.CENTER);
                contentPane.add(listSelectionTextArea, BorderLayout.SOUTH);

                back.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        mainMenu();
                    }

                });
                mainframe.add(back);

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
        DefaultListModel<String> listModel = new DefaultListModel<String>();

        listModel.addElement("Element 1");
        listModel.addElement("Element 2");
        listModel.addElement("Element 3");
        listModel.addElement("Element 4");

        return listModel;
    }
}