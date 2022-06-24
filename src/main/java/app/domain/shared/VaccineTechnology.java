package app.domain.shared;

/**
 * Class with Vaccine Technology
 *
 * author Nuno Cunha <1211689@isep.ipp.pt>
 * author Diogo Teixeira <1200904@isep.ipp.pt>
 */
public enum VaccineTechnology {
    LAV ("Live-attenuated vaccine"),
    IV ("Inactivated vaccine"),
    SV ("Subunit vaccine"),
    TV ("Toxoid vaccine"),
    VVV ("Viral vector vaccine"),
    MRV ("Messenger RNA (mRNA) vaccine")
    ;

    private final String technology;

    /**
     * Constructor of the class to build a new technology
     * @param s
     *
     * @author Diogo Teixeira <1200904@isep.ipp.pt>
     */
    VaccineTechnology(String s) {
        this.technology = s;
    }

    /**
     * Method to get the vaccine technology string
     *
     * @param i
     * @return String with  the technology
     *
     * @author Diogo Teixeira <1200904@isep.ipp.pt>
     */
    public static String getTechnology (int i){

        switch (i){

            case 1:
                return LAV.technology;
            case 2 :
                return IV.technology;
            case 3:
                return SV.technology;
            case 4:
                return TV.technology;
            case 5:
                return VVV.technology;
            case 6:
                return MRV.technology;
        }

        return null;
    }

    /**
     * Method to get the vaccine technology respective integer
     * @param s
     * @return integer correspondent to the String of the vaccine technology
     *
     * @author Nuno Cunha <1211689@isep.ipp.pt>
     */
    public static int getIndex (String s){
        switch (s){

            case "Live-attenuated vaccine":
                return 1;
            case "Inactivated vaccine":
                return 2;
            case "Subunit vaccine":
                return 3;
            case "Toxoid vaccine":
                return 4;
            case "Viral vector vaccine":
                return 5;
            case "Messenger RNA (mRNA) vaccine":
                return 6;
        }
        return 0;
    }
}
