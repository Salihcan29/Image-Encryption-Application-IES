import java.awt.Color;
import java.awt.image.BufferedImage;

public class CryptReader {
	
	static StringBuilder ComparisonText;//FUNCTION OUTPUT STRING
	static String SimultaneousComparison ="";//SIMULTANEOUS TRANSLATION STRING
	
	static Translator TR = new Translator();
	static int textLength;
	static int tagLength;
	static String RProgress;

	public static String getComparisonText(BufferedImage KeyIMG,BufferedImage CryptIMG){
		ComparisonText = new StringBuilder();
		SimultaneousComparison="";
		tagLength=0;
		
		
		int I1PL = KeyIMG.getWidth()*KeyIMG.getHeight();    //THE NUMBER OF PIXELS
		int I2PL = CryptIMG.getWidth()*CryptIMG.getHeight();//THE NUMBER OF PIXELS
		
		
		int pixelLength = I1PL;//DEFAULT (EQUALS)
		if(I1PL<I2PL)		   //Small value will be processed to avoid blank pixels
			pixelLength = I1PL;
		else
			pixelLength = I2PL;		
		if(Panel.isConsoleActive)
		System.out.println("Reader started.");
		
		for(int pixelCount = 0;pixelCount<pixelLength;pixelCount++){
						
			if(pixelCount>35)
				if(pixelLength>100)
						if(pixelLength%(pixelLength/100)==pixelCount%(pixelLength/100)){
							RProgress = "Reader&Translate Progress... %"+(pixelCount*100/pixelLength);
							System.out.println(RProgress);	
						}
			
			if(pixelCount%7==0){				
				
				if(SimultaneousComparison.length()%7==0){
									
					ComparisonText.append(TR.getInstantText(SimultaneousComparison));
					
					////////////////////////////////////////////////////////////////
					if(pixelCount==35){
					
						if(ComparisonText.toString().split("<L>").length>1){
							textLength = Integer.parseInt(ComparisonText.toString().split("<L>")[1]);						
							tagLength = 6+ComparisonText.toString().split("<L>")[1].length();	
							if(pixelLength>textLength+tagLength){
								pixelLength=((textLength+tagLength)*7)/3+7;
							}
							
							
						}else{
						//textLength=ComparisonText.length();						
						}
					
					}
					////////////////////////////////////////////////////////////////
					
					
				}												
												
				SimultaneousComparison = "";			
			}
			
			
					
			int KeyX = pixelCount%KeyIMG.getWidth();
			int KeyY = pixelCount/KeyIMG.getWidth();
			
			int CryptX = pixelCount%CryptIMG.getWidth();
			int CryptY = pixelCount/CryptIMG.getWidth();
			
			if(KeyIMG.getWidth()>KeyX&&KeyIMG.getHeight()>KeyY&&CryptIMG.getWidth()>CryptX&&CryptIMG.getHeight()>CryptY){
				if(new Color(KeyIMG  .getRGB(KeyX, KeyY)).getRed()%2==
				   new Color(CryptIMG.getRGB(CryptX, CryptY)).getRed()%2)
				    {SimultaneousComparison+="1";}else{SimultaneousComparison+="0";}				
				if(new Color(KeyIMG  .getRGB(KeyX, KeyY)).getGreen()%2==
				   new Color(CryptIMG.getRGB(CryptX, CryptY)).getGreen()%2)
					{SimultaneousComparison+="1";}else{SimultaneousComparison+="0";}					
				if(new Color(KeyIMG  .getRGB(KeyX, KeyY)).getBlue()%2==
				   new Color(CryptIMG.getRGB(CryptX, CryptY)).getBlue()%2)
					{SimultaneousComparison+="1";}else{SimultaneousComparison+="0";}
			}
		}
		
		if(Panel.isConsoleActive)
		System.out.println("Reading completed.\n\n"+pixelLength*3+" bit data readed.\n\n");
		
		
			
			
		if(tagLength+textLength>pixelLength){		
			textLength = pixelLength-tagLength-1;}
		
		String ReadingResult = ComparisonText.toString();
		
		if(tagLength!=0){	
		if(ComparisonText.toString().length()>=textLength+tagLength)			
			ReadingResult=ReadingResult.substring(tagLength,textLength+tagLength);
		else
			ReadingResult=ReadingResult.substring(tagLength,ReadingResult.length());}
		
		return ReadingResult;		
	}
	
	
	
}
