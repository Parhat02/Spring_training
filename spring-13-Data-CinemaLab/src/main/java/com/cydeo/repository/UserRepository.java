package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserAccount, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    UserAccount findByEmail(String email);

    //Write a derived query to read a user with a username?
    UserAccount findByUsername(String userName);

    //Write a derived query to list all users that contain a specific name?
    List<UserAccount> findAllByUsernameContaining(String userName);

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<UserAccount> findAllByUsernameLikeIgnoreCase(String userName);

    //Write a derived query to list all users with an age greater than a specified age?
    List<UserAccount> findAllByAccountDetailsAge(Integer age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from UserAccount u where u.email=?1")
    UserAccount findUserByEmail(String email);
    //Write a JPQL query that returns a user read by username?
    @Query("select u from UserAccount u where u.username=?1")
    UserAccount findUserByUserName(String userName);

    //Write a JPQL query that returns all users?
    @Query("select u from UserAccount u")
    List<UserAccount> findAllUser();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    //@Query(value = "select * from user_account where username like concat('%',?1,'%')", nativeQuery = true)
    @Query(value = "SELECT * FROM user_account u JOIN account_details ad " +
            "ON ad.id = u.account_details_id WHERE ad.name ILIKE concat('%',?1,'%')",nativeQuery = true)
    UserAccount findUserByName(String userName);

    //Write a native query that returns all users?
    @Query(value = "select * from user_account", nativeQuery = true)
    UserAccount listAllUsers();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "SELECT * FROM user_account u " +
            "JOIN account_details ad ON ad.id = u.account_details_id " +
            "WHERE ad.age BETWEEN ?1 AND ?2",nativeQuery = true)
    UserAccount retrieveBetweenAgeRange(Integer age, Integer age2);

    //Write a native query to read a user by email?
    @Query(value = "select * from user_account where user_account.email = ?1", nativeQuery = true)
    UserAccount readUserByEmail(String email);


}
