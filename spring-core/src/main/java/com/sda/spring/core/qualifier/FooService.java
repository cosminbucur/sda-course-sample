package com.sda.spring.core.qualifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    @Autowired
    @Qualifier("barFormatter")
    private Formatter formatter;

    // AOP aspect oriented programming
    // print 1
    public void run() {
        // print 2
        formatter.format();
    }
    // print 3
}
