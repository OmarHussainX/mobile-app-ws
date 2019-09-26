package com.appsdeveloperblog.app.ws.service;

import com.appsdeveloperblog.app.ws.shared.dto.UserDto;

/**
 * Specifies methods which can be used to create a user, get all users,
 * update user details, delete a user, etc.
 *
 * @author Omar Hussain
 */
public interface UserService {
    UserDto createUser(UserDto user);
}
