package app.domain.model.data.employees;

import java.util.Objects;

public class Coordinator extends Employee{

    private String vaccinationCenter;

    /**
     * Constructor of Employee class
     *
     * @param email             E-mail of the employee
     * @param name              Name of the employee
     * @param role              role of the employee
     * @param phoneNumber       phone number of an employee
     * @param citizenCardNumber number of citizenship of employee
     * @param address
     */
    public Coordinator(String email, String name, String role, int phoneNumber, int citizenCardNumber, String address, String vaccinationCenter) {
        super(email, name, role, phoneNumber, citizenCardNumber, address);
        this.vaccinationCenter = vaccinationCenter;
    }

    public Coordinator(String email, String name, String role, int phoneNumber, int citizenCardNumber, String address) {
        super(email, name, role, phoneNumber, citizenCardNumber, address);
    }

    public String getVaccinationCenter() {
        return vaccinationCenter;
    }

    public void setVaccinationCenter(String vaccinationCenter) {
        this.vaccinationCenter = vaccinationCenter;
    }


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), vaccinationCenter);
    }

    @Override
    public String toString() {
        return "Coordinator\n" +
                "Id: " + this.getEmployeeID() + "\n" +
                "Name: " + this.getName() + "\n" +
                "Address: " + this.getAddress() + "\n" +
                "Phone Number: " + this.getPhoneNumber() + "\n" +
                "Email: " + this.getEmail() + "\n" +
                "Citizen Number: " + this.getCitizenCardNumber() + "\n" +
                "Manages: " + this.getVaccinationCenter() + "\n";
    }
}
