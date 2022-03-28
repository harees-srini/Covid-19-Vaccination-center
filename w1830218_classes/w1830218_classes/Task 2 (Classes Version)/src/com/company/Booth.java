package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Booth {
    private int boothNum;
    private String customerName;
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


    public static void viewBooths(Booth[] booths) {
        //looping array to display the status of the booths. If occupied by none, it shows null
        for (int j = 0; j < booths.length; j++) {
            System.out.println("Booth " + j + " is occupied by " + booths[j].getCustomerName());
        }
    }

    public static void viewEmptyBooths(Booth[] booths) {
        for (int j = 0; j < booths.length; j++) { //looping array
            //only if the element does not contain any value(==null), it gets shown here
            if (booths[j].getCustomerName() == null)
                System.out.println("Booth " + j + " is empty");
        }
    }

    public void addPatient() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name: ");
        customerName = input.next();//getting patient's name
        System.out.println(customerName + " has been added to Booth " + boothNum);
        patientCount = patientCount + 1;//adding number of served patients
        vaccineStock = vaccineStock - 1;//reducing number of vaccines
        if (vaccineStock == 20) {
            System.out.println("The vaccine stock has reached 20. Please refill the stock.");
        }
    }

    public void removePatient() {
        System.out.println("You have removed " + customerName + " from Booth " + boothNum);
        customerName = null;//setting that booth to null

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

    public void remVaccines() {
        System.out.println("The number of remaining vaccines are: " + vaccineStock);
    }

    public void addVaccines() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of added vaccines: ");
        int newVaccines = input.nextInt();//user input for the number of vaccines to be added
        vaccineStock = vaccineStock + newVaccines;//adding vaccineStock by the newVaccines
        System.out.println("The updated vaccine stock is: " + vaccineStock);
    }

    public void exitProgram() {
        System.out.println("Thank you for using our services");
        System.exit(0);
    }

    public static void storeData(Booth[] booths) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("VaccinationDetails.txt"));//creating file
            for (int i = 0; i < booths.length; i++) {
                writer.write("\n" + booths[i].customerName +" "+ booths[i].boothNum+" " + booths[i].vaccineStock);//entering the values of array to file
            }
            writer.close();//closing file
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Data stored into a text file called VaccinationDetails.txt");
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

    //Getters and Setters

    public int getBoothNum() {
        return boothNum;
    }

    public void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
}

