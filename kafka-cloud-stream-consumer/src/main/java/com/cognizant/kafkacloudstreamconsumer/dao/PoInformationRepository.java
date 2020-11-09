package com.cognizant.kafkacloudstreamconsumer.dao;

import com.cognizant.kafkacloudstreamconsumer.model.PoInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoInformationRepository extends JpaRepository<PoInformation,Long> {
//      PoInformation findByPONumber(int poNumber);
}
