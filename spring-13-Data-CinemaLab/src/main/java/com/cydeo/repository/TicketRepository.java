package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.Ticket;
import com.cydeo.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countAllByUserAccountId(Long userAccount_id);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    int countAllByMovieCinemaMovieName(String movie_name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime dateTime, LocalDateTime dateTime2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("SELECT t from Ticket t where t.userAccount = ?1")
    List<Ticket> allTicketsByUser(UserAccount userAccount);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("SELECT t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> allTicketsBetweenDate(LocalDateTime dateTime, LocalDateTime dateTime2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "SELECT count(*) from ticket where user_account_id = ?1", nativeQuery = true)
    int countTicketsByUser(Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "SELECT * from ticket where user_account_id = ?1 and date_time between ?2 and ?3", nativeQuery = true)
    int countTicketsByUserByTime(Long id, LocalDateTime dateTime, LocalDateTime dateTime2);

    //Write a native query to distinct all tickets by movie name
    //@Query(value = "SELECT distinct * from ticket where movie_cinema_id=(select id from movie_cinema where cinema_id = (select id from cinema where movie_id=(Select id from movie where movie.name=?1)) )", nativeQuery = true)
    @Query(value = "SELECT DISTINCT (m.name) FROM ticket t JOIN movie_cinema mc " +
            "ON mc.id = t.movie_cinema_id " +
            "JOIN movie m ON m.id = mc.movie_id where m.name=?1",nativeQuery = true)
    List<Ticket> ticketsByMovieName(String name);

    //Write a native query to find all tickets by user email
    //@Query(value = "SELECT * from ticket where user_account_id=(select id from user_account where email = ?1)", nativeQuery = true)
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id " +
            "WHERE ua.email = ?1",nativeQuery = true)
    List<Ticket> ticketsByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "SELECT * from ticket", nativeQuery = true)
    List<Ticket> findAllTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    //@Query(value = "SELECT * from ticket where user_account_id=(select id from user_account where username = ?1)", nativeQuery = true)
    @Query(value = "SELECT * FROM ticket t JOIN user_account ua ON t.user_account_id = ua.id " +
            "JOIN account_details ad ON ad.id = ua.account_details_id " +
            "JOIN movie_cinema mc ON mc.id = t.movie_cinema_id " +
            "JOIN movie m ON mc.movie_id = m.id " +
            "WHERE ua.username ILIKE concat('%',?1,'%') " +
            "OR ad.name ILIKE concat('%',?1,'%') " +
            "OR m.name ILIKE concat('%',?1,'%') ",nativeQuery = true)
    List<Ticket> ticketsByUserName(String name);


}
