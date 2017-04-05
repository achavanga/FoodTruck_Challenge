package za.co.chavanga.camel;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.MultivaluedMap;
import org.codehaus.jackson.map.ObjectMapper;
import za.co.chavanga.camel.model.TruckData;

/**
 * File Name : GetData.java Project Name : SparkTest
 *
 * @since Apr 4, 2017, 9:45:36 PM
 * @author Abel Chavanga <achavanga@fnb.co.za>
 *
 */
public class GetData {

    public static TruckData getGETJSONConnection() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        WebResource resource = client.resource("https://data.sfgov.org/resource/6a9r-agq8.json");
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("status", "APPROVED");
        params.add("$$app_token", "5i36j9wyiU0itZ0gcdSCmLjNb");
        params.add("$q", "hot dogs");

        WebResource webResource = resource.queryParams(params);
        ClientResponse response = webResource.accept(APPLICATION_JSON)
                .type(APPLICATION_JSON)
                .get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        TruckData trucks = mapper.readValue(response.getEntity(String.class), TruckData.class);
        return trucks;
    }
}
