<h1>Project Description</h1>

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
Spring Boot application that has 4 main entities: Albums, Songs, Artists. There is a One-to-Many relation between the Albums and Artist and a Many-to-Many relation between the Albums and Songs. The user can add, delete, update and search objects regarding these entities.
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

<h3>Features</h3>
- PatchMapping in all the API controllers to change the name of the objects
- PostMapping in all the API controllers to add a new object
- validation framework to implement basic checks on the input
- ModelMapper
- endpoints are called from JavaScript
- .http file
<p>

</p>

- users can log in or out of their account
- the user knows they're logged by seeing their username in the top right corner of any page
- the website has a custom login page
- passwords are hashed in the database (BCrypt)
<p>

</p>

- project has 2 roles: ROLE_USER and ROLE_ADMIN
- if the user is not logged in (url: http://localhost:8080/musicLibrary or http://localhost:8080) they can only see the landing page 
- if the user is logged in as a regular user (ROLE_USER)
  - they can see the landing page
  - they can see all the already added Albums, Artists and Songs
  - they can search for songs
  - they can see the individual page of the Artist, Album or Song
- if the user is logged in as an admin (ROLE_ADMIN)
  - they can see the landing page
  - they can see the already added Albums, Artists, Songs
  - they can add new Albums, Artists, Songs
  - they can delete Albums, Artists, Songs
  - they can update the name of the Albums, Artists, Songs
- the user is associated with all the entities
<p>

</p>

- 2 different spring profiles
  - one works using .sql to implement the data (**used profile**)
  - the other one works with a seeder to implement the album info
- [x] included test specific setups (_@BeforeAll_) in the _Seeder_ class that works with the AlbumControllerTest to check if allAlbums actually shows all the albums implemented 
- [x] controller test has a "_@AutoConfigureMockMvc(addFilters = false)_" that bypassed the security temporarily
<p>

</p>

- _AlbumControllerTest_ has 2 methods that 
  - **deletingAnAlbumStopShouldReturn404ForNonExistingAlbums()** 
    - checks that it's not possible to delete an album that does not already exist based on the ID value
  - **allAlbumsShouldShowAllAlbums()**
    - checks that all 10 albums are shown on the _/albums_ page
- _ArtistControllerTest_ checks if the url _/api/artists_ returns a JSON file as a response 
- _ArtistRepositoryTest_ has 2 methods that
  - **artistNameIsUnique()**
    - checks if an Artist object is unique
  - **artistGenderIsMandatory()**
    - check that gender has to be specified when creating a new Artist
- _AlbumServiceTest_ checks that you cannot change the name of an album that does not exist based on the ID
- _ArtistServiceTest_ has
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
<h3>Testing</h3> 

- tests cover the MVC, API, repository and service parts of the project
- _ArtistsControllerTest_  
  - **searchArtistsShouldSearchCaseInsensitive()**
    - checks if searching an artist is case-insensitive by including a section of an existing band name and the expected number of matching results expected
  - **deleteArtistShouldReturnNotFoundForNonExistingArtist**
    - checks if trying to delete a non-existing artist by an id that doesn't exist is returning the status "not found"
  - **deletingASongShouldReturn404ForNonExistingSong**
- _SongsControllerTest_  
    - checks if trying to delete a non-existing song by an id that doesn't exist is returning code 404
- _SongControllerTest_ 
  - has a @BeforeAll that seeds 3 new songs
  - **addSongShouldSucceedAsAdmin** checks if only admins can add a song by adding an admin's details and trying to create a new song
  - **addSongShouldFailForRegularUsers** checks that normal users can't add a song
-  _ArtistRepositoryTest_  
  - **artistNameIsUnique** created 2 new artists that have the same attributes and checks to see if the name is unique by throwing a DataIntegrityViolationException exception
  - **artistGenderIsMandatory** checks if it's possible to create a new artist and insert the gender as null. To check if gender is mandatory, the test throws a DataIntegrityViolationException exception
-  _SongRepositoryTest_  
   - has a @BeforeAll that creates a new song by adding its name, duration and genre using the repository and fetching its id
   - then in the actual test, there are 3 new Song instances that get the song previously created by getting the name; each time spelled differently, and then tries to see if they match the song from @BeforeAll
   - in the end, the song is deleted from the DB using the id
- _AlbumServiceTest_
  - check if a non-existent album can be modified by asserting it as false
- _ArtistServiceTest_
  - has a @BeforeAll that creates a user and a new artist
  - the test checks if the user can modify the name of a pre-existing artist
<p>

</p>

<h4>Docker and CSV</h4>

- commands to create a container for the main project's database are included in the README
- all tests run without installing PostgreSQL locally, manually creating a DB schema, or granting access to the "postgres" database
- all unused files and Programming 3 files are removed
- gitignore has been updated
- admin only page that lets the user upload artist entities using a csv file
- page is implemented using the ArtistController
- the user gets a response as soon as the file is uploaded
- Thread.milis is used in the repository to mimic long processing times
- a sample CSV file can be found in the resources static folder
