package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import spittr.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcSpittleRepository implements SpittleRepository {

    private JdbcOperations jdbc;

    @Autowired
    public JdbcSpittleRepository(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Spittle> findRecentSpittles(int count) {
        return jdbc.query(
                "select id, message, time, latitude, longitude" +
                    " from Spittle" +
                    " order by time desc limit ?",
                new SpittleRowMapper(),
                count
        );
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return jdbc.query(
                "select id, message, time, latitude, longitude" +
                        " from Spittle" +
                        " where id < ?" +
                        " order by time desc limit ?",
                new SpittleRowMapper(),
                max,
                count
        );
    }

    @Override
    public Spittle findOne(long id) {
        return jdbc.queryForObject(
                "select id, message, time, latitude, longitude" +
                        " from Spittle" +
                        " where id = ?",
                new SpittleRowMapper(),
                id
        );
    }

    @Override
    public void save(Spittle spittle) {
        jdbc.update(
                "insert into Spittle (message, time, latitude, longitude)" +
                        " values (?, ?, ?, ?)",
                spittle.getMessage(),
                spittle.getTime(),
                spittle.getLatitude(),
                spittle.getLongitude()
        );
    }

    private static class SpittleRowMapper implements RowMapper<Spittle> {
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Spittle(
                    rs.getLong("id"),
                    rs.getString("message"),
                    rs.getDate("created_at"),
                    rs.getDouble("longitude"),
                    rs.getDouble("latitude"));
        }
    }
}
