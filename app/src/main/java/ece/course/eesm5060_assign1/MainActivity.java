package ece.course.eesm5060_assign1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random mRng = new Random();
    int mCurrentIndex;
    final int NUM_TOTAL_IMAGES = 6;

    private void showImageByIndex(int index)
    {
        mCurrentIndex = index;
        ImageView image = findViewById(R.id.image);
        TextView textView = findViewById(R.id.name);
        switch(mCurrentIndex) {
            case 0:
                image.setImageResource(R.drawable.bigbird);
                textView.setText(getString(R.string.nameBigBird));
                break;
            case 1:
                image.setImageResource(R.drawable.cookiemonster);
                textView.setText(getString(R.string.nameCookieMonster));
                break;
            case 2:
                image.setImageResource(R.drawable.elmo);
                textView.setText(getString(R.string.nameElmo));
                break;
            case 3:
                image.setImageResource(R.drawable.goldfish);
                textView.setText(getString(R.string.nameGoldfish));
                break;
            case 4:
                image.setImageResource(R.drawable.julia);
                textView.setText(getString(R.string.nameJulia));
                break;
            case 5:
                image.setImageResource(R.drawable.mrnoodle);
                textView.setText(getString(R.string.nameMrNoodle));
                break;
        }
    }

    private void showRandomImage() {
        showImageByIndex(
                (mCurrentIndex + mRng.nextInt(NUM_TOTAL_IMAGES - 1) + 1)
                % NUM_TOTAL_IMAGES
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btnChange = findViewById(R.id.btnChange);
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomImage();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        showRandomImage();
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
        switch(id)
        {
            case R.id.chooseBigBird:
                showImageByIndex(0);
                return true;
            case R.id.chooseCookieMonster:
                showImageByIndex(1);
                return true;
            case R.id.chooseElmo:
                showImageByIndex(2);
                return true;
            case R.id.chooseGoldfish:
                showImageByIndex(3);
                return true;
            case R.id.chooseJulia:
                showImageByIndex(4);
                return true;
            case R.id.chooseMrNoodle:
                showImageByIndex(5);
                return true;
        }

        return false;
    }
}
