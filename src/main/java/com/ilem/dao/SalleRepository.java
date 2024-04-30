package com.ilem.dao;

import com.ilem.Entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface SalleRepository extends JpaRepository<Salle, Long> {
}
