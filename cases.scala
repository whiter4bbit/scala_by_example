abstract class Expr{
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr  
}

case class Number(n: Int) extends Expr{
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def numValue: Int = n
  def leftOp: Expr = error("Number.leftOp")
  def rightOp: Expr = error("Number.rigthOp")
}

case class Sum(e1: Expr, e2: Expr) extends Expr{
  def isNumber: Boolean = false
  def isSum: Boolean = true
  def numValue: Int = error("Sum.numValue")
  def leftOp: Expr = e1
  def rightOp: Expr = e2
}

def eval(e: Expr): Int = e match {
  case Number(x) => x
  case Sum(l, r) => eval(l) + eval(r)
}
