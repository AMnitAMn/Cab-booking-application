package com.am.cabbooking.repository;

import com.am.cabbooking.dao.IDriverDao;
import com.am.cabbooking.entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("dDao")
public interface IDriverRepository extends JpaRepository<Driver, Integer>, IDriverDao {

}