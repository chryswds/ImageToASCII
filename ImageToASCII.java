/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package imagetoascii;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author chrystiandybas
 */
public class ImageToASCII {
    
    private static final String ASCII_CHARACTERS = "@%#*+=-:. ";
    
    public ImageToASCII(){
        try{
            BufferedImage image = ImageIO.read(new File(""));

            int width = image.getWidth(); 
            int height = image.getHeight();
            
            
            
            StringBuilder asciiArt = new StringBuilder();
            for(int y = 0; y < height; y++){
                for(int x = 0; x < width; x++){
                    int pixel = image.getRGB(x, y);
                    int intensity = new Color(pixel).getRed();
                    int index = (int) (intensity / 255.0 * (ASCII_CHARACTERS.length() - 1));
                    asciiArt.append(ASCII_CHARACTERS.charAt(index));
                }
                asciiArt.append("\n");
            }
            System.out.println(asciiArt);
            String filePath = "";
            saveToTextFile(asciiArt.toString(), filePath);
            
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("ERROR SAVING");
        }
    }
    private void saveToTextFile(String asciiArt, String filePath) throws IOException {
    try (FileWriter writer = new FileWriter(filePath, true)) {
        writer.write(asciiArt);
    }
}
    public static void main(String[] args) {
        new ImageToASCII();
    }
    
}
