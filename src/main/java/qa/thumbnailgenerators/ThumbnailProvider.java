package qa.thumbnailgenerators;

import org.reflections.Reflections;
import qa.enums.ThumbnailType;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class ThumbnailProvider {

    public static ThumbnailFactory getFactory(ThumbnailType type) {

        String packages = ThumbnailFactory.class.getPackage().getName();
        Reflections reflections = new Reflections(packages);

        Set<Class<? extends ThumbnailFactory>> factories = reflections.getSubTypesOf(ThumbnailFactory.class);

        Class<? extends ThumbnailFactory> inherited = factories
                .stream()
                .filter(factory -> factory.getName().toLowerCase().contains(type.getName().toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Could not find driver with name " + type.getName()));

        String inheritedClassName = inherited.getName();

        try {

            return (ThumbnailFactory) Class.forName(inheritedClassName).getConstructor().newInstance();

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {

            throw new IllegalStateException(e);
        }
    }
}
