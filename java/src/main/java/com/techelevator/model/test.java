package com.techelevator.model;

public class test {

    // Test comment
    // print out a string of letters
    public static void main(String[] args) {
        String str = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(str);
    }

    // get a list of zip codes in michigan
    // and print out the first 5
    public static void main2(String[] args) {
        String[] zipCodes = {"49503", "49501", "49502", "49505", "49506"};
        for (int i = 0; i < 5; i++) {
            System.out.println(zipCodes[i]);
        }
    }

    // connect to weather api and print out the current temperature
    public static void main3(String[] args) {
        String apiKey = "";
        String zipCode = "49503";
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + ",us&appid=" + apiKey;
        String json = "";
        String temp = "";
        System.out.println(temp);
    }

    // connect to a beer api and print out the name of the first beer
    public static void main4(String[] args) {
        String apiKey = "";
        String url = "https://api.punkapi.com/v2/beers?page=1&per_page=1";
        String json = "";
        String beerName = "";
        System.out.println(beerName);
    }

    // connect to a brewery api and find breweries in the state of michigan
    // sort by distance from the user
    // print out the name of the first 5
    // store in postgres database
    public static void main5(String[] args) {
        String apiKey = "";
        String url = "https://api.openbrewerydb.org/breweries?by_state=mi&sort=distance&per_page=5";
        String json = "";
        String breweryName = "";
        System.out.println(breweryName);
    }


}
