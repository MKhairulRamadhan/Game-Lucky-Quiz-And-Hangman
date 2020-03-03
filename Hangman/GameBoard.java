/**
 * GameBoard adalah class dimana dibuatnya frame dan unit-unit lainnya untuk 
 * GUI dari program HangMan
 *
 * @author Lucky Quiz Team
 * Projek PBO Kelas A Kelompok 6 , 01-Januari-2019
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Displays a Hangman game board to the screen for interaction with the player.
 * @author  Lucky Quiz Team
 */
public class GameBoard extends JFrame 
{
     //The width of the GameBoard.
    private final int WIDTH;
   
    //The height of the GameBoard.
    private final int HEIGHT;
    
    //The maximum number of guesses before game over.
    private final int MAX_INCORRECT;

    //The directory of the images of the hangman.
    private final String HANGMAN_IMAGE_DIRECTORY;
    
    //The type of the images of the hangman.
    private final String HANGMAN_IMAGE_TYPE;
    
    //The directory of the images of the letters.
    private final String LETTER_IMAGE_DIRECTORY;
    
    //The type of the images of the letters.
    private final String LETTER_IMAGE_TYPE;

    private final String HANGMAN_IMAGE_BASE_NAME;

    //The word to be guessed by the player.
    private String password;

    //Game difficulty level
    private String category;
    
    //The hangman image placeholder.
    private Hangman gameHangman;
    
    //Displays The Word
    private JLabel correct;

    //Displays The Question
    private JLabel hint;

    //Displays For number of dice
    private JLabel dice;
    
    //Displays the number of incorrect guesses.
    private JLabel incorrect;

    //Displays name of Player
    private JLabel nama;

    //Player Points
    private JLabel skor;

    //Round of Game
    private JLabel banyak;

    //The number of incorrect guesses.
    private int numIncorrect;

    //Handle game repetition
    private int repeat = 0;

    //Random The Question
    private int random;

    //Random The Dice
    private int random_dice;

    //StringBuilder used to hide the password(the word), revealing letters as they are
    //guessed by the player.
    private StringBuilder passwordHidden;
    
    //LetterRack objeck
    private LetterRack gameRack;

    //Dadu objeck
    Dadu2 dadu = new Dadu2(0);

    //Pemain Objeck
    Pemain2 pemain = new Pemain2("");

    //TanyaJawab Objeck dice1
    TanyaJawab2 TJ1[] = {
        new TanyaJawab2("apakah nama ibukota prancis ?"                   , "paris"),
        new TanyaJawab2("Mata uang negara Jepang yaitu ?"                    ,"yen"),
        new TanyaJawab2("Layar komputer disebut juga ?"                  ,"monitor"),
        new TanyaJawab2("Ibukota negara Rusia yaitu ?"                    ,"Moscow"),
        new TanyaJawab2("Penemu radio berasal dari negara ?"              ,"italia"),
        new TanyaJawab2("Rumput yang tumbuh paling cepat adalah ?"         ,"bambu")
            
    };

    //TanyaJawab Objeck dice2
    TanyaJawab2 TJ2[] = {
        new TanyaJawab2("Negara terkaya di dunia adalah  ?"                ,"qatar"),
        new TanyaJawab2("Kota pelajar ."                              ,"Yogyakarta"),
        new TanyaJawab2("Minuman terfavorit di dunia adalah ?"               ,"teh"),
        new TanyaJawab2("Tokoh utama film \"Toy Story\" adalah ?"          ,"woody"),
        new TanyaJawab2("Jenis batuan terkeras adalah ?"                 ,"berlian"),
        new TanyaJawab2("Mamalia tertinggi adalah ?"                     ,"jerapah")
    };

    //TanyaJawab Objeck dice3
     TanyaJawab2 TJ3[] = {
        new TanyaJawab2("Tanggal 29 februari  ."                ,"Kabisat"),
        new TanyaJawab2("Ilmu pengetahuan alam ."                 ,"Sains"),
        new TanyaJawab2("Udara yang bergerak  ."                  ,"Angin"),
        new TanyaJawab2("Besaran bunyi  ."                      ,"Desibel"),
        new TanyaJawab2("Serangga Sodidaritas tinggi  ."          ,"Semut"),
        new TanyaJawab2("Air terjut tertinggi di negara ?"    ,"Venezuele"),

    };

    //TanyaJawab Objeck dice4
    TanyaJawab2 TJ4[] = {
        new TanyaJawab2("Sungai Terpanjang"                                 , "Nil"),
        new TanyaJawab2("Pulau Terbesar ?"                            , "GreenLand"),
        new TanyaJawab2("Kandungan zat dalam kunyit"                   , "Kurkumin"),
        new TanyaJawab2("Binatang hidup di air dan darat disebut ?"       ,"Amfibi"),
        new TanyaJawab2("Monumen terkenal di kota Paris adalah menara..?" ,"Eiffel"),
        new TanyaJawab2("Gunung tertinggi di dunia adalah gunung...?"    ,"Everest")
    };


