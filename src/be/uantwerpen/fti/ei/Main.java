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
        Map mapFrame = new Map(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        mapFrame.grCtx.setGameDimensions(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);

        //gs[1].setFullScreenWindow(input);

        IOReader map = new IOReader("Map1.csv");
        while (true) {
            ArrayList<String> newCombobox = new ArrayList<>();
            for (Student student : map.getStudents()) {
                if (Objects.equals(input.getOutput2(), student.getCourse())) {
                    mapFrame.setPin(student.getCoordinates()[0],student.getCoordinates()[1]);
                    newCombobox.add(student.getName());
                }
            }
            if (input.isInputReceived()) {
                input.setSecondCombobox(newCombobox);
            }
            mapFrame.render();
        }
    }
}
