package app.domain.model.dto.utils;
/**
 * Class to represent a hour as a dto
 *
 * @author Miguel Ferreira <1211488@isep.ipp.pt>
 */
public class HourDto {
    private final int horas;
    private final int minutos;
    private final int segundos;

    /**
     * Constructor of the dto
     * @param horas hours of the time
     * @param minutos minutes of the time
     * @param segundos seconds of the time
     */

    public HourDto(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }
    /**
     * Method to get the hours
     * @return hours
     */
    public int getHoras() {
        return horas;
    }
    /**
     * Method to get the minutes
     * @return minutes
     */
    public int getMinutos() {
        return minutos;
    }
    /**
     * Method to get the seconds
     * @return seconds
     */
    public int getSegundos() {
        return segundos;
    }

    @Override
    public String toString() {
        return "HourDto{" +
                "horas=" + horas +
                ", minutos=" + minutos +
                ", segundos=" + segundos +
                '}';
    }
}
