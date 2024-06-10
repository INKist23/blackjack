package blackjack;

public class Gameplay {
	
	public static void playGamego(){
		//System.out.println("プレイヤーネームを入力してください");
		int[] remycard = new int[10],dealerAdd = new int[10];
		int bet=0,card=0,gamecount=1,dealer1,dealer2,mycardSum,dealerSum;
		//絵柄カード
		char ace = 'A',jack = 'J',queen = 'Q',king = 'K',answer;
		System.out.println("まず初めに所持金を決めます。所持金は本日の日付をもとに決定します。\n"
		 		+ "日付を入力してください。(例:1月1日→0101)");
		//所持金決め
		int mymoney = money()*100;
		System.out.println("\nあなたの所持金は"+mymoney+"円になりました。\n");
		Main.enter();
		while(true) {
			card=0;
			if(gamecount>1) {
				gamecount(gamecount);
			}else {
				System.out.println("まずはカードをお配りします。\n");
			}
			//自分の手札を1～13のランダムな数字で決める
			int mycard1 = new java.util.Random().nextInt(13)+1;
			int mycard2 = new java.util.Random().nextInt(13)+1;
			
			if(mycard1==1) {
				System.out.println("一枚目は「"+ace+"」(1または11)です");
				//1か11を選択するのはを2枚目がわかった段階で決める
			}else if(mycard1==11) {
				System.out.println("一枚目は「"+jack+"」(10)です");
				mycard1 = 10;
			}else if(mycard1==12) {
				System.out.println("一枚目は「"+queen+"」(10)です");
				mycard1 = 10;
			}else if(mycard1==13) {
				System.out.println("一枚目は「"+king+"」(10)です");
				mycard1 = 10;
			}else {
				System.out.println("一枚目は「"+mycard1+"」です");
			}
			if(mycard2==1) {
				System.out.println("二枚目は「"+ace+"」(1または11)です");
				System.out.println("どちらにしますか？\n"
						+ "1にする場合は「1」を、11にする場合は「11」を押してください");
				//A(エース)を「1」or「11」に設定する
				int Acard = new java.util.Scanner(System.in).nextInt();
				while(true) {
				if(Acard==1) {
					mycard2 = 1;
					break;
				}else if(Acard == 11) {
					mycard2 = 11;
					break;
				}else {
					System.out.println("「1」か「11」を入力してください");
					Acard = new java.util.Scanner(System.in).nextInt();
				}
			  }
			}else if(mycard2==11) {
				System.out.println("二枚目は「"+jack+"」(10)です");
				mycard2 = 10;
			}else if(mycard2==12) {
				System.out.println("二枚目は「"+queen+"」(10)です");
				mycard2 = 10;
			}else if(mycard2==13) {
				System.out.println("二枚目は「"+king+"」(10)です");
				mycard2 = 10;
			}else {
				System.out.println("二枚目は「"+mycard2+"」です");
			}
			System.out.println("");
			//1枚目のA決め
			if(mycard1==1) {
				System.out.println("一枚目は「"+ace+"」(1または11)でした");
				System.out.println("どちらにしますか？\n"
						+ "1にする場合は「1」を、11にする場合は「11」を押してください");
				int Acard = new java.util.Scanner(System.in).nextInt();
				while(true) {
				if(Acard==1) {
					mycard1 = 1;
					break;
				}else if(Acard == 11) {
					mycard1 = 11;
					break;
				}else {
					System.out.println("「1」か「11」を入力してください");
					Acard = new java.util.Scanner(System.in).nextInt();
				}
			  }
			}
			
			if(mycard1+mycard2==21) {
				blackjack();
			}else {
				System.out.println("\nあなたの現在のカードの合計は"+(mycard1+mycard2)+"です\n");
			}
			
			Main.enter();
			
				dealer1 = new java.util.Random().nextInt(13)+1;
				dealer2 = new java.util.Random().nextInt(13)+1;
			if(dealer1==1) {
				System.out.println("ディーラーの一枚目は「"+ace+"」(1または11)です");
				//ディーラーのAはランダムで決める
				int Dcard = new java.util.Random().nextInt(10);
				if(Dcard % 2 == 0) {
					dealer1 = 1;
				}else {
					dealer1 = 11;
				}
			}else if(dealer1==11) {
				System.out.println("ディーラーの一枚目は「"+jack+"」(10)です");
				dealer1 = 10;
			}else if(dealer1==12) {
				System.out.println("ディーラーの一枚目は「"+queen+"」(10)です");
				dealer1 = 10;
			}else if(dealer1==13) {
				System.out.println("ディーラーの一枚目は「"+king+"」(10)です");
				dealer1 = 10;
			}else {
				System.out.println("ディーラーの一枚目は「"+dealer1+"」です");
			}
			switch(dealer2) {
			case 1:
				//ディーラーのAはランダムで決める
				int Dcard = new java.util.Random().nextInt(10);
				if(Dcard % 2 == 0) {
					dealer1 = 1;
				}else {
					dealer1 = 11;
				}
				break;
			case 11:
				dealer2 = 10;
				break;
			case 12:
				dealer2 = 10;
				break;
			case 13:
				dealer2 = 10;
				break;
			}
			
			System.out.println("掛け金をベットしてください"
					+ "(ベットしないことも可能です)");
			while(true) {
			bet = new java.util.Scanner(System.in).nextInt();
			if(bet > mymoney) { //ベット金額が所持金より多いとき
				System.out.println("所持金を越えています。所持金以内でベットしてください。");
			}else if(bet < 0){  //ベット金額が0未満のとき
				System.out.println("ベット金額は0円以上で入力してください。");
			}else {
				mymoney -= bet;
				break;
			}
		  }
			mycardSum=mycard1+mycard2;
		if(mycard1+mycard2 != 21) {
			System.out.println("勝負する手札を決めていただきます。\n"
					+ "もう一枚引く場合はY(y)を、この手札で勝負する場合はN(n)を押してください。\n"
					+ "手札を確認する場合はC(c)を押してください");
			answer = new java.util.Scanner(System.in).next().charAt(0);  //行動決定キー入力
			while(true) {
			  if(answer == 'C' || answer == 'c') {
				  System.out.println("あなたの現在の手札は「"+mycardSum+"」です");
				  System.out.println("もう一枚引く場合はY(y)を、この手札で勝負する場合はN(n)を押してください。");
				   answer = new java.util.Scanner(System.in).next().charAt(0);  //行動決定キー入力
				   while(true) {
					   if(answer == 'Y' || answer == 'y' || answer == 'N' || answer == 'n') {
						   break;
					   }else {
						   answer = notYN();
					   }
			        }
		       }else if(answer == 'Y' || answer == 'y' || answer == 'N' || answer == 'n') break;
		        else {
		        	System.out.println("Y(y)かN(n)かC(c)を入力してください");
		        	answer = new java.util.Scanner(System.in).next().charAt(0);
		       }
		     }
		 
			
			 //手札をもう一枚引く処理をwhile文で繰り返し
			 while(answer == 'Y' || answer == 'y') {
				
				remycard[card] = new java.util.Random().nextInt(13)+1;
				if(remycard[card]==1) {
					System.out.println((card+3)+"枚目は「"+ace+"」(1または11)です");
					//1か11を選択できる条件式
					System.out.println("どちらにしますか？\n"
							+ "1にする場合は「1」を、11にする場合は「11」を押してください");
					int Acard = new java.util.Scanner(System.in).nextInt();
					while(true) {
					if(Acard==1) {
						remycard[card] = 1;
						break;
					}else if(Acard == 11) {
						remycard[card] = 11;
						break;
					}else {
						System.out.println("「1」か「11」を入力してください");
						Acard = new java.util.Scanner(System.in).nextInt();
					}
				  }
				}else if(remycard[card]==11) {
					System.out.println((card+3)+"枚目は「"+jack+"」(10)です");
					remycard[card] = 10;
				}else if(remycard[card]==12) {
					System.out.println((card+3)+"枚目は「"+queen+"」(10)です");
					remycard[card] = 10;
				}else if(remycard[card]==13) {
					System.out.println((card+3)+"枚目は「"+king+"」(10)です");
					remycard[card] = 10;
				}else {
					System.out.println((card+3)+"枚目は「"+remycard[card]+"」を引きました。");
				}
				
				mycardSum += remycard[card];
				if(mycardSum == 21) {
					blackjack();
					break;
				}else {
					System.out.println("あなたの手札の合計は"+(mycardSum)+"です");
				}
				
				if(mycardSum>21) {
					break;
				}else {
					System.out.println("もう一枚引く場合はY(y)を、"
							+ "この手札で勝負する場合はN(n)を押してください。");
					answer = new java.util.Scanner(System.in).next().charAt(0);
					card++;
					while(true) {
						 if(answer == 'Y' || answer == 'y') {
							 break;
						 }else if(answer == 'N' || answer == 'n') {
							 break;
						 }else {
							 answer = notYN();
						 }
					 }
					if(answer == 'N' || answer == 'n') break;
				}
			}
			
		
			if(mycardSum>21) {
				System.out.println("バーストしてしまいました。");
				System.out.println("あなたの負けです。\n"
						+ "ベットした金額は没収されます。\n");
				System.out.println("\n所持金は"+mymoney+"円になりました");
				System.out.println("ラウンド"+gamecount+"が終了しました。\n"
						+ "もう一度続ける場合は「C」を、終了する場合は「E」を押してください。");
				while(true) {
				  answer = new java.util.Scanner(System.in).next().charAt(0);
				  if(answer == 'E' || answer == 'e') {
					  System.out.println("それでは終了いたします");
					  return;
				  }else if(answer == 'C' || answer == 'c') {
					  System.out.println("もう一戦参りましょう。\n\n(￣y▽￣)╭ Ohohoho.....\n\n");
					  Main.enter();
					  break;
				  }else {
					  System.out.println("「C」(c)か「E」(e)を押してください。");
				  }
			   }
			   if(answer == 'C' || answer == 'c') {
				   gamecount++;
				   continue;
				   }
				
			  }
			}
		    
	
			card = 0; 
			Main.enter();
			System.out.println("プレイヤーの手札が決定しました");
			System.out.println("勝負のときです");
			System.out.println("ディーラーのもう一枚の手札を開きます");
			System.out.println("ディーラーのもう一枚のカードは「"+dealer2+"」でした\n"
					+ "ディーラーの合計は「"+(dealer1+dealer2)+"」です。\n");
			dealerSum=dealer1+dealer2;
			Main.enter();
			if(dealerSum < 17) {
				System.out.println("ディーラーのカードの合計16以下でしたので、\n"
						+ "17以上になるまでディーラーはカードを追加します");
				//dealerAdd[card]=new java.util.Random().nextInt(13)+1;
				while(dealerSum < 17) {
					dealerAdd[card]=new java.util.Random().nextInt(13)+1;
					if(dealerAdd[card]==1) {
						//ディーラーのAはランダムで決める
						int Dcard = new java.util.Random().nextInt(10);
						if(Dcard % 2 == 0) {
							dealerAdd[card] = 1;
							System.out.println("ディーラーの"+ (card+3) +"枚目は「"+dealerAdd[card]+"」です");
						}else {
							dealerAdd[card] = 11;
							System.out.println("ディーラーの"+ (card+3) +"枚目は「"+dealerAdd[card]+"」です");
						}
					}else if(dealerAdd[card]==11) {
						System.out.println("ディーラーの"+ (card+3) +"枚目は「"+jack+"」(10)です");
						dealer1 = 10;
					}else if(dealerAdd[card]==12) {
						System.out.println("ディーラーの"+ (card+3) +"枚目は「"+queen+"」(10)です");
						dealer1 = 10;
					}else if(dealerAdd[card]==13) {
						System.out.println("ディーラーの"+ (card+3) +"枚目は「"+king+"」(10)です");
						dealer1 = 10;
					}else {
						System.out.println("ディーラーの"+ (card+3) +"枚目は「"+dealerAdd[card]+"」です");
					}
					dealerSum += dealerAdd[card];
					if(dealerSum > 21) break;
					card++;
				}
				System.out.println("ディーラーの合計は"+dealerSum+"になりました。\n");
			}
			if(dealerSum>21) {
				System.out.println("ディーラーがバーストしたため、プレイヤーの勝ちです\n"
						+ "掛け金の2倍をリターンします。");
				mymoney += bet*2;
			}else if(dealerSum <= 21) {
				if(dealerSum < mycardSum) {
					System.out.println("あなたの勝ちです\n"
							+ "掛け金の2倍をリターンします。\n");
					mymoney += bet*2;
				}else if(dealerSum > mycardSum) {
					System.out.println("あなたの負けです。\n"
							+ "ベットした金額は没収されます。\n");
				}else if(dealerSum == mycardSum) {
					System.out.println("ドローです。\n"
							+ "ベットした金額が戻されます。\n");
					mymoney += bet;
				}
			}
		 
			Main.enter();
			System.out.println("所持金は"+mymoney+"円になりました");
			if(mymoney <= 0) {
				System.out.println("所持金がなくなってしまいました。終了しますか？\n"
						+ "再びプレイするには借りてくる必要があります。");
				System.out.println("終了する場合は「E」を、\n"
						+ "借りてくる場合は「Ａ」または「P」を押してください。");
				answer = new java.util.Scanner(System.in).next().charAt(0);  //行動選択キー入力
				if(answer == 'E' || answer == 'e') {
					System.out.println("それでは終了いたします");
					break;
				}else if(answer == 'A' || answer == 'a' || answer == 'P' || answer == 'p') {
					System.out.println("借りることに成功しました！\n"
							+ "+10万です！");
					mymoney += 100000;
					System.out.println("所持金は"+mymoney+"円になりました");
				}else {
					System.out.println("Y(y)かA(a)かP(p)を入力してください");
				}
			}
			System.out.println("ラウンド"+gamecount+"が終了しました。\n"
					+ "もう一度続ける場合は「C」を、終了する場合は「E」を押してください。");
			answer = new java.util.Scanner(System.in).next().charAt(0);
			while(true) {
			if(answer == 'E' || answer == 'e') {
				System.out.println("それでは終了いたします");
				return;
			}else if(answer == 'C' || answer == 'c') {
				System.out.println("\nもう一戦参りましょう。\n\n(￣y▽￣)╭ Ohohoho.....\n\n");
				Main.enter();
				break;
			}else {
				System.out.println("「E」か「C」を入力してください");
				answer = new java.util.Scanner(System.in).next().charAt(0);
			}
		  }
			gamecount++;
	}
}

	
	
