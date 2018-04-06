//package net.am.play.scala
//
//import org.specs2.Specification
//
//import scala.util.{Success, Try}
//import scala.util.{Either, Left, Right}
//
//class TempSpec extends Specification {
//
//  def is = s2"""
//      asdf $fasdf
//    """
//
//  def fasdf = {
//    case class Employee(name: String, department: String, manager: Option[String])
//    def lookupByName(name: String): Option[Employee] = name match {
//      case "Joe" => Some(Employee("Joe", "Finances", Some("Julie")))
//      case "Mary" => Some(Employee("Mary", "IT", None))
//      case _ => None
//    }
//
//    /**
//      * We can look for our employees, and try to obtain their departments. We will assume that we won't find any errors,
//      * and if it's the case, we don't have to worry as the computation will end there. Try to use `map` on the result of
//      * calling `lookupByName` to create a function to obtain the department of each employee. Hint: to access the
//      * optional employee, use Scala's underscore notation. i.e.:
//      *
//      * _.getOrElse(Employee("John", "Doe", None))
//      *
//      * Employee is defined as:
//      *
//      * case class Employee(name: String, department: String, manager: Option[String])
//      */
//
////    def getDepartment: (Option[Employee]) => Option[String] = (emp:Option[Employee]) => {emp map (_.department)}
//    def getDepartment: (Option[Employee]) => Option[String] = _ map (_.department)
//
//
//    getDepartment(lookupByName("Joe")) === Some("Finances")
//    getDepartment(lookupByName("Mary")) === Some("IT")
//    getDepartment(lookupByName("Foo")) === None
//
////    def getManager: (Option[Employee]) => Option[String] = _ flatMap (_.manager)
////
////
////    getManager(lookupByName("Joe")) === Some("Julie")
////    getManager(lookupByName("Mary")) === None
////    getManager(lookupByName("Foo")) === None
//
//    def getManager(employee: Option[Employee]): Option[String] = employee.flatMap(_.manager)
//
//    getManager(lookupByName("Joe")).orElse(Some("Mr. CEO")) === Some("Julie")
//
//    getManager(lookupByName("Mary")).orElse(Some("Mr. CEO")) === Some("Mr. CEO")
//
//    getManager(lookupByName("Foo")).orElse(Some("Mr. CEO")) === Some("Mr. CEO")
//
//    lookupByName("Joe").filter(_.department != "IT") === Some(Employee("Joe", "Finances", Some("Julie")))
//
//    lookupByName("Mary").filter(_.department != "IT") === None
//
//    lookupByName("Foo").filter(_.department != "IT") === None
//
//    def map2[A, B, C](a: Option[A], b: Option[B])(f: (A, B) => C): Option[C] =
//      a flatMap (aa => b map (bb => f(aa, bb)))
//
//
//    def traverse[A, B](a: List[A])(f: A => Option[B]): Option[List[B]] = a match {
//      case Nil => Some(Nil)
//      case h :: t => map2(f(h), traverse(t)(f))(_ :: _)
//    }
//    def sequenceViaTraverse[A](a: List[Option[A]]): Option[List[A]] = traverse(a)(x => x)
//
//    val list1 = List("1", "2", "3")
//    val list2 = List("I", "II", "III", "IV")
//
//    def parseInt(a: String): Option[Int] = Try(a.toInt) match {
//      case Success(r) => Some(r)
//      case _ => None
//    }
//
//    traverse(list1)(i => parseInt(i)) === Some(List(1,2,3))
//
//    traverse(list2)(i => parseInt(i)) === None
//
//    def lookupByNameViaEither(name: String): Either[String, Employee] = name match {
//      case "Joe" => Right(Employee("Joe", "Finances", Some("Julie")))
//      case "Mary" => Right(Employee("Mary", "IT", None))
//      case _ => Left("Employee not found")
//    }
//
////    def map[B](f: A => B): Either[E, B] = this match {
////      case Right(a) => Right(f(a))
////      case Left(e) => Left(e)
////    }
//
////    def map[B](f: A => B): Either[E, B] = this match {
////      case Right(a) => Right(f(a))
////      case Left(e) => Left(e)
////    }
//
//    def getManager(employee: Either[String, Employee]): Either[String, String] = employee.flatMap(e =>
//      e.manager match {
//        case Some(e) => Right(e)
//        case _ => Left("Manager not found")
//      })
//
//    getManager(lookupByNameViaEither("Joe")).orElse(Right("Mr. CEO")) === Right("Julie")
//
//    getManager(lookupByNameViaEither("Mary")).orElse(Right("Mr. CEO")) === "Mr. CEO"
//
//    getManager(lookupByNameViaEither("Foo")).orElse(Right("Mr. CEO")) === "Mr. CEO"
//
//
//  }
//
//  def fold[A, B](t: Tree[A])(f: A => B)(g: (B, B) => B): B = t match {
//    case Leaf(a) => f(a)
//    case Branch(l, r) => g(fold(l)(f)(g), fold(r)(f)(g))
//  }
//
//  sealed trait Tree[+A]
//  case class Leaf[A](value: A) extends Tree[A]
//  case class Branch[A](left: Tree[A], right: Tree[A]) extends Tree[A]
//
//}
