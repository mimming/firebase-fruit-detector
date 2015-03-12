package com.firebase.sample.firebasefruitdetector;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class DetectFruitActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        setContentView(R.layout.activity_detect_fruit);
        final ImageView fruitImageView = (ImageView)findViewById(R.id.fruit_image);

        Firebase myFirebaseRef = new Firebase("https://fruit.firebaseio-demo.com/");

        myFirebaseRef.child("type").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String fruitType = snapshot.getValue(String.class);
                if(fruitType.equals("orange")) {
                    fruitImageView.setImageResource(R.drawable.orange);
                } else if(fruitType.equals("apple")) {
                    fruitImageView.setImageResource(R.drawable.apple);
                } else {
                    fruitImageView.setImageResource(R.drawable.ic_stop);
                }
            }

            @Override
            public void onCancelled(FirebaseError error) {
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detect_fruit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
