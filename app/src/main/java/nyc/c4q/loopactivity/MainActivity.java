package nyc.c4q.loopactivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text=findViewById(R.id.show_loop);

        Loop loop = new Loop();
        loop.execute();
    }

    private class Loop extends AsyncTask<Integer, Integer, Integer> {



        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            for(int i=0; i< 100; i++) {
                publishProgress(i);

            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            text.setText("Loops completed" + " " + String.valueOf(values[0]));
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            text.setText("Loops completed" + " " + integer);
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
