package com.mycompagny.app;

public class Orange {
  public double price;
  public String origin;

  protected double price;
  protected String origin;

  public double getPrice(){
    return this.price;
  }
  public String getOrigin(){
    return this.origin;
  }

  public void setPrice(double newPrice) {
    if(newPrice < 0){
      System.out.println("Error, set a positive price!");
      System.exit(-1);
    }
    this.price = newPrice;
  }

  public static void main(String[] args){
    Orange orange = new Orange();
    orange.setPrice(-5);
  }
}