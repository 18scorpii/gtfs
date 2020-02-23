package com.gtfs.repos.service;

import com.gtfs.repos.controller.*;
import com.gtfs.repos.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataLoader {
    @Autowired
    private AgencyRepo agencyRepo;
    @Autowired
    private RouteRepo routeRepo;
    @Autowired
    private TripRepo tripRepo;
    @Autowired
    private ShapeRepo shapeRepo;
    @Autowired
    private CalendarDateRepo calendarDateRepo;

    private final DateFormat format = new SimpleDateFormat("yyyyMMdd");

    public void loadData() {
        loadRoutAgencyData();
        loadRouteData();
        loadShapeData();
        loadServiceData();
        loadTripData();
    }

    void loadRoutAgencyData(){
        try {
            List<Agency> data = Files.lines(Paths.get(getClass().getClassLoader().getResource("njt-data/agency.txt").toURI()))
                    .skip(1)
                    .map(line -> {
                        List<String> lineList = Arrays.asList(line.split("\\s*,\\s*")).stream()
                                .map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
                        Agency route = new Agency(lineList.get(0), lineList.get(1), lineList.get(2),
                                lineList.get(3), lineList.get(4), lineList.get(5));
                        return route;
                    }).collect(Collectors.toList());
            data.stream().forEach(agencyRepo::save);
            System.out.println("Completed loading agency data");
        }catch (Exception exp) {
            System.out.println("Error loading routes data : "+ exp.getMessage());
        }
    }


    void loadRouteData(){
        try {
            List<Route> data = Files.lines(Paths.get(getClass().getClassLoader().getResource("njt-data/routes.txt").toURI()))
                    .skip(1)
                    .map(line -> {
                        List<String> lineList = Arrays.asList(line.split("\\s*,\\s*")).stream()
                                .map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
                        Route route = new Route(Long.valueOf(lineList.get(0)), agencyRepo.findById(lineList.get(1)).get(), lineList.get(2),
                                lineList.get(3), lineList.get(4), lineList.get(5), lineList.get(6));
                        return route;
                    }).collect(Collectors.toList());
            data.stream().forEach(routeRepo::save);
            System.out.println("Completed loading route data");
        }catch (Exception exp) {
            System.out.println("Error loading routes data : "+ exp.getMessage());
        }
    }

    void loadShapeData(){
        try {
            List<Shape> data = Files.lines(Paths.get(getClass().getClassLoader().getResource("njt-data/shapes.txt").toURI()))
                    .skip(1)
                    .map(line -> {
                        List<String> lineList = Arrays.asList(line.split("\\s*,\\s*")).stream()
                                .map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
                        Shape shape = new Shape(Long.valueOf(lineList.get(0)), Double.valueOf(lineList.get(1)),
                                Double.valueOf(lineList.get(2)),Integer.valueOf(lineList.get(3)) , Float.valueOf(lineList.get(4)));
                        return shape;
                    }).collect(Collectors.toList());
            data.stream().forEach(shapeRepo::save);
            System.out.println("Completed loading shape data");
        }catch (Exception exp) {
            System.out.println("Error loading shape data : "+ exp.getMessage());
        }
    }

    void loadServiceData(){
        try {
            List<CalendarDate> data = Files.lines(Paths.get(getClass().getClassLoader().getResource("njt-data/calendar_dates.txt").toURI()))
                    .skip(1)
                    .map(line -> {
                        List<String> lineList = Arrays.asList(line.split("\\s*,\\s*")).stream()
                                .map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
                        Date dt = null;
                        try {
                            java.util.Date ut = format.parse(lineList.get(1));
                            dt = new java.sql.Date(ut.getTime());
                        }catch (Exception exp){
                            System.out.println("Error in parsing date field in CalendarDate.txt file");
                        }
                        CalendarDate calendarDate = new CalendarDate(Long.valueOf(lineList.get(0)), dt,
                                Integer.valueOf(lineList.get(2)));
                        return calendarDate;
                    }).collect(Collectors.toList());
            data.stream().forEach(calendarDateRepo::save);
            System.out.println("Completed loading service data");
        }catch (Exception exp) {
            exp.printStackTrace();
            System.out.println("Error loading service data : "+ exp.getMessage());
        }
    }

    void loadTripData(){
        try {
            List<Trip> data = Files.lines(Paths.get(getClass().getClassLoader().getResource("njt-data/trips.txt").toURI()))
                    .skip(1)
                    .map(line -> {
                        List<String> lineList = Arrays.asList(line.split("\\s*,\\s*")).stream()
                                .map(s -> s.replaceAll("\"", "")).collect(Collectors.toList());
                        Trip trip = new Trip(routeRepo.findById(Long.valueOf(lineList.get(0))).get(), calendarDateRepo.findByServiceId(Long.valueOf(lineList.get(1))), Long.valueOf(lineList.get(2)),
                                lineList.get(3), Integer.valueOf(lineList.get(4)), lineList.get(5), shapeRepo.findByShapeId(Long.valueOf(lineList.get(6))));
                        return trip;
                    }).collect(Collectors.toList());
            data.stream().forEach(tripRepo::save);
            System.out.println("Completed loading trip data");
        }catch (Exception exp) {
            System.out.println("Error loading trip data : "+ exp.getMessage());
        }
    }


}
