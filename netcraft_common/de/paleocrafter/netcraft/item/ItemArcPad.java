package de.paleocrafter.netcraft.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.netcraft.lib.Colours;
import de.paleocrafter.netcraft.lib.Reference;
import de.paleocrafter.netcraft.lib.Strings;

/**
 * 
 * NetCraft
 * 
 * ItemArcPad
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ItemArcPad extends ItemNetCraft {

    private static String[] subNames = { "arcPadOn", "arcPadBorder" };

    @SideOnly(Side.CLIENT)
    private Icon[] icons;

    public ItemArcPad(int id) {
        super(id);
        this.setUnlocalizedName(Strings.ARCPAD_NAME);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister) {
        icons = new Icon[subNames.length];
        for (int i = 0; i < subNames.length; i++) {
            icons[i] = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase()
                    + ":" + subNames[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses() {

        return true;
    }

    @Override
    public Icon getIcon(ItemStack itemStack, int renderPass) {
        if (renderPass != 1)
            return icons[0];
        else
            return icons[1];
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack itemStack, int renderPass) {
        if (renderPass == 0)
            return Integer.parseInt(Colours.PURE_WHITE, 16);
        else {
            int padColor = this.getColor(itemStack);

            if (padColor < 0) {
                padColor = Integer.parseInt(Colours.PURE_WHITE, 16);
            }

            return padColor;
        }
    }

    public boolean hasColor(ItemStack itemStack) {
        return !itemStack.hasTagCompound() ? false : !itemStack
                .getTagCompound().hasKey("color") ? false : itemStack
                .getTagCompound().getCompoundTag("display").hasKey("color");
    }

    public int getColor(ItemStack itemStack) {
        NBTTagCompound nbtTagCompound = itemStack.getTagCompound();

        if (nbtTagCompound == null)
            return Integer.parseInt(Colours.PURE_WHITE, 16);
        else {
            NBTTagCompound displayTagCompound = nbtTagCompound
                    .getCompoundTag("display");
            return displayTagCompound == null ? Integer.parseInt(
                    Colours.PURE_WHITE, 16) : displayTagCompound
                    .hasKey("color") ? displayTagCompound.getInteger("color")
                    : Integer.parseInt(Colours.PURE_WHITE, 16);
        }
    }

    public void setColor(ItemStack itemStack, int color) {
        if (itemStack != null) {

            NBTTagCompound nbtTagCompound = itemStack.getTagCompound();

            if (nbtTagCompound == null) {

                nbtTagCompound = new NBTTagCompound();
                itemStack.setTagCompound(nbtTagCompound);
            }

            NBTTagCompound colourTagCompound = nbtTagCompound
                    .getCompoundTag("display");

            if (!nbtTagCompound.hasKey("display")) {
                nbtTagCompound.setCompoundTag("display", colourTagCompound);
            }

            colourTagCompound.setInteger("color", color);
        }
    }

    public void removeColor(ItemStack itemStack) {

        if (itemStack != null) {

            NBTTagCompound nbtTagCompound = itemStack.getTagCompound();

            if (nbtTagCompound != null) {

                NBTTagCompound displayTagCompound = nbtTagCompound
                        .getCompoundTag("display");

                if (displayTagCompound.hasKey("color")) {
                    displayTagCompound.removeTag("color");
                }
            }
        }
    }
}
