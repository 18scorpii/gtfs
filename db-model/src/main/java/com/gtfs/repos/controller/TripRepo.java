package com.gtfs.repos.controller;

import com.gtfs.repos.model.Trip;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "trips")
public interface TripRepo extends PagingAndSortingRepository<Trip, Long> {
}
