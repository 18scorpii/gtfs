package com.gtfs.repos.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agency implements Serializable {
    @Id
    String agency_id;
    String agency_name;
    String agency_url;
    String agency_timezone;
    String agency_lang;
    String agency_phone;
}
