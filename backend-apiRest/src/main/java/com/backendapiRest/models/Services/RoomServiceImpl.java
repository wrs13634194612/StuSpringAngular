package com.backendapiRest.models.Services;



import com.backendapiRest.models.dao.IRoomDao;
import com.backendapiRest.models.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService  {

    @Autowired
    private IRoomDao holidayDao;

    @Override
    @Transactional(readOnly = true)
    public List<Room> finAll() {
        return (List<Room>) holidayDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Room> finAll(Pageable pageable) {
        return holidayDao.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Room findById(Long id) {
        return holidayDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Room save(Room cliente) {
        return holidayDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        holidayDao.deleteById(id);
    }
}
