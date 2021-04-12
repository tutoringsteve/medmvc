package com.sarasinsteven.medmvc.repositories;

import com.sarasinsteven.medmvc.domain.Disease;
import com.sarasinsteven.medmvc.domain.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD (Create, read, update, and delete) for example SQL Create = INSERT , read = SELECT, update = UPDATE, and delete = DELETE.
 * 	The Spring Data JPA will automatically setup all the methods in the interface that we are extending for us.
 */
public interface DiseaseRepository extends CrudRepository<Disease, Long> {
}
