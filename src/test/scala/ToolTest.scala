import block.{Dirt, Stone, Wood}
import munit.FunSuite
import tool.{Axe, Pickaxe, Shovel, Tool}
import world.Chunk

class ToolTest extends FunSuite {
  var axe: Axe = _
  var pickaxe: Pickaxe = _
  var shovel: Shovel = _
  var chunk: Chunk = _

  override def beforeEach(context: BeforeEach): Unit = {
    axe = new Axe()
    pickaxe = new Pickaxe()
    shovel = new Shovel()
    chunk = new Chunk()
  }

  test("Axe is a tool") {
    assert(axe.isInstanceOf[Tool])
    assertEquals(axe.name, "Axe")
  }

  test("Pickaxe is a tool") {
    assert(pickaxe.isInstanceOf[Tool])
    assertEquals(pickaxe.name, "Pickaxe")
  }

  test("Shovel is a tool") {
    assert(shovel.isInstanceOf[Tool])
    assertEquals(shovel.name, "Shovel")
  }

  test("Axe can remove wood and stone but only store wood") {
    val wood = new Wood()
    val stone = new Stone()
    chunk.addBlock(wood)
    chunk.addBlock(stone)
    chunk.getMinedWithVisitor(axe)
    assert(axe.obtainBlocks().contains(wood))
    assert(!axe.obtainBlocks().contains(stone))
  }

  test("Axe can't break dirt") {
    val dirt = new Dirt()
    chunk.addBlock(dirt)
    chunk.getMinedWithMatch(axe)
    assert(!axe.obtainBlocks().contains(dirt))
  }

  test("Pickaxe can remove stone and dirt but only store stone") {
    val stone = new Stone()
    val dirt = new Dirt()
    chunk.addBlock(stone)
    chunk.addBlock(dirt)
    chunk.getMinedWithVisitor(pickaxe)
    assert(pickaxe.obtainBlocks().contains(stone))
    assert(!pickaxe.obtainBlocks().contains(dirt))
  }

  test("Pickaxe can't break wood") {
    val wood = new Wood()
    chunk.addBlock(wood)
    chunk.getMinedWithVisitor(pickaxe)
    assert(!pickaxe.obtainBlocks().contains(wood))
  }

  test("Shovel can remove wood and dirt but only store dirt") {
    val dirt = new Dirt()
    val wood = new Wood()
    chunk.addBlock(dirt)
    chunk.addBlock(wood)
    chunk.getMinedWithVisitor(shovel)
    assert(shovel.obtainBlocks().contains(dirt))
    assert(!shovel.obtainBlocks().contains(wood))
  }

  test("Shovel can't break stone") {
    val stone = new Stone()
    chunk.addBlock(stone)
    chunk.getMinedWithVisitor(shovel)
    assert(!shovel.obtainBlocks().contains(stone))
  }
}
