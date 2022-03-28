import java.util.Scanner;

public class Patient extends Booth{
    private String lastName;
    private int patientAge;
    private String patientCity;
    private long patientId;

    public Patient() {
    }//default constructor


    public Patient(int boothnum, int vaccineStock, String lastName, int patientAge, String patientCity, long patientId){
        super (0, 25);
        this.lastName = lastName;
        this.patientAge = patientAge;
        this.patientCity = patientCity;
        this.patientId = patientId;
    }

    Scanner input = new Scanner(System.in);


    public void asklastname(){
        System.out.println("Enter last name: ");
        lastName= input.next();
    }

    public void askage(){
        System.out.println("Enter your age: ");
        patientAge= input.nextInt();
    }

    public void askcity(){
        System.out.println("Enter your city: ");
        patientCity = input.next();
    }

    public void askid(){
        System.out.println("Enter your NIC number or Passport number: ");
        patientId=input.nextLong();
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public int getPatientAge() {
        return patientAge;
    }


    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }


    public String getPatientCity() {
        return patientCity;
    }


    public void setPatientCity(String patientCity) {
        this.patientCity = patientCity;
    }


    public long getPatientId() {
        return patientId;
    }


    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }
}
