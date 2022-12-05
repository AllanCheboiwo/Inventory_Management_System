package Inventory_Management_System;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.Calendar.Events.Get;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import com.google.api.services.calendar.model.Events;
import com.google.api.services.docs.v1.DocsScopes;
import com.google.api.services.tasks.TasksScopes;
import com.google.api.services.tasks.model.Task;
import com.google.api.services.tasks.model.TaskList;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/* class to demonstarte use of Calendar events list API */
public class CalendarAPI {
  /**
   * Application name.
   */
  private static final String APPLICATION_NAME = "Google Calendar API Java Quickstart";
  /**
   * Global instance of the JSON factory.
   */
  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
  /**
   * Directory to store authorization tokens for this application.
   */
  private static final String TOKENS_DIRECTORY_PATH = "tokens";

  /**
   * Global instance of the scopes required by this quickstart.
   * If modifying these scopes, delete your previously saved tokens/ folder.
   */
  private static final List<String> SCOPES =
	Arrays.asList(CalendarScopes.CALENDAR,DocsScopes.DOCUMENTS,TasksScopes.TASKS);
     
		 
  private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
  
  private static final String list_ID="$allan12345678#";

  /**
   * Creates an authorized Credential object.
   *
   * @param HTTP_TRANSPORT The network HTTP Transport.
   * @return An authorized Credential object.
   * @throws IOException If the credentials.json file cannot be found.
   */
  
  public static Calendar service;
  private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
      throws IOException {
    // Load client secrets.
    InputStream in = CalendarAPI.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
    if (in == null) {
      throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
    }
    GoogleClientSecrets clientSecrets =
        GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

    // Build flow and trigger user authorization request.
    GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
        .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
        .setAccessType("offline")
        .build();
    LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
    Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    //returns an authorized Credential object.
    return credential;
  }

  public static void main(String... args) throws IOException, GeneralSecurityException {
    // Build a new authorized API client service.

    
   // createEvent("orders","veggies",now,"allangabz@gmail.com");
  }
  public static void createEvent(String title, String Description,DateTime date,String email) throws IOException, GeneralSecurityException {
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    	service =
        new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
            .setApplicationName(APPLICATION_NAME)
            .build();
	  Event event = new Event().setSummary(title).setDescription(Description);
	  EventDateTime start = new EventDateTime().setDateTime(date).setTimeZone("Canada/Pacific");
	  event.setStart(start);
	  
	  EventDateTime end = new EventDateTime().setDateTime(date).setTimeZone("Canada/Pacific");
	  event.setEnd(end);
	  EventAttendee attendee = new EventAttendee().setEmail(email);
	  event.setAttendees(Arrays.asList(attendee));
	  
	  EventReminder reminder = new EventReminder().setMethod("email").setMinutes(24*60);
	  
	  Event.Reminders reminders = new Event.Reminders().setUseDefault(false).setOverrides(Arrays.asList(reminder));
	  event.setReminders(reminders);
	  
	  String calendarId = "primary";
	  event = service.events().insert(calendarId,event).execute();
	  
	  
  }
  public static List<String> getEvent() throws IOException, GeneralSecurityException {
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
  	service =
      new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
          .setApplicationName(APPLICATION_NAME)
          .build();
	    DateTime now = new DateTime(System.currentTimeMillis());
	    List<String> s = new ArrayList<String>();
	    Events events = service.events().list("primary")
	        .setTimeMin(now)
	        .setOrderBy("startTime")
	        .setSingleEvents(true)
	        .execute();
	    List<Event> items = events.getItems();
	    if (items.isEmpty()) {
	      s.add("No upcoming events found");
	    } else {
	      for (Event event : items) {
	        DateTime start = event.getStart().getDateTime();
	        if (start == null) {
	          start = event.getStart().getDate();
	          
	        }
	        s.add(event.getSummary());
	        s.add("\t"+"("+start+")");
	       //System.out.printf("%s (%s)\n", event.getSummary(), start);
	      }
	      
	    }
	    return s;

  }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
}