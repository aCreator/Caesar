import java.util.HashMap;

public class Caesar {
	
	public static void main(String[] args) {
		String message = "eituih, rinsfy ltgivtl mwb livu sf mrim cgiet, kteixut rt ril ifmsescimtl mrim, sf mrt fimxhig ebxhut ba tntfmu, uxer wbxgl kt mrt ebflxem ba nthesfytmbhsq, gtintu mrt ihdv xflth chtmtfut ba hisusfy htehxsmu ifl einighv: rt cgietu khxmxu, i vbxfy dif, sf ebddifl ba mrtut abhetu; rt ysntu rsd sfumhxemsbfu mrim mrt einighv urbxgl hifyt iu tqmtfusntgv iu cbuuskgt sf igg lshtemsbfu; mrim rt wbxgl tqthm rsdutga fbm mb kt ikutfm ahbd mrt eidc gbfyth mrif mrhtt livu. rinsfy ihhifytl mrtut dimmthu, rt dihertu mb nstffi kv iu gbfy zbxhftvu iu rt eif, wrtf rsu bwf ubglsthu lsl fbm tqctem rsd. asflsfy mrtht i ahtur kblv ba einighv, wrser rt ril utfm bf mb mrim cgiet utnthig livu ktabht, dihersfy sfetuuifmgv fsyrm ifl liv, rt ilnifetl hicslgv mrhbxyr mrt mthhsmbhv ba mrt itlxs sfmb mrim ba mrt gsfybftu, sf wrser mwb gtysbfu wtht wsfmthsfy, mrim, sa ifv cgif iaatemsfy rsu bwf uiatmv urbxgl rint kttf bhyifsotl kv mrt itlxs, rt dsyrm ltatim sm kv mrt hicslsmv ba rsu dbntdtfmu. wrtf rt ihhsntl mrtht, rt utflu sfabhdimsbf mb mrt htum ba mrt gtysbfu, ifl yimrthu igg rsu ihdv sfmb bft cgiet ktabht sfmtggsytfet ba rsu ihhsnig ebxgl kt iffbxfetl mb mrt ihnthfs. nthesfytmbhsq, bf rtihsfy mrsu eshexdumifet, gtilu kiej rsu ihdv sfmb mrt ebxfmhv ba mrt ksmxhsytu; ifl iamth dihersfy ahbd sm mb ythybnsi, i mbwf ba mrt kbss, wrbd eituih ril utmmgtl mrtht iamth ltatimsfy mrtd sf mrt rtgntmsif wih, ifl ril htflthtl mhskxmihv mb mrt itlxs, rt ltmthdsftl mb immiej sm.";
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		HashMap<String, String> cipher = new HashMap<String, String>();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < alphabet.length(); i++) {
			map.put(alphabet.charAt(i), 0);
			cipher.put(alphabet.charAt(i)+"", alphabet.charAt(i)+"");
		}
		for (int i = 0; i < message.length(); i++) {
			if (alphabet.contains("" + message.charAt(i))) {
				int c = map.get(message.charAt(i));
				c++;
				map.put(message.charAt(i), c);
			}
		}
		int amount = 0;
		char mostcommon = 'e';
		for (int i = 0; i < alphabet.length(); i++) {
			if (amount < map.get(alphabet.charAt(i))) {
				mostcommon = alphabet.charAt(i);
				amount = map.get(alphabet.charAt(i));
			}
		}
		System.out.println("Most common character in encrypted message: "+ mostcommon + " Amount: " + amount);
		HashMap<String, Integer> bigram = new HashMap<String, Integer>();
		int biamount = 0;
		String bimostcommon = "th";
		for (int i = 0; (i + 1) < message.length(); i++) {
			if (alphabet.contains(message.charAt(i) + "") && alphabet.contains(message.charAt(i+1)+"")) {
				String t = "" + message.charAt(i) + message.charAt(i + 1);
				if (!bigram.containsKey(t)) {
					bigram.put(t, 1);
				} else {
					int x = bigram.get(t) + 1;
					bigram.put(t, x);
					if (biamount < x) {
						bimostcommon = t;
						biamount = x;
					}
				}
			}
		}
		System.out.println("Mostcommon pair of letters: " + bimostcommon + " " + biamount);
		//------------------------------------------------------------
		HashMap<String, Integer> trigram = new HashMap<String, Integer>();
		int triamount = 0;
		String trimostcommon = "the";
		for (int i = 0; (i + 2) < message.length(); i++) {
			if (alphabet.contains(message.charAt(i) + "") && alphabet.contains(message.charAt(i+1)+"")&&alphabet.contains(message.charAt(i+2)+"")) {
				String t = "" + message.charAt(i) + message.charAt(i + 1) + message.charAt(i+2);
				if (!trigram.containsKey(t)) {
					trigram.put(t, 1);
				} else {
					int x = trigram.get(t) + 1;
					trigram.put(t, x);
					if (triamount < x) {
						trimostcommon = t;
						triamount = x;
					}
				}
			}
		}
		System.out.println("Mostcommon three letters in a row: " + trimostcommon + " " + triamount);
		String sbimostcommon="";
		int sbiamount = 0;
		for(String s : bigram.keySet()){
			if(!s.equals(bimostcommon) && sbiamount < bigram.get(s)){
				sbimostcommon = s;
				sbiamount = bigram.get(s);
			}
		}
		System.out.println("second most common pair of letters: "+sbimostcommon+" " + sbiamount);
		cipher.put("t","E");
		cipher.put("m","T");
		cipher.put("r","H");
		System.out.println(decode(cipher));
		System.out.println(cipher(cipher));
		cipher.put("i", "A");
		cipher.put("e", "C");
		cipher.put("u", "S");
		cipher.put("h", "R");
		System.out.println(decode(cipher));
		System.out.println(cipher(cipher));
		cipher.put("k", "B");
		cipher.put("j", "K");
		cipher.put("x", "U");
		cipher.put("a", "F");
		System.out.println(decode(cipher));
		System.out.println(cipher(cipher));
		cipher.put("b", "O");
		cipher.put("w", "W");
		cipher.put("d", "M");
		System.out.println(decode(cipher));
		System.out.println(cipher(cipher));
		cipher.put("s", "I");
		cipher.put("f", "N");
		System.out.println(decode(cipher));
		System.out.println(cipher(cipher));
		cipher.put("c", "P");
		cipher.put("g", "L");
		cipher.put("v", "Y");
		cipher.put("l", "D");
		System.out.println(decode(cipher));
		System.out.println(cipher(cipher));
		cipher.put("n", "V");
		cipher.put("y", "G");
		cipher.put("z", "J");
		System.out.println(decode(cipher));
		System.out.println(cipher(cipher));
		cipher.put("o", "Z");
		cipher.put("q", "X");
		System.out.println(decode(cipher));
		System.out.println(cipher(cipher));
	}
	public static String decode(HashMap<String, String> cipher){
		String decoded = "";
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String message = "eituih, rinsfy ltgivtl mwb livu sf mrim cgiet, kteixut rt ril ifmsescimtl mrim, sf mrt fimxhig ebxhut ba tntfmu, uxer wbxgl kt mrt ebflxem ba nthesfytmbhsq, gtintu mrt ihdv xflth chtmtfut ba hisusfy htehxsmu ifl einighv: rt cgietu khxmxu, i vbxfy dif, sf ebddifl ba mrtut abhetu; rt ysntu rsd sfumhxemsbfu mrim mrt einighv urbxgl hifyt iu tqmtfusntgv iu cbuuskgt sf igg lshtemsbfu; mrim rt wbxgl tqthm rsdutga fbm mb kt ikutfm ahbd mrt eidc gbfyth mrif mrhtt livu. rinsfy ihhifytl mrtut dimmthu, rt dihertu mb nstffi kv iu gbfy zbxhftvu iu rt eif, wrtf rsu bwf ubglsthu lsl fbm tqctem rsd. asflsfy mrtht i ahtur kblv ba einighv, wrser rt ril utfm bf mb mrim cgiet utnthig livu ktabht, dihersfy sfetuuifmgv fsyrm ifl liv, rt ilnifetl hicslgv mrhbxyr mrt mthhsmbhv ba mrt itlxs sfmb mrim ba mrt gsfybftu, sf wrser mwb gtysbfu wtht wsfmthsfy, mrim, sa ifv cgif iaatemsfy rsu bwf uiatmv urbxgl rint kttf bhyifsotl kv mrt itlxs, rt dsyrm ltatim sm kv mrt hicslsmv ba rsu dbntdtfmu. wrtf rt ihhsntl mrtht, rt utflu sfabhdimsbf mb mrt htum ba mrt gtysbfu, ifl yimrthu igg rsu ihdv sfmb bft cgiet ktabht sfmtggsytfet ba rsu ihhsnig ebxgl kt iffbxfetl mb mrt ihnthfs. nthesfytmbhsq, bf rtihsfy mrsu eshexdumifet, gtilu kiej rsu ihdv sfmb mrt ebxfmhv ba mrt ksmxhsytu; ifl iamth dihersfy ahbd sm mb ythybnsi, i mbwf ba mrt kbss, wrbd eituih ril utmmgtl mrtht iamth ltatimsfy mrtd sf mrt rtgntmsif wih, ifl ril htflthtl mhskxmihv mb mrt itlxs, rt ltmthdsftl mb immiej sm.";
		for (int i = 0; i < message.length(); i++) {
			if(alphabet.contains(message.charAt(i)+"")){
				decoded+=cipher.get(message.charAt(i)+"");
			}else{
				decoded+=message.charAt(i);
			}
		}
		return decoded;
	}
	public static String cipher(HashMap<String, String> ciphermap){
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String cipher=alphabet+ "\n";
		for (int i = 0; i < alphabet.length(); i++) {
			cipher+=ciphermap.get(alphabet.charAt(i)+"");
		}
		return cipher;
	}

}
