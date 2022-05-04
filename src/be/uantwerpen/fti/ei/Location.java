package be.uantwerpen.fti.ei;

public record Location(Double[] coordinates, String study, String university, String info, String picture) {

    public String getPic() {
        return picture;
    }

    public String getUniversity() {
        return university;
    }

    public Double[] getCoordinates() {
        return coordinates;
    }

    public String getStudy() {
        return study;
    }
}
