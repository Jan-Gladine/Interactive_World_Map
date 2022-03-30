package be.uantwerpen.fti.ei;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class IOReader {
    private LinkedList<Student> students = new LinkedList<Student>();
    public IOReader(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        LinkedList<String> lines = new LinkedList<>();
        while (sc.hasNextLine())
        {
            lines.add(sc.nextLine());
        }
        sc.close();
        String[] data;
        for(String line:lines){
            data = line.split(";");
            this.students.add(new Student(data[4], data[1], new String[]{data[2], data[3]}));
        }
    }

    public LinkedList<Student> getStudents() {
        return students;
    }
}
