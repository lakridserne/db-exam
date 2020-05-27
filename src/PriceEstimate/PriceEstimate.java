package PriceEstimate;
import redis.clients.jedis.Jedis;

import java.sql.Date;
import java.time.LocalDateTime;

public class PriceEstimate {

    private  int _price;

    public int get_price() {
        return _price;
    }

    public void set_price(int _price) {
        this._price = _price;
    }

    public String get_address_id() {
        return _address_id;
    }

    public void set_address_id(String _address_id) {
        this._address_id = _address_id;
    }

    public LocalDateTime get_date() {
        return _date;
    }

    public void set_date(LocalDateTime _date) {
        this._date = _date;
    }

    public int get_sqm() {
        return _sqm;
    }

    public void set_sqm(int _sqm) {
        this._sqm = _sqm;
    }

    private String _address_id;
    private LocalDateTime _date;
    private int _sqm;


    public static void main(String[] args) {


        //Connecting to Redis server on localhost
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());
    }
}
