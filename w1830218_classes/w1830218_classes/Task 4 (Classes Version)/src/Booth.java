
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Booth {
    private int boothNum;
    private String customerName;
    private int patientCount;
    private int vaccineStock;

    LinkedList<String> AZwaitingList = new LinkedList<String>();//linked list for AstraZeneca patients
    LinkedList<String> PFwaitingList = new LinkedList<String>();//linked list for Pfizer patients
    LinkedList<String> SPwaitingList = new LinkedList<String>();//linked list for Sinopharm patients

    //default constructor
    public Booth() {
    }

    //parameterized constructor
    public Booth(int boothNum, int vaccineStock) {
        this.boothNum = boothNum;
        this.vaccineStock = vaccineStock;
    }

    public static void viewBooths(Booth[] booths) {
        //looping array to display the status of the booths. If occupied by none, it shows null
        for (int j = 0; j < booths.length; j++) {
            System.out.println(new StringBuilder().append("Booth ").append(j).append(" is occupied by ").append(booths[j].getCustomerName()).toString());
        }
    }

    public static void viewEmptyBooths(Booth[] booths) {
        for (int j = 0; j < booths.length; j++) { //looping array
            //only if the element does not contain any value(==null), it gets shown here
            if (booths[j].getCustomerName() == null)
                System.out.println("Booth " + j + " is empty");
        }
    }


    public static void storeData(Booth[] booths) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("VaccinationDetails.txt"));//creating file
            for (int i = 0; i < booths.length; i++) {
                writer.write("\n" + booths[i].customerName + " " + booths[i].boothNum + " " + booths[i].vaccineStock);//entering the values of array to file
            }
            writer.close();//closing file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadData() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("VaccinationDetails.txt"));//reading file
            String line;
            while ((line = reader.readLine()) != null) {//looping through each line of the file
                System.out.println(line);//printing each line of the file
            }
            reader.close();//closing file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sortPatients(String[] x) {
        System.out.println("Unsorted list: " + Arrays.toString(x));//printing unsorted array
        for (int i = 0; i < x.length; i++) {//outer loop through array
            for (int j = i + 1; j < x.length; j++) {//inner loop through array but starting with one index more than i
                if (x[i].compareTo(x[j]) > 0) {//using compareTo to check whether x[i] > x[j]
                    String temp = x[i];//storing x[j] to a temporary variable
                    x[i] = x[j];//setting the value of x[i] as x[j]
                    x[j] = temp;//setting the value of x[j] as temp
                }
            }
        }
        System.out.println("Sorted list " + Arrays.toString(x));//printing sorted array
    }

    public void addPatient(Booth[] booths) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = input.next();

        System.out.println("\nEnter the vaccine number you require (1-AstraZeneca | 2-Pfizer | 3-SinoPharm): ");
        int vaccineNum = input.nextInt();//asking vaccine preference

        if (vaccineNum == 1) {
            System.out.println("Which booth do you prefer? 0 or 1?");
            int userbooth = input.nextInt();//asking booth preference

            if (userbooth == 0) {
                if (booths[userbooth].customerName != null) {
                    AZwaitingList.addLast(userName);//adding to linked list if booth is occupied
                    System.out.println("Booth is occupied. "+userName + " has been added to the waiting list");
                } else {
                    booths[userbooth].customerName = userName;//setting the element to the customer's name
                    System.out.println(userName + " has been added to Booth " + userbooth);
                }

            } else if (userbooth == 1) {
                if (booths[userbooth].customerName != null) {
                    AZwaitingList.addLast(userName);//adding to linked list if booth is occupied
                    System.out.println("Booth is occupied. "+userName + " has been added to the waiting list");
                } else {
                    booths[userbooth].customerName = userName;//setting the element to the customer's name
                    System.out.println(userName + " has been added to Booth " + userbooth);
                }
            }

        } else if (vaccineNum == 2) {
            System.out.println("Which booth do you prefer? 2 or 3?");
            int userbooth = input.nextInt();

            if (userbooth == 2) {
                if (booths[userbooth].customerName != null) {
                    SPwaitingList.addLast(userName);//adding to linked list if booth is occupied
                    System.out.println("Booth is occupied. "+userName + " has been added to the waiting list");
                } else {
                    booths[userbooth].customerName = userName;//setting the element to the customer's name
                    System.out.println(userName + " has been added to Booth " + userbooth);
                }

            } else if (userbooth == 3) {
                if (booths[userbooth].customerName != null) {
                    SPwaitingList.addLast(userName);//adding to linked list if booth is occupied
                    System.out.println("Booth is occupied. "+userName + " has been added to the waiting list");
                } else {
                    booths[userbooth].customerName = userName;//setting the element to the customer's name
                    System.out.println(userName + " has been added to Booth " + userbooth);
                }
            }

        } else if (vaccineNum == 3) {
            System.out.println("Which booth do you prefer? 4 or 5?");
            int userbooth = input.nextInt();

            if (userbooth == 4) {
                if (booths[userbooth].customerName != null) {
                    PFwaitingList.addLast(userName);//adding to linked list if booth is occupied
                    System.out.println("Booth is occupied. "+userName + " has been added to the waiting list");
                } else {
                    booths[userbooth].customerName = userName;//setting the element to the customer's name
                    System.out.println(userName + " has been added to Booth " + userbooth);
                }

            } else if (userbooth == 5) {
                if (booths[userbooth].customerName != null) {
                    PFwaitingList.addLast(userName);//adding to linked list if booth is occupied
                    System.out.println("Booth is occupied. "+userName + " has been added to the waiting list");
                } else {
                    booths[userbooth].customerName = userName;//setting the element to the customer's name
                    System.out.println(userName + " has been added to Booth " + userbooth);
                }
            }
        }
        patientCount = patientCount + 1;
        vaccineStock = vaccineStock - 1;
        if (vaccineStock == 20) {
            System.out.println("The vaccine stock has reached 20. Please refill the stock.");
        }
    }

        public void removePatient(Booth[] booths) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter booth number (0-5): ");
            int boothnum=input.nextInt();
            System.out.println("You have removed " + booths[boothnum].customerName + " from Booth " + boothNum);
            if (boothnum==0 || boothnum==1){
                if (!AZwaitingList.isEmpty()){
                    booths[boothnum].customerName=AZwaitingList.getFirst();
                } else {booths[boothnum].customerName = null;}
            }
            else if (boothnum==2 || boothnum==3){
                if (!SPwaitingList.isEmpty()){
                    booths[boothnum].customerName=SPwaitingList.getFirst();
                } else {booths[boothnum].customerName = null;}
            }
            else if (boothnum==4 || boothnum==5){
                if (!PFwaitingList.isEmpty()){
                    booths[boothnum].customerName=PFwaitingList.getFirst();
                } else {booths[boothnum].customerName = null;}
            }
        }

        public void remVaccines () {
            System.out.println("The number of remaining vaccines are: " + vaccineStock);
        }

        public void addVaccines () {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the number of added vaccines: ");
            int newVaccines = input.nextInt();//user input for the number of vaccines to be added
            vaccineStock = vaccineStock + newVaccines;//adding vaccineStock by the newVaccines
            System.out.println("Number of remaining vaccines: " + vaccineStock);
        }

        public void exitProgram () {
            System.out.println("Thank you for using our services");
            System.exit(0);
        }

        public int getBoothNum () {
            return boothNum;
        }

        public void setBoothNum ( int boothNum){
            this.boothNum = boothNum;
        }

        public String getCustomerName () {
            return customerName;
        }

        public void setCustomerName (String customerName){
            this.customerName = customerName;
        }

        public int getPatientCount () {
            return patientCount;
        }

        public void setPatientCount ( int patientCount){
            this.patientCount = patientCount;
        }

        public int getVaccineStock () {
            return vaccineStock;
        }

        public void setVaccineStock ( int vaccineStock){
            this.vaccineStock = vaccineStock;
        }

        public LinkedList<String> getAZwaitingList () {
            return AZwaitingList;
        }

        public void setAZwaitingList (LinkedList < String > AZwaitingList) {
            this.AZwaitingList = AZwaitingList;
        }

        public LinkedList<String> getPFwaitingList () {
            return PFwaitingList;
        }

        public void setPFwaitingList (LinkedList < String > PFwaitingList) {
            this.PFwaitingList = PFwaitingList;
        }

        public LinkedList<String> getSPwaitingList () {
            return SPwaitingList;
        }

        public void setSPwaitingList (LinkedList < String > SPwaitingList) {
            this.SPwaitingList = SPwaitingList;
        }
    }



