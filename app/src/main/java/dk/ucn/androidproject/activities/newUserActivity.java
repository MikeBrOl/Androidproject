package dk.ucn.androidproject.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.jasypt.util.password.BasicPasswordEncryptor;

import dk.ucn.androidproject.R;
import dk.ucn.androidproject.dao.UserDao;
import dk.ucn.androidproject.model.User;


public class newUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
    }


    public void createNewUser(View view)
    {
        UserDao ud = new UserDao(this);

        EditText editText_name = (EditText) findViewById(R.id.input_newUser_name);
        String name = editText_name.getText().toString();

        EditText editText_userName = (EditText) findViewById(R.id.input_newUser_userName);
        String username = editText_userName.getText().toString();

        EditText editText_password = (EditText) findViewById(R.id.input_newUser_password);
        String inputPassword = editText_password.getText().toString();

        EditText editText_email = (EditText) findViewById(R.id.input_newUser_email);
        String email = editText_email.getText().toString();

        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        String encryptedPassword = passwordEncryptor.encryptPassword(inputPassword);

        User user = new User();
        user.setName(name);
        user.setUserName(username);
        user.setPassword(encryptedPassword);
        user.setMail(email);

        ud.insertUser(user);

        Context context = getApplicationContext();
        CharSequence text = "User created";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context,text, duration);
        toast.show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
