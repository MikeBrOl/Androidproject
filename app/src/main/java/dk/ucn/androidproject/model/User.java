package dk.ucn.androidproject.model;

/**
 * Created by Mike on 16-10-2015.
 */
public class User {
    private long _id;
    private String name;
    private String userName;
    private String password;
    private String eMail;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return eMail;
    }

    public void setMail(String eMail) {
        this.eMail = eMail;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }
}
