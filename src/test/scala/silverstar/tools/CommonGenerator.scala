package silverstar.tools

import java.time.LocalDate
import java.util.UUID

import org.scalacheck.Gen
import silverstar.model.Employee

object CommonGenerator {

  val genLocaDate: Gen[LocalDate] = for {
    year <- Gen.choose(1, 50)
    day  <- Gen.choose(1, 365)
  } yield {
    LocalDate.now.minusYears(year).minusDays(day)
  }
  val genFirstName: Gen[String] = Gen.oneOf(
    Seq(
      "Jack",
      "James",
      "Noah",
      "Conor",
      "Daniel",
      "Harry",
      "Luke",
      "Michael",
      "Adam",
      "Charlie",
      "Liam",
      "Thomas",
      "Seán",
      "Fionn",
      "Oisín",
      "Alex",
      "Cillian",
      "Patrick",
      "Finn",
      "Tadhg",
      "Darragh",
      "Jamie",
      "Matthew",
      "Oliver",
      "Ryan",
      "Emily",
      "Grace",
      "Emma",
      "Sophie",
      "Amelia",
      "Ella",
      "Mia",
      "Ellie",
      "Ava",
      "Fiadh",
      "Hannah",
      "Anna",
      "Lucy",
      "Olivia",
      "Lily",
      "Chloe",
      "Aoife",
      "Kate",
      "Sadie",
      "Saoirse",
      "Sarah",
      "Sophia",
      "Holly",
      "Robyn",
      "Caoimhe"
    ))
  val genLastName: Gen[String] = Gen.oneOf(
    Seq(
      "O'Sullivan",
      "O'Brien",
      "O'Connor",
      "Murphy",
      "Kelly",
      "Walsh",
      "Smith",
      "Byrne",
      "Ryan",
      "O'Neill",
      "O'Reilly",
      "O'Doherty",
      "Doyle",
      "McCarthy",
      "Gallagher",
      "Kennedy",
      "Lynch",
      "Murray",
      "Quinn",
      "Moore"
    ))
  val genPlaceOfBirth: Gen[String] = Gen.oneOf(
    Seq(
      "Dublin",
      "Cork",
      "Limerick",
      "Galway",
      "Waterford",
      "Drogheda",
      "Swords",
      "Dundalk",
      "Bray",
      "Navan",
      "Kilkenny",
      "Ennis",
      "Carlow",
      "Tralee",
      "Newbridge",
      "Port",
      "Balbriggan",
      "Naas",
      "Athlone",
      "Mullingar",
      "Celbridge",
      "Wexford",
      "Letterkenny",
      "Sligo",
      "Greystones",
      "Clonmel",
      "Malahide",
      "Carrigaline",
      "Leixlip",
      "Tullamore"
    ))
  val genPosition: Gen[String] = Gen.oneOf(Seq("Permanent", "Temporary", "Manager", "Intern", "Contractor"))
  val genDepartment: Gen[String] =
    Gen.oneOf(Seq("Accounting", "Production", "Logistics", "Security", "Cleaning", "Management"))
  val genEmployee: Gen[Employee] = for {
    firstName        <- genFirstName
    lastName         <- genLastName
    dateOfEmployment <- genLocaDate
    dateOfBirth      <- genLocaDate
    placeOfBirth     <- genPlaceOfBirth
    position         <- genPosition
    department       <- genDepartment
  } yield {
    Employee(
      firstName        = firstName,
      lastName         = lastName,
      dateOfEmployment = dateOfEmployment,
      employeeId       = UUID.randomUUID(),
      dateOfBirth      = dateOfBirth,
      placeOfBirth     = placeOfBirth,
      position         = position,
      department       = department
    )
  }
}
