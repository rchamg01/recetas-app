
package views.xml

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.xml._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object ingrediente extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Ingrediente,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ingrediente: Ingrediente):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*2.1*/("""<ingrediente>
    <nombre>"""),_display_(/*3.14*/ingrediente/*3.25*/.getNombre()),format.raw/*3.37*/("""</nombre>
</ingrediente>"""))
      }
    }
  }

  def render(ingrediente:Ingrediente): play.twirl.api.XmlFormat.Appendable = apply(ingrediente)

  def f:((Ingrediente) => play.twirl.api.XmlFormat.Appendable) = (ingrediente) => apply(ingrediente)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-02-23T17:35:54.700
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/ingrediente.scala.xml
                  HASH: 64cdb0f40fad567c039bef4e3abfd926ffd3b482
                  MATRIX: 912->1|1032->27|1060->29|1114->57|1133->68|1165->80
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3
                  -- GENERATED --
              */
          