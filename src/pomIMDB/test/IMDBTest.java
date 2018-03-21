package pomIMDB.test;

import org.junit.Test;

public class IMDBTest extends IMDBBase {

	@Test
	public void testMovies() {
		System.out.println("test");

		imdbHomePage.searchMovie();
		imdbFindPage.moreMatches();
		imdbFindPage.locateAndOpen();
		imdbTitlePage.validateTitle();
		imdbTitlePage.validateTitle();
		imdbTitlePage.openCast();
		imdbCastPage.validateActor_Role();
	}

}
