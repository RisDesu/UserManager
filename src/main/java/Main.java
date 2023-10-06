
import controller.UserManager;
import java.util.ArrayList;
import model.UserList;
import view.Menu;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        String title = "USER MANAGEMENT SYSTEM ";
        String[] s = new String[]{"Create a new account", "Login system","Exit"};
        Menu<String> menu = new UserManager(title, s);
        menu.run();
        
    }
}
