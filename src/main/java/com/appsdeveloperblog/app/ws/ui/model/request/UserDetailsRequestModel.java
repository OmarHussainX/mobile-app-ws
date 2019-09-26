package com.appsdeveloperblog.app.ws.ui.model.request;

/**
 * Used by the framework to convert JSON payload in an
 * incoming request body into a UserDetailsRequestModel object
 *
 * @see com.appsdeveloperblog.app.ws.ui.model.response.UserResponseModel
 * @see com.appsdeveloperblog.app.ws.io.entity.UserEntity
 *
 * @author Omar Hussain
 */
public class UserDetailsRequestModel {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

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
}
