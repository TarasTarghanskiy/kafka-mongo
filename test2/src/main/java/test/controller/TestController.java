package test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import test.object.TestObjectDAO;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("test")
public class TestController {

    private KafkaTemplate<String, TestObjectDAO> template;

    public TestController(KafkaTemplate<String, TestObjectDAO> template) {
        this.template = template;
    }

    @GetMapping("{test}")
    private ResponseEntity<TestObjectDAO> get(@PathVariable("message") String message, @PathParam("id") Long id) {
        TestObjectDAO testObjectDAO = new TestObjectDAO(id, message);
        template.send("TestTopic", testObjectDAO);
        return new ResponseEntity<>(testObjectDAO, HttpStatus.ACCEPTED);
    }

    @PostMapping()
    private ResponseEntity<TestObjectDAO> post(@RequestBody TestObjectDAO testObjectDAO) {
        template.send("TestTopic", testObjectDAO);
        return new ResponseEntity<>(testObjectDAO, HttpStatus.ACCEPTED);
    }
}
