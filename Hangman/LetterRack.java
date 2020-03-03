import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * class LetterRack ini adalh class yang berfungsi untuk membuat posisi di Jpanel dalam peletakan gambar huruf-huruf
 * yang akan ditampilkan di dalam game HangMan
 *
 * @author Lucky Quiz Team
 * Projek PBO Kelas A Kelompok 6 , 01-Januari-2019
 */

public class LetterRack extends JPanel
{

    //The number of columns present in the letter tile rack.
    private final int RACK_COLS;
    
    //The number of row present in the letter tile rack.
     
    private final int RACK_ROWS;
    
    //The layout of the letter rack.
    private final GridLayout LETTER_RACK_LAYOUT;
    
    //The capacity of the letter rack.
    private final int CAPACITY;
    
    //The directory containing the letter images.
    private final String IMAGE_DIRECTORY;
    
    //The type of image (.jpg, .png, etc. to include the period).
    private final String IMAGE_TYPE;
    
    //The password choosen to be guessed.
    private final String password;
    
    //An array of letters to be displayed on the GameBoard.
    private final ArrayList<LetterTile> rack;
    

    //The default constructor.
    public LetterRack()
    {
        this("password", "images/", ".png");
    }
    
    /**
     * Creates a new LetterRack given the password to be guessed, letter image
     * directory, and letter image type
     *  'inPassword'     The password to be guessed.
     *  'imageDirectory' The directory of the letter images.
     *  'imageType'      The type of the letter images.
     */
    public LetterRack(String inPassword, String imageDirectory, String imageType)
    {

        RACK_COLS = 8;
        RACK_ROWS = 2;
        LETTER_RACK_LAYOUT = new GridLayout(RACK_ROWS, RACK_COLS);
        LETTER_RACK_LAYOUT.setVgap(10);
        CAPACITY = RACK_ROWS * RACK_COLS;
        
        IMAGE_DIRECTORY = imageDirectory;
        IMAGE_TYPE = imageType;
        
        rack = new ArrayList<>();
        password = inPassword;
        
        // add a little padding to make sure the letter rack is centered
        setBorder(BorderFactory.createEmptyBorder(10, 17, 10, 10));
        setLayout(LETTER_RACK_LAYOUT);
        loadRack();
    }
    
    /**
     * Builds and loads the letter rack with letter tiles.
     */
    private void loadRack()
    {
        buildRack();
        for (LetterTile tile : rack)
            add(tile);
    }
    
    /**
     * Builds a letter rack from a blend of the password and random letters.
     */
    private void buildRack()
    {
        StringBuilder passwordBuilder = new StringBuilder(password.toLowerCase());
        ArrayList<Character> tiles = new ArrayList<>(); // cannot use char
        Random rand = new Random();
        int i = 0, j = 0;
        
        // add the password letters to the rack
        while (passwordBuilder.length() > 0){
            // want to make sure that no letters are repeated in tile rack
            if (!tiles.contains(passwordBuilder.charAt(0)))
            {
                tiles.add(passwordBuilder.charAt(0));
                i++;
            }
            passwordBuilder.deleteCharAt(0);
        }
        
        // add random values to fill the remainder of the rack
        for (; i < CAPACITY; i++)
        {
            Character c = 'a'; // 'a' is just a default value
            do
            {
                c = (char) (rand.nextInt(26) + 'a');
            } while (tiles.contains(c));
            tiles.add(c);
        }
        
        // grab random tiles from the ArrayList to display randomly on the
        //    GameBoard
        for (i = 0; i < CAPACITY; i++)
        {
            j = rand.nextInt(tiles.size());
            rack.add(new LetterTile(tiles.get(j), IMAGE_DIRECTORY, IMAGE_TYPE));
            tiles.remove(j);
        }
    }
    
    
     //Add a TileListener to each LetterTile in the LetterRack
     //l The TileListener to be added.
    public void attachListeners(MouseListener l)
    {
        for (LetterTile tile : rack)
            tile.addTileListener(l);
    }
    
    //Remove all TileListeners from all LetterTiles.
    public void removeListeners()
    {
        for (LetterTile tile : rack)
            tile.removeTileListener();
    }
}