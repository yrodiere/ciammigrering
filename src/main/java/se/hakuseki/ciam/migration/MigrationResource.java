package se.hakuseki.ciam.migration;

import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.faulttolerance.api.AsynchronousNonBlocking;
import io.smallrye.faulttolerance.api.CircuitBreakerName;
import io.smallrye.faulttolerance.api.RateLimit;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.unchecked.Unchecked;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.lang3.StringUtils;
import org.apache.directory.api.ldap.model.password.PasswordUtil;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Bulkhead;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestQuery;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.Separator;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;
import se.arbetsformedlingen.ciam.migration.exceptions.UserMigratedException;
import se.arbetsformedlingen.ciam.migration.model.Accounts;
import se.arbetsformedlingen.ciam.migration.model.ResponseDTO;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


// tag::MigrationResource[]

/**
 * The type Migration resource.
 */
@Path("/api")
@ApplicationScoped
@CommonsLog
public class MigrationResource {

    // tag::findByCustomerId[]

    /**
     * Find by customer id uni.
     *
     * @param customerId the customer id
     * @return the uni
     */
    @GET
    @Path("/customerId")
    @RolesAllowed("ADMIN")
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
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.TEXT_PLAIN)
    public Uni<List<Accounts>> findByCustomerId(@RestQuery @Separator(",") List<String> customerId) {
        return Accounts.findByCustomerId(customerId);
    }
    // end::findByCustomerId[]
}
// end::MigrationResource[]
