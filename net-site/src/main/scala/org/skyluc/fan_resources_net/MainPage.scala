package org.skyluc.fan_resources_net

import org.skyluc.fan_resources.Common
import org.skyluc.fan_resources.data.Date
import org.skyluc.fan_resources.data.Path
import org.skyluc.fan_resources.html.DelayedElementCompiledDataSeq
import org.skyluc.fan_resources.html.DelayedMultimediaCompiledData
import org.skyluc.fan_resources.html.ElementCompiledData
import org.skyluc.fan_resources.html.LocalImageCopyCompiledData
import org.skyluc.fan_resources.html.PageDescription
import org.skyluc.fan_resources.html.SitePage
import org.skyluc.fan_resources.html.Url
import org.skyluc.fan_resources.html.component.Head
import org.skyluc.fan_resources.html.component.MediumCard
import org.skyluc.fan_resources.html.component.SectionHeader
import org.skyluc.html.*

import Html.*

object MainPage extends SitePage {

  override def description: PageDescription = new PageDescription {

    override val title: String = "Fan Resources Network"

    override val description: String = "A network of websites containing resources for fan of different music groups"

    override val image: Url = Url("/")

    override val canonicalUrl: Url = Url("/")

    override val ogType: String = "website"

    override val logo: Url = Url("missing") // TODO

    override val locale: String = Common.VALUE_LOCALE

    override val outputPath: Path = Path("index.html")

  }

  override def javascriptFiles(): Seq[Url] = Seq()

  override def headContent(): Seq[HeadElement[?]] =
    Head.css(
      Url(Path("asset", "css", "style.css")),
      Url(Path("asset", "css", "fr-style.css")),
    )

  override def headerContent(): Seq[BodyElement[?]] = Seq()

  override def mainContent(): Seq[BodyElement[?]] = Seq(
    SectionHeader.generate("What is the Fan Resources network ?"),
    p().appendElements(
      text(
        "The Fan Resources Network is a small, starting network of websites with the goal of providing comprehensive information and resources about one music group on each website."
      )
    ),
    p().appendElements(text("The current websites are:")),
    MediumCard.generateList(
      Seq(
        nekiData,
        babymetalData,
      )
    ),
    SectionHeader.generate("More music groups will be added ?"),
    p().appendElements(
      text("Yes. I have a couple of other groups I want to create websites for, soon.")
    ),
    p().appendElements(
      text(
        "And in the future, the plan is to open the platform to allow others to provide information about the music they support."
      )
    ),
  )

  // DATA

  val nekiData = ElementCompiledData(
    "neki",
    "&nbsp;",
    "NEK! Fan Resources",
    None,
    Some("4-piece punk/pop rock band"),
    None,
    None,
    Date.today,
    None,
    LocalImageCopyCompiledData(Url("/asset/image/site/neki/manekineko512.png"), "NEK! Fan Resources logo"),
    Nil,
    Url("https://neki-fan-resources.github.io/"),
    DelayedElementCompiledDataSeq.EMPTY,
    DelayedMultimediaCompiledData.EMPTY,
    Nil,
  )

  val babymetalData = ElementCompiledData(
    "neki",
    "&nbsp;",
    "BABYMETAL Fan Resources",
    None,
    Some("3 members kawaii metal singing and dancing unit"),
    None,
    None,
    Date.today,
    None,
    LocalImageCopyCompiledData(Url("/asset/image/site/babymetal/kitsume512.png"), "BABYMETAL Fan Resources logo"),
    Nil,
    Url("https://babymetal.fan-resources.net/"),
    DelayedElementCompiledDataSeq.EMPTY,
    DelayedMultimediaCompiledData.EMPTY,
    Nil,
  )

  override def footerContent(): Seq[BodyElement[?]] = Seq()

}
