package org.example;

public class Main {
    public static void main(String[] args) {
        ApiFacade facade = new ApiFacade();
        try {
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );
            System.out.println("Joke: " + joke);
            String rates = facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "rates"
            );
            String base =  facade.getAttributeValueFromJson(
                    "https://api.fxratesapi.com/latest",
                    "base"
            );


            System.out.println("Rates for " + base + ":" + rates );
        } catch (IllegalArgumentException iae) {
            System.err.println("Attribute missing: " + iae.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}