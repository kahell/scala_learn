package prelude
import org.apache.spark.sql.types._
import spray.json._
case class Field(Type: String)

object SchemaLoader{

  object MyJsonProtocol extends DefaultJsonProtocol {
    implicit val colorFormat = jsonFormat1(Field)
  }

  import MyJsonProtocol._
  var schemas: Map[String, StructType] = Map[String, StructType]()

  def load(path: String): Unit ={
    val json_content = scala.io.Source.fromFile(path).mkString
    val json_data = json_content.parseJson.convertTo[Map[String, Option[Map[String,Field]]]]

    val base = json_data("base").getOrElse(Map[String, Field]())
    val reserved = json_data("reserved").getOrElse(Map[String, Field]())

    val to_be_filled = json_data.filterKeys(key => {
      key != "base" && key != "reserved"
    })
    val new_map = to_be_filled map { case (event_name, fields) => (event_name, base ++ reserved ++ fields.getOrElse(Map[String, Field]()) ) }

    val result = new_map map { case (event_name, fields) =>
      var schema = new StructType()

      fields.keys.toList.sorted.foreach(field_name => {
        val _type = fields(field_name).Type
        val sqlType = _type match {
          case "int" => LongType
          case "boolean" => BooleanType
          case "float" => DoubleType
          case _ => StringType
        }
        schema = schema.add(field_name, sqlType)
      })
      (event_name, schema)
    }

    this.schemas = result

  }
}