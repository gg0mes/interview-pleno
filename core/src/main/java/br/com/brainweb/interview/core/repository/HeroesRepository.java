package br.com.brainweb.interview.core.repository;


import br.com.brainweb.interview.core.model.Heroes;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroesRepository extends CrudRepository<Heroes, Long> {

    @Cacheable(cacheNames = "findHeroByUuidCache", cacheManager = "findHeroByUuidCache")
    @Query(value = "SELECT h.id, h.name, h.race, ps.strength, ps.agility, ps.dexterity, ps.intelligence \n" +
            "FROM hero as h \n" +
            "JOIN power_stats as ps \n" +
            "WHERE c.name = :name")
    Optional<Object> findHeroByUuid(@Param("heroUuid") String heroUuid);

    Optional<Object> delete(String heroUuid);

    @Cacheable(cacheNames = "findHeroByNameCache", cacheManager = "findHeroByNameCache")
    @Query(value = "SELECT h.id, h.name, h.race, ps.strength, ps.agility, ps.dexterity, ps.intelligence \n" +
            "FROM hero as h \n" +
            "JOIN power_stats as ps \n" +
            "WHERE c.name = :name")
    Optional<Object> findHeroByName(@Param("name") String name);



}



