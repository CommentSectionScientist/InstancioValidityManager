package org.example.spi;

import org.example.AbstractEntityData;
import org.example.ValidityManager;
import org.instancio.Random;
import org.instancio.generator.Generator;
import org.instancio.spi.InstancioServiceProvider;

public class InstancioServiceProviderImpl implements InstancioServiceProvider {

    @Override
    public GeneratorProvider getGeneratorProvider() {
        return (node, generators) -> {
            if (node.getTargetClass() == ValidityManager.class) {
                return new ValidityManagerGenerator(node.getParent().getTargetClass());
            }

            return null;
        };
    }

    record ValidityManagerGenerator(Class<?> targetClass) implements Generator<ValidityManager> {
        @Override
        public ValidityManager generate(Random random) {
            try {
                // assuming default constructor exists
                final AbstractEntityData data = (AbstractEntityData) targetClass.getDeclaredConstructor().newInstance();
                return new ValidityManager(data);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
