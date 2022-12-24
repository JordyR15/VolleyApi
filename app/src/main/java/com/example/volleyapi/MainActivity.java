package com.example.volleyapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Adapter.ProductoAdaptador;
import Models.Producto;

public class MainActivity extends AppCompatActivity {

    private TextView correo, clave;
    private Button postDataBtn;
    private TextView responseTV;
    private ProgressBar loadingPB;

    ListView listaPro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaPro = (ListView) findViewById(R.id.txtLista);

        String url = "https://api.uealecpeterson.net/public/login";

        RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        ArrayList<Producto> productos = new ArrayList<Producto> ();
                        try {
                            JSONArray JSONlistaVolumen=  new JSONArray(response);
                            productos = Producto.JsonObjectsBuild(JSONlistaVolumen);


                            ProductoAdaptador adapatorVolumen = new ProductoAdaptador(getApplicationContext(), productos);
                            listaPro.setAdapter(adapatorVolumen);
                        }
                        catch (JSONException e)
                        {
                            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),  error.getMessage(), Toast.LENGTH_LONG).show();
                //TextView txtvolley = findViewById(R.id.txtlista);
            }
        }){
            @Override
            public Map<String, String> getHeaders() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZHVzciI6OSwiZW1haWwiOiJjemFtYnJhbm9AdXRlcS5lZHUuZWMiLCJpYXQiOjE2NzE4MzIxMjQsImV4cCI6MTY3MjE5MjEyNH0.yv81jmL2W-e7trcD4llfP-wE_bOFhwGASQvrz40-Gpk");

                // at last we are
                // returning our params.
                return params;
            }
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("fuente", "1");
                return params;
            }
        };
        queue.add(request);
    }
}