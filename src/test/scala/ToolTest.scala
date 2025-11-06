import munit.FunSuite

class ToolTest extends FunSuite {
  var axe: tool.Axe = _
  var pickaxe: tool.Pickaxe = _
  var chunk: world.Chunk = _

  override def beforeEach(context: BeforeEach): Unit = {
    axe = new tool.Axe()
    pickaxe = new tool.Pickaxe()
    chunk = new world.Chunk()
  }

  test("Axe is a tool") {
    assert(axe.isInstanceOf[tool.ATool])
    assertEquals(axe.name, "Axe")
  }

  test("Pickaxe is a tool") {
    assert(pickaxe.isInstanceOf[tool.ATool])
    assertEquals(pickaxe.name, "Pickaxe")
  }

  test("Axe can remove wood") {
    val wood = new block.Wood()
    val stone = new block.Stone()
    chunk.addBlock(wood)
    chunk.addBlock(stone)
    chunk.getMinedWithVisitor(axe)
    assert(axe.obtainBlocks().contains(wood))
    assert(!axe.obtainBlocks().contains(stone))
  }

  test("Pickaxe can remove stone") {
    val stone = new block.Stone()
    val wood = new block.Wood()
    chunk.addBlock(stone)
    chunk.addBlock(wood)
    chunk.getMinedWithVisitor(pickaxe)
    assert(pickaxe.obtainBlocks().contains(stone))
    assert(!pickaxe.obtainBlocks().contains(wood))
  }
}
