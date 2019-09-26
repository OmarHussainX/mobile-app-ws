package com.appsdeveloperblog.app.ws.shared.dto;

import java.io.Serializable;

/*
https://stackoverflow.com/a/4548905/11245656
Implement the Serializable interface when you want to be able to convert an instance
of a class into a series of bytes or when you think that a Serializable object might
reference an instance of your class.

Serializable classes are useful when you want to persist instances of them or
send them over a wire. Instances of Serializable classes can be easily transmitted.

Also NOTE:
There is no reason to use Java serialization in any new system you write.
Oracle's chief architect, Mark Reinhold, is on record as saying removing the
current Java serialization mechanism is a long-term goal.
https://adtmag.com/articles/2018/05/30/java-serialization.aspx

Instead, use a serialization scheme that you can explicitly control.
Such as Protocol Buffers, JSON, XML, or your own custom scheme.

--> Serializable is a MARKER interface (has no data member and method).

Also see: https://www.baeldung.com/java-serialization
*/

/**
 * Used to create data transfer objects which will be shared between
 * different layers, and used whenever there is a need to transfer
 * user data between different layers, e.g. between the UI and
 * service layers, or the database access and service layers
 *
 * @author Omar Hussain
 */
public class UserDto implements Serializable {
    // The JVM associates a version (long) number with each serializable
    // class. It is used to verify that the saved and loaded objects
    // have the same attributes and thus are compatible on serialization.
    private static final long serialVersionUID = 4462208319000844792L;

    // database auto-incremented ID
    private long id;

    // publicly shareable ID
    private String userId;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public String getEmailVerificationToken() {
        return emailVerificationToken;
    }

    public void setEmailVerificationToken(String emailVerificationToken) {
        this.emailVerificationToken = emailVerificationToken;
    }

    public Boolean getEmailVerificationStatus() {
        return emailVerificationStatus;
    }

    public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
        this.emailVerificationStatus = emailVerificationStatus;
    }
}
