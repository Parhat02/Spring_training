package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + dateTime +
                '}';
    }
}
