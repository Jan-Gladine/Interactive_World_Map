package be.uantwerpen.fti.ei;

public record Student(String name, String university, String[] coordinates, String course) {

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public String course() {
        return course;
    }
}
