
public class Translator {

	static StringBuilder instantText;
	static StringBuilder instantBinary;
	static String WTProgress="";
	static String[] DefaultCKEY = ("-CH-1-CH-2-CH-3-CH-4-CH-5-CH-6-CH-7-CH-8-CH-9-CH-0-CH-a-CH-b-CH-c-CH-ç-CH-d-CH-e-CH-f-CH-g"
		  	  + "-CH-ğ-CH-h-CH-ı-CH-i-CH-j-CH-k-CH-l-CH-m-CH-n-CH-o-CH-ö-CH-p-CH-q-CH-r-CH-s-CH-ş-CH-t-CH-u"
		  	  + "-CH-ü-CH-v-CH-w-CH-x-CH-y-CH-z-CH-A-CH-B-CH-C-CH-Ç-CH-D-CH-E-CH-F-CH-G-CH-Ğ-CH-H-CH-I-CH-İ"
		  	  + "-CH-J-CH-K-CH-L-CH-M-CH-N-CH-O-CH-Ö-CH-P-CH-Q-CH-R-CH-S-CH-Ş-CH-T-CH-U-CH-Ü-CH-V-CH-W-CH-X"
		  	  + "-CH-Y-CH-Z-CH-.-CH-:-CH-,-CH-;-CH-~-CH-`-CH-\"-CH-!-CH-'-CH-^-CH-+-CH-%-CH-&-CH-/-CH-(-CH-)"
		  	  + "-CH-=-CH-?-CH-_-CH-<-CH->-CH-£-CH-#-CH-$-CH-½-CH-{-CH-[-CH-]-CH-}-CH-\\-CH-|-CH-@-CH-€-CH-æ"
		  	  + "-CH-ß-CH-√-CH-²-CH-±-CH-	-CH-≥-CH-î-CH-â-CH-é-CH- -CH-à-CH-\n-CH-“-CH-”-CH-’-CH---CH-á-CH-ê"
		  	  + "-CH-*-CH-�").split("-CH-");
	static int unknownCount;
	
