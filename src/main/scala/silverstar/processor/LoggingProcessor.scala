package silverstar.processor

import org.apache.camel.{Exchange, Processor}

class LoggingProcessor extends Processor {
  override def process(exchange: Exchange): Unit = {
    val message = exchange.getIn().getBody[String](classOf[String])
    println(message.trim)
  }
}
