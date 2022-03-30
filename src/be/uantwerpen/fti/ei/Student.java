package be.uantwerpen.fti.ei;

public record Student(String name, String university, String[] coordinates) {

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String[] getCoordinates() {
        return coordinates;
    }
}
