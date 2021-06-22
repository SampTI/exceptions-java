
package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {


    public static void main(String[] args) throws ParseException {
        Scanner tc =  new Scanner(System.in).useLocale(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Room number: ");
        int number = tc.nextInt();
        tc.nextLine();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(tc.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(tc.next());        
        
        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }
        else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservarion: "+reservation);
          
            System.out.println("");
            System.out.println("Enter date to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(tc.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(tc.next()); 
            
            
            String error = reservation.updateDates(checkIn, checkOut);
            if(error != null){
                System.out.println("Error in reservation"+ error);
                       }else{
                System.out.println("Reservation: "+reservation);
            }
        }
        
        
        
        
    }
    
}
