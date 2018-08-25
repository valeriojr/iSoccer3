package Login;

import MVC.Model;

public class Login implements Model {
    public static String USERNAME = "Usuário", PASSWORD = "Senha";

    private String username, password;

    public Login(){
        username = null;
        password = null;
    }

    public Login(String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(){
        return username.equals("admin") && password.equals("123456");
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("%s: %s\n%s: %s\n", USERNAME, username, PASSWORD, password);
    }
}
