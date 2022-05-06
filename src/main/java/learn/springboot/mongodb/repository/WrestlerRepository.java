package learn.springboot.mongodb.repository;

import learn.springboot.mongodb.entity.Wrestler;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WrestlerRepository extends MongoRepository<Wrestler, String> {

}
