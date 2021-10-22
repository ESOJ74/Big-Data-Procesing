
trait Analizador extends App {

  // Implementa la función en el objeto que extienda este trait.
  // ejercicio-10:
  //Al extender Analizador, pedirá que se implemente la función abstracta impimeContribuyentes,
  // la cual hará uso de la función imprimeDatos del companion object definido en el ejercicio 7.
  def imprimeContribuyentes(c: Seq[Contribuyente]): Unit = {
    print("Esta es la funcion imprimeContribuyentes. Hay que implementarla")
    for (n <- c) {
      println(s" workclass : ${n.workclass}, occupation : ${n.occupation}, nativeCountry :  ${n.nativeCountry}, income : ${n.income} ")
    }

    //$workclass - $occupation - $nativeCountry - $income
  }
}
