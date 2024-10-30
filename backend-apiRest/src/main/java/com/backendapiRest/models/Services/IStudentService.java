package com.backendapiRest.models.Services;



import com.backendapiRest.models.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IStudentService {

    public List<Student> finAll();

    public Page<Student> finAll(Pageable pageable);

    public Student findById(Long id);

    public Student save(Student cliente);

    public void delete(Long id);

}
