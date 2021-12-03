package com.gotravel.flightadminservice.entity;


import com.gotravel.flightadminservice.model.AirlineStatusType;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id")
    private int airlineId;

    @Column(name = "airline_name")
    private String airlineName;

    @Column(name = "iata_code")
    private String iataCode;

    @Enumerated(EnumType.STRING)
    @Column(name = "airline_status")
    private AirlineStatusType airlineStatus;

}
