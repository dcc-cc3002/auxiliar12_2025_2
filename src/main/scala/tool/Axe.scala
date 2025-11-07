package tool
import block.{Block, Stone, Wood}
import world.Chunk

class Axe extends ATool("Axe") {
  // visitor
  override def visitWood(b: Wood, c: Chunk): Unit = {
    addBlock(b)
    c.removeBlock(b)
  }

  override def visitStone(b: Stone, c: Chunk): Unit = {
    c.removeBlock(b)
  }

  // pattern matching
  override def use(b: Block, c: Chunk): Unit = {
    b match {
      case w: Wood => {
        addBlock(b)
        c.removeBlock(b)
      }
      case s: Stone => {
        c.removeBlock(s)
      }
      case _ => ()
    }
  }
}
