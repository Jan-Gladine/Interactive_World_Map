package be.uantwerpen.fti.ei;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	    InputFrame input = new InputFrame();
        DisplayFrame display = new DisplayFrame();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        //gs[0].setFullScreenWindow(input);
        //gs[1].setFullScreenWindow(display);
        while (true){
            display.setInput(input.getOutput());
        }
    }
}
