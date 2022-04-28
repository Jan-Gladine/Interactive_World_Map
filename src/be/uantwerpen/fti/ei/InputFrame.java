package be.uantwerpen.fti.ei;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Objects;

public class InputFrame extends JFrame {
    private JLabel txtLabel;
    private JTextField textField1;
    private JButton enterButton;
    private JPanel Panel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private String output1;
    private String output2;
    private ArrayList<String> comboBox2Inputs;
    private boolean inputReceived = false;

    public InputFrame(){
        setContentPane(Panel);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output1 = textField1.getText();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output2 = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                comboBox2.removeAllItems();
                inputReceived = true;
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        enterButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
            }
        });
    }


    public boolean isInputReceived() {
        return inputReceived;
    }

    public void setSecondCombobox(ArrayList<String> a){
        for (String text: a){
            comboBox2.addItem(text);
        }
        inputReceived = false;
    }
    public String getOutput1() {
        return output1;
    }
    public String getOutput2(){
        return output2;
    }
}
