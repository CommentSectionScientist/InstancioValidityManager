import org.assertj.core.api.Assertions;
import org.example.AbstractEntityData;
import org.example.Entity;
import org.instancio.Instancio;
import org.instancio.Select;
import org.junit.jupiter.api.Test;

public class EntityTest {
    @Test
    void validityManagerIsInitializedAndIgnoredByInstancio(){
        Entity entity = Instancio.of(Entity.class)
                .ignore(Select.field(AbstractEntityData.class, "validityManager"))
                .create();
        Assertions.assertThat(entity)
                .extracting(Entity::getDate)
                .isNotNull();
    }
    @Test
    void failsBecauseAnnotationFieldIsNull(){
        Entity entity = Instancio.of(Entity.class)
                                 .create();
        Assertions.assertThat(entity)
                  .extracting(Entity::getDate)
                  .isNotNull();
    }
}
