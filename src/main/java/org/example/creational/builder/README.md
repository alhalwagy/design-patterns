# Builder Pattern

The Builder Pattern is a creational design pattern that separates the construction of a complex object from its representation, allowing the same construction process to create different representations. It is useful when there could be multiple ways to construct complex objects or when you want to build objects step by step.

## Example

Imagine you have a complex object like a `Product` that requires a series of steps to construct, such as adding components and setting configurations. Instead of constructing `Product` directly, the Builder Pattern uses a separate builder class (`Builder`) to manage these steps.

### Components

1. **Product**: Represents the complex object being constructed.
2. **Builder**: Abstracts the construction process and provides methods for adding parts to the product.
3. **Concrete Builders**: Implement the `Builder` interface to define the specific steps and logic for constructing different representations of the product.
4. **Director**: Manages the building process, orchestrating the steps defined by the `Builder`.

### Benefits

- **Separation of Concerns**: Builder separates the construction and representation of an object.
- **Flexibility**: Allows different representations of the same complex object to be created using the same building process.
- **Simplifies Complex Object Creation**: Especially useful when an object requires multiple steps or configurations to be set.

## UML Diagram

![Builder Pattern UML Diagram](https://www.pentalog.com/wp-content/uploads/2023/02/abstract-patterns.png)


## Usage

To use the Builder Pattern:
1. Define a `Product` class that represents the complex object.
2. Create a `Builder` interface or abstract class with methods for building the `Product`.
3. Implement concrete builders (`ConcreteBuilder`) that implement the `Builder` interface and define the construction steps for specific representations of the `Product`.
4. Optionally, use a `Director` class to orchestrate the construction process using a builder.

## Example Code

### `RunAppBuilder.java`

This is the main class that demonstrates the use of the Builder Pattern. It creates instances of `Car` and `MotorCycle` using the builder steps defined in their respective classes.

```java
package org.example.creational.builder;

public class RunAppBuilder {

  public static void main(String[] args) {
    // Create different objects with Builder used once
    Director director = new Director();

    // Create car object with builder steps step by step
    IBuilder carBuilder = new Car("BMW");
    director.build(carBuilder);

    // Return car as ready object to use as Product in my project
    Product car = carBuilder.getVehicle();
    System.out.println(car.show());

    // Create motorcycle object with builder steps step by step
    IBuilder motoCycleBuilder = new MotorCycle("Honda");
    director.build(motoCycleBuilder);

    // Return motorcycle as ready object to use as Product in my project
    Product motoCycle = motoCycleBuilder.getVehicle();
    System.out.println(motoCycle.show());
  }
}
```

### `Car.java`
This class implements the `IBuilder` interface and defines the steps to build a car.
```java
package org.example.creational.builder;

public class Car implements IBuilder {

  private String brandName;
  private Product product;

  public Car(String brandName) {
    product = new Product();
    this.brandName = brandName;
  }

  @Override
  public void startUpOperation() {
    product.addPart("Car Model Name is " + brandName);
  }

  @Override
  public void buildBody() {
    product.addPart("Body of car is added");
  }

  @Override
  public void insertWheels() {
    product.addPart("Wheels of car are added");
  }

  @Override
  public void addHeadLights() {
    product.addPart("Head lights of car are added");
  }

  @Override
  public void endOperation() {
    product.addPart("Car is already added with all parts. You can use it.");
  }

  @Override
  public Product getVehicle() {
    return product;
  }
}
```

### `Director.java`
This class directs the building process using a builder.


```java
package org.example.creational.builder;

public class Director {
    IBuilder builder;

    public void build(IBuilder builder) {
        this.builder = builder;
        builder.startUpOperation();
        builder.buildBody();
        builder.insertWheels();
        builder.addHeadLights();
        builder.endOperation();
    }
}
```
### `IBuilder.java`
This interface defines the steps for building a product.


```java
package org.example.creational.builder;

public interface IBuilder {

    void startUpOperation();
    void buildBody();
    void insertWheels();
    void addHeadLights();
    void endOperation();
    Product getVehicle();
}
```

### `MotorCycle.java`
This class implements the `IBuilder` interface and defines the steps to build a motorcycle.

```java
package org.example.creational.builder;

public class MotorCycle implements IBuilder {

  private String brandName;
  private Product product;

  public MotorCycle(String brand) {
    product = new Product();
    this.brandName = brand;
  }

  @Override
  public void startUpOperation() {
    product.addPart("Operation to build motor cycle started: 😊");
  }

  @Override
  public void buildBody() {
    product.addPart("Body is added");
  }

  @Override
  public void insertWheels() {
    product.addPart("Insert wheels is done");
  }

  @Override
  public void addHeadLights() {
    product.addPart("Add head lights is done");
  }

  @Override
  public void endOperation() {
    product.addPart("End operation of Creating Motor Cycle with new brand name: " + this.brandName);
  }

  @Override
  public Product getVehicle() {
    return product;
  }
}
```
### `Product.java`
This class represents the product being built.

```java
package org.example.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class Product {

  private List<String> parts;

  public Product() {
    parts = new ArrayList<>();
  }

  public void addPart(String part) {
    parts.add(part);
  }

  public String show() {
    StringBuilder result = new StringBuilder();
    result.append("Product components are:\n");

    for (String part : parts) {
      result.append(part).append("\n");
    }

    return result.toString();
  }
}

```







