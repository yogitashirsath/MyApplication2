package com.g.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String JSON_URL = "http://cricapi.com/api/matches?apikey=9chVvsipibUFAZNNbGlIL0q9nop2";

  private RecyclerView  recyclerView;
  private RecyclerView.Adapter cricketAdapter;
  private List<cricketModel> cricketModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
         recyclerView.setHasFixedSize(true);
       recyclerView.setLayoutManager(new LinearLayoutManager(this ));
        cricketModelList = new ArrayList<>();
        loadUrlData();

    }

    private  void loadUrlData() {
        final ProgressDialog pd=new ProgressDialog(this);
        pd.setMessage("loading");
        pd.show();
        StringRequest stringRequest=new StringRequest(Request.Method.GET, JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                pd.dismiss();
                try {
                    JSONArray jsonArray=new JSONObject(response).getJSONArray("matches");
                    for (int i=0;i<jsonArray.length();i++){
                        try {
                            String uniqueId=jsonArray.getJSONObject(i).getString("unique_id");
                            String team1=jsonArray.getJSONObject(i).getString("team-1");
                            String team2=jsonArray.getJSONObject(i).getString("team-2");
                            String type=jsonArray.getJSONObject(i).getString("type");
                            String squad=jsonArray.getJSONObject(i).getString("squad");
                           String toss_winner_team=jsonArray.getJSONObject(i).getString("toss_winner_team");
                            String winner_team=jsonArray.getJSONObject(i).getString("winner_team");
                            String matchStarted=jsonArray.getJSONObject(i).getString("matchStarted");




                            cricketModel cricketModel=new cricketModel(uniqueId,team1,team2,type,squad,toss_winner_team,winner_team,matchStarted);
                            cricketModelList.add(cricketModel);
                        }
                        catch (Exception e){
                           // Log.e("DATA123","DATAAK"+response);
                            Toast.makeText(MainActivity.this, "Error"+e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                   CricketAdapter adapterCricket=new CricketAdapter(cricketModelList,getApplicationContext());
                    recyclerView.setAdapter(adapterCricket);
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error"+error.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }}