package de.paleocrafter.netcraft.configuration;

import java.io.File;
import java.util.logging.Level;

import cpw.mods.fml.common.FMLLog;
import de.paleocrafter.netcraft.lib.ItemIds;
import de.paleocrafter.netcraft.lib.Reference;
import de.paleocrafter.netcraft.lib.Strings;

import net.minecraftforge.common.Configuration;

/**
 * 
 * NetCraft
 * 
 * ConfigurationHandler
 * 
 * @author PaleoCrafter
 * @license Lesser GNU Public License v3 (http://www.gnu.org/licenses/lgpl.html)
 * 
 */
public class ConfigurationHandler {
    public static Configuration configuration;

    public static void init(File configFile) {
        configuration = new Configuration(configFile);

        try {
            /* Item IDs */
            ItemIds.ARCPAD = configuration.getItem(Strings.ARCPAD_NAME,
                    ItemIds.ARCPAD_DEFAULT).getInt(ItemIds.ARCPAD_DEFAULT);
        } catch (Exception e) {
            FMLLog.log(Level.SEVERE, e, Reference.MOD_NAME
                    + " has had a problem loading its configuration");
        } finally {
            configuration.save();
        }
    }
}
