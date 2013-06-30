package de.paleocrafter.netcraft.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.netcraft.NetCraft;
import de.paleocrafter.netcraft.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * 
 * NetCraft
 * 
 * ItemNetCraft
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemNetCraft extends Item {

    public ItemNetCraft(int id) {
        super(id - Reference.SHIFTED_ID_RANGE_CORRECTION);
        this.setCreativeTab(NetCraft.tabsNetCraft);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                + ":"
                + this.getUnlocalizedName().substring(
                        this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item."
                + Reference.MOD_ID.toLowerCase()
                + "."
                + super.getUnlocalizedName(stack).substring(
                        super.getUnlocalizedName(stack).indexOf(".") + 1);
    }

}
