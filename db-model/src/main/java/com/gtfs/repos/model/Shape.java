package com.gtfs.repos.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@IdClass(ShapeId.class)
public class Shape implements Serializable {
    @Id
    Long shape_id;
    @Id
    Double shape_pt_lat;
    @Id
    Double shape_pt_lon;
    @Id
    Integer shape_pt_sequence;
    Float shape_dist_traveled;
}
