package com.am.cabbooking.repository;

import com.am.cabbooking.dao.ICabDao;
import com.am.cabbooking.entities.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICabRepository extends JpaRepository<Cab, Integer>, ICabDao {
	
}