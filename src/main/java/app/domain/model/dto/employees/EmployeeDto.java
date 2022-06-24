package app.domain.model.dto.employees;

/**
 * Class to carry all the information of a certain Employee
 *
 * @author Pedro Campos <1211511@isep.ipp.pt>
 * @author Nuno Cunha <1211689@isep.ipp.pt>
 */

public class EmployeeDto {

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
     * @param address address of the employee
     */
    public EmployeeDto(String email, String name, String role, int phoneNumber, int citizenCardNumber, String address) {
        this.email = email;
        this.name = name;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.citizenCardNumber = citizenCardNumber;
        this.address = address;
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
     * Method to get the employee address
     *
     * @return employee citizen address
     */
    public String getAddress() {
        return address;
    }
}
