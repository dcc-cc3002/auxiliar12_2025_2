# Auxiliar 12 - BlockCraft

First we mine, then we craft.

## Contexto
Sus auxiliares favoritos están tristes porque les cambiaron la auxiliar que hicieron sobre su serie favorita,
así que ahora no tienen motivación para terminar el auxiliar de esta semana. Usted para animarlos decide mostrarles sus
conocimientos del curso a través de un programa basado en su juego favorito: BlockCraft (?).

## Problemas
De momento lleva implementado un sistema de bloques y herramientas. Donde
sus herramientas son "visitors" que visitan los chunks en busca de bloques
específicos. En particular:

- `Pickaxe` - Destruye de bloques de `Stone`
- `Axe` - Destruye de bloques de `Wood`

### P1 - Añadir una herramienta
Añada una nueva herramienta llamada `Shovel` que destruya bloques de `Wood` pero que no
obtenga el bloque destruido.

### P2 - Añadir un bloque
Añada el bloque `Dirt` que puede ser destruido y obtenido por la herramienta `Shovel`.

Modifique además `Pickaxe` para que pueda destruir bloques de `Dirt` sin obtenerlos y
`Axe` para que pueda destruir bloques de `Stone` sin obtenerlos.

### P3 - Pattern matching
De manera similar a como existe `getMinedWithVisitor` dentro de `Chunk`, cree una función
`getMinedWithMatch` que reciba una herramienta pero en vez de usar `accept` use una nueva
función `use` que reciba un bloque y un chunk, y realice la acción correspondiente
usando pattern matching.
