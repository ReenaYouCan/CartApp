package com.cuelogic.cartapp;

import android.app.ProgressDialog;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cuelogic.cartapp.controllers.CAAppController;
import com.cuelogic.cartapp.model.CAGetProductDetailsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPager mPager;
    private TabLayout mTabLayout;
    public ArrayList<CAGetProductDetailsModel> productList = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews() {
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void getProductListWSCall() {
        String tag_json_obj = "json_obj_req";

        String url = "https://mobiletest-hackathon.herokuapp.com/getdata/";

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(getClass().getSimpleName(), response.toString());

                        try {
                            JSONArray arrProduct = response.getJSONArray("products");

                            for (int i = 0; i < arrProduct.length(); i++) {
                                CAGetProductDetailsModel model = new CAGetProductDetailsModel();
                                JSONObject objProductInfo = arrProduct.getJSONObject(i);
                                model.setmIsAddedToCart(false);
                                model.setmPImgUrl(objProductInfo.getString("productImg"));
                                model.setmPName(objProductInfo.getString("productname"));
                                model.setmPPRice(objProductInfo.getString("price"));
                                model.setmPVendorName("vendorname");
                                model.setmPVendorAddress("vendoraddress");
                                model.setmVendorPhone("phoneNumber");
                                productList.add(model);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        pDialog.hide();
                    }
                }

                , new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(getClass().getSimpleName(), "Error: " + error.getMessage());
                // hide the progress dialog
                pDialog.hide();
            }
        });

// Adding request to request queue
        CAAppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);
    }

}
