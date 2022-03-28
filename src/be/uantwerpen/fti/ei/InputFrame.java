package be.uantwerpen.fti.ei;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputFrame extends JFrame {
    private JLabel txtLabel;
    private JTextField textField1;
    private JButton enterButton;
    private JPanel Panel;
    private String output;

    public InputFrame(){
        setContentPane(Panel);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output = textField1.getText();
            }
        });
    }

    public String getOutput() {
        return output;
    }
}
