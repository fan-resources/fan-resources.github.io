package org.skyluc.fan_resources_net

import org.skyluc.fan_resources.html.Url

object Site {
  val DOMAIN_NAME_FR = "fan-resources.net"

  val GOOGLE_VERIFICATION_CODE = "5DUf4g9lYSa_jzwy0JIrwsfTppM2uM5culgvgkbXj7U"
  val MICROSOFT_VERIFICATION_CODE = "B6C2BBE1BBDED01F740330EB10DEAEF8"

  def absoluteUrl(url: Url): Url =
    if (url.text.startsWith("http")) {
      url
    } else {
      if (url.text.startsWith("/")) {
        Url(Config.current.baseUrl, url.text.substring(1))
      } else {
        Url(Config.current.baseUrl, url.text)
      }
    }

}
