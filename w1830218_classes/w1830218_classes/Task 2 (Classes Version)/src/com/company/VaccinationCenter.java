package com.company;

import java.util.Scanner;

public class VaccinationCenter {

    public static void main(String[] args) {
        System.out.println("Welcome to the CoViD-19 Vaccination Center");
        Scanner input = new Scanner(System.in);
        System.out.println("Before starting, please enter the total number of customers you can serve in this program: ");
        int patientNum = input.nextInt();//taking user input to determine length of customerList array
        String[] customerList = new String[patientNum];//creating a string array to hold patients
        System.out.println("You can serve " + patientNum + " customers.");

        Booth[] booths = new Booth[6];//creating array of booth objects
        Booth booth = new Booth();//creating another booth object

        //initializing values to instance variables in each object
        booths[0] = new Booth(0, 25);
        booths[1] = new Booth(1, 25);
        booths[2] = new Booth(2, 25);
        booths[3] = new Booth(3, 25);
        booths[4] = new Booth(4, 25);
        booths[5] = new Booth(5, 25);

        int k = 0;//initializing a variable k to update the customerList array with the customer names
        String userInput;//declaring user input for the switch case.
        do {
            System.out.println("\nEnter an option from the following menu:" +
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

            int userBooth;
            if (userInput.equals("100") || userInput.equals("VVB")) {
                Booth.viewBooths(booths);

            } else if (userInput.equals("101") || userInput.equals("VEB")) {
                Booth.viewEmptyBooths(booths);

            } else if (userInput.equals("102") || userInput.equals("APB")) {
                System.out.println("Enter booth number (0-5): ");
                userBooth = input.nextInt();//getting booth number from user
                booths[userBooth].addPatient();//getting relevant booth object using userBooth index
                customerList[k] = booths[userBooth].getCustomerName();//adding customer's name to customerList array
                k++;//incrementing k after each iteration of the switch case

            } else if (userInput.equals("103") || userInput.equals("RPB")) {
                System.out.println("Enter booth number (0-5): ");
                userBooth = input.nextInt();//getting booth number to get the userBooth index
                booths[userBooth].removePatient();

            } else if (userInput.equals("104") || userInput.equals("VPS")) {
                Booth.sortPatients(customerList);

            } else if (userInput.equals("105") || userInput.equals("SPD")) {
                Booth.storeData(booths);

            } else if (userInput.equals("106") || userInput.equals("LPD")) {
                Booth.loadData();

            } else if (userInput.equals("107") || userInput.equals("VRV")) {
                System.out.println("Enter booth: ");
                userBooth = input.nextInt();//Getting booth number to check the remaining vaccines
                booths[userBooth].remVaccines();// in the relevent booth

            } else if (userInput.equals("108") || userInput.equals("AVS")) {
                System.out.println("Enter booth: ");
                userBooth = input.nextInt();//getting booth number to add vaccines to the
                booths[userBooth].addVaccines();//relevant booth

            } else if (userInput.equals("999") || userInput.equals("EXT")) {
                booth.exitProgram();
            }
        } while (true);//loops goes on until user presses exit option
    }
}

