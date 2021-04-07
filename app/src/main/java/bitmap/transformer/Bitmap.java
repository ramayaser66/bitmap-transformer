package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

public class Bitmap {
    int height;
    int width;
    String path;
    BufferedImage img ;

    public Bitmap(String path) {
        try {
            this.img = ImageIO.read(new File(path));

            this.height = img.getHeight();
            this.width = img.getWidth();
        }catch(IOException ex){
            System.out.println("an error occurred while reading the file... " + ex.getMessage());
        }
    }


    public void convertBlue(){
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {

                Color color = new Color(img.getRGB(x, y));
                int blue = color.getBlue();
                img.setRGB(x, y, blue);

            }
        }
    }

    public void mirror(){
        int[] row1 = new int[this.height/2+1];
        int[] row2 = new int[this.height/2+1];

        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height /2 ; y++) {

                row1[y]= img.getRGB(x,y);

            }
            int count =0;
            for(int z = this.height-1; z >= this.height/2 ; z--){

                row2[count] = img.getRGB(x,z);
                img.setRGB(x,z,row1[count]);
                count++;

            }

            for (int y = 0; y <= this.height /2 ; y++) {
                img.setRGB(x,y,row2[y]);
            }
        }

    }

    public void convertToBlackAndWhite(){
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {

                Color color = new Color(img.getRGB(x, y));
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();

                int col = (red + green + blue) /3;
                if( col > 128){
                    col = -1;
                }
                else{
                    col = -16777216;
                }
                img.setRGB(x,y,col);
            }
        }
    }

    public boolean writeImage(String path){
        try {
            RenderedImage rd = this.img;
            ImageIO.write(rd, "bmp", new File(path));
            return true;
        }catch (IOException ex){
            System.out.println("an error occurred while writing the file...."+ ex.getMessage());
            return false;
        }

    }

}
