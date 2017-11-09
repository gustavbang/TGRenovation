package dk.tg.renovation.models.services;

import dk.tg.renovation.models.entities.Oil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OilRepository implements ICrud<Oil> {

    @Autowired
    private JdbcTemplate jdbc;


    @Override
    public List<Oil> readAll() {
        return null;
    }

    @Override
    public Oil read(int cvr) {
        return null;
    }

    @Override
    public void create(Oil oil) {
        jdbc.update("INSERT INTO renovationdb.oil(size, amount, fk_CVR) " +
                "VALUES('" + oil.getSize() + "', '" + oil.getAmount() + "', '" + oil.getFkCVR() + "') ");
    }

    @Override
    public void delete(int cvr) {

    }

    @Override
    public void update(Oil oil) {

    }

}