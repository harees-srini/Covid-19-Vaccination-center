package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class VaccinationCenter {
    static int vaccineStock = 150;//declaring vaccine stock
    static int patientCount=0;//declaring number of patients that have been served
    static int patientNum;//declaring total serviceable patients
    static String customerName;//declaring customer name variable

    public static void main(String[] args) {
        System.out.println("----------Welcome to the CoViD-19 Vaccination Center----------");
        Scanner input = new Scanner(System.in);
        System.out.println("Before starting, please enter the total number of customers you wish to serve in this program: ");
        patientNum = input.nextInt();//taking user input to determine length of customerList array
        String[] customerList = new String[patientNum];//creating a string array to hold customers
        System.out.println("You wish to serve "+patientNum+" customers.");
        String[] customerBooths = new String[6];//creating array with 6 elements to hold the booths
        System.out.println("*There are 6 booths available. Please enter your name and a booth number when prompted*\n");

        int k = 0;//initializing a variable k to update the customerList array with the customer names
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
            String userInput = input.next();
            if (userInput.equals("100") || userInput.equals("VVB"))
                viewBooths(customerBooths);
            else if (userInput.equals("101") || userInput.equals("VEB")){emptyBooths(customerBooths);}
            else if (userInput.equals("102") || userInput.equals("APB")){
                addPatient(customerBooths);
                customerList[k] = customerName;//adding the customer's name to the array customer List using k for each iteration.
                k++;//incrementing k after each iteration of addPatient method
            }
            else if (userInput.equals("103") || userInput.equals("RPB")){removePatient(customerBooths);}
            else if (userInput.equals("104") || userInput.equals("VPS")){sortPatients(customerList);}
            else if (userInput.equals("105") || userInput.equals("SPD")){storeData(customerList);}
            else if (userInput.equals("106") || userInput.equals("LPD")){loadData();}
            else if (userInput.equals("107") || userInput.equals("VRV")){remVaccines();}
            else if (userInput.equals("108") || userInput.equals("AVS")){addVaccines();}
            else if (userInput.equals("999") || userInput.equals("EXT")){exitProgram();}
        } while (true);//loops goes on until user presses exit option

    }
    public static void viewBooths(String[] x) {
        for (int j = 0; j<6; j++) {//looping array to display the status of the booths. If occupied by none, it shows null
            System.out.println("Booth " + j + " is occupied by " + x[j]);
        }
    }
    public static void emptyBooths(String x[]){
        for (int j=0; j<6; j++){//looping array
            if (x[j] == null)//only if the element does not contain any value(==null), it gets shown here
                System.out.println("Booth " + j + " is empty");
        }
    }
    public static void addPatient(String[] x){
        Scanner input=new Scanner(System.in);
        System.out.println("\nEnter a booth number (0-5): ");
        int boothNum = input.nextInt();//taking user input for which booth the patient should be added
        System.out.println("Enter your name: ");
        customerName = input.next();//taking the name of the customer to be added
        x[boothNum] = customerName;//setting the element to the customer's name
        System.out.println(customerName+" has been added to Booth "+boothNum);
        patientCount=patientCount+1;//incrementing the number of served patients
        vaccineStock=vaccineStock-1;//decreasing the number of vaccines
        if (vaccineStock==20){//if vacccine stock reaches 20, prints a warning
            System.out.println("The vaccine stock has reached 20. Please refill the stock.");
        }
    }
    public static void removePatient(String x[]){
        Scanner input=new Scanner(System.in);
        System.out.println("\nEnter booth number to remove patient(0-5): ");
        int boothNum = input.nextInt();//taking user input asking which booth should be removed
        System.out.println("You have removed "+x[boothNum]+"from Booth "+boothNum);
        x[boothNum] = null;//setting that booth to null
    }

    public static void sortPatients(String[] x){
        System.out.println("Unsorted list: "+ Arrays.toString(x));//printing unsorted array
        for (int i=0; i<x.length; i++){//outer loop through array
            for (int j=i+1; j<x.length; j++) {//inner loop through array but starting with one index more than i
                if (x[i].compareTo(x[j]) > 0) {//using compareTo to check whether x[i] > x[j]
                    String temp = x[i];//storing x[j] to a temporary variable
                    x[i] = x[j];//setting the value of x[i] as x[j]
                    x[j] = temp;//setting the value of x[j] as temp
                }
            }
        }
        System.out.println("Sorted list "+Arrays.toString(x));//printing sorted array
    }

    public static void remVaccines(){
        System.out.println("The number of remaining vaccines are: "+vaccineStock);
    }

    public static void addVaccines(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the number of added vaccines: ");
        int newVaccines=input.nextInt();//user input for the number of vaccines to be added
        vaccineStock=vaccineStock+newVaccines;//adding vaccineStock by the newVaccines
        System.out.println("Vaccination stock has been updated to "+vaccineStock);
    }

    public static void exitProgram(){
        System.out.println("Thank you for using our services");
        System.exit(0);
    }

    public static void storeData(String[] x){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("VaccinationDetails.txt"));//creating file
            writer.write("Patient Names:");
            for (int i=0; i< x.length; i++) {
                writer.write("\n"+x[i]);//entering the values of array to file
            }
            writer.write("\nVaccine Stock: "+vaccineStock);//writing number of vaccines to file
            writer.write("\nNumber of patients served: "+patientCount);//writing number of served patients to file
            writer.close();//closing file
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data stored into a text file called VaccinationDetails.txt");
    }

    public static void loadData(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("VaccinationDetails.txt"));//reading file
            String line;
            while ((line = reader.readLine()) != null){//looping through each line of the file
                System.out.println(line);//printing each line of the file
            }
            reader.close();//closing file
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

