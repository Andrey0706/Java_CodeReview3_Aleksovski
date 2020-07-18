package citybike;
import java.util.*;
public class Rent {

    private Date rentStart;
    private Date rentEnd;
    private int currentlyRentedBikeID;

    public Rent(Date rentStart, Date rentEnd, int currentlyRentedBikeID) {
        this.rentStart = rentStart;
        this.rentEnd = rentEnd;
        this.currentlyRentedBikeID = currentlyRentedBikeID;
    }

    public Date getRentStart() {
        return rentStart;
    }

    public void setRentStart(Date rentStart) {
        this.rentStart = rentStart;
    }

    public Date getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(Date rentEnd) {
        this.rentEnd = rentEnd;
    }

    public int getCurrentlyRentedBikeID() {
        return currentlyRentedBikeID;
    }

    public void setCurrentlyRentedBikeID(int currentlyRentedBikeID) {
        this.currentlyRentedBikeID = currentlyRentedBikeID;
    }
}
