
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

object _usuario extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Usuario,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(usuario: Usuario):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.20*/("""
"""),format.raw/*2.1*/("""<usuario>
    <nombre>"""),_display_(/*3.14*/usuario/*3.21*/.getNombre()),format.raw/*3.33*/("""</nombre>
</usuario>"""))
      }
    }
  }

  def render(usuario:Usuario): play.twirl.api.XmlFormat.Appendable = apply(usuario)

  def f:((Usuario) => play.twirl.api.XmlFormat.Appendable) = (usuario) => apply(usuario)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-02-23T17:35:54.856
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/usuario.scala.xml
                  HASH: 52406cbd9c93ad9ec141fbcc0d1d21d8560bcc8d
                  MATRIX: 905->1|1017->19|1045->21|1095->45|1110->52|1142->64
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3
                  -- GENERATED --
              */
          