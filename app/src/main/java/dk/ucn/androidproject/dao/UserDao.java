package dk.ucn.androidproject.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dk.ucn.androidproject.model.User;

/**
 * Created by MIke on 21-10-2015.
 */
public class UserDao {

    private SQLiteDatabase database;
    private DBAccess dbHelper;
    private String[] allColumns = {"_id", "name", "username", "password", "email"};

    public UserDao(Context context)
    {
        dbHelper = DBAccess.getInstance(context);
        database = dbHelper.getWritableDatabase();
    }

    public void insertUser(User user)
    {
        ContentValues values = new ContentValues();
        values.put("name", user.getName());
        values.put("username", user.getUserName());
        values.put("password", user.getPassword());
        values.put("email", user.getMail());

        database.insert("users", null, values);
    }

    public void deleteUser(User user)
    {
        long id = user.get_id();
        System.out.println("Deleted user with id: " + id);
        database.delete("users", "_id = " + id, null);
    }

    public List<User> getAllUsers()
    {
        List<User> users = new ArrayList<User>();

        Cursor c = database.query("users", allColumns, null, null, null, null, null);
        c.moveToFirst();

        while (!c.isAfterLast())
        {
            User user = cursorToUser(c);
            users.add(user);
            c.moveToNext();
        }

        c.close();
        return users;
    }

    public User getUser(long id)
    {
        Cursor c = database.query("users", allColumns, "_id = ?", new String[]{"" + id}, null, null, null, null);
        c.moveToFirst();
        User user = cursorToUser(c);
        c.close();
        return user;
    }

    public User getUserByUsername(String userName)
    {
        Cursor c = database.query("users", allColumns, "username = ?", new String[]{"" + userName}, null, null, null, null);
        c.moveToFirst();
        User user = cursorToUser(c);
        c.close();
        return user;
    }

    private User cursorToUser(Cursor c)
    {
        User user = new User();
        user.set_id(c.getLong(0));
        user.setName(c.getString(1));
        user.setUserName(c.getString(2));
        user.setPassword(c.getString(3));
        user.setMail(c.getString(4));

        return user;
    }


}
