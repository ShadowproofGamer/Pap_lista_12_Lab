import scala.annotation.tailrec

object Generator:
  var id = 0
end Generator


case class Zwierzak(var gatunek:String, var imie:String, var rokUr:Int):
  override def toString: String = ""+gatunek+" "+imie+" "+rokUr
end Zwierzak


class Obora(var owner:String, var nrOfBoxes:Int):
  var nr = Generator.id
  Generator.id += 1
  var animals: List[Zwierzak] = List()
  def addAnimal(animal: Zwierzak): Unit = {
    if animals.length < nrOfBoxes then animals = animal :: animals
    else throw new Exception(s"cannot add new animals")
  }

  def removeAnimal(animal: Zwierzak):Unit = {
    @tailrec
    def removeAnimal_rec(listOfAnimals: List[Zwierzak], acc: List[Zwierzak]): List[Zwierzak] = {
      listOfAnimals match
        case Nil if (acc == animals) => throw new Exception(s"Nie ma takiego zwierzecia")
        case Nil => acc.reverse
        case hd :: tl if (hd == animal) => removeAnimal_rec(tl, acc)
        case hd :: tl => removeAnimal_rec(tl, hd :: acc)
    }
    animals = removeAnimal_rec(animals, List())
  }


  def showAnimals(): Unit = {
    println("\n"+"Obora nr "+nr+"\twłaściciel: "+owner+"\twielkość: "+nrOfBoxes)
    for (x <- animals) println(x)
  }

  def moveAnimal(obora: Obora, animal: Zwierzak): Unit = {
    removeAnimal(animal)
    obora.addAnimal(animal)
  }
end Obora


//var gen = new Generator()
var ob1 = new Obora("Maciej", 5)
var ob2 = new Obora("Paweł", 3)
var zw1 = Zwierzak("Krowa", "Mućka", 2022)
var zw2 = Zwierzak("Krowa", "M2", 2019)
var zw3 = Zwierzak("Krowa", "M3", 2021)
var zw4 = Zwierzak("Krowa", "M4", 2022)
var zw5 = Zwierzak("Kura", "Gdakacz", 2022)
var zw6 = Zwierzak("Kura", "Cichacz", 2022)

ob1.addAnimal(zw1)
ob1.addAnimal(zw2)
ob1.addAnimal(zw3)
ob1.addAnimal(zw4)
ob1.addAnimal(zw5)
ob1.addAnimal(zw6)


ob1.showAnimals()
ob2.showAnimals()
ob1.moveAnimal(ob2, zw5)
ob1.showAnimals()
ob2.showAnimals()

