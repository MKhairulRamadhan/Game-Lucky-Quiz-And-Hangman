import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

/**
 * Class LetterTile ini berfungsi sebagai class yang akan menampilkan gambar icon-icon dari huruf-huruf
 * yang digunakan di kelas LetterRack untuk menyusun posisinya secara acak
 *
 * @author Lucky Quiz Team
 * Uas PBO , 01-Januari-2019
 */

// A tile representing a letter to be guessed during a game.

public class LetterTile extends JLabel{

    // The letter to be displayed on the tile
    private final char IMAGE_LETTER;
    
    // The directory containing the letter images.
    private final String IMAGE_DIRECTORY;
    
    // The type of image (.jpg, .png, etc. to include the period).
    private final String IMAGE_TYPE;
    
    // The preferred width of the tiles.
    private final int PREFERRED_WIDTH;
    
    // The preferred height of the tiles.
    private final int PREFERRED_HEIGHT;
    

    // The current path of the current image.
    private String path;
    
    // The current image being displayed.
    private BufferedImage image;
    

    // A custom MouseListener from the GameBoard class to change the tiles on
    // a click.
    private MouseListener tileListener;

    //The default constructor.
    public LetterTile() { this('a', "images/", ".png"); }
    
    /**
     * Creates a new LetterTile given the letter to be displayed, the directory
     * of the letter image series, and the image type.
     *  'imageLetter' The letter to be displayed on the tile.
     *  'imageDirectory' The directory holding the letter images.
     *  'imageType' The type of the letter images.
     */

    public LetterTile(char imageLetter, String imageDirectory, String imageType)
    {
        IMAGE_LETTER = imageLetter;
        IMAGE_DIRECTORY = imageDirectory;
        IMAGE_TYPE = imageType;
        
        PREFERRED_WIDTH = 50; 
        PREFERRED_HEIGHT = 50;
        
        setPreferredSize(new Dimension(PREFERRED_WIDTH, PREFERRED_HEIGHT));
        path = IMAGE_DIRECTORY + IMAGE_LETTER + IMAGE_TYPE;
        image = loadImage(path);
    }
    
    /**
     * Loads an image from a file.
     *  imagePath The path to load an image from.
     *  A BufferedImage object on success, exits on failure.
     */
    private BufferedImage loadImage(String imagePath)
    {
        BufferedImage img = null;

        try 
        {
            img = ImageIO.read(new File(imagePath));
        }catch (IOException ex) {
            System.err.println("loadImage(): Error: Image at " + imagePath + " could not be found");
            System.exit(1);
        }

        return img;
    }
    
    /**
     * Changes the tile's appearance and removes the mouse listener to prevent
     * the tile from being clicked again.
     * return The tile's letter.
     */
    public char guess() { 
        loadNewImage("guessed");
        removeTileListener();
        return IMAGE_LETTER;
    }
    
    /**
     * Loads a new image in the hangman image series.
     * suffix The suffix of the image name.
     */
    private void loadNewImage(String suffix){
        path = IMAGE_DIRECTORY + IMAGE_LETTER + "_" + suffix + IMAGE_TYPE;
        image = loadImage(path);
        repaint();  
    }
    
    /**
     * Add a TileListener to the tile.
     * l The MouseListener to attach as a TileListener
     */
    public void addTileListener(MouseListener l) 
    { 
        tileListener = l;
        addMouseListener(tileListener);
    }
    
    // Remove the tile's TileListener.
    public void removeTileListener() { removeMouseListener(tileListener); }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, PREFERRED_WIDTH, PREFERRED_HEIGHT, null);
    }
    
}