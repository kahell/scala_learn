package prelude

import org.apache.spark.sql.types._
import org.scalatest.{FunSuite, Matchers}

class SchemaLoaderTest extends FunSuite with Matchers {

  test("SchemaLoader is able to read schema_file and update the schema variable") {
    SchemaLoader.load("src/test/scala/resources/schema_dummy.json")
    val expected_abandoned_cart_schema = new StructType()
      .add("ad_id", StringType)
      .add("base_time", LongType)
      .add("bl_username", StringType)
      .add("browser", StringType)
      .add("browser_version", StringType)
      .add("cart_id", StringType)
      .add("credits_amount", LongType)
      .add("credits_expired_at", LongType)
      .add("credits_notes", StringType)
      .add("em", StringType)
      .add("evn", StringType)
      .add("identity", StringType)
      .add("ip_address", StringType)
      .add("platform", StringType)
      .add("request_id", StringType)
      .add("sdk", StringType)
      .add("server_time", LongType)
      .add("t", LongType)
      .add("td_app_ver", StringType)
      .add("td_app_ver_num", StringType)
      .add("td_board", StringType)
      .add("td_brand", StringType)
      .add("td_device", StringType)
      .add("td_display", StringType)
      .add("td_model", StringType)
      .add("td_os_type", StringType)
      .add("td_os_ver", StringType)
      .add("td_uuid", StringType)
      .add("ui", StringType)
      .add("user_agent", StringType)
      .add("user_variant", StringType)
      .add("visible", BooleanType)

    val expected_event_null_schema = new StructType()
      .add("ad_id", StringType)
      .add("base_time", LongType)
      .add("bl_username", StringType)
      .add("browser", StringType)
      .add("browser_version", StringType)
      .add("em", StringType)
      .add("evn", StringType)
      .add("identity", StringType)
      .add("ip_address", StringType)
      .add("platform", StringType)
      .add("request_id", StringType)
      .add("sdk", StringType)
      .add("server_time", LongType)
      .add("t", LongType)
      .add("td_app_ver", StringType)
      .add("td_app_ver_num", StringType)
      .add("td_board", StringType)
      .add("td_brand", StringType)
      .add("td_device", StringType)
      .add("td_display", StringType)
      .add("td_model", StringType)
      .add("td_os_type", StringType)
      .add("td_os_ver", StringType)
      .add("td_uuid", StringType)
      .add("ui", StringType)
      .add("user_agent", StringType)
      .add("visible", BooleanType)

    val actual = SchemaLoader.schemas
    print(actual)
    actual shouldEqual Map[String, StructType](
      "abandoned_cart_user_reward" -> expected_abandoned_cart_schema,
      "event_null" -> expected_event_null_schema
    )
  }
}