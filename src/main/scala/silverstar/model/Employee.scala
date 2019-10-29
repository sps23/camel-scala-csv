package silverstar.model

import java.time.LocalDate
import java.util.UUID

case class Employee(firstName: String,
                    lastName: String,
                    dateOfEmployment: LocalDate,
                    employeeId: UUID,
                    dateOfBirth: LocalDate,
                    placeOfBirth: String,
                    position: String,
                    department: String)

object Employee {

  val header: Seq[String] = Seq(
    "firstName",
    "lastName",
    "dateOfEmployment",
    "employeeId",
    "dateOfBirth",
    "placeOfBirth",
    "position",
    "department"
  )
}
