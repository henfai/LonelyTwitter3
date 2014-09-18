package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ca.ualberta.cs.loneltwitter.data.fileDataManager;
import ca.ualberta.cs.loneltwitter.data.iDataManager;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class LonelyTwitterActivity extends Activity {

	private iDataManager dataManager; 
	
	private EditText bodyText;
	
	private ArrayList<abstractTweet> tweets;
	
	private ArrayAdapter<abstractTweet> tweetsViewAdapter;
	
	private ListView oldTweetsList;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		dataManager = new fileDataManager();
		bodyText = (EditText) findViewById(R.id.body);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);
	}

	@Override
	protected void onStart() {
		super.onStart();
		
		tweets = dataManager.loadTweets();
		tweetsViewAdapter = new ArrayAdapter<abstractTweet>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(tweetsViewAdapter);
	}
	
	public void save(View v) {
		
		String text = bodyText.getText().toString();
		
		
		///---------------------
		if(text.contains("*"))
		{
			text = text.replace("*","");
			StarredTweet stweet = new StarredTweet(new Date(), text);
			tweets.add(stweet);
		}
		else
		{
			Tweet tweet = new Tweet (new Date(), text);
			tweets.add(tweet);
		}
		///---------------------
		
		tweetsViewAdapter.notifyDataSetChanged();
		
		bodyText.setText("");
		dataManager.saveTweets(tweets);
	}
	
	public void clear(View v) {
		
		tweets.clear();
		tweetsViewAdapter.notifyDataSetChanged();
		dataManager.saveTweets(tweets);
	}
	
}