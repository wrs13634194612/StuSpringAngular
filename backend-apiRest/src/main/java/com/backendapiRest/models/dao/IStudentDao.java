package com.backendapiRest.models.dao;



import com.backendapiRest.models.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IStudentDao extends JpaRepository<Student, Long> {

}
