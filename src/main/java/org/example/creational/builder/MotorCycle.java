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
    product.addPart("Operation to build motor cycle  started: 😊");
  }

  @Override
  public void buildBody() {
    product.addPart("Body is  added");
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
    product.addPart(
        "End operation of Creating Motor Cycle with  new brand name: " + this.brandName);
  }

  @Override
  public Product getVehicle() {
    return product;
  }
}
