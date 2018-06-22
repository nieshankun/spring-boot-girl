package com.imooc.girl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

    List<Girl> findByAge(Integer age);

    List<Girl> queryGirlsByAgeBetween(Integer minAge, Integer maxAge);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update girl set age=?1,cup_size=?2 where id = ?3", nativeQuery = true)
    void updateGirl(Integer age, String cupSize, Integer id);

    @Query(value = "select g.id, g.age,g.cup_size from girl g where g.age = ?1 and g.cup_size = ?2", nativeQuery = true)
    List<Girl> getGirlsByAgeAndCupSize(Integer age, String cupSize);
}
