package com.glanz.serializer.model;

import com.glanz.serializer.annotation.SerializableField;

public class User {
    @SerializableField
    private String username;

    private String password;

    @SerializableField("email_address")
    private String email;

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
