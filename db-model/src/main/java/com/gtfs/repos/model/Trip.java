package com.gtfs.repos.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trip implements Serializable {
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "route_id")
    Route route;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "TRIP_SERVICES",
            joinColumns = {@JoinColumn(name = "trip_trip_id")},
            inverseJoinColumns = {@JoinColumn(name = "calendardate_pk_id")}
            )
    List<CalendarDate> services;
    @Id
    Long trip_id;
    String trip_headsign;
    Integer direction_id;
    String block_id;
    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    List<Shape> shapes;
}
