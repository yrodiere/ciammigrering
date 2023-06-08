package se.hakuseki.ciam.migration;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.QueryHint;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// tag::Accounts[]

/**
 * The type Accounts.
 */
@Entity
@Cacheable
@Getter
@Setter
@ToString
@RegisterForReflection
@NamedQueries({
        @NamedQuery(name = "Accounts.getByCustomerId", query = "from Accounts where agasCustomerNumber = ?1", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
})
public class Accounts extends PanacheEntity {
    /**
     * The Uuid.
     */
    @Column(name = "pisa_uid", updatable = false)
    UUID pisaUid;
    /**
     * The User name.
     */
    @Column(name = "username", updatable = false)
    String userName;
    /**
     * The Person number.
     */
    @Column(name = "personnumber", updatable = false)
    String personNumber;
    /**
     * The First name.
     */
    @Column(name = "first_name", updatable = false)
    String firstName;
    /**
     * The Last name.
     */
    @Column(name = "last_name", updatable = false)
    String lastName;
    /**
     * The Email.
     */
    @Column(updatable = false)
    String email;
    /**
     * The Password.
     */
    @Column(updatable = false)
    String password;
    /**
     * The Customer number.
     */
    @Column(name = "customernumber", updatable = false)
    String customerNumber;
    /**
     * The Company customer number.
     */
    @Column(name = "companycustomernumber", updatable = false)
    String companyCustomerNumber;
    /**
     * The Organisation customer number.
     */
    @Column(name = "customernumberorganisation", updatable = false)
    String organisationCustomerNumber;
    /**
     * The Migration state.
     */
    @Column(name = "migration_state")
    boolean migrationState;
    /**
     * The Imported timestamp.
     */
    @Column(name = "imported_timestamp", updatable = false)
    LocalDateTime importedTimestamp;
    /**
     * The Migrated timestamp.
     */
    @Column(name = "migrated_timestamp")
    OffsetDateTime migratedTimestamp;

    /**
     * The Customer number ag.
     */
    @Column(name = "agas_customernumber", updatable = false)
    String agasCustomerNumber;

    /**
     * The Last login.
     */
    @Column(name = "last_login", updatable = false)
    LocalDateTime lastLogin;



    /**
     * Find by customer id uni.
     *
     * @param customerId the customer id
     * @return the uni
     */
    public static Accounts findByCustomerId(String customerId) {
        return find("#Accounts.getByCustomerId", customerId).singleResult();
    }

    /**
     * Find by customer id uni.
     *
     * @param customerId the customer id
     * @return the uni
     */
    public static List<Accounts> findByCustomerId(List<String> customerId) {
        return find("agasCustomerNumber in :vals ", Parameters.with("vals", customerId)).list();
    }
}
// end::Accounts[]
