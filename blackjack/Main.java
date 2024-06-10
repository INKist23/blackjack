package blackjack;


public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
	char answer = 0 ;	
		
	System.out.println("ようこそKカジノへ\n"
			+ "ここでは「ブラックジャック」を楽しむことができます。");
	System.out.println("プレイしますか？Yes or No\n"
			+ "YかNを押してください");
	char playAnswer = new java.util.Scanner(System.in).next().charAt(0);
	while(true) {
		if(playAnswer == 'Y' || playAnswer == 'y') {
		System.out.println("ありがとうございます");
		break;
	    }else if(playAnswer == 'N' || playAnswer == 'n') {

	    	System.out.println("またのご来店をお待ちしております。");
	    	return ;
		}
	    else {
		  playAnswer = Gameplay.notYN();
		  
	    }
	}
	if(playAnswer == 'Y' || playAnswer == 'y') answer = playAnswer;
	if(answer == 'Y' || answer == 'y') {
		System.out.println("ルールの説明はいかがいたしましょう？\n"
				+ "いらない場合はN(n)、説明が必要な場合はY(y)を押してください");
		 answer = new java.util.Scanner(System.in).next().charAt(0);
	}
	
	while(true) {  
	   if(answer == 'Y' || answer == 'y') {
		   break;
	     }else if(answer == 'N' || answer == 'n') {
	    	 System.out.println("それでは早速プレイしましょう\n");
			 Gameplay.playGamego();
	    	 break;
	     }else {
	    	 answer = Gameplay.notYN();
	  }
	}
	    //ルール説明
		if(answer == 'Y' || answer == 'y' ) {
			System.out.println("それではご説明いたしましょう");
			System.out.println("プレイヤーのみなさまはチップをかけてディーラーと戦っていただきます\n"
					+ "まずみなさまとディーラーにカードを2枚お配りいたします。\n"
					+ "この段階ではディーラーのカードは1枚しかわかりません。");
			enter();
			System.out.println("そして、この時点でチップをベットします。ベットしないことも可能です\n"
					+ "その後21を越えないようにカードを引いて、勝負する手札を決めます。\n"
					+ "カードを引いたときに21を越えてしまった場合は「バースト」となり\n"
					+ "その時点で負けとなります。\n");
			enter();
			System.out.println("プレイヤーのみなさまの勝負手札がきまりましたら\n"
					+ "ディーラーの2枚目のカードをオープンします。"
					+ "ディーラーのカードの合計より高ければ勝ちです。");
			System.out.println("勝った場合はかけたチップの2倍、\n"
					+ "負けた場合はチップ没収、ドローの場合はかけたチップをお返しします。\n");
			enter();
			System.out.println("カードの点数は絵札(11～13)は「10」点、\n"
					+ "2～10は数字通り、A(エース)は「11」点または「1」点です。\n");
			enter();
			System.out.println("説明は以上です\n"
					+ "それでは参りましょう。\n");
			enter();
			Gameplay.playGamego();
		}
	

	System.out.println("またのご来店をお待ちしております。");
	
  }
	//Enterキー入力メソッド
	public static void enter(){
		System.out.println("続きを読む（Enter）を押してください");
		String strAn = new java.util.Scanner(System.in).nextLine();
		while(true) {
			if(strAn.equals("")) {
				break;
			}else {
				System.out.println("Enterを押してください");
				strAn = new java.util.Scanner(System.in).nextLine();
			}
		}
	}
	
	

}
