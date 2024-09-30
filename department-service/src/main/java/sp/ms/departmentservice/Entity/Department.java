package sp.ms.departmentservice.Entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "department")
@NoArgsConstructor
@Setter
@Getter
// Create Department JPA Entity
public class Department {
    // GenerationType.UUID is a strategy in the Java Persistence API (JPA) used to generate primary keys for entities as Universally Unique Identifiers (UUIDs)
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
