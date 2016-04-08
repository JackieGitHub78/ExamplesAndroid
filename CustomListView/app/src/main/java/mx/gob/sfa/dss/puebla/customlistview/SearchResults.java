package mx.gob.sfa.dss.puebla.customlistview;

/**
 * Created by dtit on 07/04/16.
 */
public class SearchResults {
    private String name = "";
    private String cityState = "";
    private String phone = "";
    private String posicion;

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityState() {
        return cityState;
    }

    public void setCityState(String cityState) {
        this.cityState = cityState;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
