package ca.ualberta.cs.lonelytwitter.test;

//import android.annotation.SuppressLint;
import org.w3c.dom.Text;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

//@SuppressLint("NewApi") 
public class IntentReaderActivityTest extends
        ActivityInstrumentationTestCase2<IntentReaderActivity> {

    public IntentReaderActivityTest() {
        super(IntentReaderActivity.class);
    }

//TODO: Add your code here:
       
    public void testSendText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing send text");
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	assertEquals("okay", ira.getText(), "testing send text");
    	
    }
    
    public void testDisplayText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "testing send text");
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	
    	TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	
    	assertEquals(tv.getText(), "testing send text");
    } 
    
    public void testDoubleText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Bye ");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.DOUBLE);
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	assertEquals("okay", ira.getText(), "Bye Bye ");
    }
    
    public void testReverseText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.TEXT_TO_TRANSFORM_KEY, "Jordan");
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.REVERSE);
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	assertEquals("okay", ira.getText(), "nadroJ");
    }
    
    public void testDeafultText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.NORMAL);
    	
    	setActivityIntent(intent);
    	
    	IntentReaderActivity ira = getActivity();
    	assertEquals("okay", ira.getText(), "default text");
    }
    
    
    public void testViewText(){
    	Intent intent = new Intent();
    	intent.putExtra(IntentReaderActivity.MODE_OF_TRANSFORM_KEY, IntentReaderActivity.NORMAL);
    	
    	IntentReaderActivity ira = getActivity();
    	TextView tv = (TextView)ira.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
    	setActivityIntent(intent);
    
    	ViewAsserts.assertOnScreen(ira.getWindow().getDecorView(), tv);
    }
    
}
