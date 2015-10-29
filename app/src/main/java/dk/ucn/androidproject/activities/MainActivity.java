package dk.ucn.androidproject.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.jasypt.util.password.BasicPasswordEncryptor;

import dk.ucn.androidproject.R;
import dk.ucn.androidproject.dao.UserDao;
import dk.ucn.androidproject.model.User;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_USER_ID = "USER_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* //Starts EvaluationActivity
        Intent intent = new Intent(getApplicationContext(), EvaluationActivity.class);
        startActivity(intent);*/

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

    public void login(View view)
    {
//        Intent intent = new Intent(getApplicationContext(), EvaluationActivity.class);
//        startActivity(intent);


        EditText editText_userName = (EditText) findViewById(R.id.input_main_userName);
        String userName = editText_userName.getText().toString();

        EditText editText_password = (EditText) findViewById(R.id.input_main_password);
        String inputPassword = editText_password.getText().toString();

        UserDao ud = new UserDao(this);
        User user = ud.getUserByUsername(userName);

        BasicPasswordEncryptor pe = new BasicPasswordEncryptor();
        String encryptedPassword = user.getPassword();

        if(pe.checkPassword(inputPassword, encryptedPassword))
        {
            Intent intent = new Intent(getApplicationContext(), EvaluationActivity.class);
            long userID = user.get_id();
            intent.putExtra(EXTRA_USER_ID, userID);
            startActivity(intent);
        }
        else
        {
         Context context = getApplicationContext();
            CharSequence text = "Wrong username or password!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void newUser(View view)
    {
        Intent intent = new Intent(getApplicationContext(), newUserActivity.class);
        startActivity(intent);
    }
}
