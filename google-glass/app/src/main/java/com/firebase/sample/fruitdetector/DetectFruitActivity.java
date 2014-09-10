package com.firebase.sample.fruitdetector;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.android.glass.app.Card;
import com.google.android.glass.media.Sounds;
import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;

/**
 * An {@link Activity} showing a tuggable "Hello World!" card.
 * <p>
 * The main content view is composed of a one-card {@link CardScrollView} that provides tugging
 * feedback to the user when swipe gestures are detected.
 * If your Glassware intends to intercept swipe gestures, you should set the content view directly
 * and use a {@link com.google.android.glass.touchpad.GestureDetector}.
 * @see <a href="https://developers.google.com/glass/develop/gdk/touch">GDK Developer Guide</a>
 */
public class DetectFruitActivity extends Activity {

    /** {@link CardScrollView} to use as the main content view. */
    private CardScrollView mCardScroller;

    private View mView;

    @Override
    protected void onCreate(Bundle bundle) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onCreate(bundle);

            Firebase myFirebaseRef = new Firebase("https://test-firebase-please-ignore.firebaseio.com/");

            myFirebaseRef.child("fruitdetector").child("type").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot snapshot) {
                mView = buildView(snapshot.getValue(String.class));
                setContentView(mView);
            }

            @Override public void onCancelled(FirebaseError error) { }

        });

        mView = buildView("loading...");

        setContentView(mView);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Builds a Glass styled "Hello World!" view using the {@link Card} class.
     */
    private View buildView(String fruitType) {
        Card card = new Card(this);

        card.setText(fruitType);
        if(fruitType.equals("orange")) {
            card.addImage(R.drawable.orange);
        } else if(fruitType.equals("apple")) {
            card.addImage(R.drawable.apple);
        } else {
            card.addImage(R.drawable.ic_stop);

        }
        return card.getView();
    }

}
