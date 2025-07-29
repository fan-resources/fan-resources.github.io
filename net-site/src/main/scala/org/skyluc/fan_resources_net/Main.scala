package org.skyluc.fan_resources_net

import org.skyluc.fan_resources.data.Path
import org.skyluc.fan_resources.html.SiteOutput
import org.skyluc.fan_resources.html.pages.CssPage

object Main {
  def main(argv: Array[String]): Unit = {
    val pages = Seq(
      MainPage,
      CssPage(
        BASE_FR_CSS_PATH,
        Seq(
          Path("referenceunit.css"),
          Path("sitepage.css"),
          Path("maincontent.css"),
          Path("component", "coverimage.css"),
          Path("component", "mediumcard.css"),
        ),
        "fr-style.css",
      ),
      CssPage(
        BASE_SITE_CSS_PATH,
        Seq(
          Path("colors.css")
        ),
        "style.css",
      ),
    )

    SiteOutput.generate(pages, Seq(BASE_SITE_STATIC_PATH.asFilePath()), SITE_OUTPUT_PATH.asFilePath())
  }

  val CSS_SEGMENT = "css"
  val FR_SEGMENT = "fan-resources"
  val NET_SITE_SEGMENT = "net-site"
  val SITE_SEGMENT = "site"
  val STATIC_SEGMENT = "static"
  val STATIC_PIECES_SEGMENT = "static_pieces"
  val TARGET_SEGMENT = "target"

  val BASE_SITE_STATIC_PATH = Path(NET_SITE_SEGMENT, STATIC_SEGMENT)
  val BASE_SITE_CSS_PATH = Path(NET_SITE_SEGMENT, STATIC_PIECES_SEGMENT, CSS_SEGMENT)
  val BASE_FR_CSS_PATH = Path(FR_SEGMENT, STATIC_PIECES_SEGMENT, CSS_SEGMENT)

  val SITE_OUTPUT_PATH = Path(TARGET_SEGMENT, SITE_SEGMENT)
}
