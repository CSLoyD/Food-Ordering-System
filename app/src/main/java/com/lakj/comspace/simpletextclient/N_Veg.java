package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class N_Veg extends Activity {


    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n__veg);
        total_cal();
        orders_list_init();
    }

    static int chicken_burger;
    static int chicken_bbq_pizza;
    static int chicken_tikka;
    static int fried_fish_rice;
    static int chicken_biryani;
    static int mutton_biryani;
    static int kolhapuri_chicken;
    static int chicken_noodles;
    static int chicken_fried_rice;
    static int chicken_lollipop;
    static int n_veg_total;


    public void chicken_bbq_pizza_inc(View view){
        chicken_bbq_pizza=inc(chicken_bbq_pizza);
        TextView tv = (TextView) findViewById(R.id.chicken_BBQ_pizza_order);
        tv.setText("" + chicken_bbq_pizza);
        total_cal();
    }
    public void chicken_bbq_pizza_dec(View view) {
        if (chicken_bbq_pizza >= 0) {
        chicken_bbq_pizza= dec(chicken_bbq_pizza);
        TextView tv = (TextView) findViewById(R.id.chicken_BBQ_pizza_order);
            if(chicken_bbq_pizza>0) tv.setText("" + chicken_bbq_pizza);
            else tv.setText("__");
            total_cal();

    }
    }

    public void chicken_burger_inc(View view){
        chicken_burger=inc(chicken_burger);
        TextView tv = (TextView) findViewById(R.id.chickburger_order);
        tv.setText("" + chicken_burger);
        total_cal();
    }
    public void chicken_burger_dec(View view) {
        if (chicken_burger >= 0) {
            chicken_burger = dec(chicken_burger);
            TextView tv = (TextView) findViewById(R.id.chickburger_order);
            if(chicken_burger>0) tv.setText("" + chicken_burger);
            else tv.setText("__");
            total_cal();
        }
    }


    public void chicken_tikka_inc(View view){
        chicken_tikka=inc(chicken_tikka);
        TextView tv = (TextView) findViewById(R.id.chicken_tikka_order);
        tv.setText("" + chicken_tikka);
        total_cal();
    }
    public void chicken_tikka_dec(View view) {
        if (chicken_tikka>= 0) {
            chicken_tikka = dec(chicken_tikka);
            TextView tv = (TextView) findViewById(R.id.chicken_tikka_order);
            if(chicken_tikka>0) tv.setText("" + chicken_tikka);
            else tv.setText("__");
            total_cal();
        }
    }

    public void total_cal() {
        n_veg_total = chicken_burger * (75) + chicken_bbq_pizza * (100) + chicken_tikka * (90) + fried_fish_rice * (250) + kolhapuri_chicken * (120) + chicken_noodles * (120) + chicken_fried_rice * (120) + chicken_lollipop * (100) + chicken_biryani * (180) + mutton_biryani * (200);
        finalize_order.all_total = Starters.starters_total + Veg.total_veg + N_Veg.n_veg_total + Dessert.dessert_total;
        if (finalize_order.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.n_veg_tot_id);
            tv.setText("" + "₱" + (finalize_order.all_total));
        }

        else{
            TextView tv = (TextView) findViewById(R.id.n_veg_tot_id);
            tv.setText("");

        }
    }





    public void main_menu(View view){
        Intent goto_main_menu= new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public int dec(int x) {
    if (x > 0) {
        x--;
        return x;
    }
    else return 0;
}


public int inc(int x)
{
   x++;
    return (x);
}

    public void orders_list_init(){

        if(chicken_burger>0) {
            TextView tv = (TextView) findViewById(R.id.chickburger_order);
            tv.setText("" + chicken_burger);
        }

        if(chicken_bbq_pizza>0) {
            TextView tv = (TextView) findViewById(R.id.chicken_BBQ_pizza_order);
            tv.setText("" + chicken_bbq_pizza);
        }
        if(chicken_tikka>0) {
            TextView tv = (TextView) findViewById(R.id.chickburger_order);
            tv.setText("" + chicken_tikka);
        }
    }

    public void fin_ord(View view)
    {
        final Object o=this;
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

                                Intent nextact = new Intent((N_Veg) o, thankyou.class);
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


