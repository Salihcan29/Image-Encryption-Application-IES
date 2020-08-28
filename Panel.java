import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Panel{
	
	JFrame frame;
	
	static int width = 1125;
	static int height = 650;    
    static GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    static GraphicsDevice device = env.getDefaultScreenDevice();
    static JPanel panel;
    
    JButton selectKey = new JButton("Select KeyIMG");
    JButton selectCrypt = new JButton("Select EncryptIMG");
    JButton encrypt = new JButton("Encrypt");
    JButton decrypt = new JButton("Decrypt");
    JButton randomKey = new JButton("Randomize Key");
    JButton syncKey = new JButton("Sync to Key");
    JButton saveFile = new JButton("Save Image");
    JButton Advanced = new JButton("Advanced");
    JButton Exit = new JButton("Exit");
    
    static JTextArea Console = new JTextArea();
    JScrollPane scroll = new JScrollPane();
        
    JLabel menuLabel = new JLabel("Menu",SwingConstants.CENTER);
    JLabel logo = new JLabel("Encryption System",SwingConstants.CENTER);
    
    static JLabel loadedKey = new JLabel("",SwingConstants.CENTER);
    static JLabel loadedEncrypt = new JLabel("",SwingConstants.CENTER);
    
    static BufferedImage Key   = null;
    static BufferedImage Crypt = null;
    static BufferedImage bg    = null;
    
    static String[] CKey;
    static String AdvancedCKEY = "-CH-1-CH-2-CH-3-CH-4-CH-5-CH-6-CH-7-CH-8-CH-9-CH-0-CH-a-CH-b-CH-c-CH-ç-CH-d-CH-e-CH-f-CH-g"
		  	  + "-CH-ğ-CH-h-CH-ı-CH-i-CH-j-CH-k-CH-l-CH-m-CH-n-CH-o-CH-ö-CH-p-CH-q-CH-r-CH-s-CH-ş-CH-t-CH-u"
		  	  + "-CH-ü-CH-v-CH-w-CH-x-CH-y-CH-z-CH-A-CH-B-CH-C-CH-Ç-CH-D-CH-E-CH-F-CH-G-CH-Ğ-CH-H-CH-I-CH-İ"
		  	  + "-CH-J-CH-K-CH-L-CH-M-CH-N-CH-O-CH-Ö-CH-P-CH-Q-CH-R-CH-S-CH-Ş-CH-T-CH-U-CH-Ü-CH-V-CH-W-CH-X"
		  	  + "-CH-Y-CH-Z-CH-.-CH-:-CH-,-CH-;-CH-~-CH-`-CH-\"-CH-!-CH-'-CH-^-CH-+-CH-%-CH-&-CH-/-CH-(-CH-)"
		  	  + "-CH-=-CH-?-CH-_-CH-<-CH->-CH-£-CH-#-CH-$-CH-½-CH-{-CH-[-CH-]-CH-}-CH-\\-CH-|-CH-@-CH-€-CH-æ"
		  	  + "-CH-ß-CH-√-CH-²-CH-±-CH-	-CH-≥-CH-î-CH-â-CH-é-CH- -CH-à-CH-\n-CH-“-CH-”-CH-’-CH---CH-á-CH-ê"
		  	  + "-CH-*-CH-�";
    
    static String KeyFilePath = "NON-SELECTED";
    static String KeyIMGName     = "";
    static String EncryptIMGName ="";
    static Boolean isConsoleActive = true;
    //////////////////////////////////////////////////////////////////
    class Background extends JComponent {

    	/**
    	 * 
    	 */
    	private static final long serialVersionUID = 1L;
    	private BufferedImage bg;
    	
    	public Background() {
    		try {
    			bg = ImageIO.read(new File("BGFILE"));
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    		setLayout(new BorderLayout());
    	}

    	@Override
    	public Dimension getPreferredSize() {
    		return bg == null ? super.getPreferredSize() : new Dimension(bg.getWidth(), bg.getHeight());
    	}

    	@Override
    	protected void paintComponent(Graphics g) {
    		super.paintComponent(g);   		
    			Graphics2D g2d = (Graphics2D) g.create();
    			g2d.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    			g2d.setColor(new Color(255,255,255,255));
        	    g2d.drawRect(0, 0, width, height);//window 
        	    g2d.drawRect(width/45-1, height/26*3-1, width/45*16+1, height/26*9+1);
        	    g2d.drawRect(width/5*2-1, height/26*3-1, width/45*16+1, height/26*9+1); 	
        	    g2d.drawRect(width/9*7-1, 0, width/9*2, height); 
        	    g2d.drawRect(0,height/13*8-1,width/9*7-1,height/13*5); 
        	    g2d.setColor(new Color(255,255,255,64));
        	    g2d.fillRect(width/45, height/26*3, width/45*16, height/26*9);
        	    g2d.fillRect(width/5*2, height/26*3, width/45*16, height/26*9);
        	    g2d.setColor(new Color(0,0,0,192));
        	    g2d.fillRect(width/9*7, 3, width/9*2-3, height-5);
        	   
        	    
        	    g.drawImage(Key,width/45, height/26*3, width/45*16, height/26*9,null);
        	    g.drawImage(Crypt,width/5*2, height/26*3, width/45*16, height/26*9,null);
    			g2d.dispose();  		
    	}
    }
    ////////////////////////////////////////////////////////////////////////////
    
    public Panel(){
    	frame = new JFrame("Image EncryptSystem based-on RGB Comparison");             
        frame.setBounds(250, 100, width, height);
        
        CKey = AdvancedCKEY.split("-CH-");
        
    System.out.println(" ______                             _   _");             
 	System.out.println("|  ____|                           | | (_)");            
 	System.out.println("| |__   _ __   ___ _ __ _   _ _ __ | |_ _  ___  _ __");  
 	System.out.println("|  __| | '_ \\ / __| '__| | | | '_ \\| __| |/ _ \\| '_ \\"); 
 	System.out.println("| |____| | | | (__| |  | |_| | |_) | |_| | (_) | | | |");
 	System.out.println("|______|_| |_|\\___|_|   \\__, | .__/ \\__|_|\\___/|_| |_|");
  	System.out.println(" / ____|         | |     __/ | |");                      
 	System.out.println("| (___  _   _ ___| |_ __|___/|_|__");                    
  	System.out.println(" \\___ \\| | | / __| __/ _ \\ '_ ` _ \\");                   
  	System.out.println(" ____) | |_| \\__ \\ ||  __/ | | | | |");                  
 	System.out.println("|_____/ \\__, |___/\\__\\___|_| |_| |_|");                  
    System.out.println("	 __/ |");                                        
    System.out.println("	|___/                             Developed by Salihcan Turan");
    System.out.println("______________________________________________________________________________");
    System.out.println("\n\nWelcome to Image Encryption System.\n");  
    System.out.println("After you have selected the key image, the image you want to encrypt, and the message you want to encrypt, you can encrypt the second image by pressing the Encrypt button.\n");
    System.out.println("After selecting the key image and the encrypted image, you can perform the read operation by pressing the decrypt button\n");    
    System.out.println("You can mix key image by pressing the random button\n");
    System.out.println("You can synchronize the second image to the key image by pressing the sync button\n");
    System.out.println("");
    
        selectKey.setBounds(width/9,height/2,width/45*8,height/13);			
        selectCrypt.setBounds(width/45*22,height/2,width/45*8,height/13);	selectCrypt.setEnabled(false);
        encrypt.setBounds(width/5*4,height/26*3,width/45*8,height/13);		encrypt.setEnabled(false);
        decrypt.setBounds(width/5*4,height/13*3,width/45*8,height/13);		decrypt.setEnabled(false);
        randomKey.setBounds(width/5*4,height/26*9,width/45*8,height/13);	randomKey.setEnabled(false);
        syncKey.setBounds(width/5*4,height/13*6,width/45*8,height/13);		syncKey.setEnabled(false);
        saveFile.setBounds(width/5*4,height/26*15,width/45*8,height/13);	saveFile.setEnabled(false);
        Advanced.setBounds(width/5*4,height/13*9,width/45*8,height/13);		
        Exit.setBounds(width/5*4,height/26*21,width/45*8,height/13);		
        
        Console.setBounds(0,0,0,0);
        Console.setBackground(new Color(0,0,0,255));
        Console.setForeground(Color.WHITE);
        Console.setSelectionColor(Color.WHITE);
        Console.setLineWrap(true);
        
        scroll = new JScrollPane (Console);
        scroll.setBackground(new Color(0,0,0,127));
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBounds(1,height/13*8,width/9*7,height/13*5);
        
        logo.setBounds(0,height/56,width/5*4,height/13);
        logo.setFont(new Font("Arial",Font.PLAIN,36));
        logo.setForeground(Color.WHITE);      
        menuLabel.setBounds(width/5*4,height/56,width/45*8,height/13);
        menuLabel.setFont(new Font("Arial", Font.PLAIN, 36));
        menuLabel.setForeground(Color.WHITE);
        loadedKey.setBounds(width/45, height/26*3, width/45*16, height/26*9);
        loadedKey.setFont(new Font("Arial", Font.PLAIN, 36));
        loadedKey.setForeground(Color.WHITE);
        loadedEncrypt.setBounds(width/5*2,height/26*3,width/45*16,height/26*9);
        loadedEncrypt.setFont(new Font("Arial", Font.PLAIN, 36));
        loadedEncrypt.setForeground(Color.WHITE);              	    
        
      //ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED
        JFrame JFA = new JFrame("Advanced");
            	JFA.setUndecorated(true);
            	JFA.setResizable(false);
            	JPanel JPA = new MotionPanel(JFA);
            	JPA.setLayout(null);
            	JFA.setBounds(250+width/45,100+height/13,width/2,height/2);
            	
            	JTextArea JTA = new JTextArea(AdvancedCKEY);
            	JTA.setEnabled(false);
            	JTA.setBounds((width/2)/20,(height/2)/5,(width/2)/20*18,(height/3));
            	JLabel JLConsoleisActive = new JLabel("is Console Activate (Recommended)");JLConsoleisActive.setBounds((width/2)/30+20,(height/2)/20,width/3,20);
            	JLabel JLCharKey = new JLabel("Use private character key");JLCharKey.setBounds((width/2)/30+20,(height/2)/8,width/3,20);
            	JButton saveChanges = new JButton("Save changes");saveChanges.setBounds((width/2)/20,(height/2)/20*18,(width/2)/20*18,height/20);
            	
            	JTA.setLineWrap(true);
            	JCheckBox CheckConsole = new JCheckBox();CheckConsole.setBounds((width/2)/30,(height/2)/20,18,18);
            	JCheckBox CheckCharKey = new JCheckBox();CheckCharKey.setBounds((width/2)/30,(height/2)/8,18,18);
            	CheckConsole.setSelected(isConsoleActive);
            	CheckConsole.addActionListener(new ActionListener(){//////// CHECKCONSOLE CHECKBOX
                    public void actionPerformed(ActionEvent e){
                    	isConsoleActive = CheckConsole.isSelected();
                    	                   	
                    }
                });
            	
            	saveChanges.addActionListener(new ActionListener(){//////// SAVECHANGES BUTTON
                    public void actionPerformed(ActionEvent e){
                    	AdvancedCKEY = JTA.getText();
                    	CKey = AdvancedCKEY.split("-CH-");
                    	if(!(CKey.length>127)){
                    		System.out.println("Character key is missing. The default character key will be used.");
                    		CKey = Translator.DefaultCKEY;
                    		JTA.setText("-CH-1-CH-2-CH-3-CH-4-CH-5-CH-6-CH-7-CH-8-CH-9-CH-0-CH-a-CH-b-CH-c-CH-ç-CH-d-CH-e-CH-f-CH-g"
		  	  + "-CH-ğ-CH-h-CH-ı-CH-i-CH-j-CH-k-CH-l-CH-m-CH-n-CH-o-CH-ö-CH-p-CH-q-CH-r-CH-s-CH-ş-CH-t-CH-u"
		  	  + "-CH-ü-CH-v-CH-w-CH-x-CH-y-CH-z-CH-A-CH-B-CH-C-CH-Ç-CH-D-CH-E-CH-F-CH-G-CH-Ğ-CH-H-CH-I-CH-İ"
		  	  + "-CH-J-CH-K-CH-L-CH-M-CH-N-CH-O-CH-Ö-CH-P-CH-Q-CH-R-CH-S-CH-Ş-CH-T-CH-U-CH-Ü-CH-V-CH-W-CH-X"
		  	  + "-CH-Y-CH-Z-CH-.-CH-:-CH-,-CH-;-CH-~-CH-`-CH-\"-CH-!-CH-'-CH-^-CH-+-CH-%-CH-&-CH-/-CH-(-CH-)"
		  	  + "-CH-=-CH-?-CH-_-CH-<-CH->-CH-£-CH-#-CH-$-CH-½-CH-{-CH-[-CH-]-CH-}-CH-\\-CH-|-CH-@-CH-€-CH-æ"
		  	  + "-CH-ß-CH-√-CH-²-CH-±-CH-	-CH-≥-CH-î-CH-â-CH-é-CH- -CH-à-CH-\n-CH-“-CH-”-CH-’-CH---CH-á-CH-ê"
		  	  + "-CH-*-CH-�");
                    	}
                    	JFA.setVisible(false);                    	                   	
                    }
                });
            	
            	CheckCharKey.addActionListener(new ActionListener(){//////// CHECKCHARKEY CHECKBOX
                    public void actionPerformed(ActionEvent e){   
                    	if(CheckConsole.isSelected()){JTA.setEnabled(true);}else{JTA.setEnabled(false);}                    		
                    }
                });
            	JPA.setBackground(new Color(0,0,0,0));
            	JPA.add(JLCharKey);
            	JPA.add(JLConsoleisActive);
            	JPA.add(CheckConsole);
            	JPA.add(CheckCharKey);
            	JPA.add(JTA);
            	JPA.add(saveChanges);
            	JFA.add(JPA);        
        //ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED//ADVANCED
        
        
        selectKey.addActionListener(new ActionListener(){/////// SELECTKEY BUTTON
        	public void actionPerformed(ActionEvent e){
        		JFileChooser fc = new JFileChooser();
        		fc.setDialogTitle("Please choose key image...");
        		fc.setAcceptAllFileFilterUsed(false);
        		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Formats", "jpeg", "jpg", "png", "bmp", "gif");
        		fc.addChoosableFileFilter(filter);
        		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        		    File selectedFile = fc.getSelectedFile();
        		    try {
        		    	if(isConsoleActive)
        		    	System.out.println("Selected File: "+selectedFile.getName());
        		        Key = ImageIO.read(selectedFile);
        		        loadedKey.setText("");
        		        KeyIMGName = selectedFile.getName();
        		        KeyFilePath = selectedFile.getPath();
        		        frame.repaint();
        		        randomKey.setEnabled(true);
        		        selectCrypt.setEnabled(true);
        		    } catch (IOException ex) {
        		        ex.printStackTrace();
        		    }
        		}
        		
        	}
        });       
        selectCrypt.addActionListener(new ActionListener(){///// SELECTCRYPT BUTTON
            public void actionPerformed(ActionEvent e){
            	JFileChooser fc = new JFileChooser();
        		fc.setDialogTitle("Please choose encrypt image...");
        		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg", "jpg", "png", "bmp", "gif");
        		fc.setAcceptAllFileFilterUsed(false);
        		fc.addChoosableFileFilter(filter);
        		if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        		    File selectedFile = fc.getSelectedFile();
        		    if(selectedFile.getPath().equals(KeyFilePath)){
        		    		if(isConsoleActive)
        		    		System.out.println("Warning: selected first image "+selectedFile.getName()+" is the same as the second image.");
        		        	Console.setText(Console.getText()+"\nWarning: Key image is the same as the encrypt image");
        		        	
        		    }
        		    
        		    try {
        		    	if(isConsoleActive)
        		    	System.out.println("Selected File: "+selectedFile.getName()+"\n");
        		        Crypt = ImageIO.read(selectedFile);
        		        loadedEncrypt.setText("");
        		        EncryptIMGName = selectedFile.getName();
        		        frame.repaint();
        		        decrypt.setEnabled(true);
        		        encrypt.setEnabled(true);
        		        syncKey.setEnabled(true);
        		        saveFile.setEnabled(true);
        		    } catch (IOException ex) {
        		        ex.printStackTrace();
        		    }
        		}
            }
          });              
        encrypt.addActionListener(new ActionListener(){///////// ENCRYPT BUTTON
            public void actionPerformed(ActionEvent e){            	
            	CryptWriter.CryptWrite(Key, Crypt, Console.getText());
            	frame.repaint();
            }
          });
        decrypt.addActionListener(new ActionListener(){///////// DECRYPT BUTTON
            public void actionPerformed(ActionEvent e){ 
            	Console.setText(CryptReader.getComparisonText(Key,Crypt));
            }
          });
        randomKey.addActionListener(new ActionListener(){/////// RANDOMIZE BUTTON
            public void actionPerformed(ActionEvent e){
            	CryptWriter.Randomize(Key);
            	frame.repaint();
            }
          });
        syncKey.addActionListener(new ActionListener(){///////// SYNCKEY BUTTON
            public void actionPerformed(ActionEvent e){
            	CryptWriter.Synchronize(Key, Crypt);
            	frame.repaint();
            }
          });
        saveFile.addActionListener(new ActionListener(){//////// SAVEFILE BUTTON
            public void actionPerformed(ActionEvent e){
            	if(isConsoleActive){
            	System.out.println("File saved: "+System.getProperty("user.home") + "\\Desktop"+"\\Encrypted-"+EncryptIMGName);}else{
            		Console.setText(Console.getText()+"\nFile saved: "+System.getProperty("user.home") + "\\Desktop"+"\\Encrypted-"+EncryptIMGName);
            	}
            	File outputfile = new File(System.getProperty("user.home") + "\\Desktop"+"\\Encrypted-"+EncryptIMGName);
            	try {
					ImageIO.write(Crypt, "png", outputfile);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
        Advanced.addActionListener(new ActionListener(){//////// ADVANCED BUTTON
            public void actionPerformed(ActionEvent e){
            	JFA.setVisible(true);
            }
          });////////////////ADVANCED END
        Exit.addActionListener(new ActionListener(){//////////// EXIT BUTTON
            public void actionPerformed(ActionEvent e){   
            	System.exit(0);
            }
          });
      
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
            	frame.setContentPane(new Background());       
            	frame.setUndecorated(true);
        	     
            	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
            	panel = new MotionPanel(frame);
            	panel.setLayout(null);
        
        
            	panel.add(selectKey);
            	panel.add(selectCrypt);
            	panel.add(encrypt);
            	panel.add(decrypt);
            	panel.add(randomKey);
            	panel.add(syncKey);
            	panel.add(saveFile);
            	panel.add(Advanced);
            	panel.add(Exit);
       
            	panel.add(logo);
            	panel.add(menuLabel);
        
            	panel.add(loadedKey);
            	panel.add(loadedEncrypt);
        
            	panel.add(scroll);
            	panel.setOpaque(false);
            	frame.setVisible(true);
            	frame.add(panel);
            }});
        
        
        
   }
    
    
   public static void main(String...Args){
	   new Panel();
	   
   }
    
   
}
 