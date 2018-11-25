package spittr.data;

import spittr.Spittle;

import java.util.List;

public interface SpittleRepository {

    /**
     * List spittles that are most recently active
     * @return a list of spittles
     */
    List<Spittle> findRecentSpittles();

    /**
     * List a number of spittles that have is less than max
     * @param max maximum id of any spittle that should be returned
     * @param count the number of spittles that should be returned
     * @return a list of spittles
     */
    List<Spittle> findSpittles(long max, int count);

    /**
     * Find a specific spittle by its id
     * @param id id of the needed spittle
     * @return the spittle
     */
    Spittle findOne(long id);

    /**
     * Save spittle into the data repository
     * @param spittle the spittle that should be saved
     */
    void save(Spittle spittle);
}