	//所持金計算
	public static int money() {
		int mymoney;
		while(true) {
		   //mymoney = new java.util.Scanner(System.in).nextInt();
		   //文字列を受け取ったときのエラー処理
		   try {
			   mymoney = new java.util.Scanner(System.in).nextInt();
			   break;
		   }catch(Exception e) {
			   System.out.println("整数を入力してください。\n");
		   }
		
		}
		return mymoney;
	}
	//ゲームカウント
	public static void gamecount(int x) {
		System.out.println("さて、"+x+"試合目を始めましょう");
		System.out.println("カードをお配りします");
	}
	//指定したキー以外の入力をしたときの処理
	public static char notYN() {
		System.out.println("Y(y)かN(n)を入力してください");
		char answer = new java.util.Scanner(System.in).next().charAt(0);
		
		return  answer;
	}
	//手札が21になったときの処理
	public static void blackjack() {
		System.out.println("                                                                  \n"
				+ "■■■■■  ■       ■     ■■■■   ■   ■   ■    ■     ■■■■   ■   ■  ■  ■ \n"
				+ "■   ■  ■       ■    ■■   ■  ■  ■    ■    ■    ■■   ■  ■  ■   ■  ■ \n"
				+ "■   ■  ■      ■ ■   ■       ■ ■     ■   ■ ■   ■       ■ ■    ■  ■ \n"
				+ "■■■■   ■      ■ ■   ■       ■■■     ■   ■ ■   ■       ■■■    ■  ■ \n"
				+ "■   ■  ■     ■   ■  ■       ■ ■     ■  ■   ■  ■       ■ ■    ■  ■ \n"
				+ "■   ■■ ■     ■■■■■  ■       ■  ■    ■  ■■■■■  ■       ■  ■   ■  ■ \n"
				+ "■   ■  ■     ■   ■  ■■   ■  ■   ■   ■  ■   ■  ■■   ■  ■   ■       \n"
				+ "■■■■■  ■■■■■■     ■  ■■■■   ■   ■■■■■ ■     ■  ■■■■   ■   ■■ ■  ■");
	
		System.out.println("\nあなたの合計は「21」です！！");
	}
	

}
