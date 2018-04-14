package omy.boston.soundpool;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private SoundPool soundPool;
    private int soundID;
    boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView touch = (TextView) findViewById(R.id.textView);
        touch.setOnTouchListener(this);

        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i1) {
                loaded = true;
            }
        });
        soundID = soundPool.load(this, R.raw.sound_bubanj, 1);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (loaded){
            soundPool.play(soundID, 1.0f, 1.0f, 1, 0, 1.0f);
        }
        return false;
    }
}
