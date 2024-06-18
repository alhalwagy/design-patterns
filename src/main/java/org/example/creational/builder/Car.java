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

    product.addPart("wheels of car is added");

  }

  @Override
  public void addHeadLights() {

    product.addPart("head lights of car is added");

  }

  @Override
  public void endOperation() {
    product.addPart("Car is already added with all parts you can use  it.") ;
  }

  @Override
  public Product getVehicle() {
    return product;
  }

}
