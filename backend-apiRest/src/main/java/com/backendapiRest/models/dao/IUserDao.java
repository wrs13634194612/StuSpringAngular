package com.backendapiRest.models.dao;



import com.backendapiRest.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface IUserDao extends JpaRepository<User, Long> {


}
