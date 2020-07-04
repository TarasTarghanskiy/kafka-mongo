package test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import test.object.TestObject;

import java.util.Optional;

@Repository
public interface TestObjectRepository extends MongoRepository<TestObject, Long> {
    @Override
    Optional<TestObject> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void deleteAll(Iterable<? extends TestObject> iterable);
}

