import utils._
import java.io.FileWriter

object Appl {
  def readWriteFile(fileName: String, destFileName: String): Unit = try {
    println("Opening the file...")
    val inFile = scala.io.Source.fromFile(fileName)
    try {
      for (line <- inFile.getLines) {
        val passwd: String = PasswordGenerator.nextPasswd(util.Random.nextInt(10) + 5)
        val fw = new FileWriter(destFileName, true)
        try {
          fw.write(line ++ ":" ++ passwd ++ "\n")
        }
        finally fw.close()
      }
    } finally {
      println("Closing the file...")
      inFile.close
    }
  } catch {
    case ex: java.io.FileNotFoundException => println(ex.getMessage)
    case ex: Throwable => println("Default exception handler: " + ex.getMessage)
  }

  def main(args: Array[String]) {
    readWriteFile("logins.txt", "login-passwds.txt")
  }
}