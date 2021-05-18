import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ClinicReservation {
    ClinicInfo information = new ClinicInfo();
    int[] TimeSlots = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    String[] Appointments = {"9:00", "10:00", "11:00",
     "14:00", "15:00", "16:00", "18:00", "19:00", "20:00"};
    public ClinicReservation(){
  
    }

    public ClinicReservation(String nameOfClinic, String nameOfDoctor, String address, String phoneNumber){
        information.setClinicName(nameOfClinic);
        information.setDoctorName(nameOfDoctor);
        information.setAddress(address);
        information.setPhoneNumber(phoneNumber);
    }

    public void setClinicInfo(String nameOfClinic, String nameOfDoctor, String address, String phoneNumber){
        information.setClinicName(nameOfClinic);
        information.setDoctorName(nameOfDoctor);
        information.setAddress(address);
        information.setPhoneNumber(phoneNumber);
    }

    public void getClinicInfo(){
        System.out.println(information.getClinicName());
        System.out.println(information.getDoctorName());
        System.out.println(information.getAddress());
        System.out.println(information.getPhoneNumber());

    }

    public void displaySlots(){
        String availability;
        int startingPeriod = 0;
        for(int i = 0; i < 9; i++){
            if(TimeSlots[i] == -1){
                availability = "Available";
            }else{
                availability = "Reserved";
            }

            if(i == 0){
                System.out.println("## Morning Period ##");
                startingPeriod = 9;
            }else if(i == 3){
                System.out.println("## Afternoon Period ##");
                startingPeriod = 11;
            }else if(i == 6){
                System.out.println("## Evening Periods ##");
                startingPeriod = 12;
            }

            System.out.println("Appointment " + String.valueOf(startingPeriod + i) +
             ":00 - " + String.valueOf(startingPeriod + i + 1) + ":00 " + availability);


        }
    }

    public boolean reserveSlot(int patientId, String period, String startingHour){
        int index = 0;
        switch(period){
            case "Morning":
                if(startingHour.equals("9:00")){
                    index = 0;
                }else if(startingHour.equals("10:00")){
                    index = 1;
                }else if(startingHour.equals("11:00")){
                    index = 2;
                }else{
                    System.out.println("There's no available time slot at the given hour!");
                    return false;
                }
                break;
            case "Afternoon":
                if(startingHour.equals("14:00")){
                    index = 3;
                }else if(startingHour.equals("15:00")){
                    index = 4;
                }else if(startingHour.equals("16:00")){
                    index = 5;
                }else{
                    System.out.println("There's no available time slot at the given hour!");
                    return false;
                }
                break;
            case "Evening":
                if(startingHour.equals("18:00")){
                    index = 6;
                }else if(startingHour.equals("19:00")){
                    index = 7;
                }else if(startingHour.equals("20:00")){
                    index = 8;
                }else{
                    System.out.println("There's no available time slot at the given hour!");
                    return false;
                }
                break;
            default:
                System.out.println("No period matches the entered period");
                break;
            }
            if(TimeSlots[index] == -1){
                TimeSlots[index] = patientId;
                System.out.println("Reservation made successfully!");
                return true;
            }else if(TimeSlots[index] == patientId){
                System.out.println("Patient already has a reservation!");
                return false;
            }else{
                System.out.println("This appointment is already reserved!");
                return false;
            }

    }

    public void deleteSlot(int patientId){
        List<Integer> reservations = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            if(TimeSlots[i] == patientId){
                reservations.add(i);
            }
        }
        if(reservations.size() == 0){
            System.out.println("No reservations found!");
        }else if(reservations.size() == 1){
            TimeSlots[reservations.get(0)] = -1;
            System.out.println("Reservation deleted!");
        }else{
            Scanner scan = new Scanner(System.in);
            int choice;
            for(int i = 0; i < reservations.size() ; i++){
                System.out.println(String.valueOf(i) + " " + Appointments[reservations.get(i)]);
            }
            System.out.println("Enter which reservation to delete: ");
            choice = scan.nextInt();
            scan.nextLine();
            scan.close();
            TimeSlots[reservations.get(choice)] = -1;
            System.out.println("Reservation deleted!");
        }
    }

   public void getPatientReservation(int patientId){
        int reservations = 0;
        System.out.println("Your appointments");
        for(int i = 0; i < 9 ; i++){
            if(TimeSlots[i] == patientId){
                System.out.println(Appointments[i]);
                reservations ++;
            }
        }
        if(reservations == 0){
            System.out.println("No reservations found!");

        }
   }
}
