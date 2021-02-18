
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
    <tipo>"""),_display_(/*5.12*/receta/*5.18*/.getTipo),format.raw/*5.26*/("""</tipo>
    """),_display_(/*6.6*/for(u <- ingredientes) yield /*6.28*/ {_display_(Seq[Any](format.raw/*6.30*/("""
    """),_display_(/*7.6*/ingrediente(u)),format.raw/*7.20*/("""
    """)))}),format.raw/*8.6*/("""

"""),format.raw/*10.1*/("""</receta>"""))
      }
    }
  }

  def render(receta:Receta,ingredientes:List[Ingrediente]): play.twirl.api.XmlFormat.Appendable = apply(receta,ingredientes)

  def f:((Receta,List[Ingrediente]) => play.twirl.api.XmlFormat.Appendable) = (receta,ingredientes) => apply(receta,ingredientes)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-02-17T17:40:54.222
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/receta.scala.xml
                  HASH: f7078fe834c3b3574c48f604e03fe6003ee700f5
                  MATRIX: 920->1|1063->50|1091->52|1140->75|1154->81|1184->91|1234->115|1248->121|1278->131|1326->153|1340->159|1368->167|1407->181|1444->203|1483->205|1515->212|1549->226|1585->233|1616->237
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3|35->4|35->4|35->4|36->5|36->5|36->5|37->6|37->6|37->6|38->7|38->7|39->8|41->10
                  -- GENERATED --
              */
          