
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

object receta extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template2[Receta,List[Ingrediente],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(receta: Receta, ingredientes: List[Ingrediente]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.51*/("""
"""),format.raw/*2.1*/("""<receta>
    <nombre>"""),_display_(/*3.14*/receta/*3.20*/.getNombre),format.raw/*3.30*/("""</nombre>
    <tiempo>"""),_display_(/*4.14*/receta/*4.20*/.getTiempo),format.raw/*4.30*/("""</tiempo>
    """),_display_(/*5.6*/for(u <- ingredientes) yield /*5.28*/ {_display_(Seq[Any](format.raw/*5.30*/("""
    """),_display_(/*6.6*/ingrediente(u)),format.raw/*6.20*/("""
    """)))}),format.raw/*7.6*/("""

"""),format.raw/*9.1*/("""</receta>"""))
      }
    }
  }

  def render(receta:Receta,ingredientes:List[Ingrediente]): play.twirl.api.XmlFormat.Appendable = apply(receta,ingredientes)

  def f:((Receta,List[Ingrediente]) => play.twirl.api.XmlFormat.Appendable) = (receta,ingredientes) => apply(receta,ingredientes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-01-31T19:11:53.960
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/receta.scala.xml
                  HASH: ff0f11d50a0f815affc4fefa15840ab09446a753
                  MATRIX: 920->1|1063->50|1091->52|1140->75|1154->81|1184->91|1234->115|1248->121|1278->131|1319->147|1356->169|1395->171|1427->178|1461->192|1497->199|1527->203
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3|35->4|35->4|35->4|36->5|36->5|36->5|37->6|37->6|38->7|40->9
                  -- GENERATED --
              */
          