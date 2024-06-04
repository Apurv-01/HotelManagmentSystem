import java.util.*;
import java.io.*;

class User {
    String name;
    String adno;
    String pNo;
    String roomType;
    int days;

    public User(String name, String adno, String pNo,String roomType, int days) {
        this.name = name;
        this.adno = adno;
        this.pNo = pNo;
        this.roomType = roomType;
        this.days = days;
    }
}

public class HotelManagmentSystem {
    static int amount = 0;
    static int maxBookings = 50;
    static User[] users = new User[maxBookings];
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***************************************************************************Welcome to Hotel Infinity***********************************************");
        while (true) {
            System.out.println("\n1. Gold : with Spa, Wifi, Laundry, Complimentary Breakfast, : Only 5000 per night/- ");
            System.out.println("2. Silver : with  Wifi, Laundry, Complimentary Breakfast, : Only 3000 per night/- ");
            System.out.println("3. Bronze : with Complimentary Breakfast, : Only 2000 per night/- \n");
            System.out.println("* Press 4 to exit  * ");
            
            int choice = scanner.nextInt();
            if (choice == 4) {
                System.out.println("You have now exited the system.");
                break;
            }
            System.out.print("Enter Name: ");
            String name = scanner.next();
            System.out.print("Enter Aadhar No.: ");
            String adno = scanner.next();
            System.out.print("Enter Phone No.: ");
            String pNo = scanner.next();
            System.out.print("Enter No. of days: ");
            int days = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookRoom("Gold", name, adno, pNo, days);
                    break;
                case 2:
                    bookRoom("Silver", name, adno, pNo, days);
                    break;
                case 3:
                    bookRoom("Bronze", name, adno, pNo, days);
                    break;
                default:
                    System.out.println("Wrong Input Please Try again!");
            }
        }

        saveToFile();
    }

    static void bookRoom(String roomType, String name, String adno, String pNo, int days) {
        users[count++] = new User(name, adno, pNo, roomType, days);
        if(roomType=="Gold") amount+=days*5000;
        else if(roomType=="Silver") amount+=days*3000;
        else if(roomType=="Bronze") amount+=days*2000;
        
        System.out.println("Room booked successfully for " + days + " days in " + roomType + " room.");
    }

    static void saveToFile() {
        try {
            FileWriter writer = new FileWriter("bookings.txt",true);
            for (int i = 0; i < count; i++) {
                writer.write("Name: " + users[i].name + ", Aadhar: " + users[i].adno +
                        ", Phone: " + users[i].pNo + ", Days: " + users[i].days +", RoomType: "+users[i].roomType +"\n");
            }
            writer.close();
            System.out.println("Thanks for the booking: ");
            System.out.println("The Total Amount for your booking is: ₹"+ amount);
        } catch (IOException e) {
            System.out.println("An Error occured while processing your booking. Please Try again.");
        }
    }
}
// Hotel managment
// GOLD
// SilVER
// Bronze

// Name , id, phone number , no of days, 

//prerequesite
//given , input to be taken
//choose datatype(primary,secondary)
