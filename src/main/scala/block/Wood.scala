package block

import tool.Tool
import world.Chunk

class Wood extends ABlock("Wood") {
  override def accept(visitor: Tool, c: Chunk): Unit = {
    visitor.visitWood(this, c)
  }
}
