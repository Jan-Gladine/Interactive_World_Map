package be.uantwerpen.fti.ei;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Pin> pins = new ArrayList<>();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        InputFrame input = new InputFrame();
        DisplayFrame display = new DisplayFrame();
        Map mapFrame = new Map(1920,1080);
        mapFrame.grCtx.setGameDimensions(1920,1080);
        pins.add(new Pin(4,51, mapFrame.grCtx));
        pins.add(new Pin(4,70, mapFrame.grCtx));
        pins.add(new Pin(4,30, mapFrame.grCtx));
        pins.add(new Pin(20,30, mapFrame.grCtx));
        pins.add(new Pin(0,0, mapFrame.grCtx));

        gs[0].setFullScreenWindow(input);
        //gs[1].setFullScreenWindow(mapFrame);

        IOReader map = new IOReader("Map1.csv");
        while (true){
            StringBuilder outputString = new StringBuilder();
//            for(Student student :map.getStudents()){
//                if (Objects.equals(input.getOutput2(), student.getCourse())){
//                    mapFrame.setPin(student.getCoordinates()[0], student.getCoordinates()[1]);
//                }
//            }
            for (Pin pin:pins){
                pin.draw();
            }
            mapFrame.render();
            display.setInput(String.valueOf(outputString));
        }
    }
}