    //TanyaJawab Objeck dice5
    TanyaJawab2 TJ5[] = {
        new TanyaJawab2("Hewan terkecil adalah ?"                          ,"amuba"),
        new TanyaJawab2("Nama resmi negara Belanda adalah ?"          ,"Netherland"),
        new TanyaJawab2("Negara termiskin di dunia adalah ?"               ,"kango"),
        new TanyaJawab2("Ilmu yang mempelajari tentang ikan ?"       , "Ichtiologi"),
        new TanyaJawab2("Rabun Dekat   ."                                 , "Miopi"),
        new TanyaJawab2("Alat pernafasan belalang adalah ?"               ,"trakea")
    };


    //TanyaJawab Objeck dice6
    TanyaJawab2 TJ6[] = {
        new TanyaJawab2("Kerja paksa pada zaman penduduk jepang ..."                , "Romusha"),
        new TanyaJawab2("Suku aborigin berasal dari .?"                           , "Australia"),
        new TanyaJawab2("Juara Piala Eropa 2016 . "                                , "Portugal"),
        new TanyaJawab2("Sinonim 'Tembok' ."                                         ,"Dinding"),
        new TanyaJawab2("cabang Ilmu biologi yang mempelajari virus"               , "Virologi"),
        new TanyaJawab2("Daging domba dalam bahasa jepang . "                        , "Yoniku")
    };



    public GameBoard()
    {
        WIDTH = 500;
        HEIGHT = 500;
        MAX_INCORRECT = 6;
        
        // The default directory for the sample images is images/ and the 
        //     default image type is .png; ensure this directory is
        //     created in the project folder if the sample images are used.
        HANGMAN_IMAGE_DIRECTORY = LETTER_IMAGE_DIRECTORY = "images/";
        HANGMAN_IMAGE_TYPE = LETTER_IMAGE_TYPE = ".png";
        HANGMAN_IMAGE_BASE_NAME = "hangman";
        
        setTitle("Phantom Hangman");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        addCloseWindowListener();

        initialize();
    }
    