	public String getInstantText(String binary){
		
		String[] CK;		
		if(Panel.CKey.length>127){
			CK = Panel.CKey;
		}else{			
			CK = DefaultCKEY;
		}
		
		if(binary.length()%7 != 0){
			if(Panel.isConsoleActive){
			System.out.println("ERROR: There is an error in the translator codes. Try restart program");}
			else{Panel.Console.setText(Panel.Console.getText()+"\nERROR: There is an error in the translator codes. Try restart program");}
		}else{
			instantText = new StringBuilder(); 
			for(int i=0;i<binary.length()/7;i++){
				
				switch(binary.substring(i*7,i*7+7)){
				case "0000000": instantText.append(CK[1]);break;case "0000001": instantText.append(CK[2]);break;case "0000010": instantText.append(CK[3]);break;
				case "0000011": instantText.append(CK[4]);break;case "0000100": instantText.append(CK[5]);break;case "0000101": instantText.append(CK[6]);break;
				case "0000110": instantText.append(CK[7]);break;case "0000111": instantText.append(CK[8]);break;case "0001000": instantText.append(CK[9]);break;
				case "0001001": instantText.append(CK[10]);break;case "0001010": instantText.append(CK[11]);break;case "0001011": instantText.append(CK[12]);break;
				case "0001100": instantText.append(CK[13]);break;case "0001101": instantText.append(CK[14]);break;case "0001110": instantText.append(CK[15]);break;
				case "0001111": instantText.append(CK[16]);break;case "0010000": instantText.append(CK[17]);break;case "0010001": instantText.append(CK[18]);break;
				case "0010010": instantText.append(CK[19]);break;case "0010011": instantText.append(CK[20]);break;case "0010100": instantText.append(CK[21]);break;
				case "0010101": instantText.append(CK[22]);break;case "0010110": instantText.append(CK[23]);break;case "0010111": instantText.append(CK[24]);break;
				case "0011000": instantText.append(CK[25]);break;case "0011001": instantText.append(CK[26]);break;case "0011010": instantText.append(CK[27]);break;
				case "0011011": instantText.append(CK[28]);break;case "0011100": instantText.append(CK[29]);break;case "0011101": instantText.append(CK[30]);break;
				case "0011110": instantText.append(CK[31]);break;case "0011111": instantText.append(CK[32]);break;case "0100000": instantText.append(CK[33]);break;
				case "0100001": instantText.append(CK[34]);break;case "0100010": instantText.append(CK[35]);break;case "0100011": instantText.append(CK[36]);break;
				case "0100100": instantText.append(CK[37]);break;case "0100101": instantText.append(CK[38]);break;case "0100110": instantText.append(CK[39]);break;
				case "0100111": instantText.append(CK[40]);break;case "0101000": instantText.append(CK[41]);break;case "0101001": instantText.append(CK[42]);break;
				case "0101010": instantText.append(CK[43]);break;case "0101011": instantText.append(CK[44]);break;case "0101100": instantText.append(CK[45]);break;
				case "0101101": instantText.append(CK[46]);break;case "0101110": instantText.append(CK[47]);break;case "0101111": instantText.append(CK[48]);break;
				case "0110000": instantText.append(CK[49]);break;case "0110001": instantText.append(CK[50]);break;case "0110010": instantText.append(CK[51]);break;
				case "0110011": instantText.append(CK[52]);break;case "0110100": instantText.append(CK[53]);break;case "0110101": instantText.append(CK[54]);break;
				case "0110110": instantText.append(CK[55]);break;case "0110111": instantText.append(CK[56]);break;case "0111000": instantText.append(CK[57]);break;
				case "0111001": instantText.append(CK[58]);break;case "0111010": instantText.append(CK[59]);break;case "0111011": instantText.append(CK[60]);break;
				case "0111100": instantText.append(CK[61]);break;case "0111101": instantText.append(CK[62]);break;case "0111110": instantText.append(CK[63]);break;
				case "0111111": instantText.append(CK[64]);break;case "1000000": instantText.append(CK[65]);break;case "1000001": instantText.append(CK[66]);break;
				case "1000010": instantText.append(CK[67]);break;case "1000011": instantText.append(CK[68]);break;case "1000100": instantText.append(CK[69]);break;
				case "1000101": instantText.append(CK[70]);break;case "1000110": instantText.append(CK[71]);break;case "1000111": instantText.append(CK[72]);break;
				case "1001000": instantText.append(CK[73]);break;case "1001001": instantText.append(CK[74]);break;case "1001010": instantText.append(CK[75]);break;
				case "1001011": instantText.append(CK[76]);break;case "1001100": instantText.append(CK[77]);break;case "1001101": instantText.append(CK[78]);break;
				case "1001110": instantText.append(CK[79]);break;case "1001111": instantText.append(CK[80]);break;case "1010000": instantText.append(CK[81]);break;
				case "1010001": instantText.append(CK[82]);break;case "1010010": instantText.append(CK[83]);break;case "1010011": instantText.append(CK[84]);break;
				case "1010100": instantText.append(CK[85]);break;case "1010101": instantText.append(CK[86]);break;case "1010110": instantText.append(CK[87]);break;
				case "1010111": instantText.append(CK[88]);break;case "1011000": instantText.append(CK[89]);break;case "1011001": instantText.append(CK[90]);break;
				case "1011010": instantText.append(CK[91]);break;case "1011011": instantText.append(CK[92]);break;case "1011100": instantText.append(CK[93]);break;
				case "1011101": instantText.append(CK[94]);break;case "1011110": instantText.append(CK[95]);break;case "1011111": instantText.append(CK[96]);break;
				case "1100000": instantText.append(CK[97]);break;case "1100001": instantText.append(CK[98]);break;case "1100010": instantText.append(CK[99]);break;
				case "1100011": instantText.append(CK[100]);break;case "1100100": instantText.append(CK[101]);break;case "1100101": instantText.append(CK[102]);break;
				case "1100110": instantText.append(CK[103]);break;case "1100111": instantText.append(CK[104]);break;case "1101000": instantText.append(CK[105]);break;
				case "1101001": instantText.append(CK[106]);break;case "1101010": instantText.append(CK[107]);break;case "1101011": instantText.append(CK[108]);break;
				case "1101100": instantText.append(CK[109]);break;case "1101101": instantText.append(CK[110]);break;case "1101110": instantText.append(CK[111]);break;
				case "1101111": instantText.append(CK[112]);break;case "1110000": instantText.append(CK[113]);break;case "1110001": instantText.append(CK[114]);break;
				case "1110010": instantText.append(CK[115]);break;case "1110011": instantText.append(CK[116]);break;case "1110100": instantText.append(CK[117]);break;
				case "1110101": instantText.append(CK[118]);break;case "1110110": instantText.append(CK[119]);break;case "1110111": instantText.append(CK[120]);break;
				case "1111000": instantText.append(CK[121]);break;case "1111001": instantText.append(CK[122]);break;case "1111010": instantText.append(CK[123]);break;
				case "1111011": instantText.append(CK[124]);break;case "1111100": instantText.append(CK[125]);break;case "1111101": instantText.append(CK[126]);break;
				case "1111110": instantText.append(CK[127]);break;case "1111111": instantText.append(CK[128]);break;
				}
						
			}
			
		}
		return instantText.toString();
	}//INSTANT TEXT FUNCTION END
	
