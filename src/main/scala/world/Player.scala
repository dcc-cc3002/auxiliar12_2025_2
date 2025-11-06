package world

import tool.Tool

class Player {
  def mine(tool: Tool, chunk: Chunk): Unit = {
    chunk.getMinedWithVisitor(tool)
  }
}
