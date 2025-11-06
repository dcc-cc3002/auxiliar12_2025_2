package tool
import block.Block
import world.Chunk

class Axe extends ATool("Axe") {
  override def visitWood(b: block.Wood, c: Chunk): Unit = {
    addBlock(b)
    c.removeBlock(b)
  }
}
