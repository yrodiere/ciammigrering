import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


/**
 * The type External migration application.
 */
@OpenAPIDefinition(
        tags = {
                @Tag(name = "pisa", description = "Operations related to migration of PISA users"),
                @Tag(name = "maintenance", description = "Operations related to maintenance")
        },
        info = @Info(
                title = "External Migration Application API",
                version = "1.0.0",
                contact = @Contact(
                        name = "Säk Tillgängliggöra API Support")
        )
)
public class ExternalMigrationApplication extends Application {
}
