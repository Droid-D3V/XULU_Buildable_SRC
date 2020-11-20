package dev.xulu.newgui.util;

import com.elementars.eclient.module.render.NewGui;

import java.awt.*;

//Deine Imports

/**
 *  Made by HeroCode
 *  it's free to use
 *  but you have to credit me
 *
 *  @author HeroCode
 */
public class ColorUtil {
	
	public static Color getClickGUIColor(){
		return new Color((int) NewGui.red.getValue(), (int)NewGui.green.getValue(), (int)NewGui.blue.getValue());
	}
}
