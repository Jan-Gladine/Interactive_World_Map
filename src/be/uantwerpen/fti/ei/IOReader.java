package be.uantwerpen.fti.ei;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class IOReader {
    private LinkedList<Location> students = new LinkedList<Location>();
    private LinkedList<BufferedImage> pictures = new LinkedList<>();

    public IOReader(String file) throws IOException {
        Scanner sc = new Scanner(new File(file));
        LinkedList<String> lines = new LinkedList<>();
        while (sc.hasNextLine())
        {
            lines.add(sc.nextLine());
        }
        sc.close();
        String[] data;
        for (String line : lines) {
            data = line.split(";");
            this.students.add(new Location(new Double[]{Double.valueOf(data[0].split(",")[0]), Double.valueOf(data[0].split(",")[1])}, data[1], data[2], data[3], data[4]));
        }
    }

    public LinkedList<Location> getStudents() {
        return students;
    }
}
