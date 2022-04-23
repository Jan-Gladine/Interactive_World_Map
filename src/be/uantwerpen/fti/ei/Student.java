package be.uantwerpen.fti.ei;

public record Student(String name, String university, Double[] coordinates, String course) {

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public String getCourse() {
        return course;
    }
}
