package be.uantwerpen.fti.ei;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        InputFrame input = new InputFrame();
        DisplayFrame display = new DisplayFrame();
        Map mapFrame = new Map(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        mapFrame.grCtx.setGameDimensions(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);

        //gs[1].setFullScreenWindow(input);

        IOReader map = new IOReader("Map1.csv");
        while (true) {
            ArrayList<String> newCombobox = new ArrayList<>();
            ArrayList<Double> mapCoordinates = new ArrayList<>();
            for (Student student : map.getStudents()) {
                if (Objects.equals(input.getOutput2(), student.getCourse())) {
                    mapCoordinates.add(student.getCoordinates()[0]);
                    mapCoordinates.add(student.getCoordinates()[1]);
                    newCombobox.add(student.getName());
                }
            }
            if (input.isInputReceived()) {
                input.setSecondCombobox(newCombobox);
            }
            for (int i = 0; i < mapCoordinates.size()/2; i++) {
                mapFrame.setPin(mapCoordinates.get(i * 2), mapCoordinates.get(i * 2 + 1));
            }
            mapFrame.render();
        }
    }
}
