package silverstar.tools

import java.io.{BufferedWriter, File, FileWriter}
import java.time.LocalDate
import java.util.UUID

import org.scalactic.{Every, Good, Or}
import purecsv.safe._
import purecsv.safe.converter.{StringConverter, StringConverterUtils}
import silverstar.model.Employee
import silverstar.tools.CommonGenerator._

import scala.math.BigDecimal.RoundingMode.HALF_DOWN
import scala.util.Try

object CsvFileGenerator extends App {

  implicit val localDateConverter: StringConverter[LocalDate] =
    StringConverterUtils.mkStringConverter[LocalDate](s => Try(LocalDate.parse(s)), ld => stringc.to(ld.toString))
  implicit val uuidConverter: StringConverter[UUID] =
    StringConverterUtils.mkStringConverter[UUID](s => Try(UUID.fromString(s)), u => stringc.to(u.toString))

  def generateFile(name: String, numberOfRecords: Int): Or[File, Every[String]] = {

    val file: File                     = new File(s"input/$name")
    val fileWriter: FileWriter         = new FileWriter(file)
    val bufferedWriter: BufferedWriter = new BufferedWriter(fileWriter)

    bufferedWriter.write(Employee.header.mkString(",") + "\n")
    (1 to numberOfRecords).par.foreach(_ => {
      genEmployee.sample.foreach(employee => {
        bufferedWriter.write(employee.toCSV() + "\n")
      })
    })
    bufferedWriter.close()

    Good(file)
  }

  val fileOr = generateFile("test2.csv", numberOfRecords = 10000000)
  fileOr.foreach(f =>
    if (f.exists()) {
      val length: BigDecimal = BigDecimal.apply(f.length().toDouble / (1024 * 1024)).setScale(2, HALF_DOWN)
      println(s"File: ${f.getAbsolutePath}; size = $length MB")
  })
}
