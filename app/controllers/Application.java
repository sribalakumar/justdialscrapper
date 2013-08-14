package controllers;

import play.*;
import play.mvc.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() throws IOException {
    	String json_chennai_cabs="";
    	String json_chennai_cars="";
    	String json_chennai_watch="";
    	String json_chennai_laptop="";
    	String json_chennai_tv="";
    	
    	String json_mumbai_cabs="";
    	String json_mumbai_cars="";
    	String json_mumbai_watch="";
    	String json_mumbai_laptop="";
    	String json_mumbai_tv="";
    	
    	String json_delhi_cabs="";
    	String json_delhi_cars="";
    	String json_delhi_watch="";
    	String json_delhi_laptop="";
    	String json_delhi_tv="";
    	
    	BufferedReader reader = new BufferedReader(new FileReader("./app/controllers/chennai-cabs.json"));
    	String line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_chennai_cabs=line;
    	}
    	
    	System.out.println("json_chennai_cabs"+json_chennai_cabs);
    	
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/chennai-cars.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_chennai_cars=line;
    	}
    	
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/chennai-watch.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_chennai_watch=line;
    	}
    	
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/chennai-laptop.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_chennai_laptop=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/chennai-tv.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_chennai_tv=line;
    	}
    	
    	    	
    	reader = new BufferedReader(new FileReader("./app/controllers/mumbai-cabs.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_mumbai_cabs=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/mumbai-cars.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_mumbai_cars=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/mumbai-watch.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_mumbai_watch=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/mumbai-laptop.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_mumbai_laptop=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/mumbai-tv.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_mumbai_tv=line;
    	}
    	
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/delhi-cabs.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_delhi_cabs=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/delhi-cars.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_delhi_cars=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/delhi-watch.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_delhi_watch=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/delhi-laptop.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_delhi_laptop=line;
    	}
    	
    	reader = new BufferedReader(new FileReader("./app/controllers/delhi-tv.json"));
    	line = null;
    	while ((line = reader.readLine()) != null) {
    	    json_delhi_tv=line;
    	}
    	
    	    	
        render(json_chennai_cabs,
        		json_chennai_cars,json_chennai_watch ,json_chennai_laptop ,json_chennai_tv ,
        		json_mumbai_cabs,json_mumbai_cars,json_mumbai_watch,json_mumbai_laptop,json_mumbai_tv,
        		json_delhi_cabs,json_delhi_cars,json_delhi_watch,json_delhi_laptop,json_delhi_tv
        		);
    }

}