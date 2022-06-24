package app.domain.model.data.vaccine;


import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class VaccineTypeTest {


    @Test

    public void testConstructionThrows() throws Exception {

        // test when code is blank
        assertThrows(IllegalArgumentException.class,() -> {
            new VaccineType("","test",4);
        });

        //test when code doesn't have 5 chars
        assertThrows(IllegalArgumentException.class,() -> {
            new VaccineType("af","test",4);
        });

        //test when code doesn't have 5 alphanumeric chars
        assertThrows(IllegalArgumentException.class,() -> {
            new VaccineType("af23-","test",4);
        });

        //test when the description can't be larger than 30 chars
        assertThrows(IllegalArgumentException.class,() -> {
            new VaccineType("AF23T","Hello today we are going to test the description to see if it fails, if so an exception will be catched",4);
        });

        //test when the technology number is smaller than 1
        assertThrows(IllegalArgumentException.class,() -> {
            new VaccineType("AF23T","Covid-19 vaccine",0);
        });

        //test when the technology number is bigger than 6
        assertThrows(IllegalArgumentException.class,() -> {
            new VaccineType("AF23T","Covid-19 vaccine",7);
        });


    }

    @Test

    public void testGetsAndSet(){

        VaccineType type = new VaccineType("AF23P","Covid-19 vaccine",3);

        //test the getTypeCode
        assertEquals("AF23P",type.getTypeCode());
        //test the setShortDescription with a description bigger than 30 chars
        assertThrows(IllegalArgumentException.class,() -> {
            type.setShortDescription("Hello today we are going to test the description to see if it fails, if so an exception will be catched");
        });
        //test the setShortDescription with a regular description
        type.setShortDescription("MonkeyPox vaccine");
        //test the getShortDescription
        assertEquals("MonkeyPox vaccine",type.getShortDescription());
        //test the getTechnology
        assertEquals("Subunit vaccine",type.getTechnology());
    }

    @Test

    public void testEquals(){

        VaccineType type = new VaccineType("AF23P","Covid-19 vaccine",3);
        VaccineType type2 = new VaccineType("AF23P","Covid-19 vaccine",3);

        VaccineType typeCopy = type;
        String typeString = "Vaccine type";

        //test equals with objects that have the same reference
        assertEquals(type,typeCopy);
        //test equals with a null object
        assertNotEquals(type,null);
        //test equals with objects that have different classes
        assertNotEquals(type,typeString);
        //test equals with objects that have the same concept (type code)
        assertEquals(type,type2);

    }

    @Test

    public void testHashCode (){

        VaccineType type = new VaccineType("AF23P","Covid-19 vaccine",3);

        assertEquals(Objects.hash(type.getTypeCode(),type.getShortDescription(),type.getTechnology()),type.hashCode());
    }

    @Test

    public void testToString (){

        VaccineType type = new VaccineType("AF23P","Covid-19 vaccine",3);

        assertEquals("VaccineType: \n" +
                "Code: AF23P\n" +
                "Description: Covid-19 vaccine\n" +
                "Technology: Subunit vaccine" + "\n",type.toString());
    }


}