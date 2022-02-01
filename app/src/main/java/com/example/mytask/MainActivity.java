package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

  /*  @BindView(R.id.states_rv)
    RecyclerView states;*/
    double min,max;
RecyclerView states;
    List<item_model> orders;
main_adapter Main_adapter;
    final LinearLayoutManager mLayoutManager  = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
states = findViewById(R.id.states_rv);
        orders = new ArrayList<>();
        item_model Item_model= new item_model();
        Item_model.setName("asjhg");
        Item_model.setBid(29.23);
        Item_model.setAsk(30.11);
        min =29.02;
        max=90.33;
        GlobalData.min=min;
        max=45.54;
        orders.add(Item_model);

        Main_adapter= new main_adapter(orders, MainActivity.this);
        //  newTaskRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
       states.setLayoutManager(mLayoutManager);
      states.setItemAnimator(new DefaultItemAnimator());
        states.setAdapter(Main_adapter);



item_model Item_modelllll= new item_model();
Item_modelllll.setName("asjhg");
        Item_modelllll.setBid(29.02);
        Item_modelllll.setAsk(30.44);
        orders.add(Item_modelllll);

        item_model Item_modell= new item_model();
        Item_modell.setName("kdsdasd");
        Item_modell.setBid(45.54);
        Item_modell.setAsk(3.01);
        orders.add(Item_modell);

        item_model Item_modelll= new item_model();
        Item_modelll.setName("kdsdasd");
        Item_modelll.setBid(20.76);
        Item_modelll.setAsk(90.33);
        orders.add(Item_modelll);
        Main_adapter.notifyDataSetChanged();






        final Handler handler = new Handler();
        final Random random = new Random();
        final Runnable task = new Runnable() {
            @Override
            public void run() {
                double randomNumber = random.nextDouble();

                item_model item_modeln= new item_model();
                item_modeln.setBid(randomNumber);
if(min>randomNumber){
    min=randomNumber;
    GlobalData.min=min;
}
if(max<randomNumber){
   max=randomNumber;
    GlobalData.max=max;
}
                double randomNumberask = random.nextDouble();
                item_modeln.setAsk(randomNumberask);


                byte[] array = new byte[5]; // length is bounded by 5
                new Random().nextBytes(array);
                String generatedString = new String(array, Charset.forName("UTF-8"));


                item_modeln.setName(generatedString );
                orders.add(item_modeln);
                Main_adapter.notifyDataSetChanged();
                handler.postDelayed(this, 60000);

            }
        };


        task.run();
    }
}