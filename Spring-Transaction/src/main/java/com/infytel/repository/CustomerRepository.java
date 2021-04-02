package com.infytel.repository;

import com.infytel.entity.Customer;
import com.infytel.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // method to update a customer record int ot the db
    @Transactional
    @Modifying
    @Query(value = "update Customer set plan_name = ? " + " where phone_No = ?", nativeQuery = true)
    public void customerUpdate(Plan plan, long phoneNumber);

}
