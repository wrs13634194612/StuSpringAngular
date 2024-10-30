package com.backendapiRest.models.Services;



import com.backendapiRest.models.entity.User;

import com.backendapiRest.models.dao.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService    {

    @Autowired
    private IUserDao   userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> finAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> finAll(Pageable pageable) {
        return userDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public User save(User cliente) {
        return userDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userDao.deleteById(id);
    }
}
