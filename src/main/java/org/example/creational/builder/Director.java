package org.example.creational.builder;

public class Director {
    IBuilder builder;


    public void build(IBuilder builder){
    this.builder =  builder;

    builder.startUpOperation();
    builder.buildBody();
    builder.insertWheels();
    builder.addHeadLights();
    builder.endOperation();
    }


}
