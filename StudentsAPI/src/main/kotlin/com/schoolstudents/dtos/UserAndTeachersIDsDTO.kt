import io.micronaut.serde.annotation.Serdeable
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Serdeable
@Entity
class UserAndTeachersIDsDTO(
    @Id
    val userId: Long,
    @Id
    val teacherId: Long
) {
}