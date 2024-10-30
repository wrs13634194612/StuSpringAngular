package com.backendapiRest.models.Services;





import com.backendapiRest.models.dao.IShopDao;
import com.backendapiRest.models.entity.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ShopServiceImpl implements IShopService    {

    @Autowired
    private IShopDao   shopDao;

    @Override
    @Transactional(readOnly = true)
    public List<Shop> finAll() {
        return (List<Shop>) shopDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Shop> finAll(Pageable pageable) {
        return shopDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Shop findById(Long id) {
        return shopDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Shop save(Shop cliente) {
        return shopDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        shopDao.deleteById(id);
    }
}
