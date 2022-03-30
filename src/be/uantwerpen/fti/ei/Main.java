package be.uantwerpen.fti.ei;

import java.awt.*;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    InputFrame input = new InputFrame();
        DisplayFrame display = new DisplayFrame();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        //gs[0].setFullScreenWindow(input);
        //gs[1].setFullScreenWindow(display);
        IOReader map = new IOReader("C:\\Users\\Jan\\IdeaProjects\\Interactive_World_Map\\src\\Map1.csv");
        while (true){
            display.setInput(input.getOutput());
        }
    }
}