    /**
     * Initializes all elements of the GameBoard that must be refreshed upon
     * the start of a new game.
     */
    private void initialize()
    {        

        numIncorrect = 0;


        dadu.setDadu((((int)(Math.random()*(6-0))+1)));
        random_dice = dadu.getDadu();
        random = ((int)(Math.random()*(5-0))+1);
        

        correct = new JLabel("Word: ");

        hintM();
        

        incorrect = new JLabel("Incorrect: " + numIncorrect);
        password = new String();
        passwordHidden = new StringBuilder();

        banyak = new JLabel();
        nama = new JLabel();
        dice = new JLabel("Dice : " + random_dice + category);
        skor = new JLabel();
        
        getPassword();
        addTextPanel();
        addLetterRack();
        addHangman();
        
        // set board slightly above middle of screen to prevent dialogs
        //     from blocking images
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2,dim.height / 2 - getSize().height / 2 - 100);
        setVisible(true);
    }
    

    /**
     *Prompts the user to confirm before quitting out of the window.
     */
    private void addCloseWindowListener()
    {
        //Must be DO_NOTHING_ON_CLOSE for prompt to function correctly
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent we)
            {
                int prompt = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to quit?",
                        "Quit?", 
                        JOptionPane.YES_NO_OPTION);
                
                if (prompt == JOptionPane.YES_OPTION)
                    System.exit(0);
            }
        });
    }
    
    /**
     * Adds the correct and incorrect labels to the top of the GameBoard
     */
    private void addTextPanel()
    {
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(3,2));

        skor.setText("Skor : "+pemain.getSkor());
        banyak.setText("Round : " + (repeat+1));

        textPanel.add(nama);
        textPanel.add(dice);
        textPanel.add(skor);
        textPanel.add(banyak);
        textPanel.add(correct);
        textPanel.add(incorrect);

        // use BorderLayout to set the components of the gameboard in
        //     "visually agreeable" locations
        add(textPanel, BorderLayout.NORTH);
    }
    

     /**
      * Adds the LetterRack to the bottom of the GameBoard and attaches
      * the LetterTile TileListeners to the LetterTiles.
      */
    private void addLetterRack(){
        gameRack = new LetterRack(password, LETTER_IMAGE_DIRECTORY,  LETTER_IMAGE_TYPE);
        gameRack.attachListeners(new TileListener());
        add(gameRack, BorderLayout.SOUTH);
    }
    
    // Adds a panel that contains the hangman images to the middle of the GameBoard.
    private void addHangman()
    {
        JPanel hangmanPanel = new JPanel();
        gameHangman = new Hangman(HANGMAN_IMAGE_BASE_NAME, HANGMAN_IMAGE_DIRECTORY, HANGMAN_IMAGE_TYPE);
        hangmanPanel.add(gameHangman);
        add(hangmanPanel, BorderLayout.CENTER);

        hangmanPanel.add(hint);
    }
    

    /**
     * Retrieves the password from the player, constrained by the length and
     * content of the password.
     */
    private void getPassword(){
        String[] options = {"Let's Play", "Quit"};
        JPanel passwordPanel = new JPanel();
        JLabel passwordLabel = new JLabel("Enter Your Name: ");

        JTextField nm = new JTextField(10);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(nm);


        String[] options2 = {"Random Cube"};
        JPanel passwordPane2 = new JPanel();

        int confirm;


        if(repeat == 0){
            confirm = JOptionPane.showOptionDialog(null, 
                    passwordPanel, 
                    "Enter Name", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    options, 
                    options[0]);

            if(confirm == 1){
                System.exit(0);
            }

            pemain.setNama("Nama : "+nm.getText());
        }

             JOptionPane.showOptionDialog(null, 
                    passwordPane2, 
                    "RANDOM", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, 
                    null, 
                    options2, 
                    options[0]);
            
            nama.setText(pemain.getNama());
            password();
        passwordHidden.append(password.replaceAll(".", "#"));
        correct.setText(correct.getText() + passwordHidden.toString());
    }
    
    // Prompts the user for a new game when one game ends.
    private void newGameDialog()
    {
        int dialogResult = JOptionPane.showConfirmDialog(null, 
                "The password was: " + password +
                "\nWould You Like to Start a New Game?",
                "Play Again?",
                JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION){
            repeat += 1;
            initialize(); // re-initialize the GameBoard
        }else{

            pemain.setSkor(0);
            repeat = 0;
            initialize(); // re-initialize the GameBoard
        }
    }
    
    /**
     * A custom MouseListener for the LetterTiles that detects when the user
     * "guesses" (clicks on) a LetterTile and updates the game accordingly.
     */
    private class TileListener implements MouseListener {
        @Override
        public void mousePressed(MouseEvent e) {
            Object source = e.getSource();
            if(source instanceof LetterTile){
                char c = ' ';
                int index = 0;
                boolean updated = false;
                
                // cast the source of the click to a LetterTile object
                LetterTile tilePressed = (LetterTile) source;
                c = tilePressed.guess();
                
                // reveal each instance of the character if it appears in the the password
                while ((index = password.toLowerCase().indexOf(c, index)) != -1){
                    passwordHidden.setCharAt(index, password.charAt(index));
                    index++;
                    updated = true;
                }
                
                // if the guess was correct, update the GameBoard and check for a win
                if (updated){
                    correct.setText("Word: " + passwordHidden.toString());
                    
                    if (passwordHidden.toString().equals(password))
                    {
                        gameRack.removeListeners();
                        gameHangman.winImage();

                        pemain.setSkor(pemain.getSkor() + 10);

                        newGameDialog();
                    }
                }
                
                // otherwise, add an incorrect guess and check for a loss
                else
                {
                    incorrect.setText("Incorrect: " + ++numIncorrect);
                    
                    if (numIncorrect >= MAX_INCORRECT)
                    {
                        gameHangman.loseImage();
                        gameRack.removeListeners();
                        if(pemain.getSkor() != 0){
                            pemain.setSkor(pemain.getSkor() - 5);
                        }
                        newGameDialog();
                    }
                    
                    else
                        gameHangman.nextImage(numIncorrect);
                }
            }
        }
        
        /**
         * These methods must be implemented in every MouseListener
         *     implementation, but since they are not used in this application, 
         *     they contain no code
         */

        @Override
        public void mouseClicked(MouseEvent e) {}  

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}
        
        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public void hintM(){
        if(random_dice == 1){
            hint = new JLabel("clue : "+ TJ1[random].getSoal() + "  ");
            category = "         |Sangat Mudah|";
        }else if(random_dice == 2){
            hint = new JLabel("clue : "+ TJ2[random].getSoal() + "  ");
            category = "         |Mudah|";
        }else if(random_dice == 3){
            hint = new JLabel("clue : "+ TJ3[random].getSoal() + "  ");
            category = "         |Sedang|";
        }else if(random_dice == 4){
            hint = new JLabel("clue : "+ TJ4[random].getSoal() + "  ");
            category = "         |Sulit.!|";
        }else if(random_dice == 5){
            hint = new JLabel("clue : "+ TJ5[random].getSoal() + "  ");
            category = "         |Sangat Sulit .!|";
        }else if(random_dice == 6){
            hint = new JLabel("clue : "+ TJ6[random].getSoal() + "  ");
            category = "         |Sangat Cukup Sulit .!|";
        }
    }

    public void password(){
        if(random_dice == 1){
            password = TJ1[random].getJawaban();
        }else if(random_dice == 2){
            password = TJ2[random].getJawaban();
        }else if(random_dice == 3){
            password = TJ3[random].getJawaban();
        }else if(random_dice == 4){
            password = TJ4[random].getJawaban();
        }else if(random_dice == 5){
            password = TJ5[random].getJawaban();
        }else if(random_dice == 6){
            password = TJ6[random].getJawaban();
        }
    }

}