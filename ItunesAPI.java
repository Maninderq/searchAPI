package mandi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ItunesAPI {
	
	@Test
	public void testSearch(){
		//https://itunes.apple.com/search?[parameterkeyvalue]
		
		Assert.assertTrue(callSearchAPI("https://itunes.apple.com/search?term=Arijit+Singh&media=music&limit=3"));
	}
	
	@Test
	public void testSearch1(){
		Assert.assertTrue(callSearchAPI("https://itunes.apple.com/search?term=Arijit+Singh&media=music"));
	}
	
	@Test
	public void testSearch2(){
		Assert.assertTrue(callSearchAPI("https://itunes.apple.com/search?term=Arijit+Singh&media=ebook"));
	}
	
	@Test
	public void testSearch3(){
		Assert.assertTrue(callSearchAPI("https://itunes.apple.com/search?term=Arijit+Singh&media=music&limit=3&country=IN"));
	}
	
	@Test
	public void testSearch4(){
		Assert.assertTrue(callSearchAPI("https://itunes.apple.com/search?term=Arijit+Singh&media=movie&limit=3&country=CV"));
	}
	
    public boolean callSearchAPI(String searchParam){
        try {

            URL url = new URL(searchParam);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("GET");
          
            InputStreamReader isr = new InputStreamReader(http.getInputStream());
            BufferedReader br = new BufferedReader(isr);

            String results;
            System.out.println("itunes Server Results \n");
            while ((results = br.readLine()) != null) {
                System.out.println(results);
            }

            http.disconnect();
            return true;

         } catch (MalformedURLException e) {

            e.printStackTrace();

         } catch (IOException e) {

            e.printStackTrace();

         }
        return false;
    }

}
