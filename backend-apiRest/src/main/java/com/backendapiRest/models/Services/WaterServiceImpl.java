package com.backendapiRest.models.Services;





import com.backendapiRest.models.dao.IWaterDao;
import com.backendapiRest.models.entity.Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class WaterServiceImpl implements IWaterService    {

    @Autowired
    private IWaterDao waterDao;

    @Override
    @Transactional(readOnly = true)
    public List<Water> finAll() {
        return (List<Water>) waterDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Water> finAll(Pageable pageable) {
        return waterDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Water findById(Long id) {
        return waterDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Water save(Water cliente) {
        return waterDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        waterDao.deleteById(id);
    }
}
