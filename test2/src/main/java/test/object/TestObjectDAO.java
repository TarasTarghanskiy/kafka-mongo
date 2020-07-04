package test.object;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.lang.annotation.Documented;

@Getter
@Setter
@NoArgsConstructor

public class TestObjectDAO {

    public TestObjectDAO(Long id, String string) {
        this.id = id;
        this.string = string;
    }

    private Long id;
    private String string;

}
