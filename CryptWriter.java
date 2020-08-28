import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Random;

public class CryptWriter {

	static Random R = new Random();
	static int isChange;
	static Translator TR = new Translator();
	static String WProgress = "";
	
	public static void CryptWrite(BufferedImage KeyIMG, BufferedImage EncryptIMG,String Text){
		int I1PL = KeyIMG.getWidth()*KeyIMG.getHeight();    //THE NUMBER OF PIXELS
		int I2PL = EncryptIMG.getWidth()*EncryptIMG.getHeight();//THE NUMBER OF PIXELS
		
		
		
		int pixelLength = I1PL;//DEFAULT (EQUALS)
		if(I1PL<I2PL)		   //Small value will be processed to avoid blank pixels
			pixelLength = I1PL;
		else
			pixelLength = I2PL;	
		
		
			
		
		if(Panel.isConsoleActive){
			if(Text.length()*7>pixelLength*3){
				System.out.println("The length of the text to be printed: "+Panel.Console.getText().length());
				System.out.println("Warning: Text clipped because the image could not be compressed.");				
				Text = Text.substring(0,(pixelLength*3)/7);
				System.out.println("New text length: "+Text.length());				
				System.out.println("Writer Started");
			}else{
				System.out.println("The length of the text to be printed: "+Panel.Console.getText().length());
				System.out.println("Writer Started");	
			}
		}
		if(Panel.isConsoleActive)
		System.out.println("The text was sent to the translator.");
		Text = "<L>"+Text.length()+"<L>"+Text;
		String TBP = TR.getInstantBinary(Text);
		for(int pixelCount = 0;pixelCount<pixelLength&&pixelCount*3<Text.length()*7;pixelCount++){				
				
			int KeyX = pixelCount%KeyIMG.getWidth();
			int KeyY = pixelCount/KeyIMG.getWidth();
			
			int EncryptX = pixelCount%EncryptIMG.getWidth();
			int EncryptY = pixelCount/EncryptIMG.getWidth();
			
			if(Panel.isConsoleActive){
				if(TBP.length()>700){
					if((Text.length()*7>pixelLength*3)){						
							if(pixelLength%(pixelLength/100)==pixelCount%(pixelLength/100)){
								WProgress = "Writer Progress.. %"+(pixelCount*100/pixelLength);
								System.out.println(WProgress);	
							}
					}else{					
								if(pixelCount%((TBP.length()/100)/3)==0){
									WProgress = "Writer Progress.. %"+(pixelCount*100/(TBP.length()/3));
									System.out.println(WProgress);	
								}																
					}
				}
			}
			
					//////////////////////////////////////////RED
					if(TBP.length()>pixelCount*3)
					if(new Color(KeyIMG  .getRGB(KeyX, KeyY)).getRed()%2==
							Integer.parseInt(""+TBP.charAt(pixelCount*3))){					
						if(new Color(EncryptIMG  .getRGB(EncryptX, EncryptY)).getRed()%2==0){
							EncryptIMG.setRGB(EncryptX, EncryptY,new Color(
								new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed()+1,
								new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen(),
								new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue(),
								new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());}
									}else{																
										if(new Color(EncryptIMG  .getRGB(EncryptX, EncryptY)).getRed()%2==1){
											EncryptIMG.setRGB(EncryptX, EncryptY,new Color(
													new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed()-1,
													new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen(),
													new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue(),
													new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());}	
						}	
					//////////////////////////////////////////GREEN
					if(TBP.length()>pixelCount*3+1)
					if(new Color(KeyIMG  .getRGB(KeyX, KeyY)).getGreen()%2==
							Integer.parseInt(""+TBP.charAt(pixelCount*3+1))){
						if(new Color(EncryptIMG  .getRGB(EncryptX, EncryptY)).getGreen()%2==0){	
							EncryptIMG.setRGB(EncryptX, EncryptY,new Color(
								new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed(),
								new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen()+1,
								new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue(),
								new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());}
									}else{																	
										if(new Color(EncryptIMG  .getRGB(EncryptX, EncryptY)).getGreen()%2==1){
											EncryptIMG.setRGB(EncryptX, EncryptY,new Color(
													new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed(),
													new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen()-1,
													new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue(),
													new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());}	
						}	
					//////////////////////////////////////////BLUE
					if(TBP.length()>pixelCount*3+2)
						if(new Color(KeyIMG  .getRGB(KeyX, KeyY)).getBlue()%2==
								Integer.parseInt(""+TBP.charAt(pixelCount*3+2))){
							if(new Color(EncryptIMG  .getRGB(EncryptX, EncryptY)).getBlue()%2==0){		
								EncryptIMG.setRGB(EncryptX, EncryptY,new Color(
									new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed(),
									new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen(),
									new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue()+1,
									new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());}
										}else{																	
											if(new Color(EncryptIMG  .getRGB(EncryptX, EncryptY)).getBlue()%2==1){
												EncryptIMG.setRGB(EncryptX, EncryptY,new Color(
														new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed(),
														new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen(),
														new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue()-1,
														new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());}	
							}	
							
		}	
		
		Panel.loadedEncrypt.setText("ENCRYPTED");
		
		if(Panel.isConsoleActive){
			if((Text.length()*7>pixelLength*3)){
				System.out.println("Writing completed.\nEncryption completed. "+pixelLength*3+" bit data processed to "+Panel.EncryptIMGName+"\n\n\n");
			}else{
				System.out.println("Writing completed.\nEncryption completed. "+TBP.length()+" bit data processed to "+Panel.EncryptIMGName+"\n\n\n");
			}
		}	
		
	}
	////////////////////////////////////////////////////////////////////WRITER END
	
	////////////////////////////////////////////////////////////////////RANDOMIZE ALGORITHM START	
	public static void Randomize(BufferedImage Image){					
		int pixelLength = Image.getWidth()*Image.getHeight();
		
		for(int pixelCount = 0;pixelCount<pixelLength;pixelCount++){				
			
			if(Panel.isConsoleActive)
			if(pixelLength%(pixelLength/100)==pixelCount%(pixelLength/100)){
				System.out.println("Randomizing progress... %"+pixelCount*100/pixelLength);
			}
			
			
			int x = pixelCount%Image.getWidth();
			int y = pixelCount/Image.getWidth();						
			
			isChange = R.nextInt(2);
			if(isChange==1){
				if(new Color(Image.getRGB(x, y)).getRed()%2==0){
					Image.setRGB(x, y,new Color(new Color(Image.getRGB(x, y)).getRed()+1,
												new Color(Image.getRGB(x, y)).getGreen(),
												new Color(Image.getRGB(x, y)).getBlue(),
												new Color(Image.getRGB(x, y)).getAlpha()).getRGB());}else
												{
													Image.setRGB(x, y,new Color(new Color(Image.getRGB(x, y)).getRed()-1,
																				new Color(Image.getRGB(x, y)).getGreen(),
																				new Color(Image.getRGB(x, y)).getBlue(),
																				new Color(Image.getRGB(x, y)).getAlpha()).getRGB());}	
			}
			isChange = R.nextInt(2);			
			if(isChange==1){
				if(new Color(Image.getRGB(x, y)).getGreen()%2==0){
					Image.setRGB(x, y,new Color(new Color(Image.getRGB(x, y)).getRed(),
												new Color(Image.getRGB(x, y)).getGreen()+1,
												new Color(Image.getRGB(x, y)).getBlue(),
												new Color(Image.getRGB(x, y)).getAlpha()).getRGB());}else
												{
													Image.setRGB(x, y,new Color(new Color(Image.getRGB(x, y)).getRed(),
																				new Color(Image.getRGB(x, y)).getGreen()-1,
																				new Color(Image.getRGB(x, y)).getBlue(),
																				new Color(Image.getRGB(x, y)).getAlpha()).getRGB());}
			}
			isChange = R.nextInt(2);			
			if(isChange==1){
				if(new Color(Image.getRGB(x, y)).getBlue()%2==0){
					Image.setRGB(x, y,new Color(new Color(Image.getRGB(x, y)).getRed(),
												new Color(Image.getRGB(x, y)).getGreen(),
												new Color(Image.getRGB(x, y)).getBlue()+1,
												new Color(Image.getRGB(x, y)).getAlpha()).getRGB());}else
												{
													Image.setRGB(x, y,new Color(new Color(Image.getRGB(x, y)).getRed(),
																				new Color(Image.getRGB(x, y)).getGreen(),
																				new Color(Image.getRGB(x, y)).getBlue()-1,
																				new Color(Image.getRGB(x, y)).getAlpha()).getRGB());}
													
			}
			
		}
		Panel.loadedKey.setText("RANDOMIZED");
		if(Panel.isConsoleActive)
		System.out.println("Key image randomized.\n");
	}																	
	////////////////////////////////////////////////////////////////////RANDOMIZE ALGORITHM END
	
	
	////////////////////////////////////////////////////////////////////SYNC ALGORITHM START
	public static void Synchronize(BufferedImage KeyIMG,BufferedImage EncryptIMG){
		int I1PL = KeyIMG.getWidth()*KeyIMG.getHeight();    //THE NUMBER OF PIXELS
		int I2PL = EncryptIMG.getWidth()*EncryptIMG.getHeight();//THE NUMBER OF PIXELS
				
		int pixelLength = I1PL;//DEFAULT (EQUALS)
		if(I1PL<I2PL)		   //Small value will be processed to avoid blank pixels
			pixelLength = I1PL;
		else
			pixelLength = I2PL;
						
		for(int pixelCount = 0;pixelCount<pixelLength;pixelCount++){
			int KeyX = pixelCount%KeyIMG.getWidth();
			int KeyY = pixelCount/KeyIMG.getWidth();
			
			int EncryptX = pixelCount%EncryptIMG.getWidth();
			int EncryptY = pixelCount/EncryptIMG.getWidth();
			
			if(Panel.isConsoleActive)
				if(pixelLength%(pixelLength/100)==pixelCount%(pixelLength/100)){
					System.out.println("Synchronization progress... %"+pixelCount*100/pixelLength);
				}
			
			if(new Color(KeyIMG.getRGB(KeyX, KeyY)).getRed()%2!=new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed()%2){
				
				if(new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed()%2==1){
					 EncryptIMG.setRGB(EncryptX,EncryptY,new Color(
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed()-1,
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());
				}else{
				   	 EncryptIMG.setRGB(EncryptX,EncryptY,new Color(
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed()+1,
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());
				}
					
				
			}
			if(new Color(KeyIMG.getRGB(KeyX, KeyY)).getGreen()%2!=new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen()%2){
				
				if(new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen()%2==1){
					 EncryptIMG.setRGB(EncryptX,EncryptY,new Color(
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen()-1,
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());
				}else{
				   	 EncryptIMG.setRGB(EncryptX,EncryptY,new Color(
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen()+1,
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());
				}
				
			}
			if(new Color(KeyIMG.getRGB(KeyX, KeyY)).getBlue()%2!=new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue()%2){
	
				if(new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue()%2==1){
					 EncryptIMG.setRGB(EncryptX,EncryptY,new Color(
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue()-1,
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());
				}else{
				   	 EncryptIMG.setRGB(EncryptX,EncryptY,new Color(
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getRed(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getGreen(),
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getBlue()+1,
							new Color(EncryptIMG.getRGB(EncryptX, EncryptY)).getAlpha()).getRGB());
				}
	
			}
		}
		Panel.loadedEncrypt.setText("SYNCHRONIZED");
		if(Panel.isConsoleActive)
		System.out.println("Encrypted image was synchronized with the key image.\n");
	}
	////////////////////////////////////////////////////////////////////SYNC ALGORITHM END

	
}//CLASS END
