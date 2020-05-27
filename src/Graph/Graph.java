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
    private String _vejnavn;
    private String _adresseringsvejnavn;
    private  String _husnr;
    private String _etage;
    private  String _dor;
    private String _supplerendebynavn;
    private int _postnr;
    private String _postnrnavn;
    private  int _stormodtagerpostnr;
    private  String _stormodtagerpostnrnavn;
    private  String _kommunenavn;
    private  String _wgs84koordinat_bredde;
    private  String _wgs84koordinat_laengde;
    private  String _nojagtighed;
    private  String _regionsnavn;
    private  String _sognenavn;
    private  String _zone;
    private  int _brofast;
    private  String _storkredsnavn;
    private  String _landsdelsnavn;
   //SalesData
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
