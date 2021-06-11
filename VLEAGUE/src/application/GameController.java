package application;

import java.awt.Desktop;
import java.net.URL;
import java.util.ResourceBundle;

import org.kordamp.ikonli.javafx.FontIcon;

import javafx.animation.KeyFrame;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class GameController implements Initializable{
	
	@FXML
	private AnchorPane parent;
	
	@FXML
	private ScrollPane scheduleScroll;
	
	@FXML
	private AnchorPane myTeamSelect;
	
	@FXML
	private AnchorPane myTeamLoad;
	
	@FXML
	private AnchorPane myTeamPane;
	
	@FXML
	private AnchorPane resultDefaultScreen;
	
	@FXML
	private AnchorPane resultLoadScreen;
	
	@FXML
	private Tab homeTab;
	
	@FXML
	private Tab myTeamTab;
	
	@FXML
	private Tab scheduleTab;
	
	@FXML
	private Tab resultsTab;
	
	@FXML
	private Tab globalTab;
	
	@FXML
	private Tab profileTab;
	
	@FXML
	private Circle homeCircle;
	
	@FXML
	private Circle myTeamCircle;
	
	@FXML
	private Circle scheduleCircle;
	
	@FXML
	private Circle resultsCircle;
	
	@FXML
	private Circle globalCircle;
	
	@FXML
	private Circle profileCircle;
	
	@FXML
	private Circle leaderLoadCircle;
	
	@FXML
	private Circle teamLoadCircle;
	
	@FXML
	private Circle resultLoadCircle;
	
	@FXML
	private Pane homePane1;
	
	@FXML
	private Pane homePane2;
	
	@FXML
	private Pane homePane3;
	
	@FXML
	private Pane leaderboardPane;
	
	@FXML
	private Pane leaderboardLoad;
	
	@FXML
	private Label username;
	
	@FXML
	private Label refreshLabel;
	
	@FXML
	private Label timeStamp;
	
	@FXML
	private Label profileUsername;
	
	@FXML
	private Label profileDateJoined;
	
	@FXML
	private Label goldTrophy;
	
	@FXML
	private Label silverTrophy;
	
	@FXML
	private Label bronzeTrophy;
	
	@FXML
	private Label matchesPlayed;
	
	@FXML
	private Label vpEarned;
	
	@FXML
	private Label globalRank;
	
	@FXML
	private Label topFinishes;
	
	@FXML
	private Label favTeam;
	
	@FXML
	private Label teamNameLabel;
	
	@FXML
	private Label playerOne;
	
	@FXML
	private Label playerTwo;
	
	@FXML
	private Label playerThree;
	
	@FXML
	private Label playerFour;
	
	@FXML
	private Label playerFive;
	
	@FXML
	private Label playerOneTitle;
	
	@FXML
	private Label playerTwoTitle;
	
	@FXML
	private Label playerThreeTitle;
	
	@FXML
	private Label playerFourTitle;
	
	@FXML
	private Label playerFiveTitle;
	
	
	@FXML
	private Label myTeamHeader;
	
	@FXML
	private ImageView headerImage;
	
	@FXML
	private Text date1;
	
	@FXML
	private Text date2;
	
	@FXML
	private Text date3;
	
	@FXML
	private Text date4;
	
	@FXML
	private Text date5;
	
	@FXML
	private Text date6;
	
	@FXML
	private Text date7;
	
	@FXML
	private Text date8;
	
	@FXML
	private Text date9;
	
	@FXML
	private Text date10;
	
	@FXML
	private Label leftTeam1;
	
	@FXML
	private Label leftTeam2;
	
	@FXML
	private Label leftTeam3;
	
	@FXML
	private Label leftTeam4;
	
	@FXML
	private Label leftTeam5;
	
	@FXML
	private Label leftTeam6;
	
	@FXML
	private Label leftTeam7;
	
	@FXML
	private Label leftTeam8;
	
	@FXML
	private Label leftTeam9;
	
	@FXML
	private Label leftTeam10;
	
	@FXML
	private Label rightTeam1;
	
	@FXML
	private Label rightTeam2;
	
	@FXML
	private Label rightTeam3;
	
	@FXML
	private Label rightTeam4;
	
	@FXML
	private Label rightTeam5;
	
	@FXML
	private Label rightTeam6;
	
	@FXML
	private Label rightTeam7;
	
	@FXML
	private Label rightTeam8;
	
	@FXML
	private Label rightTeam9;
	
	@FXML
	private Label rightTeam10;
	
	@FXML
	private Label score1;
	
	@FXML
	private Label score2;
	
	@FXML
	private Label score3;
	
	@FXML
	private Label score4;
	
	@FXML
	private Label score5;
	
	@FXML
	private Label score6;
	
	@FXML
	private Label score7;
	
	@FXML
	private Label score8;
	
	@FXML
	private Label score9;
	
	@FXML
	private Label score10;
	
	@FXML
	private ImageView leftLogo1;
	
	@FXML
	private ImageView leftLogo2;
	
	@FXML
	private ImageView leftLogo3;
	
	@FXML
	private ImageView leftLogo4;
	
	@FXML
	private ImageView leftLogo5;
	
	@FXML
	private ImageView leftLogo6;
	
	@FXML
	private ImageView leftLogo7;
	
	@FXML
	private ImageView leftLogo8;
	
	@FXML
	private ImageView leftLogo9;
	
	@FXML
	private ImageView leftLogo10;
	
	@FXML
	private ImageView rightLogo1;
	
	@FXML
	private ImageView rightLogo2;
	
	@FXML
	private ImageView rightLogo3;
	
	@FXML
	private ImageView rightLogo4;
	
	@FXML
	private ImageView rightLogo5;
	
	@FXML
	private ImageView rightLogo6;
	
	@FXML
	private ImageView rightLogo7;
	
	@FXML
	private ImageView rightLogo8;
	
	@FXML
	private ImageView rightLogo9;
	
	@FXML
	private ImageView rightLogo10;
	
	@FXML
	private ImageView playerOnePic;
	
	@FXML
	private ImageView playerTwoPic;
	
	@FXML
	private ImageView playerThreePic;
	
	@FXML
	private ImageView playerFourPic;
	
	@FXML
	private ImageView playerFivePic;
	
	@FXML
	private FontIcon editProfile;
	
	@FXML
	private Pane profilePicPane;
	
	@FXML
	private AnchorPane profileScreen;
	
	@FXML
	private AnchorPane profileSelectScreen;
	
	@FXML
	private TabPane tabpane;
	
	@FXML
	private ScrollPane profileScroll;
	
	@FXML
	private ScrollPane leaderboardScroll;
	
	@FXML
	private ScrollPane resultsScroll;
	
	@FXML
	private ImageView previewUserIcon;
	
	@FXML
	private ImageView largeUserIcon;
	
	@FXML
	private ImageView smallUserIcon;
	
	@FXML
	private ImageView teamIconPreview;
	
	@FXML
	private FontIcon refreshIcon;
	
	@FXML
	private Button equipIcon;
	
	@FXML
	private Button lockIn;

	private double xOffset;
	
	private double yOffset;
	
	private int pos = 0;
	
	public static MediaPlayer bgMusic;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		homeSlideshow();
		homeTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (homeTab.isSelected()) {
						homeCircle.setFill(Color.web("#fa4454"));
					} else {
						homeCircle.setFill(Color.web("#c7c7c7"));
					}
				});

		myTeamTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (myTeamTab.isSelected()) {
						myTeamCircle.setFill(Color.web("#fa4454"));
						if (Main.database.checkTeam(username.getText())) {
							myTeamLoad();
						} else {
							teamIconPreview.setImage(null);
							teamNameLabel.setText("");
							playerOne.setText("Player 1");
							playerTwo.setText("Player 2");
							playerThree.setText("Player 3");
							playerFour.setText("Player 4");
							playerFive.setText("Player 5");
							playerOnePic.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/person-icon.png")));
							playerTwoPic.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/person-icon.png")));
							playerThreePic.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/person-icon.png")));
							playerFourPic.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/person-icon.png")));
							playerFivePic.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/person-icon.png")));
						}
					} else {
						myTeamCircle.setFill(Color.web("#c7c7c7"));
					}
				});

		scheduleTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (scheduleTab.isSelected()) {
						scheduleCircle.setFill(Color.web("#fa4454"));
					} else {
						scheduleScroll.setVvalue(0);
						scheduleCircle.setFill(Color.web("#c7c7c7"));
					}
				});

		resultsTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (resultsTab.isSelected()) {
						resultsCircle.setFill(Color.web("#fa4454"));
						if (Main.database.checkTeam(username.getText())) {
							resultLoad();
						}
					} else {
						resultsScroll.setVvalue(0);
						resultsCircle.setFill(Color.web("#c7c7c7"));
					}
				});

		globalTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (globalTab.isSelected()) {
						globalCircle.setFill(Color.web("#fa4454"));
						timeStamp.setText("JUST NOW");
					} else {
						leaderboardScroll.setVvalue(0);
						globalCircle.setFill(Color.web("#c7c7c7"));
						;
					}
				});

		profileTab.selectedProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (profileTab.isSelected()) {
						profileCircle.setFill(Color.web("#fa4454"));
					} else {
						profileCircle.setFill(Color.web("#c7c7c7"));
						profileScroll.setHvalue(.5);
						profileScreen.setVisible(true);
						profileScreen.setDisable(false);
						profileSelectScreen.setDisable(true);
						profileSelectScreen.setVisible(false);
					}
				});

		// shows edit profile font icon if user is hovering otherwise it is not
		// visible in the profile pane
		profilePicPane.hoverProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (profilePicPane.isHover()) {
						editProfile.setDisable(false);
						editProfile.setVisible(true);
					} else {
						editProfile.setDisable(true);
						editProfile.setVisible(false);
					}
				});

		// prevents users from traversing through tabpane by using arrow keys on
		// keyboard
		tabpane.addEventFilter(KeyEvent.ANY, event -> {
			if (event.getCode().isArrowKey()) {
				event.consume();
			}
		});

		//locks team select button until player makes choice
		teamIconPreview.imageProperty()
				.addListener((observable, oldValue, newValue) -> {
					if (teamIconPreview.getImage() == null) {
						lockIn.setDisable(true);
					} else {
						lockIn.setDisable(false);
					}
				});
		
		dragStage();
	}
	
	//sets username from previous controller
	public void setUsername(String user) {
		username.setText(user);
		initializeProfilePage(user);
		try {
			Media audioFile = new Media(getClass().getResource("/resources/bgmusic.mp3").toURI().toString());
			bgMusic = new MediaPlayer(audioFile);
			
			//loops background music indefinitely
			bgMusic.setOnEndOfMedia(new Runnable() {
			       public void run() {
			         bgMusic.seek(Duration.ZERO);
			       }
			   });
			bgMusic.play();
			bgMusic.setVolume(Main.database.getMusicVolume(user));
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//retrieves values from user document in database to display in profile
	private void initializeProfilePage(String user) {
		profileUsername.setText(user);
		profileDateJoined.setText(Main.database.getDateJoined(user));
		smallUserIcon.setImage(new Image(getClass().getResourceAsStream(Main.database.getSmallIcon(user))));
		largeUserIcon.setImage(new Image(getClass().getResourceAsStream(Main.database.getLargeIcon(user))));
		previewUserIcon.setImage(largeUserIcon.getImage());
		goldTrophy.setText(Main.database.getGolds(user));
		silverTrophy.setText(Main.database.getSilvers(user));
		bronzeTrophy.setText(Main.database.getBronzes(user));
		matchesPlayed.setText(Main.database.getMatchTotal(user));
		vpEarned.setText(Main.database.getEarnings(user));
		globalRank.setText(Main.database.getRank(user));
		topFinishes.setText(Main.database.getFinishes(user));
		favTeam.setText(Main.database.getTeam(user));
	}
	
	//runs the "slideshow" at the right side of the home page at a 5 second interval
	private void homeSlideshow() {
		Pane[] infoPane = {homePane1, homePane2, homePane3};
		Timeline fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
			if (pos==infoPane.length-1) {
				infoPane[pos].setVisible(false);
				pos=0;
				infoPane[pos].setVisible(true);
			} else {
				infoPane[pos].setVisible(false);
				infoPane[++pos].setVisible(true);
			}	
		}));
		fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
		fiveSecondsWonder.play();
		
	}
	
	//makes current stage draggable
	private void dragStage() {
		parent.setOnMousePressed((event) ->  {
			parent.requestFocus();
		});
		
		parent.setOnMousePressed((event) -> {
			xOffset = event.getSceneX();
			yOffset = event.getSceneY();
		}); 
		
		parent.setOnMouseDragged((event) -> {
			Main.primaryStage.setX(event.getScreenX() - xOffset);
			Main.primaryStage.setY(event.getScreenY() - yOffset);
		});
	}
	
	//starts loading animation for leaderboard
	private void leaderboardLoad() {
		leaderboardPane.setDisable(true);
		leaderboardPane.setVisible(false);
		leaderboardLoad.setVisible(true);
		leaderboardScroll.setVmax(0);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), leaderLoadCircle);
		rotation.setByAngle(360);
		rotation.play();
		rotation.setOnFinished(event -> {
			leaderboardScroll.setVmax(1);
			leaderboardPane.setDisable(false);
			leaderboardPane.setVisible(true);
			leaderboardLoad.setVisible(false);
		});
	}
	
	//starts loading animation for myTeam
	private void myTeamLoad() {
		myTeamPane.setVisible(false);
		myTeamSelect.setDisable(true);
		myTeamSelect.setVisible(false);
		myTeamLoad.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(.75), teamLoadCircle);
		rotation.setByAngle(360);
		rotation.play();
		rotation.setOnFinished(event -> {
			myTeamLoad.setVisible(false);
			myTeamPane.setVisible(true);
			determineTeam(myTeamHeader, playerOneTitle, playerTwoTitle, playerThreeTitle, playerFourTitle, playerFiveTitle);
		});
	}
	
	private void determineTeam(Label header, Label title1, Label title2, Label title3, Label title4, Label title5) {
		String team = Main.database.getMyTeam(username.getText());
		myTeamHeader.setText(team);
		if (team.equals("TEAM SOLOMID")) {
			playerOneTitle.setText("WARDELL");
			playerTwoTitle.setText("hazed");
			playerThreeTitle.setText("Drone");
			playerFourTitle.setText("Subroza");
			playerFiveTitle.setText("brax");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/tsm-logo.png")));
		} else if (team.equals("100 THIEVES")) {
			playerOneTitle.setText("Hiko");
			playerTwoTitle.setText("Ethan");
			playerThreeTitle.setText("Asuna");
			playerFourTitle.setText("nitr0");
			playerFiveTitle.setText("steel");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/100t-logo.png")));
		} else if (team.equals("CLOUD 9")) {
			playerOneTitle.setText("leaf");
			playerTwoTitle.setText("xeta");
			playerThreeTitle.setText("poiz");
			playerFourTitle.setText("mitch");
			playerFiveTitle.setText("floppy");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/c9-logo.png")));
		} else if (team.equals("SENTINELS")) {
			playerOneTitle.setText("TenZ");
			playerTwoTitle.setText("ShahZam");
			playerThreeTitle.setText("SicK");
			playerFourTitle.setText("zombs");
			playerFiveTitle.setText("dapr");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/sen-logo.png")));
		} else if (team.equals("ENVY")) {
			playerOneTitle.setText("Victor");
			playerTwoTitle.setText("crashies");
			playerThreeTitle.setText("FNS");
			playerFourTitle.setText("mummAy");
			playerFiveTitle.setText("kaboose");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/envy-logo.png")));
		} else if (team.equals("LUMINOSITY GAMING")) {
			playerOneTitle.setText("aproto");
			playerTwoTitle.setText("stellar");
			playerThreeTitle.setText("thief");
			playerFourTitle.setText("YaBoiDre");
			playerFiveTitle.setText("moose");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/lg-logo.png")));
		} else if (team.equals("FAZE CLAN")) {
			playerOneTitle.setText("ZachaREEE");
			playerTwoTitle.setText("BABYBAY");
			playerThreeTitle.setText("Marved");
			playerFourTitle.setText("Rawkus");
			playerFiveTitle.setText("corey");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/faze-logo.png")));
		} else if (team.equals("XSET GAMING")) {
			playerOneTitle.setText("PureR");
			playerTwoTitle.setText("AYRIN");
			playerThreeTitle.setText("WeDid");
			playerFourTitle.setText("BcJ");
			playerFiveTitle.setText("twhifo");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/xset-logo.png")));
		} else if (team.equals("NRG GAMING")) {
			playerOneTitle.setText("ANDROID");
			playerTwoTitle.setText("eeiu");
			playerThreeTitle.setText("s0m");
			playerFourTitle.setText("daps");
			playerFiveTitle.setText("tex");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/nrg-logo.png")));
		} else if (team.equals("IMMORTALS")) {
			playerOneTitle.setText("N/A");
			playerTwoTitle.setText("Kehmicals");
			playerThreeTitle.setText("jcStani");
			playerFourTitle.setText("Genghsta");
			playerFiveTitle.setText("ShoT_UP");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/imt-logo.png")));
		} else if (team.equals("T1 ESPORTS")) {
			playerOneTitle.setText("autimatic");
			playerTwoTitle.setText("curry");
			playerThreeTitle.setText("Skadoodle");
			playerFourTitle.setText("Spyder");
			playerFiveTitle.setText("DaZeD");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/t1-logo.png")));
		} else if (team.equals("VERSION 1")) {
			playerOneTitle.setText("vanity");
			playerTwoTitle.setText("effys");
			playerThreeTitle.setText("Zellsis");
			playerFourTitle.setText("penny");
			playerFiveTitle.setText("wippie");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/v1-logo.png")));
		} else if (team.equals("RENEGADES")) {
			playerOneTitle.setText("Stronglegs");
			playerTwoTitle.setText("cp2");
			playerThreeTitle.setText("randyySAVAGE");
			playerFourTitle.setText("Winsum");
			playerFiveTitle.setText("RetrQ");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/rng-logo.png")));
		} else if (team.equals("BUILT BY GAMERS")) {
			playerOneTitle.setText("Poach");
			playerTwoTitle.setText("rarkar");
			playerThreeTitle.setText("Critical");
			playerFourTitle.setText("Bjor");
			playerFiveTitle.setText("Will");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/bbg-logo.png")));
		} else if (team.equals("GEN.G")){
			playerOneTitle.setText("huynh");
			playerTwoTitle.setText("Mkael");
			playerThreeTitle.setText("gMd");
			playerFourTitle.setText("koosta");
			playerFiveTitle.setText("Shawn");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/geng-logo.png")));
		} else {
			playerOneTitle.setText("jcStani");
			playerTwoTitle.setText("vice");
			playerThreeTitle.setText("yay");
			playerFourTitle.setText("seb");
			playerFiveTitle.setText("mada");
			headerImage.setImage(new Image (getClass().getResourceAsStream("/resources/VLEAGUE Assets/team icons/andbox-logo.png")));
		}
	}
	
	private void resultLoad() {		
		resultDefaultScreen.setVisible(false);
		resultDefaultScreen.setDisable(true);
		resultLoadScreen.setVisible(true);
		RotateTransition rotation = new RotateTransition(Duration.seconds(1.25), resultLoadCircle);
		rotation.setByAngle(360);
		rotation.play();
		new Thread(() -> {
			Webscraper data = new Webscraper(Main.database.getMyTeam(username.getText()));	
			Platform.runLater(() -> {
				data.setDate(date1, date2, date3, date4, date5, date6, date7, date8, date9, date10);
				data.setOpponent(rightTeam1, rightTeam2, rightTeam3, rightTeam4, rightTeam5, rightTeam6, rightTeam7, rightTeam8, rightTeam9, rightTeam10,
						rightLogo1, rightLogo2, rightLogo3, rightLogo4, rightLogo5, rightLogo6, rightLogo7, rightLogo8, rightLogo9, rightLogo10	);
				data.setScores(score1, score2, score3, score4, score5, score6, score7, score8, score9, score10);
				data.setSelf(leftLogo1, leftLogo2, leftLogo3, leftLogo4, leftLogo5, leftLogo6, leftLogo7, leftLogo8, leftLogo9, leftLogo10,
						leftTeam1, leftTeam2, leftTeam3, leftTeam4, leftTeam5, leftTeam6, leftTeam7, leftTeam8, leftTeam9, leftTeam10);
			});
		}).start();
		rotation.setOnFinished(event -> {
			resultLoadScreen.setVisible(false);
			resultsScroll.setVisible(true);
			resultsScroll.setDisable(false);
		});
	}
	
	@FXML
	private void onRefreshSelect(MouseEvent event) {
		leaderboardLoad();
	}
	
	//speeds up vertical scroll speed for the leaderboard scrollpane
	@FXML
	private void onLeaderboardScrolling(ScrollEvent event) {
		double deltaY = event.getDeltaY()*3;
        double width = leaderboardScroll.getContent().getBoundsInLocal().getWidth();
		double vvalue = leaderboardScroll.getVvalue();
        leaderboardScroll.setVvalue(vvalue - deltaY/width); 
	}
	
	//speeds up vertical scroll speed for the results scrollpane
	@FXML
	private void onResultsScrolling(ScrollEvent event) {
		double deltaY = event.getDeltaY()*3;
        double width = resultsScroll.getContent().getBoundsInLocal().getWidth();
		double vvalue = resultsScroll.getVvalue();
		resultsScroll.setVvalue(vvalue - deltaY/width); 
	}
	
	//speeds up vertical scroll speed for the schedule scrollpane
	@FXML
	private void onScheduleScrolling(ScrollEvent event) {
		double deltaY = event.getDeltaY()*3;
        double width = scheduleScroll.getContent().getBoundsInLocal().getWidth();
		double vvalue = scheduleScroll.getVvalue();
		scheduleScroll.setVvalue(vvalue - deltaY/width); 
	}
	
	//will display the settings menu once clicked
	@FXML
	private void onGearSelect(MouseEvent event) throws Exception{
		Stage dialogStage = new Stage();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("settings.fxml"));
		AnchorPane root = (AnchorPane)loader.load();
		root.setStyle(
	                "-fx-background-color: transparent; " +
	                "-fx-background-insets: 10; " +
	                "-fx-background-radius: 10; " +
	                "-fx-effect: dropshadow(three-pass-box, black, 10, 0, 0, 0);"
	    );
		//RegisterController controller = (RegisterController) loader.getController();
		Scene scene = new Scene(root);
		scene.setFill(Color.TRANSPARENT);
		dialogStage.initStyle(StageStyle.TRANSPARENT);
		dialogStage.setScene(scene);
		dialogStage.initModality(Modality.APPLICATION_MODAL);
		dialogStage.setX(Main.primaryStage.getX() + (Main.primaryStage.getWidth() / 2) - root.getPrefWidth() / 2);
		dialogStage.setY(Main.primaryStage.getY() + (Main.primaryStage.getHeight() / 2) - root.getPrefHeight() / 2);
		SettingsController controller = loader.getController();
        controller.setAccountInfo(username.getText());
        controller.setTheme(username.getText());
		dialogStage.initOwner(Main.primaryStage);
        dialogStage.showAndWait();
	}
	
	//redirects users to github page
	@FXML
	private void onPatchNotesSelect(MouseEvent event) throws Exception {
		Desktop.getDesktop().browse(new URL("https://github.com/skhanal5/vleague").toURI());
	}
	
	//shows pane with profile icons
	@FXML
	private void onEditProfileSelect(MouseEvent event) {
		profileScreen.setVisible(false);
		profileScreen.setDisable(true);
		profileSelectScreen.setDisable(false);
		profileSelectScreen.setVisible(true);
		profileScroll.setHvalue(.5);
	}
	
	//goes back to main profile pane
	@FXML
	private void onBackArrowSelect(MouseEvent event) {
		profileScreen.setVisible(true);
		profileScreen.setDisable(false);
		profileSelectScreen.setDisable(true);
		profileSelectScreen.setVisible(false);
		previewUserIcon.setImage(largeUserIcon.getImage());
	}
	
	private void playerIconShowcase(String largeIcon, String smallIcon) {
		previewUserIcon.setImage(new Image(getClass().getResourceAsStream(largeIcon)));
		equipIcon.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent actionEvent) {
		    	smallUserIcon.setImage(new Image(getClass().getResourceAsStream(smallIcon)));
		    	largeUserIcon.setImage(previewUserIcon.getImage());
		    	Main.database.setIcon(username.getText(), smallIcon, largeIcon);
		    }
		});
	}
	
	@FXML
	private void onBrimLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/brim-large-icon.png", "/resources/VLEAGUE Assets/small icons/brim-small-icon.png");
	}
	
	@FXML
	private void onCypherLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/cypher-large-icon.png", "/resources/VLEAGUE Assets/small icons/cypher-small-icon.png");
	}
	
	@FXML
	private void onSkyeLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/sky-large-icon.png", "/resources/VLEAGUE Assets/small icons/skye-small-icon.png");
	}
	
	@FXML
	private void onPhoenixLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/phoenix-large-icon.png", "/resources/VLEAGUE Assets/small icons/phoenix-small-icon.png");
	}
	
	@FXML
	private void onRazeLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/raze-large-icon.png", "/resources/VLEAGUE Assets/small icons/raze-small-icon.png");
	}
	
	@FXML
	private void onJettLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/jett-large-icon.png", "/resources/VLEAGUE Assets/small icons/jett-small-icon.png");
	}
	
	@FXML
	private void onReynaLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/reyna-large-icon.png", "/resources/VLEAGUE Assets/small icons/reyna-small-icon.png");
	}
	
	@FXML
	private void onSovaLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/sova-large-icon.png", "/resources/VLEAGUE Assets/small icons/sova-small-icon.png");
	}
	
	@FXML
	private void onKillJoyLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/sova-large-icon.png", "/resources/VLEAGUE Assets/small icons/sova-small-icon.png");
	}
	
	@FXML
	private void onOmenLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/omen-large-icon.png", "/resources/VLEAGUE Assets/small icons/omen-small-icon.png");
	}
	
	@FXML
	private void onSageLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/sage-large-icon.png", "/resources/VLEAGUE Assets/small icons/sage-small-icon.png");
	}
	
	@FXML
	private void onYoruLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/yoru-large-icon.png", "/resources/VLEAGUE Assets/small icons/yoru-small-icon.png");
	}
	
	@FXML
	private void onViperLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/viper-large-icon.png", "/resources/VLEAGUE Assets/small icons/viper-small-icon.png");
	}
	
	@FXML
	private void onBreachLabelSelect(MouseEvent event) {
		playerIconShowcase("/resources/VLEAGUE Assets/large icons/breach-large-icon.png", "/resources/VLEAGUE Assets/small icons/breach-small-icon.png");
	}
	
	private void showcaseTeam(String teamName, String imageURL, String player1, String player2, String player3, String player4, String player5,
								String picOne, String picTwo, String picThree, String picFour, String picFive) {
		teamNameLabel.setText(teamName);
		teamIconPreview.setImage(new Image(getClass().getResourceAsStream(imageURL)));
		playerOne.setText(player1);
		playerTwo.setText(player2);
		playerThree.setText(player3);
		playerFour.setText(player4);
		playerFive.setText(player5);
		playerOnePic.setImage(new Image (getClass().getResourceAsStream(picOne)));
		playerTwoPic.setImage(new Image (getClass().getResourceAsStream(picTwo)));
		playerThreePic.setImage(new Image (getClass().getResourceAsStream(picThree)));
		playerFourPic.setImage(new Image (getClass().getResourceAsStream(picFour)));
		playerFivePic.setImage(new Image (getClass().getResourceAsStream(picFive)));
	}
	
	@FXML
	private void onTSMSelect(MouseEvent event) {
		showcaseTeam("TEAM SOLOMID","/resources/VLEAGUE Assets/large team icon/tsm-large.png", "WARDELL", "hazed", "Drone", "Subroza", "brax",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void on100TSelect(MouseEvent event) {
		showcaseTeam("100 THIEVES","/resources/VLEAGUE Assets/large team icon/100t-large.png", "Hiko", "Ethan", "Asuna", "nitr0", "steel",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onC9Select(MouseEvent event) {
		showcaseTeam("CLOUD 9","/resources/VLEAGUE Assets/large team icon/c9-large.png", "leaf", "xeta", "poiz", "mitch", "floppy",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onSentinelsSelect(MouseEvent event) {
		showcaseTeam("SENTINELS","/resources/VLEAGUE Assets/large team icon/sen-large.png", "TenZ", "ShahZam", "SicK", "zombs", "dapr",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onEnvySelect(MouseEvent event) {
		showcaseTeam("ENVY","/resources/VLEAGUE Assets/large team icon/envy-large.png", "Victor", "crashies", "FNS", "mummAy", "kaboose",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onGenGSelect(MouseEvent event) {
		showcaseTeam("GEN.G","/resources/VLEAGUE Assets/large team icon/geng-large.png", "huynh", "Mkael", "gMd", "koosta", "Shawn",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");;
	}
	
	@FXML
	private void onLGSelect(MouseEvent event) {
		showcaseTeam("LUMINOSITY GAMING","/resources/VLEAGUE Assets/large team icon/lg-large.png", "aproto", "stellar", "thief", "YaBoiDre", "moose",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onFazeSelect(MouseEvent event) {
		showcaseTeam("FAZE CLAN","/resources/VLEAGUE Assets/large team icon/faze-large.png", "ZachaREEE", "BABYBAY", "Marved", "Rawkus", "corey",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onXSETSelect(MouseEvent event) {
		showcaseTeam("XSET GAMING","/resources/VLEAGUE Assets/large team icon/xset-large.png", "PureR", "AYRIN", "WeDid", "BcJ", "thwifo",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onNRGSelect(MouseEvent event) {
		showcaseTeam("NRG ESPORTS","/resources/VLEAGUE Assets/large team icon/nrg-large.png", "ANDROID", "eeiu", "s0m", "daps", "tex",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onIMTSelect(MouseEvent event) {
		showcaseTeam("IMMORTALS","/resources/VLEAGUE Assets/large team icon/imt-large.png", "N/A", "Kehmicals", "jcStani", "Genghsta", "ShoT_UP",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onT1Select(MouseEvent event) {
		showcaseTeam("T1 ESPORTS","/resources/VLEAGUE Assets/large team icon/t1-large.png", "autimatic", "curry", "Skadoodle", "Spyder", "DaZeD",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onV1Select(MouseEvent event) {
		showcaseTeam("VERSION 1","/resources/VLEAGUE Assets/large team icon/v1-large.png", "vanity", "effys", "Zellsis", "penny", "wippie",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onRNGSelect(MouseEvent event) {
		showcaseTeam("RENEGADES","/resources/VLEAGUE Assets/large team icon/rng-large.png", "Stronglegs", "cp2", "randyySAVAGE", "Winsum", "RetrQ",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onBBGSelect(MouseEvent event) {
		showcaseTeam("BUILT BY GAMERS","/resources/VLEAGUE Assets/large team icon/bbg-large.png", "Poach", "rarkar", "Critical", "Bjor", "Will",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onANDBOXSelect(MouseEvent event) {
		showcaseTeam("ANDBOX","/resources/VLEAGUE Assets/large team icon/andbox-large.png", "jcStani", "vice", "yay", "seb", "mada",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png", "/resources/VLEAGUE Assets/team icons/person-icon.png",
				"/resources/VLEAGUE Assets/team icons/person-icon.png");
	}
	
	@FXML
	private void onLockInSelect(MouseEvent event) {
		Main.database.setTeam(username.getText(), true, teamNameLabel.getText());
		myTeamLoad();
	}
}
