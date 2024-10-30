package com.backendapiRest.models.dao;



import com.backendapiRest.models.entity.Classstu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IClassstuDao extends JpaRepository<Classstu, Long> {


}
