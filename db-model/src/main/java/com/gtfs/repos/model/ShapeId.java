package com.gtfs.repos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShapeId implements Serializable {
    Long shape_id;
    Double shape_pt_lat;
    Double shape_pt_lon;
    Integer shape_pt_sequence;
}
