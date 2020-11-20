package com.elementars.eclient.module.render;

import com.elementars.eclient.Xulu;
import com.elementars.eclient.module.Category;
import com.elementars.eclient.module.Module;
import dev.xulu.newgui.NewGUI;
import dev.xulu.newgui.Panel;
import dev.xulu.settings.Value;
import org.lwjgl.input.Keyboard;

import java.util.ArrayList;
import java.util.Arrays;

public class NewGui extends Module {

    public static Value<Boolean> customfont;
    public static Value<Boolean> rainbowgui;
    public static Value<Integer> rainbowspeed;
    public static Value<Boolean> blur;
    public static Value<Boolean> outline;
    public static Value<String> moduleSetting;
    public static Value<String> toggleSetting;
    public static Value<String> sliderSetting;
    public static Value<Integer> bgAlpha;
    public static Value<Integer> red;
    public static Value<Integer> green;
    public static Value<Integer> blue;
    public static Value<Boolean> resetGui;

    public NewGui() {
        super("NewGui", "New gui for the client", Keyboard.KEY_Y, Category.CORE, false);
        resetGui = register(new Value<>("Reset Gui", this, false));
        customfont = register(new Value<>("Custom Font", this, false));
        rainbowgui = register(new Value<>("Rainbow ClickGui", this, false));
        rainbowspeed = register(new Value<>("Rainbow Speed", this, 20, 1, 50));
        blur = register(new Value<>("Blur", this, true));
        outline = register(new Value<>("Outline", this, true));
        moduleSetting = register(new Value<>("Module Setting", this, "Normal", new ArrayList<>(
                Arrays.asList("Normal", "MiniButton", "Text")
        )));
        toggleSetting = register(new Value<>("Toggle Setting", this, "Full-box", new ArrayList<>(
                Arrays.asList("Checkbox", "Full-box")
        )));
        sliderSetting = register(new Value<>("Slider Setting", this, "Box", new ArrayList<>(
                Arrays.asList("Line", "Box")
        )));
        bgAlpha = register(new Value<>("Background alpha", this, 130, 0, 255));
        red = register(new Value<>("GuiRed", this, 255, 0, 255));
        green = register(new Value<>("GuiGreen", this, 26, 0, 255));
        blue = register(new Value<>("GuiBlue", this, 42, 0, 255));
    }

    @Override
    public void onEnable() {
        mc.displayGuiScreen(Xulu.newGUI);
        this.toggle();
    }

    public static void resetGui() {
        if (resetGui.getValue()) {
            int startY = 10;
            for (Panel panel : NewGUI.getPanels()) {
                panel.x = 10;
                panel.y = startY;
                startY += 23;
            }
            resetGui.setValue(false);
        }
    }
}
