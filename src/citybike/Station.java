package citybike;
import java.util.*;
import java.util.ArrayList;

public class Station {
    private static int stationIdIncrement = 1;
    private static int maxNumberOfBikes = 5;
    private int currentNumberOfbikes=0;
    private int stationID;
    private String location;
    private ArrayList<Bike> bikesInStation = new ArrayList<>();

    public Station(String location) {
        this.location = location;
        this.stationID = stationIdIncrement++;
    }

    public int getStationID() {
        return stationID;
    }

    public void setStationID(int stationID) {
        this.stationID = stationID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<Bike> getBikesInStation() {
        return bikesInStation;
    }

    public void deleteBikeInStation(int index){
        this.bikesInStation.remove(index);
    }

    public void addBike(Bike bike, Station station) {
        if(station.getCurrentNumberOfbikes()>4){
            System.out.println(">>>Sorry, you cant add bike in the station " + station.getLocation() + " because its already full");
            return;
        }
        bikesInStation.add(bike);
        bike.setIdOfStationAssigned(station.getStationID());
        station.setCurrentNumberOfbikes(1);
        System.out.println("Sucessfully added the bike to the station: " + station.getLocation());
    }

    public int getCurrentNumberOfbikes() {
        return currentNumberOfbikes;
    }

    public void setCurrentNumberOfbikes(int i) {
        this.currentNumberOfbikes += i;
    }

    public void rentAbike(User user, Station station, Bike bike, int hoursToRent) {

        if (user.getCurrentlyRentedBike() == 0) {
            for(Bike i : station.getBikesInStation()){
                if(i.getBikeID()==bike.getBikeID()){
                    user.setCurrentlyRentedBike(i.getBikeID());
                    //station.getBikesInStation().remove(bikesInStation.indexOf(i));
                    //System.out.println("index: " + station.getBikesInStation().indexOf(i));
                    station.deleteBikeInStation(station.getBikesInStation().indexOf(i));
                    System.out.println("The user: " + user.getFirstName() + " is renting the bike: " + user.getCurrentlyRentedBike() + " for " + hoursToRent + " hours");
                    Date startDate = new Date();
                    long miliseconds = startDate.getTime()+hoursToRent*1000*60*60;
                    Date endDate = new Date(miliseconds);
                    user.setRented(new Rent(startDate, endDate, user.getCurrentlyRentedBike()));
                    System.out.println("***THANK YOU " + user.getFirstName().toUpperCase() + ", ENJOY EXPLORING VIENNA***");
                    System.out.println("Rent start: " + user.getRented().getRentStart());
                    System.out.println("Rent end: " +  user.getRented().getRentEnd());
                    System.out.println("********************");
                    station.setCurrentNumberOfbikes(-1);
                    break;
                }
            }
        } else {
            System.out.println("Sorry, but you have to return your bike first to rent another one..");
        }
    }

    public void returnAbike(User user, Station station, Bike bike, Station genuineStation){

        System.out.println("**********************\nReturning a bike to.. " + station.getLocation());
        if(user.getCurrentlyRentedBike()==0){
            System.out.println("You dont have a bike rented!");
        } else{
            if(station.getStationID()==bike.getIdOfStationAssigned()){
                if(station.getCurrentNumberOfbikes()>4){
                    System.out.println("Sorry the station is full try again later");
                    return;
                }
                genuineStation.addBike(bike, station);
                user.setCurrentlyRentedBike(0);
                System.out.println("**********************");
            } else{
                System.out.println("You are at the wrong station, but don't worry we will accept the bike and transfer it to " + genuineStation.getLocation() + ".\n Thank you for using our bike rental services");
                if(station.getCurrentNumberOfbikes()>4){
                    System.out.println("Sorry the station is full try again later");
                    return;
                }
                genuineStation.addBike(bike, genuineStation);
                user.setCurrentlyRentedBike(0);
                System.out.println("**********************");
            }
        }
    }

}