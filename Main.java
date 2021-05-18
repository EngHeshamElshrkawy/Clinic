import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClinicReservation clinic = new ClinicReservation("Final Destination", "John H. Watson", "221B Baker Street",
                "1-800-273-8255");
        ArrayList<Patient> patientRec = new ArrayList<Patient>(20);
        int NumOfPatient = 0;
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome To Final Destination Clinic!");
        boolean exit = false;
        while (!exit) {
            mainMenu();
            choice = scan.nextInt();
            scan.nextLine();
            Patient currentPatient;
            switch (choice) {
                case 1:
                    if (NumOfPatient + 1 <= 20) {
                        currentPatient = createPatient(scan, NumOfPatient);
                        patientRec.add(currentPatient);
                        System.out.println("Your file number is: " + String.valueOf(NumOfPatient));
                        NumOfPatient++;
                        secondaryMenu(scan, currentPatient, clinic);
                    } else {
                        System.out.println("Patient files at capacity!");
                    }
                    break;
                case 2:
                    int fileNumber;
                    System.out.println("Enter your file number: ");
                    fileNumber = scan.nextInt();
                    scan.nextLine();
                    currentPatient = getPatient(fileNumber, patientRec);
                    secondaryMenu(scan, currentPatient, clinic);
                    break;
                case 3:
                    clinic.displaySlots();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid Choice!");
                    break;
            }

        }
        scan.close();
    }

    public static void mainMenu() {
        System.out.println("1. New Patient");
        System.out.println("2. Previous Patient");
        System.out.println("3. Display Clinic Reservations");
        System.out.println("4. Exit System");
        System.out.println("Choose an option: ");

    }

    public static void secondaryMenu(Scanner scan, Patient currentPatient, ClinicReservation clinic) {
        System.out.println("1. Add Appointment");
        System.out.println("2. Check Appointment");
        System.out.println("3. Delete Appointment");
        System.out.println("Choose an option: ");
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Choose a period (Morning, Afternoon, Evening)");
                String period = scan.nextLine();
                System.out.println("Choose a time (example 9:00)");
                String startingHour = scan.nextLine();
                clinic.reserveSlot(currentPatient.getFileNumber(), period, startingHour);
                break;
            case 2:
                clinic.getPatientReservation(currentPatient.getFileNumber());
                break;
            case 3:
                clinic.deleteSlot(currentPatient.getFileNumber());
                break;
            default:
                System.out.println("Invalid Choice!");
                break;

        }
    }

    public static Patient createPatient(Scanner scan, int NumOfPatient) {
        System.out.print("Enter your name: ");
        String nameOfPatient = scan.nextLine();
        System.out.print("Enter your age: ");
        int age = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter your history: ");
        String history = scan.nextLine();
        Patient newPatient = new Patient(nameOfPatient, NumOfPatient, age, history);
        return newPatient;
    }

    public static Patient getPatient(int fileNumber, ArrayList<Patient> patientRec) {
        for (int i = 0; i < patientRec.size(); i++) {
            if (patientRec.get(i).getFileNumber() == fileNumber) {
                return patientRec.get(i);
            }
        }
        return null;
    }
}
