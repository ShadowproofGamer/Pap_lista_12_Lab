class Generator():
  var i = 0
  def returnNumber():Int =
    {
      i+=1
      (i-1)
    }

class Zwierzak(gatunek:String, imie:String, rokUr:Int):
  val gat = gatunek
  val im = imie
  val rok = rokUr
  override def toString: String = ""+gat+" "+im+" "+rok+"\n"

class Obora(owner:String, nrOfBoxes:Int, generator: Generator):
  var nr = generator.returnNumber()
  var ow = owner
  var boxes = nrOfBoxes
  var animals = new Array[Zwierzak](0)
  def addAnimal(animal: Zwierzak): Unit = {
    if animals.length < nrOfBoxes then animals:+animal
    else throw new Exception(s"cannot add new animals")
  }
  /*
  def removeAnimal(imie:String): Unit = {
    var i = 0
    var newAnimals:Array[Zwierzak] = new Array[Zwierzak](nrOfBoxes)
    for (x <- animals)
    {
      if x.im != imie then newAnimals :+ x
      i+=1
    }
    animals = newAnimals
  }*/

  def removeAnimal(gatunek: String): Unit = {
    var done = false
    var i = 0
    var newAnimals: Array[Zwierzak] = new Array[Zwierzak](nrOfBoxes)
    for (x <- animals) {
      if x.gat != gatunek then newAnimals :+ x
      else done = true
      i += 1
    }
    animals = newAnimals
    if (!done) throw new Exception(s"couldn't find and remove animal")
  }
  def showAnimals(): Unit = for (x <- animals) print(x)
  def moveAnimal(obora: Obora, imie:String):Unit =
    {
      var done = false
      var i = 0
      var newAnimals: Array[Zwierzak] = new Array[Zwierzak](nrOfBoxes)
      for (x <- animals) {
        if x.im != imie then newAnimals :+ x
        else if(!done)
          {
            obora.addAnimal(x)
            removeAnimal(x.im)
            done = true
          }
        i += 1
      }
      if !done then throw new Exception(s"couldn't find and move animal")
    }

var gen = new Generator()
var ob1 = new Obora("Maciej", 5, gen)
var ob2 = new Obora("Paweł", 3, gen)

ob1.addAnimal(new Zwierzak("Krowa", "Mućka", 2022))
ob1.addAnimal(new Zwierzak("Krowa", "M2", 2022))
ob1.addAnimal(new Zwierzak("Krowa", "M3", 2022))
ob1.addAnimal(new Zwierzak("Krowa", "M4", 2022))
ob1.addAnimal(new Zwierzak("Kura", "Gdakacz", 2022))
ob1.addAnimal(new Zwierzak("Kura", "Cichacz", 2022))

print(Zwierzak("Krowa", "Mućka", 2022))
ob1.showAnimals()
ob2.showAnimals()
ob1.moveAnimal(ob2, "Gdakacz")
ob1.showAnimals()
ob2.showAnimals()

