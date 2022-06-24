# Supplementary Specification (FURPS+)

## **Functionality**
* This application is going to give the possibility to manage massive vaccination of the population during a pandemic situation. It will be also be able to fulfill the requirements in order to be comercialized to future companies, organizations or healthcare systems and not only DGS.


### **1.Licensing**
* The user should have Java installed in order to run the application.

### **2.Localization**
* The application support the Portuguese and English languages.

### **3.Email**
* If the user authorize, the application will send an e-mail or SMS when the vaccination event is scheduled and registered in the system and when the recovery period ends.

### **4.Help**
* The application will be handed to the user with an user manual.

### **5.Printing**
* The application prints diverse information related to the users to the user and employees of the company

### **6.Security**
* The application will have different access to the data. All the users and employees that wish to access the application must be authenticated with a password.
The application will also restrict the user's health data to the nurses.

### **7.System management**
* The system will be managed by an administrator. This administrator will configure all the core information and create information related to employees, users and vaccination centers.

### **8.Workflow**
* The application will update the status of the user during the vaccine application.

### **9.Improvement**
* The application will have a performance analysis in order to decrease the number of clients in the center from the moment they register at the arrival, until the moment they receive the SMS informing they can leave the vaccination center

### **10.Accessibility**
* The application will give an easy and accesible use to which one that pretends to schedule the application of a vaccine


## **Usability** 

### **1.User Interface**
* The user interface will be developed with the help of JavaFx 11 and will support the hole application allowing the user to easily schedule his/her vaccine supporting a Portuguese or English layout.

## **Reliability**

### **1.Data persistance**
* The application use object serialization to ensure data persistence between two runs 


## **Performance**



## **Supportability**
* To all the metods that haven't input/output operations the application will have implemented unit tests with the JUnit 5 framework.

## +

## Design Constraints
* In the process for the system design, the team responsible shall adopt the Unified Process for identifying requirements and for OO software analysis and design, adopt recognize coding standards and use Javadoc to generate a useful documentation for Java code.

## Implementation Constraints
* In the application the team must use JAVA technologies solution using the Intellij IDE or Netbeans. The graphical user interface must be developed in JavaFX 11 and JaCoCo to test the application.

## Interface Constraints
* The interface must be implemented using JavaFx 11

