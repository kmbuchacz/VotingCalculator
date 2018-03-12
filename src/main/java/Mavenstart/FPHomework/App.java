package Mavenstart.FPHomework;

import org.springframework.beans.factory.annotation.Autowired;

import Layout.IntroductionPage;
import Layout.MainWindow;
import Statistic.VoteShare;

public class App {

	public static void main(String[] args) {
		System.out.println("Welcome to election program created by Krzysztof Buchacz");
		new IntroductionPage();
	}
}
