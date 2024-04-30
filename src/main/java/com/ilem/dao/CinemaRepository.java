package com.ilem.dao;

import com.ilem.Entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
