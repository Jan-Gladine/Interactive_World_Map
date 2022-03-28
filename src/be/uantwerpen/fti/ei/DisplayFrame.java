package be.uantwerpen.fti.ei;

import javax.swing.*;


public class DisplayFrame extends JFrame {
    private JPanel MainPanel;
    private JLabel input;

    public DisplayFrame(){
        setContentPane(MainPanel);
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void setInput(String input) {
        this.input.setText(input);
    }
}
