
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

object recetas extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.XmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.XmlFormat.Appendable]](play.twirl.api.XmlFormat) with _root_.play.twirl.api.Template1[List[Receta],play.twirl.api.XmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(recetas: List[Receta]):play.twirl.api.XmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.25*/("""
"""),format.raw/*2.1*/("""<?xml version="1.0" encoding="utf-8" ?>
<recetas>
    """),_display_(/*4.6*/for(u <- recetas) yield /*4.23*/{_display_(Seq[Any](format.raw/*4.24*/("""
        """),_display_(/*5.10*/receta(u)),format.raw/*5.19*/("""
    """)))}),format.raw/*6.6*/("""
"""),format.raw/*7.1*/("""</recetas>
"""))
      }
    }
  }

  def render(recetas:List[Receta]): play.twirl.api.XmlFormat.Appendable = apply(recetas)

  def f:((List[Receta]) => play.twirl.api.XmlFormat.Appendable) = (recetas) => apply(recetas)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2021-03-06T01:34:30.313
                  SOURCE: E:/universidad/MASTER/cloud/recetas-app/app/views/recetas.scala.xml
                  HASH: 773f7d3efa85e2086743aba15b6aa156cb17843e
                  MATRIX: 909->1|1026->24|1054->26|1136->83|1168->100|1206->101|1243->112|1272->121|1308->128|1336->130
                  LINES: 27->1|32->1|33->2|35->4|35->4|35->4|36->5|36->5|37->6|38->7
                  -- GENERATED --
              */
          