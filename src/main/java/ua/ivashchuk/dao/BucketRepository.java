package ua.ivashchuk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ivashchuk.domain.Bucket;

@Repository
public interface BucketRepository  extends JpaRepository<Bucket, Integer> {


}
