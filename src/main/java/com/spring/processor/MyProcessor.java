package com.spring.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import com.spring.exception.CamelCustomException;

public class MyProcessor implements Processor {
	
/*
 * (non-Javadoc)
 * @see org.apache.camel.Processor#process(org.apache.camel.Exchange)
 * It is Camel processor class which implements Processor
 */

    public void process(Exchange exchange) throws Exception {
        System.out.println("Exception Thrown");
        throw new CamelCustomException();
    }

}
	