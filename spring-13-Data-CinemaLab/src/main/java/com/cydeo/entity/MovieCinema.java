package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @ManyToOne
    private Cinema cinema;
    @ManyToOne
    private Movie movie;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;
}
