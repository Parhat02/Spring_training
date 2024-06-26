package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    List<MovieCinema> findAllById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    int countAllByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    int countMovieCinemasByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime dateTime);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findTop3ByOrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findAllByMovieNameContaining(String movie_name);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findAllByCinemaLocationName(String locationName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("SELECT m from MovieCinema m where m.dateTime > ?1")
    List<MovieCinema> findByDateHigherThan(LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "SELECT * from movie_cinema where movie_cinema.cinema_id = ?1", nativeQuery = true)
    List<MovieCinema> findByCinemaId(Long id);

    //Write a native query that returns all movie cinemas by location name
    //@Query(value = "SELECT * from movie_cinema where cinema_id=(select id from cinema where location_id=(select id from location where name = ?1))", nativeQuery = true)
    @Query(value = "select * from movie_cinema mc JOIN cinema c on mc.cinema_id=c.id JOIN location l on c.location_id=l.id where l.name=?1", nativeQuery = true)
    List<MovieCinema> findByLocationName(String name);


}
