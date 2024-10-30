package com.backendapiRest.models.Services;



import com.backendapiRest.models.entity.Repair;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IRepairService {

    public List<Repair> finAll();

    public Page<Repair> finAll(Pageable pageable);

    public Repair findById(Long id);

    public Repair save(Repair cliente);

    public void delete(Long id);

}
