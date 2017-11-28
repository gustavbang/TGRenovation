package dk.tg.renovation.models.services;

import dk.tg.renovation.models.entities.Oil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OilRepository implements ICrud<Oil> {

    @Autowired
    private JdbcTemplate jdbc;
    private SqlRowSet sqlRowSet;


    @Override
    public List<Oil> readAll() {
        return null;
    }

    @Override
    public ArrayList<Oil> read(int cvr) {

        sqlRowSet = jdbc.queryForRowSet("SELECT * FROM renovationdb.oil WHERE fk_CVR=" + cvr);
        ArrayList<Oil> oil = new ArrayList<>();


        while(sqlRowSet.next()){
            oil.add(new Oil(sqlRowSet.getString("size"), sqlRowSet.getInt("amount")));
        }


        return oil;
    }

    // create metoden der bliver kaldt fra homecontrollleren.
    // Får et company ind i constructoren og får fat i værdierne med get metoder.
    // Indsætter ind i databasen med MySql
    @Override
    public void create(Oil oil) {
        jdbc.update("INSERT INTO renovationdb.oil(size, amount, fk_CVR) " +
                "VALUES('" + oil.getSize() + "', '" + oil.getAmount() + "', '" + oil.getFkCVR() + "') ");
    }

    @Override
    public void delete(int id) {
        jdbc.update("DELETE FROM renovationdb.oil WHERE id = " + id);
    }

    @Override
    public void update(Oil oil) {
        jdbc.update("UPDATE  renovationdb.oil SET size = '" + oil.getSize() + "', amount = '" + oil.getAmount() + "', fk_CVR = '" +
                oil.getFkCVR() + "' WHERE fk_CVR = " + oil.getFkCVR());
    }

}
