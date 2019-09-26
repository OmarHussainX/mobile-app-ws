package com.appsdeveloperblog.app.ws;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
In Spring 2.0 and later, the @Repository annotation is a marker for any class
that fulfills the role or stereotype (also known as Data Access Object or DAO)
of a repository. Among the uses of this marker is the automatic translation of
exceptions.
https://stackoverflow.com/a/6897038/11245656

Without spring-boot-starter-data-jpa, for each CRUD operation, we would have to
write methods that would open a database connection, execute SQL queries, close
the connection - OR add methods that use Hibernate/JPA.

But with it, all that is needed is to extend CrudRepository!
CrudRepository is a Spring Data interface for generic CRUD operations on a
repository of a **specific type** (also need to specify the type of the primary key).
It provides several methods out of the box for interacting with a database:
creating, updating, deleting records etc. No need to use DAOs...

All we need to do is call a provided CRUD method to us on an Entity object.

(Data Access Object (DAO) pattern is a structural pattern that allows one to isolate
the application/business layer from the persistence layer (usually a relational database,
but it could be any other persistence mechanism) using an abstract API)
*/

/**
 * Used to persist Entity data into the database
 *
 * @author Omar Hussain
 * @see com.appsdeveloperblog.app.ws.io.entity.UserEntity
 * @see com.appsdeveloperblog.app.ws.service.impl.UserServiceImpl
 */

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    // Provides generic methods to save, read, update and delete
    // If needed, custom methods can be defined, e.g. to find a
    // user by email
    // UserEntity findUSerByEmail(String email);
}
