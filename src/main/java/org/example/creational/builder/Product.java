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
    result.append("Product components are: \n");

    for (String part : parts) {
      result.append(part).append("\n");
    }

    return result.toString();
  }
}
