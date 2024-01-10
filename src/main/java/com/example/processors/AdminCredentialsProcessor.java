package com.example.processors;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class AdminCredentialsProcessor {

    private String username;
    private String password;

    private boolean adminValid;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdminValid() {
        return adminValid;
    }

    public void setAdminValid(boolean adminValid) {
        this.adminValid = adminValid;
    }

    public void checkAdminCredentials()
    {
        if (username.equals("admin") && password.equals("adminpass"))
        {
            adminValid = true;
        }
    }
}
