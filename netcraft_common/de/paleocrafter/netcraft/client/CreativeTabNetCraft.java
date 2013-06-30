package de.paleocrafter.netcraft.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.paleocrafter.netcraft.lib.ItemIds;
import net.minecraft.creativetab.CreativeTabs;

/**
 *
 * NetCraft
 *
 * CreativeTabNetCraft
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class CreativeTabNetCraft extends CreativeTabs {

    public CreativeTabNetCraft(int id, String name) {
        super(id, name);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return ItemIds.ARCPAD;
    }
}
