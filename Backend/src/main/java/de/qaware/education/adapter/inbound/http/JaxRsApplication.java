package de.qaware.education.adapter.inbound.http;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api")
public class JaxRsApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(WorldController.class, UserController.class);
    }
}
