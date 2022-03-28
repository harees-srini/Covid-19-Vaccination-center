
import java.util.Scanner;

public class VaccinationCenter {
    static int userBooth;

    public static void main (String[] args) {
        System.out.println("----------Welcome to the CoViD-19 Vaccination Center----------");
        Scanner input = new Scanner(System.in);
        System.out.println("Before starting, please enter the total number of customers you wish to serve in this program: ");
        int patientNum = input.nextInt();//taking user input to determine length of customerList array
        String[] customerList = new String[patientNum];//creating a string array to hold customers
        System.out.println("You wish to serve "+patientNum+" customers.");

        Booth[] booths = new Booth[6];

        Booth randbooth = new Booth();

        booths[0] = new Booth(0, 25);
        booths[1] = new Booth(1, 25);
        booths[2] = new Booth(2, 25);
        booths[3] = new Booth(3, 25);
        booths[4] = new Booth(4, 25);
        booths[5] = new Booth(5, 25);


        int k = 0;//initializing a variable k to update the customerList array with the customer names
        String userInput;//declaring user input for the switch case.
        do {
            System.out.println("\n-----Select an option from the following menu-----" +
                    "\n100 or VVB:  View all Vaccination Booths" +
                    "\n101 or VEB:  View all Empty Booths" +
                    "\n102 or APB:  Add Patient to a Booth" +
                    "\n103 or RPB:  Remove Patient from a Booth" +
                    "\n104 or VPS:  View Patients Sorted in Alphabetical order" +
                    "\n105 or SPD:  Store Program Data into file" +
                    "\n106 or LPD:  Load Program Data from file" +
                    "\n107 or VRV:  View Remaining Vaccinations" +
                    "\n108 or AVS:  Add Vaccinations to the Stock" +
                    "\n999 or EXT:  Exit the program");
            System.out.println("Your option: ");
            userInput = input.next();
            if (userInput.equals("100") || userInput.equals("VVB")){Booth.viewBooths(booths);}
            else if (userInput.equals("101") || userInput.equals("VEB")){Booth.viewEmptyBooths(booths);}
            else if (userInput.equals("102") || userInput.equals("APB")){
                //customerList[k] = booths[userBooth].addPatient(booths);//getting a return value from this method
                randbooth.addPatient(booths);
                //System.out.println("Please re-enter your booth number: ");//and setting it to a customerList
                //userBooth=input.nextInt();
                k++;//incrementing k after each iteration of the switch case
            }
            else if (userInput.equals("103") || userInput.equals("RPB")){randbooth.removePatient(booths);}
            else if (userInput.equals("104") || userInput.equals("VPS")){Booth.sortPatients(customerList);}
            else if (userInput.equals("105") || userInput.equals("SPD")){Booth.storeData(booths);}
            else if (userInput.equals("106") || userInput.equals("LPD")){Booth.loadData();}
            else if (userInput.equals("107") || userInput.equals("VRV")){
                System.out.println("Enter booth: ");
                userBooth=input.nextInt();
                   booths[userBooth].remVaccines();
                   break;
            }
            else if (userInput.equals("108") || userInput.equals("AVS")){
                System.out.println("Enter booth: ");
                    userBooth=input.nextInt();
                    booths[userBooth].addVaccines();
            }
            else if (userInput.equals("999") || userInput.equals("EXT")){randbooth.exitProgram();}
        } while (userInput != null);

    }
}