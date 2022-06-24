package app.domain.shared;

public enum CenterAssociations {

    ARS ("Administração Regional de Saúde"),
    AGES ("Agrupamentos de Centros de Saúde");

    private final String association ;

    CenterAssociations(String s){
        this.association = s;
    }

    public static String getAssociation(int i){

        switch (i){

            case 1:
                return ARS.association;
            case 2:
                return AGES.association;

        }
        return null;
    }

    public static int getIndex(String s){

        switch (s){
            case "Administração Regional de Saúde" :
                return 1;
            case "Agrupamentos de Centros de Saúde":
                return 2;
        }

        return 0;
    }


}
