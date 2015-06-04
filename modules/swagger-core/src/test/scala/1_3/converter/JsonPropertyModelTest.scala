package converter

import io.swagger.converter.ModelConverters
import models._

import io.swagger.converter._

import io.swagger.util._

import java.util.Date

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.Matchers

import matchers.SerializationMatchers._

@RunWith(classOf[JUnitRunner])
class JsonPropertyModelTest extends FlatSpec with Matchers {
  val models = ModelConverters.getInstance().read(classOf[ModelWithJsonProperty])
  models should serializeToJson (
"""{
  "ModelWithJsonProperty" : {
    "type":"object",
    "properties" : {
      "theCount" : {
        "type" : "integer",
        "format" : "int32"
      }
    }
  }
}""")
}
