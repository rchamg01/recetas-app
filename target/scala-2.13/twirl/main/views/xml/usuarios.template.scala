
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

object usuarios extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Usuario],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(usuarios: List[Usuario]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.27*/("""
"""),format.raw/*2.1*/("""<usuarios>
    """),_display_(/*3.6*/for(u <- usuarios) yield /*3.24*/{_display_(Seq[Any](format.raw/*3.25*/("""
        """),_display_(/*4.10*/usuario(u)),format.raw/*4.20*/("""
    """)))}),format.raw/*5.6*/("""
"""),format.raw/*6.1*/("""</usuarios>"""))
      }
    }
  }

  def render(usuarios:List[Usuario]): play.twirl.api.XmlFormat.Appendable = apply(usuarios)

  def f:((List[Usuario]) => play.twirl.api.XmlFormat.Appendable) = (usuarios) => apply(usuarios)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-06T01:37:10.348
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/usuarios.scala.xml
                  HASH: ef26848cee5608cdaf705c9d920c1c6c94a027c4
                  MATRIX: 911->1|1030->26|1058->28|1100->45|1133->63|1171->64|1208->75|1238->85|1274->92|1302->94
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3|35->4|35->4|36->5|37->6
                  -- GENERATED --
              */
          