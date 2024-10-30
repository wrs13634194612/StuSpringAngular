package com.backendapiRest.models.Services;



import com.backendapiRest.models.dao.IHolidayDao;
import com.backendapiRest.models.entity.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class HolidayServiceImpl implements IHolidayService  {

    @Autowired
    private IHolidayDao  holidayDao;

    @Override
    @Transactional(readOnly = true)
    public List<Holiday> finAll() {
        return (List<Holiday>) holidayDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Holiday> finAll(Pageable pageable) {
        return holidayDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Holiday findById(Long id) {
        return holidayDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Holiday save(Holiday cliente) {
        return holidayDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        holidayDao.deleteById(id);
    }
}
