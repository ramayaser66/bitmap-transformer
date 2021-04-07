# bitmap-transformer

we built a class that takes in a path of a bmp file, reads that file and allow some transformation to it:

methods used: 
- Bitmap
takes in the path, reads it and get data from it (width and hight). 

- convertBlue
the image data read from the path is used in this method, using that data we can transform the colors of the image to blue.

- mirror
the image data read from the path is used in this method, using that data we can transform the image by reversing it vertically AKA mirror the image. 

- convertToBlackAndWhite
the image data read from the path is used in this method, using that data we can transform the colors of the image to black and white.

- writeImage
generates a path that has the transformed image data stored in it. 


> if you are running the program from the command line:
-  you need to set 3 args:
1. input path 
2. output path 
3. what transform you want to use 

- you write the command at the form of  `gradle run --args 'input output transform'`

transforms available:
1. mirror 
2. black
3. blue
 ex: `gradle run --args 'test.bmp run2.bmp black'`