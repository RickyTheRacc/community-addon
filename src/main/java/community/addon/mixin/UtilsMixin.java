package community.addon.mixin;

import meteordevelopment.meteorclient.utils.Utils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(Utils.class)
public class UtilsMixin {
    /**
     * @author ridglef
     * @reason cope
     */
    @Overwrite(remap = false)
    public static String nameToTitle(String name) {
        if (name.equals("step")) return "reverse-step";
        if (name.equals("reverse-step")) return "step";
        return name;
    }
}
