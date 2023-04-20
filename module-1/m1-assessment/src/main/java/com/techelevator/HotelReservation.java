package com.techelevator;


//Create a new class that represents a Hotel Reservation. - DONE
public class HotelReservation {

//    Add a name, number of nights, and estimated total attribute/property to the Hotel Reservation class: - DONE
//    name: indicates the name on the reservation. -DONE
//    number of nights: indicates how many nights the reservation is for. -DONE
//    estimated total: indicates the estimated total using number of nights times a daily rate of $59.99. - DONE

    public String name;
    public int numberOfNights;
    public double estimatedTotal;

    //    Create a constructor that accepts name and number of nights. - DONE
    public HotelReservation (String name, int numberOfNights){
        this.name = name;
        this.numberOfNights = numberOfNights;
        this.estimatedTotal = numberOfNights * 59.99;
    }
//    Instantiate an object, or objects, in main(), and use the object(s) to test your methods. - DONE
    public HotelReservation newReservation = new HotelReservation("Trav", 3);

//    Create a method that calculates the total using two boolean input parameters: requiresCleaning and usedMinibar: -DONE
//    If the minibar was used, a fee of $12.99 is added to the estimated total. - DONE
//    If the room requires cleaning, a fee of $34.99 is added to the estimated total. - DONE
//    The cleaning fee is doubled if the minibar was used. - DONE
    public double calculateTotal(boolean requiresCleaning, boolean usedMinibar) {
        double miniBarFee = 12.99;
        double cleaningFee = 34.99;
        double combinedFee = 82.97;
        if (usedMinibar && requiresCleaning) {
            estimatedTotal = estimatedTotal + combinedFee;
            return estimatedTotal;
        } else if (usedMinibar == true && !requiresCleaning) {
            estimatedTotal = estimatedTotal + miniBarFee;
            return estimatedTotal;
        } else if (!usedMinibar && requiresCleaning) {
            estimatedTotal = estimatedTotal + cleaningFee;
            return estimatedTotal;
        } else return estimatedTotal;
    }
//    Override the toString() method and have it return "RESERVATION - {name} - {estimated total}" - DONE
//    where {name} and {estimated total} are placeholders for the actual values. - DONE
//    The values from the object should be shown in the string where {variable-name} is indicated. - DONE

    @Override
    public String toString() {
        return "RESERVATION - " + name + " - " + estimatedTotal;
    }

//    Implement unit tests to validate the functionality of:
//    The estimated total calculation
//    The actual total method



//    In the main program class, within the main method, read in the provided csv file HotelInput.csv
//    use it to instantiate and populate a list of Hotel Reservation objects.

//    Add up the estimated total for all of the hotel reservations in the list, and print it to the screen.

//GETTERS AND SETTERS JUST IN CASE
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public double getEstimatedTotal() {
        return estimatedTotal;
    }

    public void setEstimatedTotal(double estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public HotelReservation getNewReservation() {
        return newReservation;
    }

    public void setNewReservation(HotelReservation newReservation) {
        this.newReservation = newReservation;
    }
}
