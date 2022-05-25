package com.am.cabbooking.repository;

import com.am.cabbooking.dao.ICustomerDao;
import com.am.cabbooking.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cDao")
public interface ICustomerRepository extends JpaRepository<Customer, Integer>, ICustomerDao {

}