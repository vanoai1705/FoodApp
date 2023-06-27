package hcmute.edu.vn.nguyenvanoai19110421.a25_foodapp.Model;

public class UserModel {

    private int Id;
    private String Username;
    private String Password;
    private String Email;

    public UserModel(int id, String username, String password, String email) {
        Id = id;
        Username = username;
        Password = password;
        Email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
