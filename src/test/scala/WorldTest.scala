import block.Dirt
import munit.FunSuite
import tool.Shovel

class WorldTest extends FunSuite {
  var player: world.Player = _
  var chunk: world.Chunk = _

  override def beforeEach(context: BeforeEach): Unit = {
    player = new world.Player()
    chunk = new world.Chunk()
    chunk.addBlock(new block.Stone())
    chunk.addBlock(new block.Wood())
    chunk.addBlock(new block.Dirt())
  }

  test("A block can be added to a chunk") {
    assertEquals(chunk.blocks.length, 3)
    val b = new block.Stone()
    chunk.addBlock(b)
    assertEquals(chunk.blocks.length, 4)
  }

  test("A block can be removed from a chunk") {
    assertEquals(chunk.blocks.length, 3)
    val b = new block.Stone()
    chunk.addBlock(b)
    assertEquals(chunk.blocks.length, 4)
    chunk.removeBlock(b)
    assertEquals(chunk.blocks.length, 3)
  }

  test("Player can mine with a Pickaxe") {
    val pickaxe = new tool.Pickaxe()
    player.mine(pickaxe, chunk)
    assertEquals(pickaxe.obtainBlocks().length, 1)
  }

  test("Player can mine with a Axe") {
    val axe = new tool.Axe()
    player.mine(axe, chunk)
    assertEquals(axe.obtainBlocks().length, 1)
  }

  test("Player can mine with a Shovel") {
    val shovel = new Shovel()
    player.mine(shovel, chunk)
    assertEquals(shovel.obtainBlocks().length, 1)
  }
}
