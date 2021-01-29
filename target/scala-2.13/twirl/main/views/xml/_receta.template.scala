
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

object _receta extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Receta,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(receta: Receta):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*2.1*/("""<receta>
    <nombre>"""),_display_(/*3.14*/receta/*3.20*/.getNombre),format.raw/*3.30*/("""</nombre>
    <tiempo>"""),_display_(/*4.14*/receta/*4.20*/.getTiempoPreparacion),format.raw/*4.41*/("""</tiempo>
</receta>"""))
      }
    }
  }

  def render(receta:Receta): play.twirl.api.XmlFormat.Appendable = apply(receta)

  def f:((Receta) => play.twirl.api.XmlFormat.Appendable) = (receta) => apply(receta)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-28T18:57:09.328
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/_receta.scala.xml
                  HASH: e0b1a929005507fd674bfa90214ebc7c2fcaff88
                  MATRIX: 903->1|1013->17|1041->19|1090->42|1104->48|1134->58|1184->82|1198->88|1239->109
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3|35->4|35->4|35->4
                  -- GENERATED --
              */
          