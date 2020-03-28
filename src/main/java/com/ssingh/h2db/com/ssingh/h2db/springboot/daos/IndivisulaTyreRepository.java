package com.ssingh.h2db.com.ssingh.h2db.springboot.daos;


import com.ssingh.h2db.springboot.models.IndivisualTyre;
import com.ssingh.h2db.springboot.models.TyrePart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IndivisulaTyreRepository extends CrudRepository<IndivisualTyre, Integer> {
}