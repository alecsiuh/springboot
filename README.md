<h1>Project Description</h1>

<h2>Domain model</h2>
![Domain model](/src/main/resources/static/domainModel.png)

<h2>Data model</h2>
![Data model](/src/main/resources/static/dataModel.png)

<h4>Login credentials</h4>
<ul>
  <li>
      Username: Alexia, Password: alexia, ADMIN
  </li>
<li>
      Username: Albert, Password: albert, ADMIN
  </li>
  <li>
      Username: Josh, Password: josh, USER
  </li>
<li>
      Username: Jenny, Password: jenny, USER
  </li>
</ul>

<h3>Description</h3>
<p>
Spring Boot application that has 4 main entities: Albums, Songs, Artists. There is a One-to-Many relation between the Albums and Artist and a Many-to-Many relation between the Albums and Songs. The user can add, delete, update and search objects regarding these entities. The preexisting objects are added via 2 .sql files: one that adds the tables and the columns and one that add the information in the tables.
The database is a PostgresSQL database.</p>
<p>
In order to see the contents of the website the user has to log in, using the already made accounts, or they can make a new account.
</p>
<p>
If the user is logged in as a regular user, they can only see the already added Albums, Artists and Songs and search for a specific song.
</p>
<p>
If the user is logged in as an admin they can, besides the perks of a regular user, manage the entities by adding, deleting and updating them. 
</p>

<h3>Features (First term)</h3>

- [ ] PatchMapping in all the API controllers to change the name of the objects
- [ ] PostMapping in all the API controllers to add a new object
- [x] validation framework to implement basic checks on the input
- [x] ModelMapper
- [ ] endpoints are called from JavaScript
- [x] .http file
<p>

</p>

- [x] users can log in or out of their account
- [x] the user knows they're logged by seeing their username in the top right corner of any page
- [x] the website has a custom login page
- [ ] user can register a new account
- [x] passwords are hashed in the database (BCrypt)
<p>

</p>

