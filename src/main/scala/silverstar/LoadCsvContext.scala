package silverstar

import org.apache.camel.main.Main
import silverstar.route.CsvFileFilteringRoute

object LoadCsvContext extends App {

  val camelMain = new Main
  camelMain.addRouteBuilder(new CsvFileFilteringRoute)
  camelMain.run()
}
