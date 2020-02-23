package com.gtfs.repos.controller;

import com.gtfs.repos.model.Shape;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestResource(path = "shapes")
public interface ShapeRepo extends PagingAndSortingRepository<Shape, Long> {
    @Query("from Shape s where s.shape_id = ?1")
    public List<Shape > findByShapeId(Long shapeId);
}
