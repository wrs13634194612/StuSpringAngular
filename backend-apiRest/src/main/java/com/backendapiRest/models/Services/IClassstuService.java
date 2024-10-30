package com.backendapiRest.models.Services;


import com.backendapiRest.models.entity.Classstu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassstuService {

    public List<Classstu> finAll();

    public Page<Classstu> finAll(Pageable pageable);

    public Classstu findById(Long id);

    public Classstu save(Classstu cliente);

    public void delete(Long id);

}
