
import io.swagger.converter.ModelConverters
import io.swagger.models.properties.{StringProperty, DoubleProperty, IntegerProperty}
import io.swagger.util.Json
import models._
import models.composition.Pet;
import io.swagger.models._
import io.swagger.models.properties._
import io.swagger.converter._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FlatSpec
import org.scalatest.Matchers


@RunWith(classOf[JUnitRunner])
class BeanValidatorTest extends FlatSpec with Matchers {
  it should "read bean validations" in {
    val schemas = ModelConverters.getInstance().readAll(classOf[BeanValidationsModel])
    val model = schemas.get("BeanValidationsModel")
    val properties = model.getProperties()

    val age = properties.get("age").asInstanceOf[IntegerProperty]
    age.getMinimum() should be (13.0)
    age.getMaximum() should be (99.0)

    val password = properties.get("password").asInstanceOf[StringProperty]
    password.getMinLength() should be (6)
    password.getMaxLength() should be (20)

    val minBalance = properties.get("minBalance").asInstanceOf[DoubleProperty]
    minBalance.getExclusiveMinimum().booleanValue() should be (true)

    val maxBalance = properties.get("maxBalance").asInstanceOf[DoubleProperty]
    maxBalance.getExclusiveMaximum().booleanValue() should be (true)
  }
}