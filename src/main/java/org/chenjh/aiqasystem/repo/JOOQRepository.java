package org.chenjh.aiqasystem.repo;

/**
 * @author hjong
 * @date 2025−01−13
 */
import java.util.List;
import java.util.Optional;

public interface JOOQRepository<T> {

    T save(T tablePojo);

    T update(T tablePojo, int id);

    List<T> findAll();

    Optional<T> findById(long id);

    boolean deleteById(int id);
}