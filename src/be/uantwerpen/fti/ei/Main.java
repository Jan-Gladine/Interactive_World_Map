package be.uantwerpen.fti.ei;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        InputFrame input = new InputFrame();
        Map mapFrame = new Map();
        mapFrame.grCtx.InitGraphics();
        gs[0].setFullScreenWindow(input);
        IOReader data = new IOReader("resource/2022.map/locations.csv");


        while (true) {
            mapFrame.update();
            ArrayList<String> newCombobox = new ArrayList<>();
            for (Location location : data.getStudents()) {
                if (Objects.equals(input.getOutput1(), location.getStudy())) {
                    if (Objects.equals("All", input.getOutput2())){
                        mapFrame.setPin(location.getCoordinates()[1],location.getCoordinates()[0]);
                        input.clearImage();
                        input.clearInfo();
                    }else if(Objects.equals(input.getOutput2(), location.getUniversity())){
                        mapFrame.setPin(location.getCoordinates()[1],location.getCoordinates()[0]);
                        input.setInfo(location.info());
                        input.placeImage(location.getPic());
                    }
                    newCombobox.add(location.getUniversity());
                }
            }

            if (newCombobox.size() == 0){
                input.clearInfo();
                input.clearImage();
                input.removeButtons();
            }else if (input.isInputReceived()|input.isBuffered()) {
                input.setSecondCombobox(newCombobox);
            }
            mapFrame.render();
            Thread.sleep(1);
        }
    }
}
