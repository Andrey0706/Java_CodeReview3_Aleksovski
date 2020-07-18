package citybike;

public class Bike {
    private static int idCounter=1;
    private  int bikeID;
    private String color;
    private String state;
    private int idOfStationAssigned;

    public Bike(String color, String state) {
        this.color = color;
        this.state = state;
        bikeID = this.idCounter++;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public  int getBikeID() {
        return bikeID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIdOfStationAssigned() {
        return idOfStationAssigned;
    }

    public void setIdOfStationAssigned(int idOfStationAssigned) {
        this.idOfStationAssigned = idOfStationAssigned;
    }

    @Override
    public String toString() {
        return "Bike{" +
                "bikeID=" + bikeID +
                ", color='" + color + '\'' +
                ", state='" + state + '\'' +
                ", idOfStationAssigned=" + idOfStationAssigned +
                '}';
    }
}