	public String getInstantBinary(String Text){
		
		String[] CK;		
		if(Panel.CKey.length>127){
			CK = Panel.CKey;
		}else{
			System.out.println("Character key is missing. Must be 128 characters. Default character key will be used.");
			CK = DefaultCKEY;
		}
		
		unknownCount = 0;
		instantBinary = new StringBuilder (Text.length()*7);
		
		WTProgress = "";
		
		//DEFAULT
		if(Panel.isConsoleActive)
		System.out.println("Binary translation started.");
		for(int i=0;i<Text.length();i++){//FOR LOOP START						
			if(Panel.isConsoleActive){
				if(Text.length()>100){
					if(Text.length()%(Text.length()/100)==i%(Text.length()/100)){
						WTProgress = "Translate Progress.. %"+(i*100/Text.length());
						System.out.println(WTProgress);	
					}
				}
			}	
			
			String string = ""+Text.charAt(i);
				   if (CK[1].equals(string)) {
				instantBinary.append("0000000");
			} else if (CK[2].equals(string)) {
				instantBinary.append("0000001");
			} else if (CK[3].equals(string)) {
				instantBinary.append("0000010");
			} else if (CK[4].equals(string)) {
				instantBinary.append("0000011");
			} else if (CK[5].equals(string)) {
				instantBinary.append("0000100");
			} else if (CK[6].equals(string)) {
				instantBinary.append("0000101");
			} else if (CK[7].equals(string)) {
				instantBinary.append("0000110");
			} else if (CK[8].equals(string)) {
				instantBinary.append("0000111");
			} else if (CK[9].equals(string)) {
				instantBinary.append("0001000");
			} else if (CK[10].equals(string)) {
				instantBinary.append("0001001");
			} else if (CK[11].equals(string)) {
				instantBinary.append("0001010");
			} else if (CK[12].equals(string)) {
				instantBinary.append("0001011");
			} else if (CK[13].equals(string)) {
				instantBinary.append("0001100");
			} else if (CK[14].equals(string)) {
				instantBinary.append("0001101");
			} else if (CK[15].equals(string)) {
				instantBinary.append("0001110");
			} else if (CK[16].equals(string)) {
				instantBinary.append("0001111");
			} else if (CK[17].equals(string)) {
				instantBinary.append("0010000");
			} else if (CK[18].equals(string)) {
				instantBinary.append("0010001");
			} else if (CK[19].equals(string)) {
				instantBinary.append("0010010");
			} else if (CK[20].equals(string)) {
				instantBinary.append("0010011");
			} else if (CK[21].equals(string)) {
				instantBinary.append("0010100");
			} else if (CK[22].equals(string)) {
				instantBinary.append("0010101");
			} else if (CK[23].equals(string)) {
				instantBinary.append("0010110");
			} else if (CK[24].equals(string)) {
				instantBinary.append("0010111");
			} else if (CK[25].equals(string)) {
				instantBinary.append("0011000");
			} else if (CK[26].equals(string)) {
				instantBinary.append("0011001");
			} else if (CK[27].equals(string)) {
				instantBinary.append("0011010");
			} else if (CK[28].equals(string)) {
				instantBinary.append("0011011");
			} else if (CK[29].equals(string)) {
				instantBinary.append("0011100");
			} else if (CK[30].equals(string)) {
				instantBinary.append("0011101");
			} else if (CK[31].equals(string)) {
				instantBinary.append("0011110");
			} else if (CK[32].equals(string)) {
				instantBinary.append("0011111");
			} else if (CK[33].equals(string)) {
				instantBinary.append("0100000");
			} else if (CK[34].equals(string)) {
				instantBinary.append("0100001");
			} else if (CK[35].equals(string)) {
				instantBinary.append("0100010");
			} else if (CK[36].equals(string)) {
				instantBinary.append("0100011");
			} else if (CK[37].equals(string)) {
				instantBinary.append("0100100");
			} else if (CK[38].equals(string)) {
				instantBinary.append("0100101");
			} else if (CK[39].equals(string)) {
				instantBinary.append("0100110");
			} else if (CK[40].equals(string)) {
				instantBinary.append("0100111");
			} else if (CK[41].equals(string)) {
				instantBinary.append("0101000");
			} else if (CK[42].equals(string)) {
				instantBinary.append("0101001");
			} else if (CK[43].equals(string)) {
				instantBinary.append("0101010");
			} else if (CK[44].equals(string)) {
				instantBinary.append("0101011");
			} else if (CK[45].equals(string)) {
				instantBinary.append("0101100");
			} else if (CK[46].equals(string)) {
				instantBinary.append("0101101");
			} else if (CK[47].equals(string)) {
				instantBinary.append("0101110");
			} else if (CK[48].equals(string)) {
				instantBinary.append("0101111");
			} else if (CK[49].equals(string)) {
				instantBinary.append("0110000");
			} else if (CK[50].equals(string)) {
				instantBinary.append("0110001");
			} else if (CK[51].equals(string)) {
				instantBinary.append("0110010");
			} else if (CK[52].equals(string)) {
				instantBinary.append("0110011");
			} else if (CK[53].equals(string)) {
				instantBinary.append("0110100");
			} else if (CK[54].equals(string)) {
				instantBinary.append("0110101");
			} else if (CK[55].equals(string)) {
				instantBinary.append("0110110");
			} else if (CK[56].equals(string)) {
				instantBinary.append("0110111");
			} else if (CK[57].equals(string)) {
				instantBinary.append("0111000");
			} else if (CK[58].equals(string)) {
				instantBinary.append("0111001");
			} else if (CK[59].equals(string)) {
				instantBinary.append("0111010");
			} else if (CK[60].equals(string)) {
				instantBinary.append("0111011");
			} else if (CK[61].equals(string)) {
				instantBinary.append("0111100");
			} else if (CK[62].equals(string)) {
				instantBinary.append("0111101");
			} else if (CK[63].equals(string)) {
				instantBinary.append("0111110");
			} else if (CK[64].equals(string)) {
				instantBinary.append("0111111");
			} else if (CK[65].equals(string)) {
				instantBinary.append("1000000");
			} else if (CK[66].equals(string)) {
				instantBinary.append("1000001");
			} else if (CK[67].equals(string)) {
				instantBinary.append("1000010");
			} else if (CK[68].equals(string)) {
				instantBinary.append("1000011");
			} else if (CK[69].equals(string)) {
				instantBinary.append("1000100");
			} else if (CK[70].equals(string)) {
				instantBinary.append("1000101");
			} else if (CK[71].equals(string)) {
				instantBinary.append("1000110");
			} else if (CK[72].equals(string)) {
				instantBinary.append("1000111");
			} else if (CK[73].equals(string)) {
				instantBinary.append("1001000");
			} else if (CK[74].equals(string)) {
				instantBinary.append("1001001");
			} else if (CK[75].equals(string)) {
				instantBinary.append("1001010");
			} else if (CK[76].equals(string)) {
				instantBinary.append("1001011");
			} else if (CK[77].equals(string)) {
				instantBinary.append("1001100");
			} else if (CK[78].equals(string)) {
				instantBinary.append("1001101");
			} else if (CK[79].equals(string)) {
				instantBinary.append("1001110");
			} else if (CK[80].equals(string)) {
				instantBinary.append("1001111");
			} else if (CK[81].equals(string)) {
				instantBinary.append("1010000");
			} else if (CK[82].equals(string)) {
				instantBinary.append("1010001");
			} else if (CK[83].equals(string)) {
				instantBinary.append("1010010");
			} else if (CK[84].equals(string)) {
				instantBinary.append("1010011");
			} else if (CK[85].equals(string)) {
				instantBinary.append("1010100");
			} else if (CK[86].equals(string)) {
				instantBinary.append("1010101");
			} else if (CK[87].equals(string)) {
				instantBinary.append("1010110");
			} else if (CK[88].equals(string)) {
				instantBinary.append("1010111");
			} else if (CK[89].equals(string)) {
				instantBinary.append("1011000");
			} else if (CK[90].equals(string)) {
				instantBinary.append("1011001");
			} else if (CK[91].equals(string)) {
				instantBinary.append("1011010");
			} else if (CK[92].equals(string)) {
				instantBinary.append("1011011");
			} else if (CK[93].equals(string)) {
				instantBinary.append("1011100");
			} else if (CK[94].equals(string)) {
				instantBinary.append("1011101");
			} else if (CK[95].equals(string)) {
				instantBinary.append("1011110");
			} else if (CK[96].equals(string)) {
				instantBinary.append("1011111");
			} else if (CK[97].equals(string)) {
				instantBinary.append("1100000");
			} else if (CK[98].equals(string)) {
				instantBinary.append("1100001");
			} else if (CK[99].equals(string)) {
				instantBinary.append("1100010");
			} else if (CK[100].equals(string)) {
				instantBinary.append("1100011");
			} else if (CK[101].equals(string)) {
				instantBinary.append("1100100");
			} else if (CK[102].equals(string)) {
				instantBinary.append("1100101");
			} else if (CK[103].equals(string)) {
				instantBinary.append("1100110");
			} else if (CK[104].equals(string)) {
				instantBinary.append("1100111");
			} else if (CK[105].equals(string)) {
				instantBinary.append("1101000");
			} else if (CK[106].equals(string)) {
				instantBinary.append("1101001");
			} else if (CK[107].equals(string)) {
				instantBinary.append("1101010");
			} else if (CK[108].equals(string)) {
				instantBinary.append("1101011");
			} else if (CK[109].equals(string)) {
				instantBinary.append("1101100");
			} else if (CK[110].equals(string)) {
				instantBinary.append("1101101");
			} else if (CK[111].equals(string)) {
				instantBinary.append("1101110");
			} else if (CK[112].equals(string)) {
				instantBinary.append("1101111");
			} else if (CK[113].equals(string)) {
				instantBinary.append("1110000");
			} else if (CK[114].equals(string)) {
				instantBinary.append("1110001");
			} else if (CK[115].equals(string)) {
				instantBinary.append("1110010");
			} else if (CK[116].equals(string)) {
				instantBinary.append("1110011");
			} else if (CK[117].equals(string)) {
				instantBinary.append("1110100");
			} else if (CK[118].equals(string)) {
				instantBinary.append("1110101");
			} else if (CK[119].equals(string)) {
				instantBinary.append("1110110");
			} else if (CK[120].equals(string)) {
				instantBinary.append("1110111");
			} else if (CK[121].equals(string)) {
				instantBinary.append("1111000");
			} else if (CK[122].equals(string)) {
				instantBinary.append("1111001");
			} else if (CK[123].equals(string)) {
				instantBinary.append("1111010");
			} else if (CK[124].equals(string)) {
				instantBinary.append("1111011");
			} else if (CK[125].equals(string)) {
				instantBinary.append("1111100");
			} else if (CK[126].equals(string)) {
				instantBinary.append("1111101");
			} else if (CK[127].equals(string)) {
				instantBinary.append("1111110");
			} else if (CK[128].equals(string)) {
				instantBinary.append("1111111");
			} else {
				System.out.println("Unknown character \""+Text.charAt(i)+"\", will not be encoded.");
				instantBinary.append("1111111");
				unknownCount+=1;
			}
							
		}//FOR LOOP END
		
		
		if(unknownCount!=0){
				System.out.println("There are "+unknownCount+" unknown character.");
			}
		
		if(Panel.isConsoleActive)
			System.out.println("Binary translation completed.");
		return instantBinary.toString();
	}
	
}
