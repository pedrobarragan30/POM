package pomIMDB.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@RunWith(JUnitParamsRunner.class)
public class IMDBTest extends IMDBBase {

	@Test
	@FileParameters("./data/dtIMDB.csv") 
	public void testMovies(String browser, String urlToOpen, String movieName, String moreMatchesLink,
			String sequelName, String movieYear, String fullCastLink,
			String roleActor_1, String roleName_1,
			String roleActor_2, String roleName_2,
			String roleActor_3, String roleName_3) {
		
		setUp(urlToOpen,browser);

		imdbHomePage.searchMovie(movieName);
		imdbFindPage.moreMatches(moreMatchesLink);
		imdbFindPage.locateAndOpen(sequelName, movieYear);
		imdbTitlePage.validateTitle(sequelName, movieYear);
		imdbTitlePage.openCast(fullCastLink);
		imdbCastPage.validateTitle(sequelName, movieYear);
		imdbCastPage.validateActor_Role(roleActor_1, roleName_1, roleActor_2, roleName_2, roleActor_3, roleName_3);
	}
}