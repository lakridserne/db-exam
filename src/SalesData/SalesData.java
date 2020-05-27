package SalesData;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

import java.sql.Date;

public class SalesData {

    private String _address;
    private int __zip_code;
    private double _price;
    private Date _sell_date;
    private  String _sell_type;
    private int _price_per_sqm;
    private  int _no_rooms;
    private String _housing_type;
    private int _size_in_sqm;
    private int _year_of_construction;
    private int _price_change_in_pct;

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public int get__zip_code() {
        return __zip_code;
    }

    public void set__zip_code(int __zip_code) {
        this.__zip_code = __zip_code;
    }

    public double get_price() {
        return _price;
    }

    public void set_price(double _price) {
        this._price = _price;
    }

    public Date get_sell_date() {
        return _sell_date;
    }

    public void set_sell_date(Date _sell_date) {
        this._sell_date = _sell_date;
    }

    public String get_sell_type() {
        return _sell_type;
    }

    public void set_sell_type(String _sell_type) {
        this._sell_type = _sell_type;
    }

    public int get_price_per_sqm() {
        return _price_per_sqm;
    }

    public void set_price_per_sqm(int _price_per_sqm) {
        this._price_per_sqm = _price_per_sqm;
    }

    public int get_no_rooms() {
        return _no_rooms;
    }

    public void set_no_rooms(int _no_rooms) {
        this._no_rooms = _no_rooms;
    }

    public String get_housing_type() {
        return _housing_type;
    }

    public void set_housing_type(String _housing_type) {
        this._housing_type = _housing_type;
    }

    public int get_size_in_sqm() {
        return _size_in_sqm;
    }

    public void set_size_in_sqm(int _size_in_sqm) {
        this._size_in_sqm = _size_in_sqm;
    }

    public int get_year_of_construction() {
        return _year_of_construction;
    }

    public void set_year_of_construction(int _year_of_construction) {
        this._year_of_construction = _year_of_construction;
    }

    public int get_price_change_in_pct() {
        return _price_change_in_pct;
    }

    public void set_price_change_in_pct(int _price_change_in_pct) {
        this._price_change_in_pct = _price_change_in_pct;
    }




    public static void main(String[] args) {
        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential("sampleUser", "myDb",
                "password".toCharArray());
        System.out.println("Connected to the database successfully");

        // Accessing the database
        MongoDatabase database = mongo.getDatabase("myDb");
        System.out.println("Credentials ::"+ credential);

    }
}
