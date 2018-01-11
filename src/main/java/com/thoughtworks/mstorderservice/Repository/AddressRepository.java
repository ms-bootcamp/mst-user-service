package com.thoughtworks.mstorderservice.Repository;

import com.thoughtworks.mstorderservice.entity.Address;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(String userId);
}
