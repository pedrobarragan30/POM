package pomIMDB.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class IMDBTest extends IMDBBase {

	@Test
	@FileParameters("./data/dtIMDB.csv") 
	public void testMovies(String browser, String urlToOpen, String movieName, String linkName,
			String sequelName, String movieYear) {
		
		setUp(urlToOpen,browser);

		imdbHomePage.searchMovie(movieName);
		imdbFindPage.moreMatches(linkName);
		imdbFindPage.locateAndOpen(sequelName, movieYear);
		imdbTitlePage.validateTitle(sequelName, movieYear);
		//imdbTitlePage.openCast();
		//imdbCastPage.validateActor_Role();
	}

}
