package de.qaware.education.core;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;


@ApplicationScoped
public class RequestIdProducer {

    @Produces
    @SessionScoped
    public RequestId createRequestId(){
        RequestId requestId = new RequestId();
        requestId.generateId();
        return requestId;
    }
}
