package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Movie findByName(String movieName);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal price, BigDecimal price2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Integer> duration);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateAfter(LocalDate date);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("select m FROM Movie m where m.price between ?1 and ?2")
    List<Movie> findAllByPrice(BigDecimal price, BigDecimal price2);

    //Write a JPQL query that returns all movie names
    @Query("select m.name FROM Movie m")
    List<Movie> findAllMovieNames();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "select m FROM Movie m where m.name = ?1 limit 1", nativeQuery = true)
    Movie findAllByName(String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "select * FROM movie where price between ?1 and ?2", nativeQuery = true)
    List<Movie> findByPriceBetween(BigDecimal price, BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select * FROM movie where movie.duration in ?1", nativeQuery = true)
    List<Movie> findByDuration(Integer duration1);

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "select * FROM movie order by price desc limit 5", nativeQuery = true)
    List<Movie> findByPrice();


}
