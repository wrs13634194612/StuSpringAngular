package com.backendapiRest.models.dao;




import com.backendapiRest.models.entity.Water;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IWaterDao extends JpaRepository<Water, Long> {


}
