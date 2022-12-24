package Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Producto {
    private String id;
    private String descripcion;
    private String costo;
    private String p_categoria;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getP_categoria() {
        return p_categoria;
    }

    public void setP_categoria(String p_categoria) {
        this.p_categoria = p_categoria;
    }

    public Producto(JSONObject a) throws JSONException {
        id =  a.getString("id").toString();
        descripcion =  a.getString("descripcion").toString() ;
        costo =  a.getString("costo").toString() ;
        p_categoria = a.getString("p_categoria").toString() ;

    }

    public static ArrayList<Producto> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Producto> producto = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            producto.add(new Producto(datos.getJSONObject(i)));
        }
        return producto;
    }
}
