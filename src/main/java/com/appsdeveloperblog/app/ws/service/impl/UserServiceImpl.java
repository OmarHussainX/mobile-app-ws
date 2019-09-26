package com.appsdeveloperblog.app.ws.service.impl;

import com.appsdeveloperblog.app.ws.UserRepository;
import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import com.appsdeveloperblog.app.ws.service.UserService;
import com.appsdeveloperblog.app.ws.shared.dto.UserDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
https://stackoverflow.com/a/6897038/11245656

In Spring 2.0 and later, the @Repository annotation is a marker for
any class that fulfills the role or stereotype (also known as Data
Access Object or DAO) of a repository. Among the uses of this marker
is the automatic translation of exceptions.

Spring 2.5 introduces further stereotype annotations: @Component,
@Service, and @Controller. @Component is a generic stereotype for any
Spring-managed component. @Repository, @Service, and @Controller are
specializations of @Component for more specific use cases, for example,
in the persistence, service, and presentation layers, respectively.

Therefore, you can annotate your component classes with @Component,
but by annotating them with @Repository, @Service, or @Controller instead,
your classes are more properly suited for processing by tools or
associating with aspects. For example, these stereotype annotations make
ideal targets for pointcuts.

Thus, if you are choosing between using @Component or @Service for
your service layer, @Service is clearly the better choice. Similarly,
as stated above, @Repository is already supported as a marker for
automatic exception translation in your persistence layer.

--> This bean needs to be annotated so that it can be injected
 (autowired) elsewhere
*/


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a new record and persists it
     *
     * @param user A UserDto containing data for a new user which
     *             is to be saved to the database
     * @return A string representing the employee’s first
     * name.
     */
    @Override
    public UserDto createUser(UserDto user) {

        // Create a new Entity, and copy properties
        // from the data transfer object parameter to it
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        // Will write the logic to set these later,
        // dummy values for now
        // These values MUST be set since they are required columns
        // in the database table
        userEntity.setUserId("testUserId");
        userEntity.setEncryptedPassword("testEncryptedPassword");

        // Use 'save' method (provided by Spring data JPA) to
        // persist Entity data into the database
        // https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#save-S-
        // This method never returns null: it creates a new record
        // - or if the record already exists, merges data - and returns
        // a new Entity instance
        UserEntity storedUserDetails = userRepository.save(userEntity);

        // Create a new data transfer object, and
        // copy properties from the Entity instance for the saved record
        // to it
        UserDto returnValue = new UserDto();
        BeanUtils.copyProperties(storedUserDetails, returnValue);

        return returnValue;
    }
}
