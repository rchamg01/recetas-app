
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

object usuario extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Usuario,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(u: Usuario):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.14*/("""
"""),format.raw/*2.1*/("""<usuario>
    <nombre>"""),_display_(/*3.14*/u/*3.15*/.getNombre()),format.raw/*3.27*/("""</nombre>
</usuario>"""))
      }
    }
  }

  def render(u:Usuario): play.twirl.api.XmlFormat.Appendable = apply(u)

  def f:((Usuario) => play.twirl.api.XmlFormat.Appendable) = (u) => apply(u)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-06T01:37:10.341
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/usuario.scala.xml
                  HASH: 68cb404ba1b2d1b005d2d421d41fc92b1fbd2dc6
                  MATRIX: 904->1|1010->13|1038->15|1088->39|1097->40|1129->52
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3
                  -- GENERATED --
              */
          