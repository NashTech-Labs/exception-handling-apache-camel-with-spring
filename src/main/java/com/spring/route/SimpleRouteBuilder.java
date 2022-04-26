package com.spring.route;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import com.spring.exception.CamelCustomException;
import com.spring.processor.MyProcessor;

public class SimpleRouteBuilder extends RouteBuilder {
	
	/*
	 * (non-Javadoc)
	 * @see org.apache.camel.builder.RouteBuilder#configure()
	 * It is a SimpleRouteBuilder class which facilitates  Routes
	 */

    @Override
    public void configure() throws Exception {
    	
    	onException(CamelCustomException.class).process(new Processor() {

            public void process(Exchange exchange) throws Exception {
                System.out.println("handling ex");
            }
        }).log("Received body ").handled(true);
    	
    	from("file:/home/knoldus/Downloads/Softwares/Workspace/input?noop=true").process(new MyProcessor()).to("file:/home/knoldus/Downloads/Softwares/Workspace/output");
    	
        from("file:/home/knoldus/Downloads/Softwares/Workspace/New/input?noop=true").process(new MyProcessor()).to("file:/home/knoldus/Downloads/Softwares/Workspace/New/output");
        
    }

}
