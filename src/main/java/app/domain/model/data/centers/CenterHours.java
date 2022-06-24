package app.domain.model.data.centers;

import app.domain.utils.Hour;

import java.util.Objects;

/**
 * Class to represent the opening and closing hours of a given vaccination center
 *
 * @author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public class CenterHours {

    private final Hour openingHour;
    private final Hour closingHour;

    /**
     * Constructor of the class
     *
     * @param openingHour opening hour of the vaccination center
     * @param closingHour closing hour of the vaccination center
     */

    public CenterHours(Hour openingHour, Hour closingHour) {
        this.openingHour = openingHour;
        this.closingHour = closingHour;
    }

    /**
     * Get method to obtain the opening hours of the vaccination center
     * @return opening hours of the vaccination center
     */
    public Hour getOpeningHour() {
        return openingHour;
    }

    /**
     * Get method to obtain the closing hours of the vaccination center
     * @return closing hours of the vaccination center
     */
    public Hour getClosingHour() {
        return closingHour;
    }

    /**
     * Equals method
     * @param o object to compare
     * @return equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CenterHours hours = (CenterHours) o;
        return Objects.equals(openingHour, hours.openingHour) && Objects.equals(closingHour, hours.closingHour);
    }

    /**
     * HashCode method
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(openingHour, closingHour);
    }

    /**
     * Method to represent the class as a string
     * @return class as a string
     */
    @Override
    public String toString() {
        return "CenterHours:\n" +
                "Opening Hour: " + openingHour + "\n" +
                "Closing Hour: " + closingHour + "\n";
    }

}
