package de.qaware.education.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/")
public class JaxRsApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(WorldController.class);
    }
}
