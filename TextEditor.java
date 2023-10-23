import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextEditor {
    private Font mainFont = new Font("Segoe Print", Font.BOLD, 18);
    private JTextField tfFirstName, tfLastName;
    private JLabel lbWelcome;

    public TextEditor() {
        initialize();
    }

    public void initialize() {

        JFrame mainFrame = new JFrame("Welcome");   //title

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   

        mainFrame.setMinimumSize(new Dimension(300, 400));   //set the size

        JPanel formPanel = new JPanel(new GridLayout(4, 1, 5, 5));  //define the rows and cols in layout

        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));   //border creation

        formPanel.setBackground(new Color(128, 128, 255));   //define the color

        JLabel lbFirstName = new JLabel("First Name");    //take input from user [as First name]
        lbFirstName.setFont(mainFont);
        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last Name");      //take input from user[as last name]
        lbLastName.setFont(mainFont);
        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        formPanel.add(lbFirstName);
        formPanel.add(tfFirstName);
        formPanel.add(lbLastName);
        formPanel.add(tfLastName);

        lbWelcome = new JLabel("Welcome");
        lbWelcome.setFont(mainFont);

        JButton btnOK = new JButton("OK");   //ok button to submit work
        
        btnOK.setFont(mainFont);
        btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = tfFirstName.getText();
                String lastName = tfLastName.getText();
                lbWelcome.setText("Hello " + firstName + " " + lastName);    //collaborate the string
            }
        });

        JButton btnClear = new JButton("Clear");    //clear button to clear the data
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfFirstName.setText("");
                tfLastName.setText("");
                lbWelcome.setText("Welcome");
            }
        });

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 5));   //button size
        buttonPanel.add(btnOK);
        buttonPanel.add(btnClear);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(formPanel, BorderLayout.NORTH);
        mainFrame.add(lbWelcome, BorderLayout.CENTER);
        mainFrame.add(buttonPanel, BorderLayout.SOUTH);

        mainFrame.setSize(500, 600);   // set width and height of whole Layout
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextEditor();
            }
        });
    }
}
