package com.example.mytask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {


    LineGraphSeries<DataPoint> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        TextView name= findViewById(R.id.name);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value1 = extras.getString("name");
            if (value1 != null) {
                name.setText(value1+" ,One Minute   ");
            }
        }
        double y,x;
        x=GlobalData.min;
        GraphView graphView =(GraphView) findViewById(R.id.grapg);
        series = new LineGraphSeries<DataPoint>();
        for(int i=0;i<500;i++){
        x=x+0.1;
        y=Math.sin(x);

        series.appendData(new DataPoint(x,y),true,500);}
        graphView.addSeries(series);
    }
}