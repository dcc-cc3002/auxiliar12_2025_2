package tool

import block.{Block, Stone, Wood}
import world.Chunk

trait Tool {
  val name: String

  // visitor pattern
  def visitStone(b: Stone, c: Chunk): Unit
  def visitWood(b: Wood, c: Chunk): Unit

  def obtainBlocks(): Array[Block]
}
