package com.backendapiRest.models.dao;



import com.backendapiRest.models.entity.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IHolidayDao extends JpaRepository<Holiday, Long> {


}
