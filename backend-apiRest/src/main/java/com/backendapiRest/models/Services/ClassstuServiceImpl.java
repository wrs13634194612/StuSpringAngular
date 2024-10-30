package com.backendapiRest.models.Services;



import com.backendapiRest.models.dao.IClassstuDao;
import com.backendapiRest.models.entity.Classstu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ClassstuServiceImpl implements IClassstuService{

    @Autowired
    private IClassstuDao   classstuDao;

    @Override
    @Transactional(readOnly = true)
    public List<Classstu> finAll() {
        return (List<Classstu>) classstuDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Classstu> finAll(Pageable pageable) {
        return classstuDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Classstu findById(Long id) {
        return classstuDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Classstu save(Classstu cliente) {
        return classstuDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        classstuDao.deleteById(id);
    }
}
