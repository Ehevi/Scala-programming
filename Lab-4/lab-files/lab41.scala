object Appl41 {
  import scala.annotation.tailrec

  def factorial(n: Int): Int = {
    assert(n >= 0)
    if (n == 0 || n == 1) 1
    else n * factorial(n - 1)
  }

  def factorialTailRec(n: Int): Int = {
    assert(n >= 0)
    @tailrec
    def goFrom(i: Int, acc: Int): Int = {
      if(i == 0 || i == 1) acc
      else goFrom(i - 1, i * acc)
    }
    goFrom(n, 1)
  }

  def fibb(n: Int): Int = {
    assert(n >= 0)
    if (n == 0 || n == 1) n
    else fibb(n - 2) + fibb(n - 1)
  }

  def fibbTailRec(n: Int): Int = {
    assert(n >= 0)
    @tailrec
    def goFrom(i: Int, prev: Int, current: Int): Int = {
      if(i == 0) current
      else goFrom(i - 1, prev + current, prev)
    }
    goFrom(n, 1, 0)
  }

  def main(args: Array[String]) {
    println("5! = " + factorial(5))
    println("5! = " + factorialTailRec(5))
    println("Fibb(10) = " + fibb(10))
    println("FibbTailRec(10) = " + fibbTailRec(10))
  }
}