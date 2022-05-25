package com.am.cabbooking.repository;

import com.am.cabbooking.dao.IAdminDao;
import com.am.cabbooking.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("aDao")
public interface IAdminRepository extends JpaRepository<Admin, Integer>, IAdminDao {
	
}