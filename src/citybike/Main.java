package citybike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bike bike1 = new Bike("red", "CanBeRented");
        Bike bike2 = new Bike("red", "CanNotBeRented");
        Bike bike3 = new Bike("blue", "InService");
        Bike bike4 = new Bike("green", "Discarded");
        Bike bike5 = new Bike("purple", "CanBeRented");
        Bike bike6 = new Bike("pink", "CanBeRented");
        Bike bike7 = new Bike("green", "InService");
        Bike bike8 = new Bike("yellow", "Discarded");
        Bike bike9 = new Bike("green", "CanBeRented");
        Bike bike10 = new Bike("black", "CanBeRented");
        Bike bike11 = new Bike("white", "CanBeRented");
        Bike bike12 = new Bike("pink", "CanBeRented");
        HashMap<Integer, Bike> bikes = new HashMap<>();
        bikes.put(bike1.getBikeID(), bike1);
        bikes.put(bike2.getBikeID(), bike2);
        bikes.put(bike3.getBikeID(), bike3);
        bikes.put(bike4.getBikeID(), bike4);
        bikes.put(bike5.getBikeID(), bike5);
        bikes.put(bike6.getBikeID(), bike6);
        bikes.put(bike7.getBikeID(), bike7);
        bikes.put(bike8.getBikeID(), bike8);
        bikes.put(bike9.getBikeID(), bike9);
        bikes.put(bike10.getBikeID(), bike10);
        bikes.put(bike11.getBikeID(), bike11);
        bikes.put(bike12.getBikeID(), bike12);

        Station station1 = new Station("Landstrasse");
        Station station2 = new Station("Donaustadt");
        Station station3 = new Station("Floridsdorf");
        HashMap<Integer, Station> stations = new HashMap<>();
        stations.put(station1.getStationID(), station1);
        stations.put(station2.getStationID(), station2);
        stations.put(station3.getStationID(), station3);

        station1.addBike(bike1, station1);
        station1.addBike(bike2, station1);
        station1.addBike(bike3, station1);
        station2.addBike(bike4, station2);
        station2.addBike(bike5, station2);
        station2.addBike(bike6, station2);
        station2.addBike(bike7, station2);
        station3.addBike(bike8, station3);
        station1.addBike(bike9, station1);
        station3.addBike(bike10, station3);
        station3.addBike(bike11, station3);
        station3.addBike(bike12, station3);

        User user1 = new User("Tom", "Spring");
        User user2 = new User("Sam", "Samson");
        User user3 = new User("Leo", "Liamson");
        User user4 = new User("Kinni", "Krampson");

        HashMap<Integer, User> users = new HashMap<>();
        users.put(user1.getUserID(), user1);
        users.put(user2.getUserID(), user2);
        users.put(user3.getUserID(), user3);
        users.put(user4.getUserID(), user4);

        System.out.println("**************************************\nWELCOME TO VIENNA BIKE RENTAL SERVICE\n**************************************");

        boolean continueLoop = true;
        String rules = "Command console\n---------------\nTo exit press: 0\nTo add new user press: 1\nTo add new Bike to station press: 2\nTo rent a Bike press: 3\nTo return a bike press: 4\nTo see all users press: 5\nTo see all available bikes press: 6\nTo print all bikes press: 7";
        while(continueLoop){
            System.out.println(rules);
            Scanner in = new Scanner(System.in);
            int command = in.nextInt();

            switch (command) {
                case 0:
                    System.out.println("Thank you for using our services, we hope to see you again..");
                    continueLoop = false;
                    break;
                case 1:
                    System.out.println("**Adding new user**");
                    System.out.println("PLease enter first name of the user");
                    in = new Scanner(System.in);
                    String firstName = in.nextLine();
                    System.out.println("PLease enter last name of the user");
                    in = new Scanner(System.in);
                    String lastName = in.nextLine();
                    User tempUser = new User(firstName, lastName);
                    users.put(tempUser.getUserID(), tempUser);
                    System.out.println("Successfully added user to the system");
                    break;
                case 2:
                    System.out.println("**Adding new bike**");
                    System.out.println("PLease enter color of the bike");
                    in = new Scanner(System.in);
                    String color = in.nextLine();
                    System.out.println("PLease enter state of the bike(CanBeRented, CanNotBeRented, InService or Discarded)");
                    in = new Scanner(System.in);
                    String state = in.nextLine();
                    Bike tempBike = new Bike(color, state);
                    bikes.put(tempBike.getBikeID(), tempBike);
                    System.out.println("Successfully added bike to the system");
                    System.out.println("To which station you want to assign the bike to? Please enter the number of the station");
                    for (int i : stations.keySet()) {
                        System.out.println("for " + stations.get(i).getLocation() + " press: " + i);
                    }
                    in = new Scanner(System.in);
                    int noOfStation = in.nextInt();
                    if (!stations.containsKey(noOfStation)) {
                        System.out.println("Aborted, there is no such station");
                        break;
                    }
                    stations.get(noOfStation).addBike(tempBike, stations.get(noOfStation));
                    break;
                case 3:
                    System.out.println("Please enter your userID");
                    in = new Scanner(System.in);
                    int userIDselected = in.nextInt();
                    if (!users.containsKey(userIDselected)) {
                        System.out.println("Sorry there is no user with the ID you selected in our system");
                        break;
                    }
                    System.out.println("Please select the station you wanna rent the bike from");
                    for (int i : stations.keySet()) {
                        System.out.println("for " + stations.get(i).getLocation() + " press: " + i);
                    }
                    in = new Scanner(System.in);
                    int location = in.nextInt();
                    System.out.println("Renting a bike at " + stations.get(location).getLocation() + "\nList of available bikes:");
                    // System.out.println(stations.get(location).getBikesInStation().size());
                    if (stations.get(location).getBikesInStation().size() == 0) {
                        System.out.println("Sorry there is no bikes for rent available at our station");
                        break;
                    }
                    for (Bike i : stations.get(location).getBikesInStation()) {
                        if (i.getState().equals("CanBeRented")) {
                            System.out.println("ID: " + i.getBikeID() + " color: " + i.getColor() + " state: " + i.getState());
                        }
                    }
                    System.out.println("Please select a bike ID from the bikes available above");
                    in = new Scanner(System.in);
                    int bikeIDselected = in.nextInt();
                    if (!bikes.get(bikeIDselected).getState().equals("CanBeRented")) {
                        System.out.println("You didnt selected an available bike please try again from the beginning");
                        break;
                    }
                    System.out.println("For how many hours you want to rent the bike");
                    in = new Scanner(System.in);
                    int hoursToRent = in.nextInt();
                    stations.get(location).rentAbike(users.get(userIDselected), stations.get(location), bikes.get(bikeIDselected), hoursToRent);
                    break;
                case 4:
                    System.out.println("Please enter your userID");
                    in = new Scanner(System.in);
                    userIDselected = in.nextInt();
                    if (!users.containsKey(userIDselected)) {
                        System.out.println("Sorry there is no user with the ID you selected in our system");
                        break;
                    }
                    System.out.println("Please select the station you wanna return the bike to");
                    for (int i : stations.keySet()) {
                        System.out.println("for " + stations.get(i).getLocation() + " press: " + i);
                    }
                    in = new Scanner(System.in);
                    location = in.nextInt();

                    if (users.get(userIDselected).getCurrentlyRentedBike() == 0) {
                        System.out.println("You haven't rented any bikes yet... Please rent a bike first");
                        break;
                    }
                    Station genuineStation = stations.get(bikes.get(users.get(userIDselected).getCurrentlyRentedBike()).getIdOfStationAssigned());
                    stations.get(location).returnAbike(users.get(userIDselected), stations.get(location), bikes.get(users.get(userIDselected).getCurrentlyRentedBike()), genuineStation);
                    break;
                case 5:
                    System.out.println("***Printing all the users***");
                    for (int i : users.keySet()) {
                        System.out.println(users.get(i).toString());
                    }
                    break;
                case 6:
                    System.out.println("***Printing all the bikes available and their respective stations***");
                    for (int i : stations.keySet()) {
                        Station station = stations.get(i);
                        ArrayList<Bike> bikesInStation = station.getBikesInStation();
                        for (Bike bike : bikesInStation) {
                            if (bike.getState().equals("CanBeRented")) {
                                System.out.println(bike);
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("Printing all the bikes");
                    for(int i : bikes.keySet()){
                        System.out.println(bikes.get(i).toString());
                    }
                    break;

            }

        }

    }
}