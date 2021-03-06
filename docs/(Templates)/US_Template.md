# US 10 - Register an employee, as an administratror

## 1. Requirements Engineering

*In this section, it is suggested to capture the requirement description and specifications as provided by the client as well as any further clarification on it. It is also suggested to capture the requirements acceptance criteria and existing dependencies to other requirements. At last, identify the involved input and output data and depicted an Actor-System interaction in order to fulfill the requirement.*


### 1.1. User Story Description
*As an administratror, I want to register an employee*

### 1.2. Customer Specifications and Clarifications 
**From the specification document:**

> - An Administrator is responsible for properly configuring, managing and registing the core information (centers, SNS users, center coordinators, recepcionists and nurses)

**From the customer clarifications**

> - **Question:**
	"Besides a password and a user name, what other (if any) information should the Admin use to register a new employee? Are any of them optional?"

> - **Answer:**
	Every Employee has only one role (Coordinator, Receptionist, Nurse).
	Employee attributes: Id (automatic), Name, address, phone number, e-mail and Citizen Card number.
	All attributes are mandatory.

<br/>

### 1.3. Acceptance Criteria

*Insert here the client acceptance criteria.*

*All the Administrators use the application to register center coordinators, receptionists and nurses.* 

### 1.4. Found out Dependencies

*There are depencies between US10 and the following ones: US9, US11, US12, US13, because all of them use same verification and register method and can only be executed by an administrator.*

### 1.5 Input and Output Data

> - *Input data:*
<br/>
	Role
<br/>
	Name
<br/>
	Address
<br/>
	Phone number
<br/>
	E-mail
<br/>
	Citizen Card number

> - *Output data:*
<br/>
	Message of sucess/failure of the registration


### 1.6. System Sequence Diagram (SSD)

*Insert here a SSD depicting the envisioned Actor-System interactions and throughout which data is inputted and outputted to fulfill the requirement. All interactions must be numbered.*

![US10-SSD](SSD/US_10_SSD.svg)


### 1.7 Other Relevant Remarks

*Use this section to capture other relevant information that is related with this US such as (i) special requirements ; (ii) data and/or technology variations; (iii) how often this US is held.* 


## 2. OO Analysis

### 2.1. Relevant Domain Model Excerpt 
*In this section, it is suggested to present an excerpt of the domain model that is seen as relevant to fulfill this requirement.* 

![USXXX-MD](USXXX-MD.svg)

### 2.2. Other Remarks

*Use this section to capture some aditional notes/remarks that must be taken into consideration into the design activity. In some case, it might be usefull to add other analysis artifacts (e.g. activity or state diagrams).* 



## 3. Design - User Story Realization 

### 3.1. Rationale

**The rationale grounds on the SSD interactions and the identified input/output data.**

| Interaction ID | Question: Which class is responsible for... | Answer      | Justification (with patterns)|
|:-------------  |:--------------------------------------------|:------------|:-----------------------------|
| Step 1  		 |							                   |             |                              |
| Step 2  		 |							                   |             |                              |
| Step 3  		 |							                   |             |                              |
| Step 4  		 |							                   |             |                              |
| Step 5  		 |							                   |             |                              |
| Step 6  		 |							                   |             |                              |              
| Step 7  		 |							                   |             |                              |
| Step 8  		 |							                   |             |                              |
| Step 9  		 |							                   |             |                              |
| Step 10  		 |							 |             |                              |  


### Systematization ##

According to the taken rationale, the conceptual classes promoted to software classes are: 

 * Class1
 * Class2
 * Class3

Other software classes (i.e. Pure Fabrication) identified: 
 * xxxxUI  
 * xxxxController

## 3.2. Sequence Diagram (SD)

*In this section, it is suggested to present an UML dynamic view stating the sequence of domain related software objects' interactions that allows to fulfill the requirement.* 

![USXXX-SD](USXXX-SD.svg)

## 3.3. Class Diagram (CD)

*In this section, it is suggested to present an UML static view representing the main domain related software classes that are involved in fulfilling the requirement as well as and their relations, attributes and methods.*

![USXXX-CD](USXXX-CD.svg)

# 4. Tests 
*In this section, it is suggested to systematize how the tests were designed to allow a correct measurement of requirements fulfilling.* 

**_DO NOT COPY ALL DEVELOPED TESTS HERE_**

**Test 1:** Check that it is not possible to create an instance of the Example class with null values. 

	@Test(expected = IllegalArgumentException.class)
		public void ensureNullIsNotAllowed() {
		Exemplo instance = new Exemplo(null, null);
	}

*It is also recommended to organize this content by subsections.* 

# 5. Construction (Implementation)

*In this section, it is suggested to provide, if necessary, some evidence that the construction/implementation is in accordance with the previously carried out design. Furthermore, it is recommeded to mention/describe the existence of other relevant (e.g. configuration) files and highlight relevant commits.*

*It is also recommended to organize this content by subsections.* 

# 6. Integration and Demo 

*In this section, it is suggested to describe the efforts made to integrate this functionality with the other features of the system.*


# 7. Observations

*In this section, it is suggested to present a critical perspective on the developed work, pointing, for example, to other alternatives and or future related work.*





