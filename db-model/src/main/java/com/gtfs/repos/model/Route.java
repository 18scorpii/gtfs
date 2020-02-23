package com.gtfs.repos.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Route implements Serializable {
    @Id
    Long route_id;
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name="agency_id")
    Agency agency;
    String route_short_name;
    String route_long_name;
    String route_type;
    String route_url;
    String route_color;
}
