/*
 *  (c) 2013 FNB
 */
package za.co.camel;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

@Startup
@ApplicationScoped
public class TriggerProcessBuilder  {



    public void configure() throws Exception {

       CamelContext context = new DefaultCamelContext();

        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("quartz://report?cron=0 0/2 * * * ?")
                .setBody().simple("I was fired at ${header.fireTime}")
                .to("stream:out");
            }
        });

        // start the route and let it do its work
        context.start();


    }
}
