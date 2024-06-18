package org.example.creational.builder;

public class RunAppBuilder {

  public static void main(String[] args) {
// Create diffrent object with Builder used once
    Director director = new Director();

    // Create car object with builder steps step  by step
    IBuilder carBuilder = new Car("BMW");
    director.build(carBuilder);

    //return car as ready object to use as Product in my project
    Product car = carBuilder.getVehicle();
    System.out.println(car.show());


    // Create motoCycle object with builder steps step  by step
    IBuilder motoCycleBuilder =  new  MotorCycle("Honda");
    director.build(motoCycleBuilder);


    //return motoCycle as ready object to use as Product in my project

    Product motoCycle = motoCycleBuilder.getVehicle();
    System.out.println(motoCycle.show());
  }
}
