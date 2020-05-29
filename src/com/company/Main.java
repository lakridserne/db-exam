package com.company;

import DawaData.DawaData;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
        String vejnavn = "Mellem Broerne";
        String husNummer = "2";
        String etage = null;
        String door = null;
        Integer postNummer = 4100;
        String postNummerNavn = "Ringsted";
        DawaData dw = new DawaData();
        boolean correctAddress = dw.getDawaDataRecords(vejnavn, husNummer, postNummer, postNummerNavn);
        if (correctAddress == true){
            if(etage == null) {
                String address = vejnavn + " " + husNummer;
            } else {
                String address = vejnavn + " " + husNummer + ", " + etage + ", " + door;
            }
            String zipcode = postNummer + " " + postNummerNavn;
        }
    }
}
