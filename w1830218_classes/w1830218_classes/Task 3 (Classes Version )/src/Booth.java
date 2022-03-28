import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Booth {
    //creating instance variables
    private String firstName;
    private int boothNum;
    private int patientCount;
    private int vaccineStock;

    //default constructor
    public Booth() {
    }

    //parameterized constructor
    public Booth(int boothNum, int vaccineStock) {
        this.boothNum = boothNum;
        this.vaccineStock = vaccineStock;
    }

    public void viewBooths(Booth[] booths) {
        //looping array to display the status of the booths. If occupied by none, it shows null
        for (int j = 0; j < booths.length; j++) {
            System.out.println("Booth " + j + " is occupied by " + booths[j].firstName);
        }
    }

    public void viewEmptyBooths(Booth[] booths) {
        for (int j = 0; j < booths.length; j++) { //looping array
            //only if the element does not contain any value(==null), it gets shown here
            if (booths[j].getFirstName() == null)
                System.out.println("Booth " + j + " is empty");
        }
    }

    public String addPatient(Booth[] booths) {
        patientCount = patientCount + 1;
        vaccineStock = vaccineStock - 1;
        if (vaccineStock == 20) {
            System.out.println("The vaccine stock has reached 20. Please refill the stock.");
        }
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String username = input.next();
        System.out.println("\nEnter the vaccine number you require (1-AstraZeneca/2-Sinopharm/3-Pfizer): ");
        int vaccineNum = input.nextInt();//taking user input for which booth the patient should be added
        if (vaccineNum==1){//AstraZeneca
            System.out.println("Which booth do you prefer? 0 or 1?");
            int userbooth= input.nextInt();
            if (userbooth==0){
                booths[userbooth].firstName = username;//setting the element to the customer's name
                System.out.println(username+" has been added to Booth 0-AstraZeneca");
            } else if (userbooth==1){
                booths[userbooth].firstName = username;
                System.out.println(username+" has been added to Booth 1-AstraZeneca");}
        } else if (vaccineNum==2){//Sinopharm
            System.out.println("Which booth do you prefer? 2 or 3?");
            int userbooth= input.nextInt();
            if (userbooth==2){
                booths[userbooth].firstName = username;//setting the element to the customer's name
                System.out.println(username+" has been added to Booth 2-Sinopharm");
            } else if (userbooth==3){
                booths[userbooth].firstName = username;
                System.out.println(username+" has been added to Booth 3-Sinopharm");}
        } else if (vaccineNum==3){//Pfizer
            System.out.println("Which booth do you prefer? 4 or 5?");
            int userbooth= input.nextInt();
            if (userbooth==4){
                booths[userbooth].firstName = username;//setting the element to the customer's name
                System.out.println(username+" has been added to Booth 4-Pfizer");
            } else if (userbooth==5){
                booths[userbooth].firstName = username;
                System.out.println(username+" has been added to Booth 5-Pfizer");}
        }

        return username;
    }

    public void removePatient() {
        System.out.println("You have removed " + firstName + " from Booth " + boothNum);
        firstName = null;//setting that booth to null

    }

    public void sortPatients(String[] example) {
        System.out.println("Unsorted list: " + Arrays.toString(example));//printing unsorted array
        for (int i = 0; i < example.length; i++) {//outer loop through array
            for (int j = i + 1; j < example.length; j++) {//inner loop through array but starting with one index more than i
                if (example[i].compareTo(example[j]) > 0) {//using compareTo to check whether x[i] > x[j]
                    String temp = example[i];//storing x[j] to a temporary variable
                    example[i] = example[j];//setting the value of x[i] as x[j]
                    example[j] = temp;//setting the value of x[j] as temp
                }
            }
        }
        System.out.println("Sorted list " + Arrays.toString(example));//printing sorted array
    }

    public void remVaccines() {
        System.out.println("The number of remaining vaccines are: " + vaccineStock);
    }

    public void addVaccines() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of added vaccines: ");
        int newVaccines = input.nextInt();//user input for the number of vaccines to be added
        vaccineStock = vaccineStock + newVaccines;//adding vaccineStock by the newVaccines
        System.out.println("The updated vaccination stock is: " + vaccineStock);
    }

    public void exitProgram() {
        System.out.println("Thank you for using our services");
        System.exit(0);
    }

    public void storeData(Booth[] booths) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("VaccinationDetails.txt"));//creating file
            for (int i = 0; i < booths.length; i++) {
                writer.write("\n" + booths[i].firstName +" "+ booths[i].boothNum+" " + booths[i].vaccineStock);//entering the values of array to file
            }
            writer.close();//closing file
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data stored into a text file called VaccinationDetails.txt");
    }

    public void loadData() {
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

    //Getters and Setters
    public int getBoothNum() {
        return boothNum;
    }

    public void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }


    public int getPatientCount() {
        return patientCount;
    }

    public void setPatientCount(int patientCount) {
        this.patientCount = patientCount;
    }

    public int getVaccineStock() {
        return vaccineStock;
    }

    public void setVaccineStock(int vaccineStock) {
        this.vaccineStock = vaccineStock;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

