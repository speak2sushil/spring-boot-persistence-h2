package com.ssingh.h2db.com.ssingh.h2db.springboot.daos;


import com.ssingh.h2db.springboot.models.TyrePart;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TyrePartRepository extends CrudRepository<TyrePart, Integer> {

    @Query("SELECT distinct t FROM TyrePart t INNER JOIN  t.indivisualTyre i")
    List<TyrePart> findAll();
}