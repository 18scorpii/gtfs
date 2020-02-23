package com.gtfs.repos.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StopTime implements Serializable {
    @Id
    Long trip_id;
    Date arrival_time;
    Date departure_time;
    Long stop_id;
    Integer stop_sequence;
    Integer pickup_type;
    Integer drop_off_type;
    Double shape_dist_traveled;

}
