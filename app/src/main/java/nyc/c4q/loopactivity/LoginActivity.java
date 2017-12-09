package nyc.c4q.loopactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private static final String SHARED_PREFS_KEY = "sharedPrefsTesting";
    private EditText username;
    private EditText password;
    private Button save;
    private CheckBox checkBox;
    private SharedPreferences login;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username= findViewById(R.id.username_edittext);
        password= findViewById(R.id.password_edittext);
        save= findViewById(R.id.save);
        checkBox= findViewById(R.id.checkbox);

        login = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        if (login.getBoolean("isChecked", false)) {
            username.setText(login.getString("username", null));
            password.setText(login.getString("password", null));
            checkBox.setChecked(login.getBoolean("isChecked", false));
        }

        save.setOnClickListener(new View.OnClickListener() {
            SharedPreferences.Editor editor = login.edit();
            @Override
            public void onClick(View v) {

                if (username.getText().toString().equalsIgnoreCase(login.getString("username", null))
                        && password.getText().toString().equals(login.getString("password", null))) {

                    Intent intent= new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("email", username.getText().toString());
                    startActivity(intent);
                } else {

                    if (username.getText().toString().contains("@")&& username.getText().toString().contains(".com")) {
                        if (checkBox.isChecked()){
                            editor.putString("username", username.getText().toString());
                            editor.putString("password", password.getText().toString());
                            editor.putBoolean("isChecked", checkBox.isChecked());
                            editor.commit();
                            Log.d("check", ""+ username.getText().toString() + " " + password.getText().toString());
                            Log.d("check", ""+ login.getString("username", "") + " " + login.getString("password", ""));
                        } else {
                            editor.putBoolean("isChecked", checkBox.isChecked());
                            editor.commit();
                            Log.d("check", ""+ username.getText().toString() + " " + password.getText().toString());
                        }
                    } else {
                        Toast.makeText(getBaseContext(), "Please enter an email address!", Toast.LENGTH_LONG).show();
                    }
                }

            }

        });


    }
}
