package com.backendapiRest.models.dao;



import com.backendapiRest.models.entity.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IRepairDao extends JpaRepository<Repair, Long> {


}
