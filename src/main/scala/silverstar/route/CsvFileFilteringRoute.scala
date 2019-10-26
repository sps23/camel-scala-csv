package silverstar.route

import org.apache.camel.builder.RouteBuilder
import silverstar.processor.LoggingProcessor

class CsvFileFilteringRoute extends RouteBuilder {

  override def configure(): Unit =
    from("file://input?noop=true")
//    from("file://D:\\Programowanie\\workspace\\camel-scala-csv\\input\\?noop=true")
      .split()
      .tokenize("\n")
      .streaming()
      .process(new LoggingProcessor())
      .to("file://output")
}
