package com.ptp.phamtanphat.volley1409;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetData("https://khoapham.vn/KhoaPhamTraining/json/tien/demo5.json");
    }

    private void GetData(String s) {
        // Cach khởi tạo Thư viện volley
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        // Đọc dữ liệu qua url = StringRequest

//        StringRequest stringRequest = new StringRequest(Request.Method.GET, s, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("BBB",error.getCause().toString());
//            }
//        });
//        requestQueue.add(stringRequest);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, s, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(MainActivity.this,response.toString() , Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("BBB",error.getMessage().toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
