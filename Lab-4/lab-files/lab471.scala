sealed abstract class Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) 
extends Expr

object ExprEval {
  def simplify(e: Expr): Expr = e match {
    case UnOp("+", Number(num)) => Number(num)
    case BinOp("+", Number(0), Number(num)) => Number(num)
    case UnOp("abs", el @ UnOp("abs", _)) => el
    case UnOp("abs", Number(num)) if(num >= 0) => Number(num)
    case UnOp("abs", Number(num)) if(num < 0) => Number(-num)
    case _ => e
  }
  def evaluate(e: Expr): Double = ExprEval.simplify(e) match {
    case Number(num) => num
    case BinOp("+", left, right) => evaluate(left) + evaluate(right)
    case BinOp("-", left, right) => evaluate(left) - evaluate(right)
    case _ => println("Unmatched expression!"); 0
  }
}
object Appl471 {
  def main(args: Array[String]) {
    import ExprEval._

    println(simplify(UnOp("+", Number(10))))
    println(simplify(BinOp("+", Number(0), Number(32))))
    println(evaluate(BinOp("+", BinOp("+", Number(1.5), Number(5.5)), Number(3))))
    println(evaluate(BinOp("+", BinOp("-", Number(11), Number(6)), Number(9))))
    println(simplify(UnOp("abs", UnOp("abs", Number(10)))))
    println(simplify(UnOp("abs", Number(10))))
    println(simplify(UnOp("abs", Number(-10))))
  }
}