package com.olympus.platform.repository;

import com.olympus.platform.entity.RepresenterEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresenterRepository extends JpaRepository<RepresenterEntity, Long> {

  @Query(
      "SELECT w FROM RepresenterEntity w WHERE w.representerId IN (1, 2, 3, 4) ORDER BY w.representerId")
  List<RepresenterEntity> findFirstFourById();
}
