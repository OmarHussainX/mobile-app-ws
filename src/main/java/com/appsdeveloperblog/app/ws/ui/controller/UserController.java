package com.appsdeveloperblog.app.ws.ui.controller;

import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Enables the application to receive and respond to HTTP
 * requests sent to {@code /users}
 *
 * @author Omar Hussain
 */
@RestController
@RequestMapping("users")    //http://localhost:8080/users
public class UserController {

    // Spring '@Autowired' annotation is used for automatic dependency
    // injection. Spring framework is built on dependency injection...
    // The bean to be injected needs to be annotated with e.g.
    // @Repository, @Service, @Controller (specializations of @Component)
    @Autowired
    private UserService userService;

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    /**
     * Handles POST requests, converts JSON payload in BODY to a UserResponseModel Object
     *
     * @param userDetails Reference to an object containing data
     *                    de-serialized from the inbound HttpRequest body
     * @return An object containing user data which will be converted by
     * the framework into a JSON payload for an outgoing response
     */
    @PostMapping
    public UserResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserResponseModel returnValue = new UserResponseModel();

        // NOTE: HTTP POST request needs to contain a JSON body, which contains
        // keys which must match the properties of the UserDetailsRequestModel



        // Populate data transfer object with data received in the
        // HttpRequest body.
        //
        // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/BeanUtils.html#copyProperties-java.lang.Object-java.lang.Object-
        // Note: The source and target classes do not have to match
        // or even be derived from each other, as long as the properties
        // match. Any bean properties that the source bean exposes but
        // the target bean does not will silently be ignored.
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        // Data transfer object created by the UI layer, and passed to
        // the service layer via userService.createUser().
        // The service layer takes the data transfer object, performs
        // business logic on it, adds some additional data to the data
        // transfer object, and passes it to the data layer.
        // The data layer creates a UserEntity instance, saves it to the DB,
        // and creates a new data transfer object which is returned to
        // the UI layer and used to compose the outgoing response with a
        // user data JSON payload.
        //
        // NOTE: The service class needs to be 'autowired' into this class
        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
