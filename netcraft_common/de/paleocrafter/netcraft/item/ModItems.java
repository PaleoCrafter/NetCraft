package de.paleocrafter.netcraft.item;

import de.paleocrafter.netcraft.lib.ItemIds;
import net.minecraft.item.Item;

/**
 *
 * NetCraft
 *
 * ModItems
 *
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 *
 */
public class ModItems {
    public static Item arcPad;
    
    public static void init() {
        arcPad = new ItemArcPad(ItemIds.ARCPAD);
    }
}
