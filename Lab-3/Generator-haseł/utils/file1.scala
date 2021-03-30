package utils

object PasswordGenerator {
  private val allowedChars = (('0' to '9') ++ ('A' to 'Z') ++ ('a' to 'z')).toArray ++ Array('$', '-', '.', '_')
  private val allowedCharsLen = allowedChars.length

  def nextPasswd(passwdLen: Int): String = {
    val passwd = new StringBuilder(passwdLen)
    for (i <- 0 to allowedCharsLen) passwd += nextChar
    passwd.toString
  }

  private def nextChar: Char = {
    allowedChars(util.Random.nextInt(allowedCharsLen))
  }
}