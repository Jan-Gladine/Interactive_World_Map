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
    private JPanel Panel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JLabel info;
    private String output1;
    private String output2 = "None";
    private boolean inputReceived = false;

    public InputFrame(){
        setContentPane(Panel);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                output1 = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
                comboBox2.removeAllItems();
                inputReceived = true;
            }
        });

        comboBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox2.getSelectedItem() != null) {
                    output2 = Objects.requireNonNull(comboBox2.getSelectedItem()).toString();
                }
            }
        });
    }


    public boolean isInputReceived() {
        return inputReceived;
    }

    public void setSecondCombobox(ArrayList<String> a){
        comboBox2.addItem("All");
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
