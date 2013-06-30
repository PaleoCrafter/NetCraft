package de.paleocrafter.netcraft.core.proxy;

import de.paleocrafter.netcraft.client.renderer.item.ItemArcPadRenderer;
import de.paleocrafter.netcraft.lib.ItemIds;
import net.minecraftforge.client.MinecraftForgeClient;

/**
 * 
 * NetCraft
 * 
 * ClientProxy
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void initRenderingAndTextures() {
        MinecraftForgeClient.registerItemRenderer(ItemIds.ARCPAD,
                new ItemArcPadRenderer());
    }
}
