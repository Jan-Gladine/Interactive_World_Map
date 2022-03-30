package be.uantwerpen.fti.ei;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputFrame extends JFrame {
    private JLabel txtLabel;
    private JTextField textField1;
    private JButton enterButton;
    private JPanel Panel;
    private JComboBox comboBox1;
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
        enterButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
    }

    public String getOutput() {
        return output;
    }
}
