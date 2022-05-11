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

    public void clearImage(){
        image.setVisible(false);
    }
    public String getOutput1() {
        return output1;
    }
    public String getOutput2(){
        return output2;
    }

}