- [x] project has 2 roles: ROLE_USER and ROLE_ADMIN
- [x] if the user is not logged in (url: http://localhost:8080/musicLibrary or http://localhost:8080)
  - they can see the landing page 
- [x] if the user is logged in as a regular user (ROLE_USER)
  - they can see the landing page
  - they can see all the already added Albums, Artists and Songs
  - they can search for songs
  - they can see the individual page of the Artist, Album or Song
-[x] if the user is logged in as an admin (ROLE_ADMIN)
  - they can see the landing page
  - they can see the already added Albums, Artists, Songs
  - they can add new Albums, Artists, Songs
  - they can delete Albums, Artists, Songs
  - they can update the name of the Albums, Artists, Songs
- [x] the user is associated with all the entities
<p>

</p>

- [x] 2 different spring profiles
  - one works using .sql to implement the data (**used profile**)
  - the other one works with a seeder to implement the album info
- [x] included test specific setups (_@BeforeAll_) in the _Seeder_ class that works with the AlbumControllerTest to check if allAlbums actually shows all the albums implemented 
- [x] controller test has a "_@AutoConfigureMockMvc(addFilters = false)_" that bypassed the security temporarily
<p>

</p>

- [x] _AlbumControllerTest_ has 2 methods that 
  - **deletingAnAlbumStopShouldReturn404ForNonExistingAlbums()** 
    - checks that it's not possible to delete an album that does not already exist based on the ID value
  - **allAlbumsShouldShowAllAlbums()**
    - checks that all 10 albums are shown on the _/albums_ page
- [x] _ArtistControllerTest_ checks if the url _/api/artists_ returns a JSON file as a response 
- [x] _ArtistRepositoryTest_ has 2 methods that
  - **artistNameIsUnique()**
    - checks if an Artist object is unique
  - **artistGenderIsMandatory()**
    - check that gender has to be specified when creating a new Artist
- [x] _AlbumServiceTest_ checks that you cannot change the name of an album that does not exist based on the ID
- [x] _ArtistServiceTest_ has
  - a _@BeforeAll_ setup that initialises a new User and a new Artist that will be used in _changeArtistNameShouldChangeTheArtistName()_ 
  - **changeArtistNameShouldChangeTheArtistName()**
    - checks if the update method from the Service layer actually changes the name of the Artist


### Create a docker container for the DB
```shell
docker build -t "music_db_image:Dockerfile" .
```

```shell
docker create --name music_db_image -p 5431:5432 music_db_image:Dockerfile
```

### Start the container:
```shell
docker container start music_db_image
```

### Check tests command
```shell
./gradlew check
```
<h3>Features (Second term)</h3>
<h4>Week 1 - Testing</h4>

- [x] tests cover the MVC, API, repository and service parts of the project
- [x] _ArtistsControllerTest_  
  - **searchArtistsShouldSearchCaseInsensitive()**
    - checks if searching an artist is case-insensitive by including a section of an existing band name and the expected number of matching results expected
  - **deleteArtistShouldReturnNotFoundForNonExistingArtist**
    - checks if trying to delete a non-existing artist by an id that doesn't exist is returning the status "not found"
  - **deletingASongShouldReturn404ForNonExistingSong**
- [x] _SongsControllerTest_  
    - checks if trying to delete a non-existing song by an id that doesn't exist is returning code 404
- [x] _SongControllerTest_ 
  - has a @BeforeAll that seeds 3 new songs
  - **addSongShouldSucceedAsAdmin** checks if only admins can add a song by adding an admin's details and trying to create a new song
  - **addSongShouldFailForRegularUsers** checks that normal users can't add a song
- [x] _ArtistRepositoryTest_  
  - **artistNameIsUnique** created 2 new artists that have the same attributes and checks to see if the name is unique by throwing a DataIntegrityViolationException exception
  - **artistGenderIsMandatory** checks if it's possible to create a new artist and insert the gender as null. To check if gender is mandatory, the test throws a DataIntegrityViolationException exception
- [x] _SongRepositoryTest_  
   - has a @BeforeAll that creates a new song by adding its name, duration and genre using the repository and fetching its id
   - then in the actual test, there are 3 new Song instances that get the song previously created by getting the name; each time spelled differently, and then tries to see if they match the song from @BeforeAll
   - in the end, the song is deleted from the DB using the id
- [x] _AlbumServiceTest_
  - check if a non-existent album can be modified by asserting it as false
- [x] _ArtistServiceTest_
  - has a @BeforeAll that creates a user and a new artist
  - the test checks if the user can modify the name of a pre-existing artist
<p>

</p>

<h4>Week 2 - Client</h4>

- [x] the Client project has npm, webpack and ESLint implemented
- [x] styling is done using Sass by using variables for the nav color, background and user messages and is imported using the index.js file
- [x] bootstrap is imported using the index.js file
- [x] nav bar menu items are done using SPA: by clicking on Search the title disappears, and the search bar is visible, and if you click on Add, the search bar is not visible anymore and the user can see the add form
- [x] the search and add endpoints were previously implemented in the Spring Boot's backend of the main project
- [x] they are implemented in the Client project using a fetch call
  - if there are no results and error message appears, otherwise there is the search result table
  - if the added form is not completed accordingly, the page remains the same; otherwise the user gets a message confirming that the object has been added succesfully
- [x] CSRF is disabled only for "api/albums"
- [x] CORS is enabled and corresponds to the Client application

<h4>Week 3</h4>

- [x] frontend project is embedded using npm and webpack and by following the 13-step project
- [x] styling is done using Sass by using color variables and is imported using a site.js file in the fragment header to import it all over the html pages easier
- [x] csrf function used in the .js files is written into a module.js file and imported into the rest of the .js files
- [x] ESLint's suggestions are implemented in the .js files
- [x] bootstrap icons are imported using the side.js file
- [x] client-side validation is done using Joi npm package

<h4>Week 4 - Multithreading</h4>

- [x] new gradle project using String Data JPA and PostgreSQL Driver
- [x] new docker container created using the Docker and README files 
- [x] application.properties updated with DB info and the number of records inserted into the Artist table (10000)
  - to seed the DB, the ddl is first set to create and then for searching and removing it's set to validate
- [x] @Entity Artists is retrieved from the main project and has a JPA repository
- [x] can switch between the seeders and searchers using @Qualifiers in the main app (interface implemented)
- [x] seeding is done using faker
  - id is implemented using the integer 'i'
  - the name is done using the name() method from Faker
  - the gender is binary and picked by the Faker
  - the year is random and is chosen between 1900 and 2023
  - time is recorded in the main app using StopWatch
- [x] multithreading has a separate Worker class that seeds that DB using random instances between 2 id numbers
- [x] the actual seeding is done using the multithreading class in a private class that takes CompletableFuture<Void>
- [x] the seeding is done using N-threads 
- [x] the single threaded seeder finds the records that start with the letter M and that debuted between 1940 and 2000 by getting them one by one using their id
- [x] multithreading has a separate worker class that finds the records between 2 numbers (same logic as the seeder)
- [x] the first 5 records are printed in the main app
- [x] the remover class removes any record that matches the predicate from List<Artist>
- [x] the actual removing is done in a separate class where 3 predicates are initialized and used by Workers
- [x] 3 threads are started
- [x] timing is done in the Multithreading project README

<h4>Week 5 - Main project docker and CSV</h4>

- [x] commands to create a container for the main project's database are included in the README
- [x] all tests run without installing PostgreSQL locally, manually creating a DB schema, or granting access to the "postgres" database
- [x] all unused files and Programming 3 files are removed
- [x] gitignore has been updated
- [x] admin only page that lets the user upload artist entities using a csv file
- [x] page is implemented using the ArtistController
- [x] the user gets a response as soon as the file is uploaded
- [x] Thread.milis is used in the repository to mimic long processing times
- [x] a sample CSV file can be found in the resources static folder
