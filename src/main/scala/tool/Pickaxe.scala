package tool

class Pickaxe extends ATool("Pickaxe") {
  override def visitStone(b: block.Stone, c: world.Chunk): Unit = {
    addBlock(b)
    c.removeBlock(b)
  }
}
