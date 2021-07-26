package ua.ivashchuk.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ivashchuk.domain.Bucket;

public interface BucketRepository  extends JpaRepository<Bucket, Integer> {

}
