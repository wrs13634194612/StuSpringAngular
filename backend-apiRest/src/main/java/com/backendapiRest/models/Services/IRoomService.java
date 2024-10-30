package com.backendapiRest.models.Services;

import com.backendapiRest.models.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IRoomService {

    public List<Room> finAll();

    public Page<Room> finAll(Pageable pageable);

    public Room findById(Long id);

    public Room save(Room cliente);

    public void delete(Long id);

}
