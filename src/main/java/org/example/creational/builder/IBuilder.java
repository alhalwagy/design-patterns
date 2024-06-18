package org.example.creational.builder;

public interface IBuilder {

    void startUpOperation();

    void buildBody();

    void insertWheels();

    void addHeadLights();

    void endOperation();

    Product getVehicle();

}
