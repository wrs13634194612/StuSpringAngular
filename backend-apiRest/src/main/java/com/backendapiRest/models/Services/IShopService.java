package com.backendapiRest.models.Services;



import com.backendapiRest.models.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IShopService {

    public List<Shop> finAll();

    public Page<Shop> finAll(Pageable pageable);

    public Shop findById(Long id);

    public Shop save(Shop cliente);

    public void delete(Long id);

}
