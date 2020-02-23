package com.gtfs.repos.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stop implements Serializable {
    @Id
    Long stop_id;
    Integer stop_code;
    String stop_name;
    String stop_desc;
    Double stop_lat;
    Double stop_lon;
    Long zone_id;
}

