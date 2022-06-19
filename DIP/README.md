#  Dependency Inversion Principle in Java with Example

## Intent/Definition

Robert C. Martin defines DI as follows:

>  High-level modules should not depend on low-level modules. Both should depend on abstractions.

>  Abstractions should not depend upon details. Details should depend on abstractions.


## High and Low-level modules:
To fully understand the dependency inversion principle, we should first understand the concept of high and low-level modules.

A software module is a coding unit that contains one or more routines. Regularly a module has just one responsibility in the whole system. You build a system using multiple modules, which can be grouped in different layers. Let's have a graphic example of this:

![1](https://user-images.githubusercontent.com/7686353/174494413-74cbe6cc-e7a1-42c8-a6fb-00d5b5102c5a.jpeg)


In this example, there are five different modules, we have the Calculator module, as well as the Add, Subtract, Multiply and Divide module.

When we talk about high-level modules, we're talking about modules that are directly used or instantiated by the presentation layer. In our example, there is just one high-level module which is the Calculator class. Low-level modules, on the other hand, help the high-level modules to accomplish their work, typically we refer to these modules as dependencies. In our example, the low-level modules are the Add, Subtract, Multiply, and Divide classes.


## Dependencies and Coupling
As mentioned in the previous paragraph, dependencies are established when a module uses another module to complete its work. For instance, the Calculator module needs the Add module to achieve its goal, so a dependency is established.

Coupling is the degree of interdependence between two modules, it's a measure of how closely connected they are. When this connection is strong and we cannot change one part of the dependency without affecting the other part, we say there is a tight coupling. On the other hand, if we can change one part of the dependency without affecting the other part, we say there is a loose coupling.

We should always avoid tight coupling because it violates the Open/Closed Principle by not allowing to modify one side of the dependency without affecting the other one.


## Applying The Dependency Inversion Principle
There is one fundamental flaw with the Calculator System design, there is a tight coupling between Calculator and the rest of the low-level modules. We cannot modify any of the operation modules without modifying the Calculator module. Additionally, if we want to add another operation, square root, for example, we also have to modify the Calculator class which violates the Open/Closed Principle. So, how do we fix this design issue? Easy, applying the Dependency Inversion Principle.

The first segment of our principle says "High-level modules should not depend on low-level modules. Both should depend on abstractions". In our current design, the Calculator module depends on the Add, Subtract, Divide and Multiply module. To comply with the DI, we must define an abstraction named "CalculatorOperation". Both, high and low-level modules will depend on this abstraction.

The second segment of the DIP principle says "Abstractions should not depend upon on details. Details should depend on abstractions". To accomplish this rule, we must define the abstraction as an interface (abstraction), not as a class (detail).

![2](https://user-images.githubusercontent.com/7686353/174494422-6615d8dd-5748-49b9-9cfe-0aafee4a83d6.jpeg)


Now there is loose coupling between the Calculator module and the Operations modules. Now you can change one side of the dependency without affecting the other side. You can also add more operations, as long as they implement the Operation abstraction, without affecting the Calculator module.

## Coding example
### Bad Design
Each calculator operation is represented as a low-level module:

```java
public class AddOperation {

    /**
     * Adds two numbers.
     * @param numA          First number.
     * @param numB          Second number.
     * @return              Result.
     */
    public double add(double numA, double numB){
        return numA + numB;
    }
}

public class SubtractOperation {

    /**
     * Subtracts two numbers.
     * @param numA          First number.
     * @param numB          Second number.
     * @return              Result.
     */
    public double subtract(double numA, double numB){
        return numA - numB;
    }
}

public class MultiplyOperation {

    /**
     * Multiplies two numbers.
     * @param numA          First number.
     * @param numB          Second number.
     * @return              Result.
     */
    public double multiply(double numA, double numB){
        return numA * numB;
    }
}

public class DivideOperation {

    /**
     * Divides two numbers.
     * @param numA          First number.
     * @param numB          Second number.
     * @return              Result.
     */
    public double divide(double numA, double numB){
        return numA / numB;
    }

}
```
The violation of the Dependency Inversion Principle is noticeable in the Calculator class. If we want to add a new calculator operation, we must modify the Calculator class, which violates the Open/Closed principle.

```java
public class Calculator {

    public enum Operation{
        ADD, SUBTRACT, MULTIPLY, DIVIDE
    }


    /**
     * Performs a two numbers operation.
     * @param numA              First number.
     * @param numB              Second number.
     * @param operation         Type of operation.
     * @return                  Operation's result.
     */
    public double calculate(double numA, double numB, Operation operation){

        double result = 0;

        switch(operation){

            case ADD:
                AddOperation addOp = new AddOperation();
                result = addOp.add(numA, numB);
                break;
            case SUBTRACT:
                SubtractOperation subOp = new SubtractOperation();
                result = subOp.subtract(numA, numB);
                break;
            case MULTIPLY:
                MultiplyOperation multOp = new MultiplyOperation();
                result = multOp.multiply(numA, numB);
                break;
            case DIVIDE:
                DivideOperation divOp = new DivideOperation();
                result = divOp.divide(numA, numB);
                break;

        }

        return result;

    }
}
```
To solve this issue and comply with the DIP and OCP, we must add an abstraction and modify the dependencies, so both, high and low-level modules depend on the abstraction.

### Good Design

```java
public interface CalculatorOperation {

    public double calculate(double numbA, double numB);

}

public class AddOperation implements CalculatorOperation {

    @Override
    public double calculate(double numbA, double numB) {
        return numbA + numB;
    }   
}

public class SubtractOperation implements CalculatorOperation {

    @Override
    public double calculate(double numbA, double numB) {
        return numbA - numB;
    }
}

public class MultiplyOperation implements CalculatorOperation {

    @Override
    public double calculate(double numbA, double numB) {
        return numbA * numB;
    }  
}

public class DivideOperation implements CalculatorOperation {

    @Override
    public double calculate(double numbA, double numB) {
        return numbA / numB;
    }
}
```
Now the Calculator class complies with the Dependency Inversion Principle.

```java
public class Calculator {

    /**
     * Performs a two numbers operation.
     * @param numA              First number.
     * @param numB              Second number.
     * @param operation         Type of operation.
     * @return                  Operation's result.
     */
    public double calculate(double numA, double numB, CalculatorOperation operation){
        return operation.calculate(numB, numB);
    }
}
```

### Final thoughts
We've gone through the five SOLID principles, you've seen the benefits and disadvantages of each one. Remember that SOLID principles were thought to help you achieve flexibility, readability, and reusability. Some of these principles are the cornerstone of multiple frameworks and architectures and you will benefit from implementing them. But, also remember that excessive or incorrect use of these principles will overcomplicate your code. You must evaluate each use case and decide which is best for your solution.