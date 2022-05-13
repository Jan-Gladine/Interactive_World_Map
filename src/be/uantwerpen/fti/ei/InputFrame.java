package be.uantwerpen.fti.ei;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class InputFrame extends JFrame {
    private JPanel Panel;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextArea info;
    private JLabel image;
    private JButton vorigeButton;
    private JButton volgendeButton;
    private boolean buffer;
    private String output1;
    private String output2 = "None";
    private boolean isCleared = true;
    private boolean inputReceived = false;

    public InputFrame(){
        vorigeButton.setVisible(false);
        volgendeButton.setVisible(false);
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
                volgendeButton.setVisible(true);
                vorigeButton.setVisible(true);
            }
        });

        volgendeButton.addActionListener(e -> {
            if (comboBox2.getSelectedIndex()+1 > comboBox2.getItemCount()-1){
                comboBox2.setSelectedIndex(0);
            } else comboBox2.setSelectedIndex(comboBox2.getSelectedIndex()+1);
        });
        vorigeButton.addActionListener(e -> {
            if (comboBox2.getSelectedIndex()-1 < 0){
                comboBox2.setSelectedIndex(comboBox2.getItemCount()-1);
            } else comboBox2.setSelectedIndex(comboBox2.getSelectedIndex()-1);
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
        isCleared = false;
        comboBox2.addItem("All");
        for (String text: a){
            comboBox2.addItem(text);
        }
        if (inputReceived){
            buffer = true;
            comboBox2.removeAllItems();
        }else {
            buffer = false;
        }
        inputReceived = false;
    }

    public void placeImage(String name) throws IOException {
        double scaleFactor;
        String filename = "resource/2022.map/" + name;
        BufferedImage originalPicture = ImageIO.read(new File(filename));
        if (originalPicture.getHeight() > (Panel.getHeight()/1.3)){
            scaleFactor = (Panel.getHeight()/1.3)/originalPicture.getHeight();
        }else scaleFactor = 1;
        ImageIcon picture = new ImageIcon(resizeImage(originalPicture, (int) Math.round(originalPicture.getWidth()*scaleFactor), (int) Math.round(originalPicture.getHeight()*scaleFactor)));
        image.setIcon(picture);
        image.setVisible(true);
    }

    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, 1);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, 7);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, (ImageObserver) null);
        return outputImage;
    }

    public void removeButtons(){
        isCleared = true;
        volgendeButton.setVisible(false);
        vorigeButton.setVisible(false);
    }

    public boolean isCleared(){
        return isCleared;
    }

    public void clearImage(){
        image.setVisible(false);
    }
    public String getOutput1() {
        return output1;
    }
    public String getOutput2(){
        return output2;
    }

    public boolean isBuffered() {
        return buffer;
    }
}
