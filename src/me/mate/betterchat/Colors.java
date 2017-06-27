package me.mate.betterchat;

import net.md_5.bungee.api.ChatColor;

public class Colors {

    public static boolean isNumeric(String str)  
    {  
        try  
        {  
            @SuppressWarnings("unused")
            double d = Double.parseDouble(str);  
        }  
        catch(NumberFormatException nfe)  
        {  
            return false;  
        }  
        return true;  
    }

    // Translate to Json colors
    static String toJson(int num){
        switch (num) {
            case 0:
                // Black
                return "black";
            case 1:
                // Dark Blue
                return "dark_blue";
            case 2:
            	// Dark Green
                return "dark_green";
            case 3:
            	// Dark Aqua
                return "dark_aqua";
            case 4:
            	// Dark Red
                return "dark_red";
            case 5:
            	// Dark Purple
                return "dark_purple";
            case 6:
            	// Gold
                return "gold";
            case 7:
            	// Gray
                return "gray";
            case 8:
            	// Dark Gray
                return "dark_gray";
            case 9:
            	// Blue
                return "blue";
            default:
            	// błąd
                return "light_purple";
        }
    }   

    // Translate to Json colors
    static String toJson(char col){
        switch (col) {
            case 'a':
                // Green
                return "green";
            case 'b':
                // Aqua
                return "aqua";
            case 'c':
                // Red
                return "red";
            case 'd':
                // Light Purple
                return "light_purple";
            case 'e':
                // Yellow
                return "yellow";
            case 'f':
                // White
                return "white";
            default:
            	// błąd
                return "light_purple";
    	}
    }

    static String toJson(String color){
    
        if(color==null){
            return null;
        }
	
        // It is int?
        if(isNumeric(color)){
            return toJson(Integer.parseInt(color));
        } else {
            // Or it's char
            return toJson(color.charAt(0));
        }	
    }

    // Translate to ChatColor
    static ChatColor toColor(int num){
        switch (num) {
	        case 0:
    	    	// Black
	            return ChatColor.BLACK;
	        case 1:
	            // Dark Blue
	            return ChatColor.DARK_BLUE;
	        case 2:
	            // Dark Green
	            return ChatColor.DARK_GREEN;
	        case 3:
	            // Dark Aqua
	            return ChatColor.DARK_AQUA;
	        case 4:
	            // Dark Red
	            return ChatColor.DARK_RED;
	        case 5:
	            // Dark Purple
	            return ChatColor.DARK_PURPLE;
	        case 6:
	            // Gold
	            return ChatColor.GOLD;
	        case 7:
	            // Gray
	            return ChatColor.GRAY;
	        case 8:
	            // Dark Gray
	            return ChatColor.DARK_GRAY;
	        case 9:
	            // Blue
	            return ChatColor.BLUE;
	        default:
	            // błąd
	            return ChatColor.LIGHT_PURPLE;
        }
    }

    // Translate to ChatColor
    static ChatColor toColor(char col){
        switch (col) {
            case 'a':
                //  Green
                return ChatColor.GREEN;
            case 'b':
                //  Aqua
                return ChatColor.AQUA;
            case 'c':
                //  Red
                return ChatColor.RED;
            case 'd':
                //  Light Purple
                return ChatColor.LIGHT_PURPLE;
            case 'e':
                //  Yellow
                return ChatColor.YELLOW;
            case 'f':
                //  White
                return ChatColor.WHITE;
            default:
                //  błąd
                return ChatColor.LIGHT_PURPLE;
	    }
    }

    static ChatColor toColor(String color){
	
        if(color==null){
            return null;
        }
	
        // Is it int?
        if(isNumeric(color)){
            return toColor(Integer.parseInt(color));
        } else {
            // Or it's char
			return toColor(color.charAt(0));
		}		
	}
}
