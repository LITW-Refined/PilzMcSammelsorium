# PilzMcSammelsorium
Minecraft Mod for my 1.7.10 Modpack that adds some extra blocks, items and features.

# Contribution

Fell free to contribue anything here. My time is limited and I only add what I really need. World generation for example would be really nice, but I don't really need it. Other ores flower or any other blocks.

# Configuration

Feel free and take a look into the `pilzmcsammelsorium.cfg` file in the `config` directory.
- Nearly everything can be toggled on/off individually.
- There are also a lot of comments that tries to explain what the config value does.
- Recips can be turned off completely.
- All blocks or items can be turned on or off.
- Each other feature can be turned on or off.

# Features

## Blocks & Items

### Sea Lanterns

The Sea lanterns from later Minecraft Versions has been added. They get not generated in world, so you need to find a way how to provide them (in my there are NPCs with quests for that).
➡️ Feel free to implement world generation if you want, this Mod is Open Source!

- Blocks
  - Sea Lantern (Oiriginal)
  - Sea Lantern (Red)
  - *there may be other color variations or may be added in the future*
- Items
  - Prismarine Shard
  - Prismarine Crystal (Raw)
  - Prismarine Crystal
  
## Crops

➡️ Also here, no worldgen. So, feel free to implement world generation if you want, this Mod is Open Source!

Currently implemented crops:
- Redstone Flower

## Other Features

### Decorative blocks and items

Decorative variant of some blocks and items can be toggled on via a config option.
I'm using this for an NPC that has a little field of Redstone Flowers. The NPC will give you real Crobs on Quest completion. But the player shouldn't get it but just destroying the planted crops nearby.

## Experimental Options

### Disable chunk Loading on request

Two experimental options for loading chunks on request has been added.
This can be used to prevent Mods (and core Minecraft itself) from loading chunks whenever a block is requested there. This also means "ghost loading" or "cascade loading" chunks.
Can help with performance, but only turn on this option if you really know what you do!

Basically for a Mod, if it needs a Block at Position XYZ, it calls `getBlock()` or `getTileEntity()` or `getEntity`. By default, this methods will load the chunk where the block or entity is loaced in. Often this is not expected and in some cases can cause lags. G.g. AE2 or Ender IO Conduits or any other multiblock structure can be a cause for such a behavior. Even Minecraft's Grass block that wants to extend its Gradd to nearby dirt blocks.
There is one configruation field in the `WorldServer` object called `loadChunkOnProvideRequest` that is true by default. Setting this to false only loads chunks when explicitely loaded via e.g. `loadChunk(x, y, z)`.

If enabled, ensure to check all your chunk loaders for functionality.
Think about switching to my Fork of Chicken Chunks. I added a fix to load the chunk before requesting the block.

Also set `disableChunkLoadingOnRequest` to `true` if you don't know what you do!
This continues functionality of chunk loading tickers. So anytime whenever a chunk loading ticket is created by a Mod, the chunks will be also loaded (Forge itself doesn't that automatically).
