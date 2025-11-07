import block.{Dirt, Stone, Wood}
import munit.FunSuite

class BlockTest extends FunSuite {
  var s: block.Stone = _
  var w: block.Wood = _
  var d: block.Dirt = _

  override def beforeEach(context: BeforeEach): Unit = {
    s = new Stone()
    w = new Wood()
    d = new Dirt()
  }

  test("Dirt is a block") {
    assert(d.isInstanceOf[block.Block])
    assertEquals(d.name, "Dirt")
  }

  test("Stone is a block") {
    assert(s.isInstanceOf[block.Block])
    assertEquals(s.name,"Stone")
  }

  test("Wood is a block") {
    assert(w.isInstanceOf[block.Block])
    assertEquals(w.name,"Wood")
  }
}
