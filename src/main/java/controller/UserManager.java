/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.UserList;
import view.Menu;

/**
 *
 * @author HP
 */
public class UserManager extends Menu<String>{
    private UserList list= new UserList();
    public UserManager(String title, String[] s){
        super(title, s);
    }
    
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                list.createNewAccount();
                break;
            case 2:
                list.loginSystem();
                break;
            case 3:
                System.exit(0);        
        }
    }
}
