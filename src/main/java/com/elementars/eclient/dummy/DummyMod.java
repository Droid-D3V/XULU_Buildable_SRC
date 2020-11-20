package com.elementars.eclient.dummy;

import com.elementars.eclient.module.Category;
import com.elementars.eclient.module.Module;
import org.lwjgl.input.Keyboard;

public class DummyMod extends Module {

    String info;

    public DummyMod(String name) {
        super(name, "Dummy", Keyboard.KEY_NONE, Category.DUMMY, true);
    }

    public DummyMod(String name, String info) {
        super(name, "Dummy", Keyboard.KEY_NONE, Category.DUMMY, true);
        this.info = info;
    }

    @Override
    public String getHudInfo() {
        return info;
    }
}
