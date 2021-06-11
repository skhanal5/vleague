package application;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class Webscraper {
	private URL url;
	private String imageLink;
	private String formattedName;
	private ArrayList<String> opponents;
	private ArrayList<String> scores;
	private ArrayList<String> dates;
	public Webscraper(String teamName) {

		String hyperlink = "";
		
		if (teamName.equals("TEAM SOLOMID")) {
			hyperlink = "https://www.vlr.gg/team/matches/106/tsm/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/tsm-logo.png";
			formattedName = "Team Solomid";
		} else if (teamName.equals("100 THIEVES")) {
			hyperlink = "https://www.vlr.gg/team/matches/120/100-thieves/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/100tlogo.png";
			formattedName = "100 Thieves";
		} else if (teamName.equals("CLOUD 9")) {
			hyperlink = "https://www.vlr.gg/team/matches/188/cloud9-blue/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/c9-logo.png";
			formattedName = "Cloud 9";
		} else if (teamName.equals("SENTINELS")) {
			hyperlink = "https://www.vlr.gg/team/matches/2/sentinels/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/sen-logo.png";
			formattedName = "Sentinels";
		} else if (teamName.equals("ENVY")) {
			hyperlink = "https://www.vlr.gg/team/matches/427/envy/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/t1-logo.png";
			formattedName = "Envy";
		} else if (teamName.equals("LUMINOSITY GAMING")) {
			hyperlink = "https://www.vlr.gg/team/matches/642/luminosity/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/lg-logo.png";
			formattedName = "Luminosity";
		} else if (teamName.equals("FAZE CLAN")) {
			hyperlink = "https://www.vlr.gg/team/matches/337/faze-clan/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/faze-logo.png";
			formattedName = "FaZe Clan";
		} else if (teamName.equals("XSET GAMING")) {
			hyperlink = "https://www.vlr.gg/team/matches/533/xset/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/xset-logo.png";
			formattedName = "XSET Gaming";
		} else if (teamName.equals("NRG GAMING")) {
			hyperlink = "https://www.vlr.gg/team/matches/1034/nrg-esports/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/nrg-logo.png";
			formattedName = "NRG Esports";
		} else if (teamName.equals("IMMORTALS")) {
			hyperlink = "https://www.vlr.gg/team/matches/103/immortals/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/imt-logo.png";
			formattedName = "Immortals";
		} else if (teamName.equals("T1 ESPORTS")) {
			hyperlink = "https://www.vlr.gg/team/matches/14/t1/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/t1-logo.png";
			formattedName = "T1 Esports";
		} else if (teamName.equals("VERSION 1")) {
			hyperlink = "https://www.vlr.gg/team/matches/2815/version1/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/v1-logo.png";
			formattedName = "Version 1";
		} else if (teamName.equals("RENEGADES")) {
			hyperlink = "https://www.vlr.gg/team/matches/468/renegades/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/rng-logo.png";
			formattedName = "Renegades";
		} else if (teamName.equals("BUILT BY GAMERS")) {
			hyperlink = "https://www.vlr.gg/team/matches/473/built-by-gamers/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/bbg-logo.png";
			formattedName = "Built By Gamers";
		} else if (teamName.equals("GEN.G")){
			hyperlink = "https://www.vlr.gg/team/matches/17/gen-g/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/geng-logo.png";
			formattedName = "Gen.G";
		} else {
			hyperlink = "https://www.vlr.gg/team/matches/856/andbox/?group=completed";
			imageLink = "/resources/VLEAGUE Assets/team icons/andbox-logo.png";
			formattedName = "Andbox";
		}

		try {
			url = new URL(hyperlink);
			opponents = getOpponents();
			scores = getScores();
			dates = getDates();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getOpponents() throws IOException {
		ArrayList<String> opponents = new ArrayList<String>();
		Scanner scanner = new Scanner(url.openStream());
		
		/* Read HTML from web site one line at a time */
		StringBuffer pageContent = new StringBuffer();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			pageContent.append(line);
		}
		scanner.close();
		
		int matchesStart = pageContent.indexOf("<div class=\"wf-card mod-loss mod-dark\" style=\"margin-bottom: 25px;\">");
		int matchEnd = pageContent.indexOf("<div class=\"action-container\">");
		String refined = pageContent.substring(matchesStart, matchEnd);
		
		while (opponents.size()<10) {
			int indexStart = refined.indexOf("<div class=\"rm-item-opponent mod-full \">");
			int indexEnd = refined.indexOf("<div class=\"rm-item-vods\">")+27;
			String opponentInfo = refined.substring(indexStart, indexEnd);
			int indexStart2 = opponentInfo.indexOf("<div class=\"text-of\">");
			int indexEnd2 = opponentInfo.indexOf("</div>");
			String team = opponentInfo.substring(indexStart2, indexEnd2);
			String remove = "<div class=\"text-of\">";
			team = team.replace(remove, " ");
			team = team.trim();
			opponents.add(team);
			refined = refined.replace(opponentInfo, "");
		}
		
		return opponents;
	}
	
	public ArrayList<String> getScores() throws IOException {
		ArrayList<String> score = new ArrayList<String>();
		Scanner scanner = new Scanner(url.openStream());
		
		/* Read HTML from web site one line at a time */
		StringBuffer pageContent = new StringBuffer();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			pageContent.append(line);
		}
		scanner.close();
		
		int matchesStart = pageContent.indexOf("<div class=\"wf-card mod-loss mod-dark\" style=\"margin-bottom: 25px;\">");
		int matchEnd = pageContent.indexOf("<div class=\"action-container\">");
		String refined = pageContent.substring(matchesStart, matchEnd);
		while(score.size()<10) {
			int indexStart = refined.indexOf("<div class=\"rm-item-score\">");
			int indexEnd = refined.indexOf("<div class=\"rm-item-date\">")+26;
			String scoreInfo = refined.substring(indexStart, indexEnd);
			int score1Start = scoreInfo.indexOf("<span class=\"rf\">")+17;
			int score1End = scoreInfo.indexOf("</span>");
			String score1 = scoreInfo.substring(score1Start, score1End);
			int score2Start = scoreInfo.indexOf("<span class=\"ra\">")+17;
			int score2End = scoreInfo.indexOf("</div>")-18;
			String score2 = scoreInfo.substring(score2Start, score2End);
			String matchScore = score1 + "-" + score2;
			score.add(matchScore);
			refined = refined.replace(scoreInfo, "");
		}
		return score;
	}
	
	public ArrayList<String> getDates() throws IOException {
		ArrayList<String> dates = new ArrayList<String>();
		Scanner scanner = new Scanner(url.openStream());
		
		/* Read HTML from web site one line at a time */
		StringBuffer pageContent = new StringBuffer();
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			pageContent.append(line);
		}
		scanner.close();
		
		int matchesStart = pageContent.indexOf("<div class=\"wf-card mod-loss mod-dark\" style=\"margin-bottom: 25px;\">");
		int matchEnd = pageContent.indexOf("<div class=\"action-container\">");
		String refined = pageContent.substring(matchesStart, matchEnd);
		while(dates.size()<10) {
			int indexStart = refined.indexOf("<div class=\"rm-item-date\">");
			int indexEnd = refined.indexOf("</a>")+4;
			String dateInfo = refined.substring(indexStart, indexEnd);
			String date = dateInfo.replace("<br>", "");
			date = date.replace("<div class=\"rm-item-date\">", "");
			date = date.replace("</div></a>", "");
			date = date.replace("			", "");
			date = date.trim();
			dates.add(date);
			refined = refined.replace(dateInfo, "");
		}
		return dates;
	}
	
	public void setOpponent(Label team1, Label team2, Label team3, Label team4, Label team5, Label team6, Label team7, Label team8, Label team9, Label team10,
			ImageView teamOne, ImageView teamTwo, ImageView teamThree, ImageView teamFour, ImageView teamFive, ImageView teamSix, ImageView teamSeven, ImageView teamEight, ImageView teamNine, ImageView teamTen) {
		team1.setText(opponents.get(0));
		team2.setText(opponents.get(1));
		team3.setText(opponents.get(2));
		team4.setText(opponents.get(3));
		team5.setText(opponents.get(4));
		team6.setText(opponents.get(5));
		team7.setText(opponents.get(6));
		team8.setText(opponents.get(7));
		team9.setText(opponents.get(8));
		team10.setText(opponents.get(9));
		teamOne.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(0)))));
		teamTwo.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(1)))));
		teamThree.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(2)))));
		teamFour.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(3)))));
		teamFive.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(4)))));
		teamSix.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(5)))));
		teamSeven.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(6)))));
		teamEight.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(7)))));
		teamNine.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(8)))));
		teamTen.setImage(new Image(getClass().getResourceAsStream(determineTeam(opponents.get(9)))));
	}
	
	public void setScores(Label score1, Label score2, Label score3, Label score4, Label score5, Label score6, Label score7, Label score8, Label score9, Label score10) {
		score1.setText(scores.get(0));
		score2.setText(scores.get(1));
		score3.setText(scores.get(2));
		score4.setText(scores.get(3));
		score5.setText(scores.get(4));
		score6.setText(scores.get(5));
		score7.setText(scores.get(6));
		score8.setText(scores.get(7));
		score9.setText(scores.get(8));
		score10.setText(scores.get(9));
	}
	
	public void setDate(Text date1, Text date2, Text date3, Text date4, Text date5, Text date6, Text date7, Text date8, Text date9, Text date10) {
		date1.setText(dates.get(0));
		date2.setText(dates.get(1));
		date3.setText(dates.get(2));
		date4.setText(dates.get(3));
		date5.setText(dates.get(4));
		date6.setText(dates.get(5));
		date7.setText(dates.get(6));
		date8.setText(dates.get(7));
		date9.setText(dates.get(8));
		date10.setText(dates.get(9));
	}
	
	public void setSelf(ImageView team1, ImageView team2, ImageView team3, ImageView team4, ImageView team5, ImageView team6, ImageView team7, ImageView team8, ImageView team9, ImageView team10,
			Label teamOne, Label teamTwo, Label teamThree, Label teamFour, Label teamFive, Label teamSix, Label teamSeven, Label teamEight, Label teamNine, Label teamTen) {
		team1.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team2.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team3.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team4.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team5.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team6.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team7.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team8.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team9.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		team10.setImage(new Image(getClass().getResourceAsStream(imageLink)));
		teamOne.setText(formattedName);
		teamTwo.setText(formattedName);
		teamThree.setText(formattedName);
		teamFour.setText(formattedName);
		teamFive.setText(formattedName);
		teamSix.setText(formattedName);
		teamSeven.setText(formattedName);
		teamEight.setText(formattedName);
		teamNine.setText(formattedName);
		teamTen.setText(formattedName);
	}
	
	public String determineTeam(String teamName) {
		if (teamName.equals("TSM")) {
			return "/resources/VLEAGUE Assets/team icons/tsm-logo.png";
		} else if (teamName.equals("100 Thieves")) {
			return "/resources/VLEAGUE Assets/team icons/100t-logo.png";
		} else if (teamName.equals("Cloud9 Blue")) {
			return "/resources/VLEAGUE Assets/team icons/c9-logo.png";
		} else if (teamName.equals("Sentinels")) {
			return "/resources/VLEAGUE Assets/team icons/sen-logo.png";
		} else if (teamName.equals("Envy")) {
			return "/resources/VLEAGUE Assets/team icons/envy-logo.png";
		} else if (teamName.equals("Luminosity")) {
			return "/resources/VLEAGUE Assets/team icons/lg-logo.png";
		} else if (teamName.equals("FaZe Clan")) {
			return "/resources/VLEAGUE Assets/team icons/faze-logo.png";
		} else if (teamName.equals("XSET")) {
			return "/resources/VLEAGUE Assets/team icons/xset-logo.png";
		} else if (teamName.equals("NRG Esports")) {
			return "/resources/VLEAGUE Assets/team icons/nrg-logo.png";
		} else if (teamName.equals("Immortals")) {
			return "/resources/VLEAGUE Assets/team icons/imt-logo.png";
		} else if (teamName.equals("T1")) {
			return "/resources/VLEAGUE Assets/team icons/t1-logo.png";
		} else if (teamName.equals("Version1")) {
			return "/resources/VLEAGUE Assets/team icons/v1-logo.png";
		} else if (teamName.equals("Renegades")) {
			return "/resources/VLEAGUE Assets/team icons/rng-logo.png";
		} else if (teamName.equals("Built By Gamers")) {
			return "/resources/VLEAGUE Assets/team icons/bbg-logo.png";
		} else if (teamName.equals("Gen.G")){
			return "/resources/VLEAGUE Assets/team icons/geng-logo.png";
		} else if (teamName.equals("Andbox")){
			return "/resources/VLEAGUE Assets/team icons/andbox-logo.png";
		} else {
			return "/resources/VLEAGUE Assets/team icons/vl-generic-logo.png";
		}
	}
}
