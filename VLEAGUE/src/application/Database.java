package application;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;

public class Database {
	
	private static MongoClient mongoClient;
	private static MongoDatabase database;
	private static MongoCollection<Document> users;
	
	//initializes static fields
	static {
		mongoClient = MongoClients.create(Constants.CLIENT_URL);
		database = mongoClient.getDatabase(Constants.DATABASE_NAME);
		users = database.getCollection(Constants.COLLECTION_NAME);
	}
	
	//adds user to database
	public void add(String username, String emailAddress, String hashedPassword) {
		LocalDate now = LocalDate.now();
		Document newUser = new Document();
		newUser.append("username", username).append("email-address", emailAddress).append("password", hashedPassword).append("date-joined", now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")))
		.append("icon-small", "/resources/VLEAGUE Assets/small icons/jett-small-icon.png").append("icon-large", "/resources/VLEAGUE Assets/large icons/jett-large-icon.png")
		.append("gold-trophy", "0").append("silver-trophy", "0").append("bronze-trophy", "0")
		.append("matches-played", "—").append("vp-earned", "—").append("global-rank", "—").append("top-finishes", "—").append("favorite-team", "—")
		.append("music-volume", 0.25).append("fx-volume", 0.5).append("team-selected", false).append("current-team", "n/a");
		users.insertOne(newUser);
	}
	
	//stores large and small icon for user profile
	public void setIcon(String user, String smallIcon, String largeIcon) {
		users.updateOne(Filters.in("username", user), Updates.set("icon-small", smallIcon));
		users.updateOne(Filters.in("username", user), Updates.set("icon-large", largeIcon));
	}
	
	//stores music volume and fx volume for settings
	public void setVolume(String user, double musicVol, double fxVol) {
		users.updateOne(Filters.in("username", user), Updates.set("music-volume", musicVol));
		users.updateOne(Filters.in("username", user), Updates.set("fx-volume", fxVol));
	}
	
	public void setTeam(String user, boolean value, String team) {
		users.updateOne(Filters.in("username", user), Updates.set("team-selected", true));
		users.updateOne(Filters.in("username", user), Updates.set("current-team", team));
	}
	
	public Boolean checkTeam(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getBoolean("team-selected");
	}
	
	public String getMyTeam(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("current-team");
	}
	
	//retrieves small icon for player profile
	public String getSmallIcon(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("icon-small");
	}
	

	//retrieves large icon for player profile
	public String getLargeIcon(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("icon-large");
	}
	
	//retrieves date-joined for player profile
	public String getDateJoined(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("date-joined");
	}
	
	//retrieves email address for account information page in settings
	public String getEmailAddress(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("email-address");
	}
	
	//retrieves gold-trophy count for player profile
	public String getGolds(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("gold-trophy");
	}
	
	//retrieves silver-trophy count for player profile
	public String getSilvers(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("silver-trophy");
	}
	
	//retrieves bronze-trophy count for player profile
	public String getBronzes(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("bronze-trophy");
	}
	
	//retrieves matches-played count for player profile
	public String getMatchTotal(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("matches-played");
	}
	
	//retrieves earnings count for player profile
	public String getEarnings(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("vp-earned");
	}
	
	//retrieves global rank for player profile
	public String getRank(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("global-rank");
	}
	
	//retrieves top finishes for player profile
	public String getFinishes(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("top-finishes");
	}
	
	//retrieves favorite team for player profile
	public String getTeam(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("favorite-team");
	}
	
	//retrieves music volume setting for user
	public double getMusicVolume(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getDouble("music-volume");
	}
	
	//retrieves music volume setting for user
	public double getFXVolume(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getDouble("fx-volume");
	}
	
	//retrieves hashed password for validation
	public String getHashedPassword(String username) {
		Document d = users.find(Filters.in("username", username)).first();
		return d.getString("password");
	}
	
	//checks if this username exists in the database
	public boolean checkUsername(String username) {
		long count = users.countDocuments(new Document("username", new Document("$eq", username)));	
		if (count==1) {
			return true;
		} else {
			return false;
		}
	}
	
	//checks if this email exists in the database
	public boolean checkEmail(String email) {
		long count = users.countDocuments(new Document("email-address", new Document("$eq", email)));	
		if (count==1) {
			return true;
		} else {
			return false;
		}
	}
	
	//returns a hashed plain-text password
	public String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}
	
}
