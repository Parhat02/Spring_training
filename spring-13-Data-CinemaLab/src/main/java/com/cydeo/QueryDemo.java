package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class QueryDemo implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final MovieRepository movieRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final TicketRepository ticketRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;

    public QueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, MovieRepository movieRepository, MovieCinemaRepository movieCinemaRepository, TicketRepository ticketRepository, GenreRepository genreRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.movieRepository = movieRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.ticketRepository = ticketRepository;
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println(cinemaRepository.findByName("Hall 1 - EMPIRE"));
        System.out.println(accountRepository.findAllAdmin());
        System.out.println(cinemaRepository.findDistinctBySponsoredName());
        System.out.println(movieRepository.findAllMovieNames());
        System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
        //System.out.println(movieCinemaRepository.findByLocationName("AMC Empire 25"));
        System.out.println(ticketRepository.allTicketsByUserId(4L));
        System.out.println(ticketRepository.findAllByDateTimeBetween(LocalDateTime.now().minusDays(1000), LocalDateTime.now()));
        //System.out.println(ticketRepository.ticketsByName("it"));
        System.out.println(genreRepository.findAllBy());
        System.out.println(userRepository.findAllUser());
    }
}
