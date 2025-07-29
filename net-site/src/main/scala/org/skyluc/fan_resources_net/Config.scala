package org.skyluc.fan_resources_net

case class Config(
    isLocal: Boolean,
    baseUrl: String,
)

object Config {
  private val localConfig = Config(true, "http://nebula:4201/")
  private val prodConfig = Config(false, "http://fan-resources.net/")

  var cached: Config = null

  def current: Config = {
    if (cached == null) {
      if (System.getenv(PROPERTY_KEY_CONFIG_KEY) == "PROD") {
        cached = prodConfig
      } else {
        cached = localConfig
      }
    }
    cached
  }

  // -------
  val PROPERTY_KEY_CONFIG_KEY = "CONFIG_KEY"
}
