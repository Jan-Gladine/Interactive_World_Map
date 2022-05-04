package be.uantwerpen.fti.ei;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class IOReader {
    private LinkedList<Location> students = new LinkedList<Location>();
    public IOReader(String file) throws FileNotFoundException {
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
