package com.pfeffamonster.culinarycraft.world;

import com.pfeffamonster.culinarycraft.blocks.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

/**
 * Created by spdennis on 9/3/2014.
 */
public class CulinaryWorldGenerator implements IWorldGenerator {

    private void generateOverWorld(Random random, World world, int x, int z){

        addOres(ModBlocks.haliteBlock, world, random, x, z, 5, 15, 8, 20, 80);

    }

    private void generateEnd(Random random, World world, int x, int z){}

    private void generateNether(Random random, World world, int x, int z){}

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

        switch(world.provider.dimensionId){
            case 0: generateOverWorld(random, world, chunkX * 16, chunkZ *16);
                break;
            case 1: generateEnd(random, world, chunkX * 16, chunkZ *16);
                break;
            case -1: generateNether(random, world, chunkX * 16, chunkZ *16);
                break;
            default: generateOverWorld(random, world, chunkX * 16, chunkZ *16);
        }

    }

    public void addOres(Block block, World world, Random random, int blockX, int blockZ, int minVeinSize, int maxVeinSize,
                        int chanceToSpawn, int minY, int maxY){
        WorldGenMinable minable = new WorldGenMinable(block, minVeinSize + random.nextInt(maxVeinSize - minVeinSize), Blocks.stone);

        for (int i = 0; i < chanceToSpawn; i++){
            int posX = blockX + random.nextInt(15);
            int posZ = blockZ + random.nextInt(15);
            int posY = minY + random.nextInt(maxY - minY);

            minable.generate(world, random, posX, posY, posZ);
        }
    }
}
