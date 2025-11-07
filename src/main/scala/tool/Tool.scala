package tool

import block.{Block, Dirt, Stone, Wood}
import world.Chunk

trait Tool {
  val name: String

  // visitor pattern
  def visitStone(b: Stone, c: Chunk): Unit
  def visitWood(b: Wood, c: Chunk): Unit
  def visitDirt(b: Dirt, c: Chunk): Unit

  // pattern matching
  def use(b: Block, c: Chunk): Unit

  def obtainBlocks(): Array[Block]
}
