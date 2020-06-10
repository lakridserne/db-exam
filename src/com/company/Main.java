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
        String address = "";
        boolean correctAddress = false;
        if(etage == null) {
            correctAddress = dw.getDawaDataRecords(vejnavn, husNummer, postNummer, postNummerNavn);
        } else {
            correctAddress = dw.getDawaDataRecords(vejnavn, husNummer, etage, husNummer, postNummer, postNummerNavn);
        }
        if (correctAddress == true){
            if(etage == null) {
                address = vejnavn + " " + husNummer;
            } else {
                address = vejnavn + " " + husNummer + ", " + etage + ", " + door;
            }
            String zipcode = postNummer + " " + postNummerNavn;
            String fullAddress = address + ", " + zipcode;
            System.out.println(fullAddress);
        }
    }
}
