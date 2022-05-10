package be.uantwerpen.fti.ei;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class InputFrame extends JFrame {
    private JPanel Panel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextArea info;
    private JPanel picture;
    private String output1;
    private String output2 = "None";
    private boolean inputReceived = false;

    public InputFrame(){
        setContentPane(Panel);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        comboBox1.addActionListener(e -> {
            output1 = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
            comboBox2.removeAllItems();
            inputReceived = true;
        });

        comboBox2.addActionListener(e -> {
            if (comboBox2.getSelectedItem() != null) {
                output2 = Objects.requireNonNull(comboBox2.getSelectedItem()).toString();
            }
        });
    }

    public void setInfo(String infoText){
        info.setText(infoText);
        info.setVisible(true);
    }
    public void clearInfo(){
        info.setVisible(false);
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
