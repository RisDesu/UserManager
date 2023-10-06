/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import common.Validation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class UserList {
    private Validation validation;
    public void createNewAccount() {
        if (!validation.checkFileExist()) {
            return;
        }
        String username = validation.checkInputUsername();
        String password = validation.checkInputPassword();
        if (!validation.checkUsernameExist(username)) {
            System.err.println("Username exist.");
            return;
        }
        addAccountData(username, password);
    }

    public void loginSystem() {
        if (!validation.checkFileExist()) {
            return;
        }
        String username = validation.checkInputUsername();
        String password = validation.checkInputPassword();
        if (!validation.checkUsernameExist(username)) {
            if (!password.equalsIgnoreCase(passwordByUsername(username))) {
                System.err.println("Password incorrect.");
            }
            System.err.println("Login success.");
        }
    }

    public void addAccountData(String username, String password) {
        File file = new File("D:\\FPTU Documents\\PRO\\Code\\NetBeansProjects\\UserManager\\text.txt");
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(username + ";" + password + "\n");
            fileWriter.close();
            System.err.println("Create successly.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public String passwordByUsername(String username) {
        File file = new File("D:\\FPTU Documents\\PRO\\Code\\NetBeansProjects\\UserManager\\text.txt");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] account = line.split(";");
                if (username.equalsIgnoreCase(account[0])) {
                    return account[1];
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
