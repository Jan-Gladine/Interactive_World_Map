package be.uantwerpen.fti.ei;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        InputFrame input = new InputFrame();
        DisplayFrame display = new DisplayFrame();
        Map mapFrame = new Map(1920,1080);
        mapFrame.grCtx.setGameDimensions(1920,1080);
        gs[0].setFullScreenWindow(input);
        //gs[1].setFullScreenWindow(mapFrame);
        IOReader map = new IOReader("Map1.csv");
        while (true){
            StringBuilder outputString = new StringBuilder();
            for(Student student :map.getStudents()){
                if (Objects.equals(input.getOutput2(), student.getCourse())){
                    mapFrame.setPin(student.getCoordinates()[0], student.getCoordinates()[1]);
                }
            }
            mapFrame.render();
            display.setInput(String.valueOf(outputString));
        }
    }
}
