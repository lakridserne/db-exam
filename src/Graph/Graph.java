package Graph;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.neo4j.driver.Result;
import org.neo4j.driver.Transaction;
import org.neo4j.driver.TransactionWork;

import java.sql.Date;

import static org.neo4j.driver.Values.parameters;

public class Graph implements AutoCloseable{

    private final Driver driver;
    // DawaData
    private String _id;
    private int _status;
    private int _postnr;
    private String _postnrnavn;
    private  String _kommunenavn; private  String _wgs84koordinat_bredde;
    private  String _wgs84koordinat_laengde;
    private  String _regionsnavn;
    private  String _zone;
    private  int _brofast;
    //SalesData
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



    public Driver getDriver() {
        return driver;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public int get_status() {
        return _status;
    }

    public void set_status(int _status) {
        this._status = _status;
    }

    public int get_postnr() {
        return _postnr;
    }

    public void set_postnr(int _postnr) {
        this._postnr = _postnr;
    }

    public String get_postnrnavn() {
        return _postnrnavn;
    }

    public void set_postnrnavn(String _postnrnavn) {
        this._postnrnavn = _postnrnavn;
    }

    public String get_kommunenavn() {
        return _kommunenavn;
    }

    public void set_kommunenavn(String _kommunenavn) {
        this._kommunenavn = _kommunenavn;
    }

    public String get_wgs84koordinat_bredde() {
        return _wgs84koordinat_bredde;
    }

    public void set_wgs84koordinat_bredde(String _wgs84koordinat_bredde) {
        this._wgs84koordinat_bredde = _wgs84koordinat_bredde;
    }

    public String get_wgs84koordinat_laengde() {
        return _wgs84koordinat_laengde;
    }

    public void set_wgs84koordinat_laengde(String _wgs84koordinat_laengde) {
        this._wgs84koordinat_laengde = _wgs84koordinat_laengde;
    }

    public String get_regionsnavn() {
        return _regionsnavn;
    }

    public void set_regionsnavn(String _regionsnavn) {
        this._regionsnavn = _regionsnavn;
    }

    public String get_zone() {
        return _zone;
    }

    public void set_zone(String _zone) {
        this._zone = _zone;
    }

    public int get_brofast() {
        return _brofast;
    }

    public void set_brofast(int _brofast) {
        this._brofast = _brofast;
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




    public Graph( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void printGreeting( final String message )
    {
        try ( Session session = driver.session() )
        {
            String greeting = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (a:Greeting) " +
                                    "SET a.message = $message " +
                                    "RETURN a.message + ', from node ' + id(a)",
                            parameters( "message", message ) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( greeting );
        }
    }



    public static void main(String[] args) throws Exception {
        try ( Graph greeter = new Graph( "bolt://localhost:7687", "neo4j", "123" ) )
        {
            greeter.printGreeting( "hello, world" );
        }
    }
}
