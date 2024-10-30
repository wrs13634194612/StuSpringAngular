package com.backendapiRest.models.Services;


import com.backendapiRest.models.entity.Holiday;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IHolidayService {

    public List<Holiday> finAll();

    public Page<Holiday> finAll(Pageable pageable);

    public Holiday findById(Long id);

    public Holiday save(Holiday cliente);

    public void delete(Long id);

}
