/**
 * Class HangMan ini berfungsi untuk mengambil dan mengganti gambar dari hangman
 * yang akan digunakan pada kelas GameBooard
 
 * @author Lucky Quiz Team
 * Projek PBO Kelas A Kelompok 6 , 01-Januari-2019 * Uas PBO , 01-Januari-2019
 */

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Displays a selected series of hangman images to the game board.
 */
public class Hangman extends JLabel{

    // The preferred width of the images.
    private final int PREFERRED_WIDTH;
    
    // The preferred height of the images.
    private final int PREFERRED_HEIGHT;
    

    // The base (common) name of the series of images to use (e.g. "hangman" in "hangman_0.png, hangman_1.png, ..."
    private final String IMAGE_BASE_NAME;
    
    // The directory containing the hangman images.
    private final String IMAGE_DIRECTORY;
    
    // The type of image (.jpg, .png, etc. to include the period).
    private final String IMAGE_TYPE;
    
    // The current path of the current image.
    private String path;
    
    // The current image being displayed.
    private BufferedImage image;
    
    // The default constructor.
    public Hangman()
    {
        this("hangman", "images/", ".png");
    }
    
    /**
     * Creates a new Hangman given the image series' base name, the directory
     * of the hangman images, and the type of image.
     * imageBaseName The base name of the image series to be used.
     * imageDirectory The directory containing the hangman images.
     * imageType The type of the hangman images.
     */
    public Hangman(String imageBaseName, String imageDirectory, String imageType){
        PREFERRED_WIDTH = 440;
        PREFERRED_HEIGHT = 255;
        
        IMAGE_BASE_NAME = imageBaseName;
        IMAGE_DIRECTORY = imageDirectory;
        IMAGE_TYPE = imageType;
        
        // you must suffix all images with _(image number) for this to work
        setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
        path = IMAGE_DIRECTORY + IMAGE_BASE_NAME + "_0" + IMAGE_TYPE;
        image = loadImage(path);
    }
    
    /**
     * Loads an image from a file.
     * @param imagePath The path to load an image from.
     * @return A BufferedImage object on success, exits on failure.
     */
    private BufferedImage loadImage(String imagePath)
    {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(imagePath));
        } 

        catch (IOException ex) {
            System.err.println("loadImage(): Error: Image at "
                    + imagePath + " could not be found");
            System.exit(1);
        }
        
        return img;
    }
    
    /**
     * Load the next hangman image in the series.
     * imageNumber The number of the image to load.
     */
    public void nextImage(int imageNumber) { 
        loadNewImage(String.valueOf(imageNumber));
    }
    
    /**
     * Display the losing image.
     */
    public void loseImage() { loadNewImage("lose"); }
    
    /**
     * Display the winning image.
     */
    public void winImage() { loadNewImage("win"); }
    
    /**
     * Loads a new image in the hangman image series.
     * suffix The suffix of the image name.
     */
    private void loadNewImage(String suffix){
        path = IMAGE_DIRECTORY + IMAGE_BASE_NAME + "_" + suffix + IMAGE_TYPE;
        image = loadImage(path);
        repaint();  
    }
    
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, PREFERRED_WIDTH, PREFERRED_HEIGHT, null);
    }
}