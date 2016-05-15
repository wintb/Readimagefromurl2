package vuvanthang.uit.readimagefromurl;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;



//Tao là chó Tiến ML
public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        imageView = (ImageView) findViewById(R.id.imageView);
        /*LoadImageFromUrl loadImageFromUrl = new LoadImageFromUrl();
        loadImageFromUrl.execute();*/

        //read image from url by Glide
        Glide.with(this)
                .load("http://icons.iconarchive.com/icons/crountch/one-piece-jolly-roger/128/Luffys-flag-2-icon.png")
                .into(imageView);
    }

    public class LoadImageFromUrl extends AsyncTask<String, Void,Bitmap>{
        @Override
        protected Bitmap doInBackground(String... params) {
            try {

                URL url = new URL("http://icons.iconarchive.com/icons/crountch/one-piece-jolly-roger/128/Luffys-flag-2-icon.png");
                InputStream is = url.openConnection().getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                return bitmap;

            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
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
}
