abstract class IntTree{}

case object EmptyTree extends IntTree{}

case class Node(elem: Int, left: IntTree, right: IntTree) extends IntTree{}

def contains(t: IntTree, v: Int): Boolean = t match {
  case EmptyTree => false
  case Node(elem: Int, left: IntTree, right: IntTree) =>
    if (elem == v) true
    else if (v > elem) contains(right, v)
    else contains(left, v)
}

def insert(t: IntTree, v: Int): IntTree = t match {
  case EmptyTree => new Node(v, EmptyTree, EmptyTree)
  case Node(elem: Int, left: IntTree, right: IntTree) =>
    if (v>elem) new Node(elem, left, insert(right, v))
    else new Node(elem, insert(left, v), right)
}
