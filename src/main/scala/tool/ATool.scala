package tool

import block.{Block, Dirt, Stone, Wood}
import world.Chunk

import scala.collection.mutable.ArrayBuffer

abstract class ATool(override val name: String) extends Tool {
  private val collectedBlocks: ArrayBuffer[Block] = ArrayBuffer.empty

  protected def addBlock(block: Block): Unit = {
    collectedBlocks += block
  }

  override def obtainBlocks(): Array[Block] = collectedBlocks.toArray

  override def visitStone(b: Stone, c: Chunk): Unit = {}
  override def visitWood(b: Wood, c: Chunk): Unit = {}
  override def visitDirt(b: Dirt, c: Chunk): Unit = {}
}
