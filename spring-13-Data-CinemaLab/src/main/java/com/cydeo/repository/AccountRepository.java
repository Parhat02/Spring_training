package com.cydeo.repository;

import com.cydeo.entity.AccountDetails;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends JpaRepository<AccountDetails, Long> {
// ------------------- DERIVED QUERIES ------------------- //

//Write a derived query to list all accounts with a specific country or state
    List<AccountDetails> findByCountryOrState(String country, String state);

//Write a derived query to list all accounts with age lower than or equal to a specific value
    List<AccountDetails> findByAgeLessThanEqual(Integer age);

//Write a derived query to list all accounts with a specific role
    List<AccountDetails> findByRole(UserRole role);

//Write a derived query to list all accounts between a range of ages
    List<AccountDetails> findByAgeBetween(Integer age, Integer age2);

//Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<AccountDetails> findByAddressStartingWith(String address);

//Write a derived query to sort the list of accounts with age
    List<AccountDetails> findByOrderByAge();

// ------------------- JPQL QUERIES ------------------- //

//Write a JPQL query that returns all accounts
    @Query("SELECT a from AccountDetails a")
    List<AccountDetails> findAllBy();

//Write a JPQL query to list all admin accounts
    @Query("select a from AccountDetails a where a.role='ADMIN'")
    List<AccountDetails> findAllAdmin();

//Write a JPQL query to sort all accounts with age
    @Query("select a from AccountDetails a order by a.age")
    List<AccountDetails> sortAllAccountsByAge();

// ------------------- Native QUERIES ------------------- //

//Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "select * from account_details where age<?1", nativeQuery = true)
    List<AccountDetails> findByAgeLessThan(Integer age);

//Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "select * from account_details where name or address or country or state like '%?1%'", nativeQuery = true)
    List<AccountDetails> findByAgeLessThan(String value);

    @Query(value = "SELECT * FROM account_details WHERE name ILIKE concat('%',?1,'%') OR address  ILIKE concat('%',?1,'%') " +
            " OR country  ILIKE concat('%',?1,'%') OR state  ILIKE concat('%',?1,'%') OR city  ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<AccountDetails> retrieveBySearchCriteria(String pattern);

//Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "select * from account_details where age>?1", nativeQuery = true)
    List<AccountDetails> findByAgeGreaterThan(Integer age);

    @Query(value = "SELECT * FROM account_details WHERE age > :age",nativeQuery = true)
    List<AccountDetails> readAccountAllAgeHigher(@Param("age") Integer age);

}
