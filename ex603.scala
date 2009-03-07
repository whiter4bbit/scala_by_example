//ex 6.0.3
abstract class Nat{
  def isZero: Boolean
  def predcessor: Nat
  def successor: Nat
  def + (that: Nat): Nat
  def - (that: Nat): Nat  
}

class Succ(x: Nat) extends Nat{
  def isZero: Boolean = false
  def predcessor: Nat = x
  def successor: Nat = new Succ(this)
  def + (that: Nat): Nat = x + that.successor
  def - (that: Nat): Nat = x - that.predcessor
}

object Zero extends Nat{
  def isZero: Boolean = true
  def predcessor: Nat = error("negative number")
  def successor: Nat = new Succ(Zero)
  def + (that: Nat): Nat = that
  def - (that: Nat): Nat = if (that.isZero) Zero
			   else error("negative number")
}

//--

/*
abstract class Integer{
  def isZero: Boolean
  def isPositive: Boolean
  def negate: Integer
  def predcessor: Integer
  def successor: Integer
  def + (that: Integer): Integer
  def - (that: Integer): Integer
}

class IPred(x: Integer) extends Integer{
  def isZero: Boolean = false
  def predcessor: Integer = new IPred(this)
  def successor: Integer = x
  def + (that: Integer): Integer = x + that.successor
  def - (that: Integer): Integer = x - that.predcessor
  var positive: Boolean = false
  def isPositive: Boolean = positive
  def negate: Integer = error("It's negated number")
}

class ISucc(x: Integer) extends Integer{
  def isZero: Boolean = false
  def predcessor: Integer = x
  def successor: Integer = new ISucc(this)
  def + (that: Integer): Integer = x + that.successor
  def - (that: Integer): Integer = x - that.predcessor
  var positive: Boolean = true
  def isPositive: Boolean = positive
  def negate: Integer = new IPred(x negate)
}


object IZero extends Integer{
  def isZero: Boolean = true
  def isPositive: Boolean = error("is zero!")
  def predcessor: Integer = new IPred(IZero)
  def successor: Integer = new ISucc(IZero)
  def + (that: Integer): Integer = that
  def - (that: Integer): Integer = that negate
  def negate: Integer = this
}
*/
