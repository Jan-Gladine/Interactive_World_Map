package be.uantwerpen.fti.ei;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    InputFrame input = new InputFrame();
        DisplayFrame display = new DisplayFrame();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        //gs[0].setFullScreenWindow(input);
        //gs[1].setFullScreenWindow(display);
        IOReader map = new IOReader("Map1.csv");
        while (true){
            for(Student student :map.getStudents()){
                if(Objects.equals(input.getOutput(), student.getName())){
                    display.setInput(student.getUniversity());
                }
            }

        }
    }
}
