package com.backendapiRest.models.Services;


import com.backendapiRest.models.entity.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IUserService {

    public List<User> finAll();

    public Page<User> finAll(Pageable pageable);

    public User findById(Long id);

    public User save(User cliente);

    public void delete(Long id);

}
