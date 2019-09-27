package com.appsdeveloperblog.app.ws.io.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/*
https://docs.oracle.com/javaee/6/tutorial/doc/bnbqa.html
An entity is a lightweight persistence domain object.
Typically, an entity represents a table in a relational database,
and each entity instance corresponds to a row in that table.
The primary programming artifact of an entity is the entity class,
although entities can use helper classes.

The persistent state of an entity is represented through either
persistent fields or persistent properties. These fields or
properties use object/relational mapping annotations to map the
entities and entity relationships to the relational data in the
underlying data store.
*/

/**
 * Used to encapsulate user data
 * (Entity instances can be persisted to the database via the
 * UserRepository interface)
 *
 * @see com.appsdeveloperblog.app.ws.shared.dto.UserDto
 * @see com.appsdeveloperblog.app.ws.UserRepository
 * @see com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel
 * @see com.appsdeveloperblog.app.ws.ui.model.response.UserResponseModel
 *
 * @author Omar Hussain
 */

@Entity(name="users")   // name of table where records will be stored
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 5313493413859894403L;

    @Id                     // primary key
    @GeneratedValue         // auto increment
    private long id;

    @Column(nullable=false) // required field
    private String userId;  // holds publicly shareable user id

    @Column(nullable=false, length=50) // required field, limited size (otherwise has max varchar length of 255)
    private String firstName;

    @Column(nullable=false, length=50)
    private String lastName;

 // @Column(nullable=false, length=120, unique=true) // field must have unique values
    @Column(nullable=false, length=120)
    private String email; // add logic to ensure that email addresses aren't duplicated

    @Column(nullable=false)
    private String encryptedPassword;

    private String emailVerificationToken;

    // NOTE: To ensure that a field has a default value, it must be specified
    // here in this class, and the data transfer object class
    @Column(nullable=false)
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
