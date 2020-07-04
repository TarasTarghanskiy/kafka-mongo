package test.object;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "test")
public class TestObject {
    public TestObject(Long id, String string) {
        this.id = id;
        this.string = string;
    }

    @Id
    private Long id;
    private String string;

    public TestObject(TestObjectDAO testObject) {
        id = testObject.getId();
        string = testObject.getString();
    }
}
