import block.{Stone, Wood}
import munit.FunSuite

class BlockTest extends FunSuite {
  var s: block.Stone = _
  var w: block.Wood = _

  override def beforeEach(context: BeforeEach): Unit = {
    s = new Stone()
    w = new Wood()
  }

  test("Dirt is a block") {
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
