package world

import block.Block
import tool.Tool

import scala.collection.mutable.ArrayBuffer

class Chunk {
  val blocks: ArrayBuffer[Block] = ArrayBuffer.empty
  def getMinedWithVisitor(tool: Tool): Unit = {
    // avoid mutation during iteration
    val blocks = this.blocks.clone()
    blocks.foreach(_.accept(tool, this))
  }

  def addBlock(block: Block): Unit = {
    blocks += block
  }

  def removeBlock(block: Block): Unit = {
    blocks -= block
  }
}
