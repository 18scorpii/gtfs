package com.gtfs.repos.controller;

import com.gtfs.repos.model.CalendarDate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "services")
public interface CalendarDateRepo extends PagingAndSortingRepository<CalendarDate, Long> {
    @Query("from CalendarDate cd where cd.service_id = ?1")
    public List<CalendarDate> findByServiceId(Long serviceId);
}
