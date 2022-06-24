package app.domain.utils;


/**
 * Class to represent the notifications that the system can send to the users
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class Notification {

    private final String address;
    private final String message;

    /**
     * Constructor of the notification class
     *
     * @param address address to which the notification will be sent
     * @param message message of the notification
     */
    public Notification(String address, String message) {
        this.address = address;
        this.message = message;
    }

    /**
     * Get method to obtain the address to which the notification will be sent
     * @return address to which the notification will be sent
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get method to obtain the message of the notification
     * @return message of the notification
     */
    public String getMessage() {
        return message;
    }


}
