package com.backendapiRest.models.dao;




import com.backendapiRest.models.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IRoomDao extends JpaRepository<Room, Long> {


}
