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
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.google.api.services.docs.v1.DocsScopes;
import com.google.api.services.tasks.Tasks;
import com.google.api.services.tasks.Tasks.Tasklists.Get;
import com.google.api.services.tasks.TasksScopes;
import com.google.api.services.tasks.model.Task;
import com.google.api.services.tasks.model.TaskList;
import com.google.api.services.tasks.model.TaskLists;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TasksAPI {
  private static final String APPLICATION_NAME = "Google Tasks API Java Quickstart";
  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
  private static final String TOKENS_DIRECTORY_PATH = "tokens";

  /**
   * Global instance of the scopes required by this quickstart.
   * If modifying these scopes, delete your previously saved tokens/ folder.
   */
  private static final List<String> SCOPES = 
		  Arrays.asList(CalendarScopes.CALENDAR,DocsScopes.DOCUMENTS,TasksScopes.TASKS);
  private static final String CREDENTIALS_FILE_PATH = "/credentials.json";
   static Tasks service;
   static  String tasklistID="R2c1eGhHODN4SDh1NVVCeA";

  /**
   * Creates an authorized Credential object.
   *
   * @param HTTP_TRANSPORT The network HTTP Transport.
   * @return An authorized Credential object.
   * @throws IOException If the credentials.json file cannot be found.
   */
  private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
      throws IOException {
    // Load client secrets.
    InputStream in = TasksAPI.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
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
    return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
  }

  public static void main(String... args) throws IOException, GeneralSecurityException {
    // Build a new authorized API client service.
    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
    service = new Tasks.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
        .setApplicationName(APPLICATION_NAME)
        .build();

    // Print the first 10 task lists.
   /* TaskLists result = service.tasklists().list()
        .setMaxResults(10)
        .execute();
    List<TaskList> taskLists = result.getItems();
    if (taskLists == null || taskLists.isEmpty()) {
      System.out.println("No task lists found.");
    } else {
      System.out.println("Task lists:");
      for (TaskList tasklist : taskLists) {
        System.out.printf("%s (%s)\n", tasklist.getTitle(), tasklist.getId());
      }
    }*/
    completeTask("Play Fifa");
    
  }
  static void createTaskList(String Title) throws IOException, GeneralSecurityException {
	    // Build a new authorized API client service.
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    service = new Tasks.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	        .setApplicationName(APPLICATION_NAME)
	        .build();
	 TaskList tasklist = new TaskList().setTitle("TO DO LIST");
	 tasklist = service.tasklists().insert(tasklist).execute();

  }
  static TaskList getTaskList() throws IOException, GeneralSecurityException {
	    // Build a new authorized API client service.
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    service = new Tasks.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	        .setApplicationName(APPLICATION_NAME)
	        .build();
	  TaskLists result = service.tasklists().list().execute();
	  List<TaskList> taskLists = result.getItems();
	  for(TaskList i:taskLists)
		  if(i.getTitle().equals("TO DO LIST")) {
			  return i;
			  }
	  
	  return null;
	 
  }
  static void createTask(String Title,String Notes) throws IOException, GeneralSecurityException {
	    // Build a new authorized API client service.
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    service = new Tasks.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	        .setApplicationName(APPLICATION_NAME)
	        .build();
	  TaskList tasklist = getTaskList();
	  if(tasklist==null)
		  System.err.println("Please create a taskList first");
	  Task task =new Task()
			  .setTitle(Title)
			  .setNotes(Notes);
	  task=service.tasks().insert(tasklist.getId(),task).execute();
  }
  static Task getTask(String taskTitle) throws IOException, GeneralSecurityException {
	    // Build a new authorized API client service.
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    service = new Tasks.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	        .setApplicationName(APPLICATION_NAME)
	        .build();
	  TaskList tasklist = getTaskList();
	  com.google.api.services.tasks.model.Tasks tasks=service.tasks().list(tasklist.getId()).execute();
	  List<Task> task = tasks.getItems();
	  for(Task i:task)
		  if(i.getTitle().equals(taskTitle)&&!(i.getCompleted()!=null))
			  return i;
	  return null;
	  
  }
  static ArrayList<String> getTasks() throws IOException, GeneralSecurityException {
	    // Build a new authorized API client service.
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    service = new Tasks.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	        .setApplicationName(APPLICATION_NAME)
	        .build();
	  ArrayList<String> list = new ArrayList<String>();
	  TaskList tasklist = getTaskList();
	  com.google.api.services.tasks.model.Tasks tasks=service.tasks().list(tasklist.getId()).execute();
	  List<Task> task = tasks.getItems();
	  for(Task i:task)
		  if(!(i.getCompleted()!=null)) {
			  list.add(i.getTitle()+":");
			  list.add("\t"+i.getNotes());
		  }
	  return list;
	  
}
  static void completeTask(String taskTitle) throws IOException, GeneralSecurityException {
	    // Build a new authorized API client service.
	    final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
	    service = new Tasks.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
	        .setApplicationName(APPLICATION_NAME)
	        .build();
	  TaskList tasklist=getTaskList();
	  Task task = getTask(taskTitle);
	  task.setStatus("completed");
	  task = service.tasks().update(
	      tasklist.getId(),
	      task.getId(),
	      task
	  ).execute();

  }

}
