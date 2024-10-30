package com.backendapiRest.models.Services;



import com.backendapiRest.models.dao.IRepairDao;
import com.backendapiRest.models.entity.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RepairServiceImpl implements IRepairService    {

    @Autowired
    private IRepairDao repairDao;

    @Override
    @Transactional(readOnly = true)
    public List<Repair> finAll() {
        return (List<Repair>) repairDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Repair> finAll(Pageable pageable) {
        return repairDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Repair findById(Long id) {
        return repairDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Repair save(Repair cliente) {
        return repairDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repairDao.deleteById(id);
    }
}
