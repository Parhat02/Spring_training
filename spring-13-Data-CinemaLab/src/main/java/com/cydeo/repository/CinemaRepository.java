package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    List<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3OrderBySponsoredNameLike(String sponsoredName);

    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findByLocationCountry(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredNameLike(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c.name from Cinema c where c.id = ?1 ")
    String findNameById(Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "SELECT * from cinema where location_id = (select l.id from location l where l.country = ?1)", nativeQuery = true)
    List<Cinema> findAllByLocationCountry(String location_country);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * from cinema where name ilike concat('%',?1,'%') OR cinema.sponsored_name ILIKE concat('%',?2,'%')", nativeQuery = true)
    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);

    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * from cinema order by name" , nativeQuery = true)
    List<Cinema> sortByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT * FROM Cinema WHERE sponsored_name IN (SELECT DISTINCT sponsored_name FROM Cinema)" , nativeQuery = true)
    List<Cinema> findDistinctBySponsoredName();

}
