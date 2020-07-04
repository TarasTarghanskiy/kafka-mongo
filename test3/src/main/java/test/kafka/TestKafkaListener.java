package test.kafka;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import test.object.TestObject;
import test.object.TestObjectDAO;
import test.repository.TestObjectRepository;

import java.util.ArrayList;

@Service
public class TestKafkaListener {

    private TestObjectRepository testObjectRepository;

    public TestKafkaListener(TestObjectRepository testObjectRepository) {
        this.testObjectRepository = testObjectRepository;
    }

    @KafkaListener(topics = "TestTopic", groupId = "testGroup")
    public void consume(TestObjectDAO testObjectDAO) {
        testObjectRepository.save(new TestObject(testObjectDAO));
        System.out.println("save is " + testObjectDAO.getId() + " " + testObjectDAO.getString());
        testObjectRepository.findAll().forEach(e -> System.out.println(e.getString()));
    }
}


