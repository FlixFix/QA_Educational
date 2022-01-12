package de.qaware.education.core;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;


public class RequestId implements Serializable {

    private String requestId;

    public void generateId() {
        requestId = UUID.randomUUID().toString();
    }

    public String getRequestId() {
        return requestId;
    }

}
