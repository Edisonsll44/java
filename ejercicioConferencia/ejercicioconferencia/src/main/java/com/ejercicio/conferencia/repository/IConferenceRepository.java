package com.ejercicio.conferencia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ejercicio.conferencia.data.models.Conference;

@Repository
public interface IConferenceRepository extends JpaRepository<Conference, Long>
{
    @Query("Select new Conference(c.description) from Conference c")
    List<Conference> findAll();


}