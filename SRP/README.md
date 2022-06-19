# Single Responsibility Principle

## Intent/Definition
The single responsibility principle states that every Java class must perform a single functionality. Implementation of multiple functionalities in a single class mashup the code and if any modification is required may affect the whole class. It precise the code and the code can be easily maintained. Let's understand the single responsibility principle through an example.

Suppose, Student is a class having three methods namely printDetails(), calculatePercentage(), and addStudent(). Hence, the Student class has three responsibilities to print the details of students, calculate percentages, and database. By using the single responsibility principle, we can separate these functionalities into three separate classes to fulfill the goal of the principle.

Student.java
```java
public class Student {
    public void printDetails() {
    //functionality of the method
    }

    public void calculatePercentage() {
        //functionality of the method
    }

    public void addStudent() {
        //functionality of the method
    }
}
```
The above code snippet violates the single responsibility principle. To achieve the goal of the principle, we should implement a separate class that performs a single functionality only.

Student.java
```java
public class Student {
    public void addStudent() {
        //functionality of the method
    }
}
```
PrintStudentDetails.java
```java
public class PrintStudentDetails {
    public void printDetails() {
        //functionality of the method  
    }
}  
```
Percentage.java
```java
public class Percentage {
    public void calculatePercentage() {
        //functionality of the method  
    }
} 
```

Hence, we have achieved the goal of the single responsibility principle by separating the functionality into three separate classes.

### Benefits
#### Easy to understand and maintain 

When the class only does “one thing”, its interface usually has smaller number of methods (and member variables) that are fairly self explanatory. It makes the code easier to read and understand.


When there is a need to change the application behavior, changes related to the class’s responsibility are fairly isolated. It reduces the chance of breaking other unrelated areas of the software. It makes the code easier to maintain.

#### Improved usability
If a class has multiple responsibilities and it is required to be used in other parts of the application for using a certain responsibility, it may adversely expose other responsibilities which may not be desired. It can lead to undesired behavior in the application e.g. security and data privacy issues.

If the class follows the SRP principle strictly then unnecessary functionality will not be exposed and it makes the class to be more usable without fearing adverse effects.

### Conclusion
The single responsibility principle design pattern has a hugely positive impact on the adaptability of code. Compared to equivalent code that does not adhere to the principle, SRP-compliant code leads to a greater number of classes that are smaller and more directed in scope.

The SRP is primarily achieved through abstracting code behind interfaces and delegating responsibility for unrelated functionality to whichever implementation happens to be behind the interface at run time.