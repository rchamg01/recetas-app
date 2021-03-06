
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

object descripcion extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Descripcion,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(descripcion: Descripcion):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.28*/("""
"""),format.raw/*2.1*/("""<descripcion>
    <texto>"""),_display_(/*3.13*/descripcion/*3.24*/.getTexto()),format.raw/*3.35*/("""</texto>
</descripcion>"""))
      }
    }
  }

  def render(descripcion:Descripcion): play.twirl.api.XmlFormat.Appendable = apply(descripcion)

  def f:((Descripcion) => play.twirl.api.XmlFormat.Appendable) = (descripcion) => apply(descripcion)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-06T00:16:32.763
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/descripcion.scala.xml
                  HASH: eab5fc28c9efb52cb56f4398363d7b80407a9f05
                  MATRIX: 912->1|1032->27|1060->29|1113->56|1132->67|1163->78
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3
                  -- GENERATED --
              */
          