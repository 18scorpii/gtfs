package com.gtfs.repos.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@Entity
public class CalendarDate implements Serializable {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CalendarDate_Sequence")
    @SequenceGenerator(name = "CalendarDate_Sequence", sequenceName = "My_CalendarDate_Sequence")
    @Id
    Long pk_id;
    Long service_id;
    Date date;
    Integer exception_type;

    public CalendarDate(Long service_id, Date date, Integer exception_type){
        this.service_id = service_id;
        this.date = date;
        this.exception_type = exception_type;
    }
}
