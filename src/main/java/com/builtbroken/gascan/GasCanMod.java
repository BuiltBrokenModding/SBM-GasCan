package com.builtbroken.gascan;

import com.builtbroken.mc.fluids.FluidModule;
import com.builtbroken.mc.fluids.bucket.BucketMaterial;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 3/7/2017.
 */
@cpw.mods.fml.common.Mod(modid = "sbmgascan", name = "Gas Can", version = GasCanMod.VERSION, dependencies = "after:vefluids")
public class GasCanMod
{
    public static final String MAJOR_VERSION = "@MAJOR@";
    public static final String MINOR_VERSION = "@MINOR@";
    public static final String REVISION_VERSION = "@REVIS@";
    public static final String BUILD_VERSION = "@BUILD@";
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + REVISION_VERSION + "." + BUILD_VERSION;

    /** Information output thing */
    public static final Logger logger = LogManager.getLogger("SBM-GasCan");

    @SidedProxy(clientSide = "com.builtbroken.gascan.ClientProxy", serverSide = "com.builtbroken.gascan.CommonProxy")
    public static CommonProxy proxy;

    public static BucketMaterial gasCanBucketMaterial;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(
                new ItemStack(FluidModule.bucket, 1, gasCanBucketMaterial.metaValue),
                "WBW",
                "I I",
                "WIW",
                'W', Blocks.wooden_slab,
                'B', Blocks.wooden_button,
                'I', Items.iron_ingot));
        proxy.postInit();
    }
}
