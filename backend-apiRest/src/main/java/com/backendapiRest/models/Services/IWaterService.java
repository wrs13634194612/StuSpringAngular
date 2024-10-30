package com.backendapiRest.models.Services;



import com.backendapiRest.models.entity.Water;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IWaterService {

    public List<Water> finAll();

    public Page<Water> finAll(Pageable pageable);

    public Water findById(Long id);

    public Water save(Water cliente);

    public void delete(Long id);

}
