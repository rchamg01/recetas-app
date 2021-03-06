
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

object receta extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[Receta,play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(receta: Receta):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.18*/("""
"""),format.raw/*2.1*/("""<receta>
    <nombre>"""),_display_(/*3.14*/receta/*3.20*/.getNombre),format.raw/*3.30*/("""</nombre>
    <tiempo>"""),_display_(/*4.14*/receta/*4.20*/.getTiempo),format.raw/*4.30*/("""</tiempo>
    <tipo>"""),_display_(/*5.12*/receta/*5.18*/.getTipo),format.raw/*5.26*/("""</tipo>
    """),_display_(/*6.6*/_usuario(receta.getUsuario)),format.raw/*6.33*/("""
    """),_display_(/*7.6*/descripcion(receta.getDescripcion)),format.raw/*7.40*/("""

    """),_display_(/*9.6*/ingredientes(receta.getIngredientes)),format.raw/*9.42*/("""

"""),format.raw/*11.1*/("""</receta>"""))
      }
    }
  }

  def render(receta:Receta): play.twirl.api.XmlFormat.Appendable = apply(receta)

  def f:((Receta) => play.twirl.api.XmlFormat.Appendable) = (receta) => apply(receta)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-06T01:33:56.159
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/receta.scala.xml
                  HASH: 4c0486a8973fc457fb2746009e43c1d33ad1cd47
                  MATRIX: 902->1|1012->17|1040->19|1089->42|1103->48|1133->58|1183->82|1197->88|1227->98|1275->120|1289->126|1317->134|1356->148|1403->175|1435->182|1489->216|1523->225|1579->261|1610->265
                  LINES: 27->1|32->1|33->2|34->3|34->3|34->3|35->4|35->4|35->4|36->5|36->5|36->5|37->6|37->6|38->7|38->7|40->9|40->9|42->11
                  -- GENERATED --
              */
          