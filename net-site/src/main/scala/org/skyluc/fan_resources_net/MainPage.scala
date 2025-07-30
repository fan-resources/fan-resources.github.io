package org.skyluc.fan_resources_net

import org.skyluc.fan_resources.Common
import org.skyluc.fan_resources.data.Date
import org.skyluc.fan_resources.data.Path
import org.skyluc.fan_resources.html as fr
import org.skyluc.html.*

import fr.component.MediumCard
import fr.component.SectionHeader
import fr.component.Head as HeadComponents
import Html.*
import fr.Url
import fr.ElementCompiledData
import fr.LocalImageCopyCompiledData
import fr.DelayedElementCompiledDataSeq
import fr.DelayedMultimediaCompiledData
import fr.component.OpenGraphSection

object MainPage extends fr.SitePage {

  override def description = new fr.PageDescription {

    override val title: String = "Fan Resources Network"

    override val description: String = "A network of websites containing resources for fan of different music groups"

    override val image: Url = Site.absoluteUrl(Url("/fr512.png"))

    override val canonicalUrl: Url = Site.absoluteUrl(Url("/"))

    override val ogType: String = "website"

    override val logo: Url = Site.absoluteUrl(Url("/fr512.png"))

    override val locale: String = Common.VALUE_LOCALE

    override val outputPath: Path = Path("index.html")

  }

  override def javascriptFiles(): Seq[Url] = Seq()

  override def headContent(): Seq[HeadElement[?]] =
    Seq(
      HeadComponents.charsetUtf8,
      HeadComponents.googleFonts(fr.SitePage.HREF_GOOGLE_FONT_NOTO),
      HeadComponents.css(
        Url(Path("asset", "css", "style.css")),
        Url(Path("asset", "css", "fr-style.css")),
      ),
      HeadComponents.icons(description.logo),
      OpenGraphSection.generate(description),
      HeadComponents.statistics(Config.current.isLocal, Site.DOMAIN_NAME_FR),
    ).flatten

  // div tag
  val NAV_DIV = "nav"

  // class
  val CLASS_NAV_LOGO = "nav-logo"
  val CLASS_NAV_LOGO_IMG = "nav-logo-img"
  val CLASS_NAV_SITE_TITLE = "nav-site-title"

  // text
  val NAV_LOGO_ALT = "Fan Resources Network logo"
  val NAV_TITLE_TEXT = "Fan<br>Resources<br>Network"

  // URLs
  val NAV_LOGO_PATH = "/fr512.png"
  val ROOT_PATH = "/"

  override def headerContent(): Seq[BodyElement[?]] =
    Seq(
      a()
        .withHref(ROOT_PATH)
        .withClass(CLASS_NAV_LOGO)
        .appendElements(
          img()
            .withClass(CLASS_NAV_LOGO_IMG)
            .withSrc(NAV_LOGO_PATH)
            .withAlt(NAV_LOGO_ALT)
        ),
      div(NAV_DIV).appendElements(
        a()
          .withClass(CLASS_NAV_SITE_TITLE)
          .withHref(ROOT_PATH)
          .appendElements(
            text(NAV_TITLE_TEXT)
          )
      ),
    )

  override def mainContent(): Seq[BodyElement[?]] = Seq(
    SectionHeader.generate("What is the Fan Resources Network ?"),
    p().appendElements(
      text(
        "The Fan Resources Network is a small, starting network of websites with the goal of providing comprehensive information and resources on one music group."
      )
    ),
    p().appendElements(text("The current websites are:")),
    MediumCard.generateList(
      Seq(
        nekiData,
        babymetalData,
      )
    ),
    SectionHeader.generate("Will more music groups be added ?"),
    p().appendElements(
      text("Yes. I have a couple of other groups I want to create websites for, soon.")
    ),
    p().appendElements(
      text(
        "And in the future, the plan is to open the platform to allow others to provide information about the music groups they support."
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
