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

The Sea lanterns from later Minecraft Versions has been added. They get not generated in world, so you need to find a way how to provide them (in my there are NPCs with quests for that). \
➡️ Feel free to implement world generation if you want, this Mod is Open Source!

- Blocks
  - Sea Lantern (Oiriginal)
  - Sea Lantern (Red)
  - *there may be other color variations or may be added in the future*
- Items
  - Prismarine Shard
  - Prismarine Crystal (Raw)
  - Prismarine Crystal

**Note:** _Some of that blocks and items are deprecated by [Et Futurum Requiem](https://github.com/Roadhog360/Et-Futurum-Requiem). I left the blocks there for now as you can actually use then as they are registred in the ore dictionary. Maybe I think about to remove them and add a migration option._

## Crops

➡️ Also here, no worldgen. So, feel free to implement world generation if you want, this Mod is Open Source!

Currently implemented crops:
- Redstone Flower

## Other Features

### Decorative blocks and items

Decorative variant of some blocks and items can be toggled on via a config option.
I'm using this for an NPC that has a little field of Redstone Flowers. The NPC will give you real Crobs on Quest completion. But the player shouldn't get it by just destroying the planted crops nearby.

### Adjust light level for hostile mobs spawn

There is an option to adjust the required light level needed for hostile mobs to spawn. This were initially inteded to set the light level to 0, like it is in Minecraft 1.18+, because we really don't want Monsters at day int he forest in a mostly peaceful world. They are fine at night and fine at thunderstorm and also fine in Nehter and The End, but that's all.
