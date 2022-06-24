package app.domain.model.data.employees;

import pt.isep.lei.esoft.auth.domain.model.Email;

import java.util.Objects;

public class Employee{

    /**
     * Class that represents the company employees
     *
     * @author Pedro Campos <1211511@isep.ipp.pt>
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */

    private static int id = 0;

    private int employeeID;
    private String role;
    private String name;
    private int phoneNumber;
    private String email;
    private int citizenCardNumber;
    private String address;

    /**
     * Constructor of Employee class
     * @param email E-mail of the employee
     * @param name Name of the employee
     * @param role role of the employee
     * @param citizenCardNumber number of citizenship of employee
     * @param phoneNumber phone number of an employee
     */
    public Employee(String email, String name, String role, int phoneNumber, int citizenCardNumber, String address) {
        validateInformation(role, name,phoneNumber,email,citizenCardNumber,address);
        this.email = email;
        this.name = name;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.employeeID = id;
        id++;
        this.address = address;
    }

    /**
     * Method to verify the parameters inputted in the constructor
     * @param email E-mail of the employee
     * @param name Name of the employee
     * @param role role of the employee
     * @param citizenCardNumber number of citizenship of employee
     * @param phoneNumber phone number of an employee
     */
    private void validateInformation (String role, String name, int phoneNumber, String email,int citizenCardNumber,String address){

        if (!Objects.equals(role, "NURSE") && !Objects.equals(role, "COORDINATOR") && !Objects.equals(role, "RECEPTIONIST")){
            throw new IllegalArgumentException("Illegal Role");
        }

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name can't be blank");
        }

        if(address == null || address.isBlank()){
            throw new IllegalArgumentException("Address can't be blank");
        }

        if(phoneNumber < 0){
            throw new IllegalArgumentException("Phone Number can't be less than 0");
        }

        try{
            new Email(email);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid e-mail type");
        }

        if(citizenCardNumber < 0){
            throw new IllegalArgumentException("Citizen card Number can't be less than 0");
        }

    }
    /**
     * Method to get the email name
     *
     * @return employee email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Method to get the employee name
     *
     * @return employee name
     */
    public String getName() {
        return name;
    }

    /**
     * Method to get the employee role
     *
     * @return employee role
     */
    public String getRole() {
        return role;
    }

    /**
     * Method to get the employee phone number
     *
     * @return employee phone number
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Method to get the employee citizen card number
     *
     * @return employee citizen card number
     */
    public int getCitizenCardNumber() {
        return citizenCardNumber;
    }

    /**
     * Method to get the employee ID number
     *
     * @return employee ID number
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Method to get the employee address
     *
     * @return employee ID number
     */
    public String getAddress() {
        return address;
    }

    /**
     * Method to set the employee address
     *
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Method to set the employee ID number
     *
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Method to set the employee role
     *
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Method to set the employee name
     *
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to set the employee phone number
     *
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Method to set the employee email
     *
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to set the employee citizen card number
     *
     */
    public void setCitizenCardNumber(int citizenCardNumber) {
        this.citizenCardNumber = citizenCardNumber;
    }

    /**
     * Method equals for employee class
     * @param o object
     * @return boolean of equality or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.employeeID == employee.employeeID;
    }

    /**
     * Method to obtain the hascode of an object from the class employee
     * @return employee hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(role, name, phoneNumber, email, citizenCardNumber,address);
    }

    /**
     * Method to string the object from the employee class
     *
     * @return empployee string
     */
    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", citizenCardNumber=" + citizenCardNumber +
                '}';
    }
}




