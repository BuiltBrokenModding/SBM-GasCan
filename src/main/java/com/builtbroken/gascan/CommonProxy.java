package com.builtbroken.gascan;

import com.builtbroken.gascan.content.BucketMaterialCan;
import com.builtbroken.mc.fluids.bucket.BucketMaterialHandler;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 3/7/2017.
 */
public class CommonProxy
{
    public void preInit()
    {

    }

    public void init()
    {
        GasCanMod.gasCanBucketMaterial = new BucketMaterialCan("sbmgascan:gascan", "sbmgascan:gascan");
        BucketMaterialHandler.addMaterial("gasCan", GasCanMod.gasCanBucketMaterial);
    }

    public void postInit()
    {

    }
}
