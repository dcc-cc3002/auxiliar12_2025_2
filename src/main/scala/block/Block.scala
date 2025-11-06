package block

import tool.Tool
import world.Chunk

trait Block {
  val name: String
  def accept(visitor: Tool, c: Chunk): Unit
}
