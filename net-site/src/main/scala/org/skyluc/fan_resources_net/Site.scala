package org.skyluc.fan_resources_net

import org.skyluc.fan_resources.html.Url

object Site {
  val DOMAIN_NAME_FR = "fan-resources.net"

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
