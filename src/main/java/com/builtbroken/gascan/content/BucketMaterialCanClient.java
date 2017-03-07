package com.builtbroken.gascan.content;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

/**
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 3/7/2017.
 */
public class BucketMaterialCanClient extends BucketMaterialCan implements IItemRenderer
{
    public static final IModelCustom MODEL = AdvancedModelLoader.loadModel(new ResourceLocation("sbmgascan", "models/gascan.obj"));
    public static final ResourceLocation TEXTURE = new ResourceLocation("sbmgascan", "models/gascan.png");

    public BucketMaterialCanClient(String localization, String textureName)
    {
        super(localization, textureName);
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return type != ItemRenderType.INVENTORY;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return type != ItemRenderType.INVENTORY;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        GL11.glPushMatrix();
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEXTURE);

        if (type == ItemRenderType.EQUIPPED)
        {
            GL11.glRotatef(-40, 0, 1, 0);
            //GL11.glRotatef(13, 1, 0, 0);
            GL11.glTranslatef(1f, -1.1f, 0.1f);

            final float scale = 0.0625f / 4;
            GL11.glScalef(scale, scale, scale);
            MODEL.renderAll();
        }
        else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON)
        {
            GL11.glRotatef(-90, 0, 1, 0);
            //GL11.glRotatef(-13, 1, 0, 0);
            GL11.glTranslatef(1f, 0.6f, 0.5f);

            final float scale = 0.0625f / 5;
            GL11.glScalef(scale, scale, scale);
            MODEL.renderAll();
        }
        else if (type == ItemRenderType.ENTITY)
        {
            GL11.glTranslatef(0f, 0, 0);

            final float scale = 0.0625f / 4;
            GL11.glScalef(scale, scale, scale);
            MODEL.renderAll();
        }

        GL11.glPopMatrix();
    }
}
