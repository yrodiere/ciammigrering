package se.hakuseki.ciam.migration;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import lombok.extern.apachecommons.CommonsLog;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.Separator;

import java.util.List;


/**
 * The type Migration resource.
 */
@Path("/api")
@ApplicationScoped
@CommonsLog
public class MigrationResource {

    /**
     * Find by customer id uni.
     *
     * @param customerId the customer id
     * @return the uni
     */
    @GET
    @Path("/customerId")
    @Produces(MediaType.APPLICATION_XML)
    public Uni<Accounts> findByCustomerId(@RestQuery String customerId) {
        return Accounts.findByCustomerId(customerId);
    }

    /**
     * Find by customer id uni.
     *
     * @param customerId the customer id
     * @return the uni
     */
    @GET
    @Path("/customerId/multi")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.TEXT_PLAIN)
    public Uni<Accounts[]> findByCustomerId(@RestQuery @Separator(",") List<String> customerId) {
        return Accounts.findByCustomerId( customerId ).onItem().transform( list -> list.toArray( Accounts[]::new ) );
    }

}


