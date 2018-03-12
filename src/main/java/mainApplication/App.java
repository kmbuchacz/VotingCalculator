package mainApplication;

import org.springframework.beans.factory.annotation.Autowired;

import layout.IntroductionPage;
import layout.MainWindow;
import statistic.VoteShare;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to election program created by Krzysztof Buchacz");
		new IntroductionPage();
	}
}
