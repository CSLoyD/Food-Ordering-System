package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Dessert extends Activity {

    static int chocolate_ice_cream;
    static int vanilla_ice_cream;
    static int strawberry_ice_cream;
    static int falooda;
    static int brownie_fudge;
    static int alpine_chocolate;
    static int devils_delight;
    static int black_forest;
    static int chocolate_lava;
    static int dutch_almond;
    static int dessert_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        total_cal();
        orders_list_init();
    }

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    public void chocolate_ice_cream_inc(View view) {
        chocolate_ice_cream = inc(chocolate_ice_cream);
        TextView tv = (TextView) findViewById(R.id.choco_ice_cream_order);
        tv.setText("" + chocolate_ice_cream);
        total_cal();
    }

    public void chocolate_ice_cream_dec(View view) {
        if (chocolate_ice_cream >= 0) {
            chocolate_ice_cream = dec(chocolate_ice_cream);
            TextView tv = (TextView) findViewById(R.id.choco_ice_cream_order);
            if (chocolate_ice_cream > 0) tv.setText("" + chocolate_ice_cream);
            else tv.setText("__");
            total_cal();
        }
    }

    public void vanilla_ice_cream_inc(View view) {
        vanilla_ice_cream = inc(vanilla_ice_cream);
        TextView tv = (TextView) findViewById(R.id.vannila_ice_cream_order);
        tv.setText("" + vanilla_ice_cream);
        total_cal();
    }

    public void vanilla_ice_cream_dec(View view) {
        if (vanilla_ice_cream >= 0) {
            vanilla_ice_cream = dec(vanilla_ice_cream);
            TextView tv = (TextView) findViewById(R.id.vannila_ice_cream_order);
            if (vanilla_ice_cream > 0) tv.setText("" + vanilla_ice_cream);
            else tv.setText("__");
            total_cal();
        }

    }

    public void strawberry_ice_cream_inc(View view) {
        strawberry_ice_cream = inc(strawberry_ice_cream);
        TextView tv = (TextView) findViewById(R.id.Strawberry_ice_cream_order);
        tv.setText("" + strawberry_ice_cream);
        total_cal();
    }

    public void strawberry_ice_cream_dec(View view) {
        if (strawberry_ice_cream >= 0) {
            strawberry_ice_cream = dec(strawberry_ice_cream);
            TextView tv = (TextView) findViewById(R.id.Strawberry_ice_cream_order);
            if (strawberry_ice_cream > 0) tv.setText("" + strawberry_ice_cream);
            else tv.setText("__");
            total_cal();
        }

    }


    public void total_cal() {
        dessert_total = chocolate_ice_cream * (65) + vanilla_ice_cream * (87) + strawberry_ice_cream * (70) + falooda * (150) + brownie_fudge * (120) + alpine_chocolate * (150) + devils_delight * (100) + black_forest * (80) + chocolate_lava * (180) + dutch_almond * (120);
        finalize_order.all_total = Starters.starters_total + Veg.total_veg + N_Veg.n_veg_total + Dessert.dessert_total;
        if (finalize_order.all_total > 0) {
        TextView tv = (TextView) findViewById(R.id.dessert_tot_id);
        tv.setText("" + "₱" + (finalize_order.all_total));

        }
        else{
            TextView tv = (TextView) findViewById(R.id.dessert_tot_id);
            tv.setText("");
        }
        orders_list_init();
    }


    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }


    public int dec(int x) {
        if (x > 0) {
            x--;
            return x;
        } else return 0;
    }


    public int inc(int x) {
        x++;
        return (x);
    }

    public void orders_list_init() {



        if (chocolate_ice_cream > 0) {
                TextView tv = (TextView) findViewById(R.id.choco_ice_cream_order);
                tv.setText("" + chocolate_ice_cream);
        }
        if (vanilla_ice_cream > 0) {
            TextView tv = (TextView) findViewById(R.id.vannila_ice_cream_order);
            tv.setText("" + vanilla_ice_cream);
        }
        if (strawberry_ice_cream > 0) {
            TextView tv = (TextView) findViewById(R.id.Strawberry_ice_cream_order);
            tv.setText("" + strawberry_ice_cream);
        }
    }

    public void fin_ord(View view)
    {
        final Object o = this;
        if(finalize_order.all_total>0) {
            Intent fin = new Intent(this, finalize_order.class);
            startActivity(fin);
            overridePendingTransition(R.anim.fadin, R.anim.fadout);
        }
        else{

            if(finalize_order.next_ord_flag==1)
            {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you don't want to place another order?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent nextact = new Intent((Dessert) o, thankyou.class);
                                startActivity(nextact);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }

                else{
                Toast.makeText(getApplicationContext(),
                        "Please select your order", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
