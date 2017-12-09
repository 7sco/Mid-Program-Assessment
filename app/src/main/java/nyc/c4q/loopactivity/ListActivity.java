package nyc.c4q.loopactivity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        TextView textView= findViewById(R.id.show_email);

        Intent intent = getIntent();
        String savedEmail= intent.getStringExtra("email");
        textView.setText(savedEmail);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new BaseFragment()).addToBackStack("fragment").commit();

    }
}
