package modelagem.monopoly.model;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;


public class ImageFactory {

	private static HashMap<String,Image> map = new HashMap<String,Image>();
	
	public static Image getImage(String name){
		if(map.containsKey(name)){
			return map.get(name);
		}else{
			Image img;
			if(name.indexOf(".PNG") > 0 || name.indexOf(".png") > 0){
				img = Toolkit.getDefaultToolkit().getImage(name);
			}else{
				img = Toolkit.getDefaultToolkit().getImage(name+".jpeg");
			}
			map.put(name, img);
			return img;
		}
	}
}
