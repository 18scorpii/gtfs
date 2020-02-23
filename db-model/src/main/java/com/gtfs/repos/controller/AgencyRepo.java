package com.gtfs.repos.controller;

import com.gtfs.repos.model.Agency;
import com.gtfs.repos.model.Route;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "agency")
public interface AgencyRepo extends PagingAndSortingRepository<Agency, String> {
}
