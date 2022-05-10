package be.uantwerpen.fti.ei;

import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        InputFrame input = new InputFrame();
        Map mapFrame = new Map(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        mapFrame.grCtx.setGameDimensions(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        //gs[0].setFullScreenWindow(input);


        IOReader map = new IOReader("resource/2022.map/locations3.csv");
        while (true) {
            //mapFrame.setPin(0,0);
            ArrayList<String> newCombobox = new ArrayList<>();
            for (Location location : map.getStudents()) {
                if (Objects.equals(input.getOutput1(), location.getStudy())) {
                    if (Objects.equals("All", input.getOutput2())){
                        mapFrame.setPin(location.getCoordinates()[1],location.getCoordinates()[0]);
                        input.clearInfo();
                    }else if(Objects.equals(input.getOutput2(), location.getUniversity())){
                        mapFrame.setPin(location.getCoordinates()[1],location.getCoordinates()[0]);
                        input.setInfo(location.info());
                    }
                    newCombobox.add(location.getUniversity());
                }
            }
            if (input.isInputReceived()) {
                input.setSecondCombobox(newCombobox);
            }
            mapFrame.render();
        }
    }
}
