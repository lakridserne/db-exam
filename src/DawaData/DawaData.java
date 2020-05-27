package DawaData;
import java.sql.Connection;
import java.sql.DriverManager;

public class DawaData {

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

    public String get_landsdelsnavn() {
        return _landsdelsnavn;
    }

    public void set_landsdelsnavn(String _landsdelsnavn) {
        this._landsdelsnavn = _landsdelsnavn;
    }

    public String get_storkredsnavn() {
        return _storkredsnavn;
    }

    public void set_storkredsnavn(String _storkredsnavn) {
        this._storkredsnavn = _storkredsnavn;
    }

    public int get_brofast() {
        return _brofast;
    }

    public void set_brofast(int _brofast) {
        this._brofast = _brofast;
    }

    public String get_zone() {
        return _zone;
    }

    public void set_zone(String _zone) {
        this._zone = _zone;
    }

    public String get_sognenavn() {
        return _sognenavn;
    }

    public void set_sognenavn(String _sognenavn) {
        this._sognenavn = _sognenavn;
    }

    public String get_regionsnavn() {
        return _regionsnavn;
    }

    public void set_regionsnavn(String _regionsnavn) {
        this._regionsnavn = _regionsnavn;
    }

    public String get_nojagtighed() {

        return _nojagtighed;
    }

    public void set_nojagtighed(String _nojagtighed) {
        this._nojagtighed = _nojagtighed;
    }

    public String get_wgs84koordinat_laengde() {
        return _wgs84koordinat_laengde;
    }

    public void set_wgs84koordinat_laengde(String _wgs84koordinat_laengde) {
        this._wgs84koordinat_laengde = _wgs84koordinat_laengde;
    }

    public String get_wgs84koordinat_bredde() {
        return _wgs84koordinat_bredde;
    }

    public void set_wgs84koordinat_bredde(String _wgs84koordinat_bredde) {
        this._wgs84koordinat_bredde = _wgs84koordinat_bredde;
    }

    public String get_kommunenavn() {
        return _kommunenavn;
    }

    public void set_kommunenavn(String _kommunenavn) {
        this._kommunenavn = _kommunenavn;
    }

    public int get_status() {
        return _status;
    }

    public String get_stormodtagerpostnrnavn() {
        return _stormodtagerpostnrnavn;
    }

    public void set_stormodtagerpostnrnavn(String _stormodtagerpostnrnavn) {
        this._stormodtagerpostnrnavn = _stormodtagerpostnrnavn;
    }

    public int get_stormodtagerpostnr() {
        return _stormodtagerpostnr;
    }

    public void set_stormodtagerpostnr(int _stormodtagerpostnr) {
        this._stormodtagerpostnr = _stormodtagerpostnr;
    }

    public String get_postnrnavn() {
        return _postnrnavn;
    }

    public void set_postnrnavn(String _postnrnavn) {
        this._postnrnavn = _postnrnavn;
    }

    public int get_postnr() {
        return _postnr;
    }

    public void set_postnr(int _postnr) {
        this._postnr = _postnr;
    }

    public String get_supplerendebynavn() {
        return _supplerendebynavn;
    }

    public void set_supplerendebynavn(String _supplerendebynavn) {
        this._supplerendebynavn = _supplerendebynavn;
    }

    public String get_dor() {
        return _dor;
    }

    public void set_dor(String _dor) {
        this._dor = _dor;
    }

    public String get_etage() {
        return _etage;
    }

    public void set_etage(String _etage) {
        this._etage = _etage;
    }

    public String get_husnr() {
        return _husnr;
    }

    public void set_husnr(String _husnr) {
        this._husnr = _husnr;
    }

    public String get_adresseringsvejnavn() {
        return _adresseringsvejnavn;
    }

    public void set_adresseringsvejnavn(String _adresseringsvejnavn) {
        this._adresseringsvejnavn = _adresseringsvejnavn;
    }

    public String get_vejnavn() {
        return _vejnavn;
    }

    public void set_vejnavn(String _vejnavn) {
        this._vejnavn = _vejnavn;
    }

    public void set_status(int _status) {
        this._status = _status;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public static void main(String args[] ){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/testdb",
                            "postgres", "abcd1234");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
}
