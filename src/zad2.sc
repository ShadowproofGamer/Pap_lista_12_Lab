object Generator:
  var id = 0

  def getId: Int = {
    (id += 1)
    id - 1
  }
end Generator

abstract class Ptak:
  val name:String
  //println("Pochodzę od dinozaurów!!!")
  var id:Int
  val abilities:(Boolean,Boolean,Boolean,Boolean)
  def latanie: Unit
  def nurkowanie: Unit
  def plywanie: Unit
  def bieganie: Unit

end Ptak
class Pingwin extends Ptak:
  val name = "Pingwin"
  println("Pochodzę od dinozaurów!!!")
  var id = 0
  val abilities = (false, true, true, false)

  def nurkowanie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + "Nurkuję")
  }

  def plywanie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + "Pływam")
  }
  def bieganie: Unit = {}
  def latanie: Unit = {}

end Pingwin


class Golab extends Ptak:
  val name = "Gołąb"
  println("Pochodzę od dinozaurów!!!")
  var id = 0
  val abilities = (true, false, true, true)
  val jakLata = "Dobrze"
  val jakBiega = "Słabo"

  def nurkowanie: Unit = {}
  def latanie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + jakLata + " latam")
  }

  def plywanie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + "Pływam")
  }

  def bieganie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + jakBiega + " biegam")
  }
end Golab

class Kura extends Ptak:
  val name = "Kura"
  println("Pochodzę od dinozaurów!!!")
  var id = 0
  val abilities = (true, false, false, true)
  val jakLata = "Słabo"
  val jakBiega = "Dobrze"
  def nurkowanie: Unit = {}

  def plywanie: Unit = {}
  def latanie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + jakLata + " latam")
  }

  def bieganie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + jakBiega + " biegam")
  }
end Kura

class Strus extends Ptak:
  val name = "Struś"
  println("Pochodzę od dinozaurów!!!")
  var id = 0
  val abilities = (false, false, false, true)
  val jakBiega = "Świetnie"

  def nurkowanie: Unit = {}

  def plywanie: Unit = {}
  def latanie: Unit = {}
  def bieganie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + jakBiega + " biegam")
  }
end Strus

class Sokol extends Ptak:
  val name = "Sokół"
  println("Pochodzę od dinozaurów!!!")
  var id = Generator.getId
  val abilities = (true, false, false, false)
  val jakLata = "Znakomicie"

  def latanie: Unit = {
    println("Ptak nr " + id + " - " + name + "\n\t" + jakLata + " latam")
  }

  def nurkowanie: Unit = {}

  def plywanie: Unit = {}
  def bieganie: Unit ={}
end Sokol




val pi1 = new Pingwin
val pi2 = new Pingwin
val pi3 = new Pingwin
val go1 = new Golab
val ku1 = new Kura
val ku2 = new Kura
val st1 = new Strus
val so1 = new Sokol

class Klub:
  var members: List[Ptak] = List()
  var flying: List[Ptak] = List()
  var diving: List[Ptak] = List()
  var swimming: List[Ptak] = List()
  var running: List[Ptak] = List()
  def addMember(animal:Ptak): Unit ={
    animal.id = Generator.getId
    members = animal::members
    if animal.abilities._1 then flying = animal::flying
    if animal.abilities._2 then diving = animal::diving
    if animal.abilities._3 then swimming = animal::swimming
    if animal.abilities._4 then running = animal::running
  }
  def showFlying: Unit = {
    println()
    for (x <- flying.reverse) x.latanie
  }

  def showDiving: Unit = {
    println()
    for (x <- diving.reverse) x.nurkowanie
  }

  def showSwimming: Unit = {
    println()
    for (x <- swimming.reverse) x.plywanie
  }

  def showRunning: Unit = {
    println()
    for (x <- running.reverse) x.bieganie
  }
end Klub

val klub = new Klub
klub.addMember(pi1)
klub.addMember(go1)
klub.addMember(ku1)
klub.addMember(st1)
klub.addMember(pi3)
klub.addMember(so1)
klub.addMember(ku2)
klub.addMember(pi2)

klub.showFlying
klub.showDiving
klub.showSwimming
klub.showRunning