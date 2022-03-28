package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class VaccinationCenter {
    static int vaccineStock = 150;
    static int patientCount=0;
    static int patientNum;
    static String firstName;//declaring patient's first name variable
    static String lastName;//declaring patient's last name variable
    static String fullName;//declaring patient's last full name variable


    public static void main(String[] args) {
        System.out.println("----------Welcome to the CoViD-19 Vaccination Center----------");
        Scanner input = new Scanner(System.in);
        System.out.println("Before starting, please enter the total number of customers you wish to serve in this program: ");
        patientNum = input.nextInt();//taking user input to determine length of customerList array
        //Parallel arrays
        String[] firstNameList = new String[patientNum];//array to hold first names
        String[] lastNameList = new String[patientNum];//array to hold last names

        System.out.println("You wish to serve "+patientNum+" customers.");
        String[] customerBooths = new String[6];//creating array with 6 elements to hold the booths
        System.out.println("*There are 6 booths available. Please enter a booth number and your name when prompted*");

        int k = 0;//initializing a variable k to update both arrays with first names and last names
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
            if (userInput.equals("100") || userInput.equals("VVB")){viewBooths(customerBooths);}
            else if (userInput.equals("101") || userInput.equals("VEB")){emptyBooths(customerBooths);}
            else if (userInput.equals("102") || userInput.equals("APB")){
                addPatient(customerBooths);
                firstNameList[k] = firstName;//adding first name to first name list
                lastNameList[k] = lastName;//adding last name to last name list
                k++;//incrementing k after each iteration of addPatient method
            }
            else if (userInput.equals("103") || userInput.equals("RPB")){removePatient(customerBooths);}
            else if (userInput.equals("104") || userInput.equals("VPS")){sortPatients(firstNameList);}
            else if (userInput.equals("105") || userInput.equals("SPD")){storeData(firstNameList, lastNameList);}
            else if (userInput.equals("106") || userInput.equals("LPD")){loadData();}
            else if (userInput.equals("107") || userInput.equals("VRV")){remVaccines();}
            else if (userInput.equals("108") || userInput.equals("AVS")){addVaccines();}
            else if (userInput.equals("999") || userInput.equals("EXT")){exitProgram();}
        } while (true);
    }
    public static void viewBooths(String[] x) {
        for (int j = 0; j<6; j++) {//looping array to display the status of the booths. If occupied by none, it shows null
            System.out.println("Booth " + j + " is occupied by " + x[j]);
        }
    }
    public static void emptyBooths(String x[]){
        for (int j=0; j<6; j++){
            if (x[j] == null)//only if the element does not contain any value(==null), it gets shown here
                System.out.println("Booth " + j + " is empty");
        }
    }
    public static void addPatient(String[] x){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter your first name: ");
        firstName = input.next();//taking first name
        System.out.println("Enter your last name: ");
        lastName = input.next();//taking last name
        fullName=firstName+" "+lastName;//combining first and last name to create full name
        System.out.println("\nEnter the number of the Vaccine you require (1-AstraZeneca | 2-Sinopharm |  3-Pfizer): ");
        int vaccineNum = input.nextInt();//taking patient's preference for vaccine type
        if (vaccineNum==1){//AstraZeneca
            System.out.println("Which booth do you prefer? 0 or 1?");
            int userbooth= input.nextInt();
            if (userbooth==0){
                x[0] = fullName;//setting element to full name
                System.out.println("*"+fullName+" has been added to Booth 0-AstraZeneca*");
            } else if (userbooth==1){
                x[1] = fullName;//setting element to full name
                System.out.println("*"+fullName+" has been added to Booth 1-AstraZeneca*");}
        } else if (vaccineNum==2){//Sinopharm
            System.out.println("Which booth do you prefer? 2 or 3?");
            int userbooth= input.nextInt();
            if (userbooth==2){
                x[2] = fullName;//setting element to full name
                System.out.println("*"+fullName+" has been added to Booth 2-Sinopharm*");
            } else if (userbooth==3){
                x[3] = fullName;//setting element to full name
                System.out.println("*"+fullName+" has been added to Booth 3-Sinopharm*");}
        } else if (vaccineNum==3){//Pfizer
            System.out.println("Which booth do you prefer? 4 or 5?");
            int userbooth= input.nextInt();
            if (userbooth==4){
                x[4] = fullName;//setting element to full name
                System.out.println("*"+fullName+" has been added to Booth 4-Pfizer*");
            } else if (userbooth==5){
                x[5] = fullName;//setting element to full name
                System.out.println("*"+fullName+" has been added to Booth 5-Pfizer*");}
        }
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
        System.out.println("You have removed "+x[boothNum]+" from Booth "+boothNum);
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
    }
    public static void exitProgram(){
        System.out.println("Thank you for using our services");
        System.exit(0);
    }
    public static void storeData(String[] x, String[] y){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("VaccinationDetails.txt"));//creating file
            writer.write("Full name list");
            for (int i=0; i< x.length; i++) {
                writer.write("\n"+x[i]);//entering the values of array to file
                writer.write(" "+y[i]);
            }
            writer.write("\nVaccine stock: "+vaccineStock);//writing number of vaccines to file
            writer.write("\nNumber of served patients: "+patientCount);//writing number of served patients to file
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
