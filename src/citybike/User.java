package citybike;

public class User {
    private static int userIdCounter=1;
    private int userID;
    private String firstName;
    private String lastName;
    private int currentlyRentedBike=0;
    private Rent rented;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userID = userIdCounter++;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCurrentlyRentedBike() {
        return currentlyRentedBike;
    }

    public void setCurrentlyRentedBike(int currentlyRentedBike) {
        this.currentlyRentedBike = currentlyRentedBike;

    }

    public Rent getRented() {
        return rented;
    }

    public void setRented(Rent rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", currentlyRentedBike= " + currentlyRentedBike +
                '}';
    }
}
