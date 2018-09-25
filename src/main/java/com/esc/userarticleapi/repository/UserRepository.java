package com.esc.userarticleapi.repository;

import com.esc.userarticleapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAgeGreaterThan(Integer age);

    List<User> findAllByIdIn(List<Integer> idList);

    @Query(value = "select distinct name from users where id in(:ids)", nativeQuery = true)
    List<String> getDistinctNamesByIdIn(@Param("ids") List<Integer> ids);
}
