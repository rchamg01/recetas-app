
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

object ingredientes_ extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Ingrediente],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(ingredientes: List[Ingrediente]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.35*/("""
"""),format.raw/*2.1*/("""<ingredientes>
    """),_display_(/*3.6*/for(u <- ingredientes) yield /*3.28*/{_display_(Seq[Any](format.raw/*3.29*/("""
        """),_display_(/*4.10*/ingrediente(u)),format.raw/*4.24*/("""
    """)))}),format.raw/*5.6*/("""
"""),format.raw/*6.1*/("""</ingredientes>"""))
      }
    }
  }

  def render(ingredientes:List[Ingrediente]): play.twirl.api.XmlFormat.Appendable = apply(ingredientes)

  def f:((List[Ingrediente]) => play.twirl.api.XmlFormat.Appendable) = (ingredientes) => apply(ingredientes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-06T01:32:53.112
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/ingredientes.scala.xml
                  HASH: 00dc9d5d973198faf3f0865dc37c84a146d82bd9
                  MATRIX: 920->1|1047->34|1075->36|1121->57|1158->79|1196->80|1233->91|1267->105|1303->112|1331->114
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3|35->4|35->4|36->5|37->6
                  -- GENERATED --
              */
          