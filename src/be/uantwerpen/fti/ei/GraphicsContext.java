package be.uantwerpen.fti.ei;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsContext {
    private int ScreenWidth;
    private int ScreenHeight;
    private BufferStrategy strategy;
    private JFrame frame;
    private JPanel panel;
    private BufferedImage g2dImage;     // used for drawing
    private Graphics2D g2d;             // always draw in this one
    public BufferedImage backgroundImg;
    public BufferedImage pinImg;


    public BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight){
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_4BYTE_ABGR_PRE);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
        return outputImage;
    }

    private void loadImages() {
        backgroundImg = null;
        try {
            backgroundImg = ImageIO.read(new File("resource/MapImage.jpg"));
            pinImg = ImageIO.read(new File("resource/Pin.png"));
        } catch (IOException e) {
            System.out.println("Unable to load Pin.png or MapImage.jpg!");
        }
    }

    public GraphicsContext() {
        ScreenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
        ScreenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
        frame = new JFrame();
        panel = (JPanel) frame.getContentPane();
        panel.setIgnoreRepaint(true);
        frame.setUndecorated(true);
        frame.setTitle("Interactive World Map");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(ScreenWidth, ScreenHeight);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.createBufferStrategy(2);
        strategy = frame.getBufferStrategy();
    }

    public void render() {
        g2d.dispose();
        strategy.show();
    }

    public void update(){
        g2d = (Graphics2D) strategy.getDrawGraphics();
        g2d.drawImage(backgroundImg, 0,0, null);
    }

    public void setPin(int x, int y){
        g2d.drawImage(pinImg,x,y,null);
    }


    public void InitGraphics() {
        frame.setLocation(0,0);
        frame.setSize(ScreenWidth, ScreenHeight);
        loadImages();
        try {
            backgroundImg = resizeImage(backgroundImg, frame.getWidth(), frame.getHeight());
            pinImg = resizeImage(pinImg,20,20 );
        } catch(Exception e) {
            System.out.println(e.getStackTrace());
        }
        g2dImage = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_4BYTE_ABGR_PRE);
        g2d = g2dImage.createGraphics();
        g2d.drawImage(backgroundImg,0, 0, null);
    }
}