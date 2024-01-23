insert into users(username, email, password, userrole)
values ('Alexia', 'alexia@gmail.com', '$2a$12$A65S9H78c6nq426YLInSCOvPeB5ecdQzUJS.X06ys81DHzjalBlhi', 0);
--user: Alexia, password: alexia

insert into users(username, email, password, userrole)
values ('Albert', 'albert@gmail.com', '$2a$12$k./WrHVF0/3VroRUxjWQN.9FL957S0C/vHesH0i5gsaIlQHSY99om', 0);
--user: Albert, password: albert

insert into users(username, email, password, userrole)
values ('Josh', 'josh96@yahoo.com', '$2a$12$UO3szsxoXl4u2D./j0nrz.QH02qyDCInb8H3ySVKVm85aMLMNLZc2', 1);
--user: Josh, password: josh

insert into users(username, email, password, userrole)
values ('Jenny', 'jennifer@gmail.com', '$2a$12$NvATq5StVU6gWmEtbNCbbemHDf6fuqyy0SIeD4kRITIhjJQuaGLIG', 1);
--user: Jenny, password: jenny

insert into artist(name, gender, debutyear)
values ('The Strokes', 'male group', 1998);

insert into artist(name, gender, debutyear)
values ('TV Girl', 'mixed group', 2010);

insert into artist(name, gender, debutyear)
values ('Radiohead', 'male group', 1985);

insert into artist(name, gender, debutyear)
values ('Brockhampton', 'male group', 2010);

insert into artist(name, gender, debutyear)
values ('Regina Spektor', 'female artist', 1997);

insert into artist(name, gender, debutyear)
values ('Elliott Smith', 'male artist', 1994);

insert into album(title, amountofsongs, releasedate, artistid)
values ('The New Abnormal', 10, '2020-04-10', 1);

insert into album(title, amountofsongs, releasedate, artistid)
values ('Is This It', 11, '2001-07-30', 1);

insert into album(title, amountofsongs, releasedate, artistid)
values ('French Exit', 12, '2014-06-05', 2);

insert into album(title, amountofsongs, releasedate, artistid)
values ('The Bends', 12, '1995-03-13', 3);

insert into album(title, amountofsongs, releasedate, artistid)
values ('OK Computer', 13, '1997-05-28', 3);

insert into album(title, amountofsongs, releasedate, artistid)
values ('In Rainbows', 14, '2007-12-28', 3);

insert into album(title, amountofsongs, releasedate, artistid)
values ('SATURATION', 17, '2017-06-09', 4);

insert into album(title, amountofsongs, releasedate, artistid)
values ('Soviet Kitsch', 11, '2004-09-17', 5);

insert into album(title, amountofsongs, releasedate, artistid)
values ('What We Saw from the Cheap Seats', 11, '2012-05-25', 5);

insert into album(title, amountofsongs, releasedate, artistid)
values ('Either/Or', 12, '1997-02-25', 6);

insert into song(songname, duration, genre)
values ('The Adults Are Talking', 5.07, 'alternative');

insert into song(songname, duration, genre)
values ('Selfless', 3.41, 'alternative');

insert into song(songname, duration, genre)
values ('Brooklyn Bridge To Chorus', 3.55, 'alternative');

insert into song(songname, duration, genre)
values ('Bad Decisions', 4.53, 'alternative');

insert into song(songname, duration, genre)
values ('Eternal Summer', 6.14, 'alternative');

insert into song(songname, duration, genre)
values ('At The Door', 5.10, 'alternative');

insert into song(songname, duration, genre)
values ('Why Are Sundays So Depressing', 4.35, 'alternative');

insert into song(songname, duration, genre)
values ('Not The Same Anymore', 5.37, 'alternative');

insert into song(songname, duration, genre)
values ('Ode To The Mets', 5.51, 'alternative');

insert into song(songname, duration, genre)
values ('Is this it', 2.31, 'rock');

insert into song(songname, duration, genre)
values ('The Modern Age', 3.28, 'rock');

insert into song(songname, duration, genre)
values ('Alone, Together', 3.08, 'rock');

insert into song(songname, duration, genre)
values ('Soma', 2.33, 'rock');

insert into song(songname, duration, genre)
values ('Hard To Explain', 3.44, 'rock');

insert into song(songname, duration, genre)
values ('Barely Legal', 3.54, 'rock');

insert into song(songname, duration, genre)
values ('Last Nite', 3.13, 'rock');

insert into song(songname, duration, genre)
values ('Someday', 3.03, 'rock');

insert into song(songname, duration, genre)
values ('Trying Your Luck', 3.22, 'rock');

insert into song(songname, duration, genre)
values ('New York City Cops', 3.30, 'rock');

insert into song(songname, duration, genre)
values ('Take It Or Leave It', 3.15, 'rock');

insert into song(songname, duration, genre)
values ('Pantyhose', 2.55, 'pop');

insert into song(songname, duration, genre)
values ('Louise', 3.13, 'pop');

insert into song(songname, duration, genre)
values ('Lovers Rock', 3.33, 'pop');

insert into song(songname, duration, genre)
values ('Anjela', 3.43, 'pop');

insert into song(songname, duration, genre)
values ('Talk To Strangers', 2.57, 'pop');

insert into song(songname, duration, genre)
values ('Daughter of a Cop', 2.33, 'pop');

insert into song(songname, duration, genre)
values ('Hate Yourself', 3.33, 'pop');

insert into song(songname, duration, genre)
values ('Her and Her Friend', 3.28, 'pop');

insert into song(songname, duration, genre)
values ('The Blonde', 3.47, 'pop');

insert into song(songname, duration, genre)
values ('Come When You Call', 3.38, 'pop');

insert into song(songname, duration, genre)
values ('The Gateway', 3.43, 'pop');

insert into song(songname, duration, genre)
values ('Birds Dont Sing', 3.28, 'pop');

insert into song(songname, duration, genre)
values ('Planet Telex', 4.18, 'rock');

insert into song(songname, duration, genre)
values ('My Iron Lung', 4.36, 'rock');

insert into song(songname, duration, genre)
values ('The Bends', 4.05, 'rock');

insert into song(songname, duration, genre)
values ('Bullet Proof...I Wish I Was', 3.28, 'rock');

insert into song(songname, duration, genre)
values ('Street Spirit (Fade Out)', 4.13, 'rock');

insert into song(songname, duration, genre)
values ('(Nice Dream)', 3.53, 'rock');

insert into song(songname, duration, genre)
values ('Just', 3.54, 'rock');

insert into song(songname, duration, genre)
values ('Black Star', 4.06, 'rock');

insert into song(songname, duration, genre)
values ('Fake Plastic Trees', 4.50, 'rock');

insert into song(songname, duration, genre)
values ('Sulk', 3.42, 'rock');

insert into song(songname, duration, genre)
values ('High and Dry', 4.17, 'rock');

insert into song(songname, duration, genre)
values ('Bones', 3.08, 'rock');

insert into song(songname, duration, genre)
values ('Airbag', 4.47, 'rock');

insert into song(songname, duration, genre)
values ('Karma Police', 4.24, 'rock');

insert into song(songname, duration, genre)
values ('Subterranean Homesick Alien', 4.27, 'rock');

insert into song(songname, duration, genre)
values ('Lucky', 4.18, 'rock');

insert into song(songname, duration, genre)
values ('Exit Music (For A Film)', 4.27, 'rock');

insert into song(songname, duration, genre)
values ('Electioneering', 3.50, 'rock');

insert into song(songname, duration, genre)
values ('Just', 3.54, 'rock');

insert into song(songname, duration, genre)
values ('The Tourist', 5.26, 'rock');

insert into song(songname, duration, genre)
values ('Paranoid Android', 6.27, 'rock');

insert into song(songname, duration, genre)
values ('Fitter Happier', 1.57, 'rock');

insert into song(songname, duration, genre)
values ('Climbing Up the Walls', 4.45, 'rock');

insert into song(songname, duration, genre)
values ('Let Down', 4.59, 'rock');

insert into song(songname, duration, genre)
values ('No Surprises', 3.48, 'rock');

insert into song(songname, duration, genre)
values ('15 Step', 3.56, 'alternative');

insert into song(songname, duration, genre)
values ('Reckoner', 4.49, 'alternative');

insert into song(songname, duration, genre)
values ('Bodysnatchers', 4.01, 'alternative');

insert into song(songname, duration, genre)
values ('Nude', 4.15, 'alternative');

insert into song(songname, duration, genre)
values ('Weird Fishes/Arpeggi', 5.18, 'alternative');

insert into song(songname, duration, genre)
values ('Faust Arp', 2.09, 'alternative');

insert into song(songname, duration, genre)
values ('House Of Cards', 5.27, 'alternative');

insert into song(songname, duration, genre)
values ('All I Need', 3.48, 'alternative');

insert into song(songname, duration, genre)
values ('Videotape', 4.39, 'alternative');

insert into song(songname, duration, genre)
values ('Jigsaw Falling Into Place', 4.08, 'alternative');

insert into song(songname, duration, genre)
values ('EAT', 4.31, 'rap');

insert into song(songname, duration, genre)
values ('FACE', 4.18, 'rap');

insert into song(songname, duration, genre)
values ('BOYS', 4.37, 'rap');

insert into song(songname, duration, genre)
values ('STAR', 2.40, 'rap');

insert into song(songname, duration, genre)
values ('2PAC', 1.02, 'rap');

insert into song(songname, duration, genre)
values ('SWIM', 3.33, 'rap');

insert into song(songname, duration, genre)
values ('BUMP', 2.37, 'rap');

insert into song(songname, duration, genre)
values ('SKIT 3', 0.38, 'rap');

insert into song(songname, duration, genre)
values ('MILK', 4.54, 'rap');

insert into song(songname, duration, genre)
values ('WASTE', 2.34, 'rap');

insert into song(songname, duration, genre)
values ('CASH', 3.14, 'rap');

insert into song(songname, duration, genre)
values ('BANK', 3.15, 'rap');

insert into song(songname, duration, genre)
values ('TRIP', 0.38, 'rap');

insert into song(songname, duration, genre)
values ('SKIT 2', 0.15, 'rap');

insert into song(songname, duration, genre)
values ('FAKE', 4.35, 'rap');

insert into song(songname, duration, genre)
values ('GOLD', 4.25, 'rap');

insert into song(songname, duration, genre)
values ('SKIT 1', 0.19, 'rap');

insert into song(songname, duration, genre)
values ('Ode to Divorce', 3.42, 'pop');

insert into song(songname, duration, genre)
values ('Poor Little Rick Boy', 2.27, 'pop');

insert into song(songname, duration, genre)
values ('Carbon Monoxide', 4.59, 'pop');

insert into song(songname, duration, genre)
values ('The Flowers', 3.54, 'pop');

insert into song(songname, duration, genre)
values ('Us', 4.51, 'pop');

insert into song(songname, duration, genre)
values ('Sailor Song', 3.15, 'pop');

insert into song(songname, duration, genre)
values ('Whisper', 0.44, 'pop');

insert into song(songname, duration, genre)
values ('Your Honour', 2.09, 'pop');

insert into song(songname, duration, genre)
values ('Ghost of Corporate Future', 3.21, 'pop');

insert into song(songname, duration, genre)
values ('Chemo Limo', 6.04, 'pop');

insert into song(songname, duration, genre)
values ('Somedays', 3.21, 'pop');

insert into song(songname, duration, genre)
values ('Small Town Moon', 2.58, 'pop');

insert into song(songname, duration, genre)
values ('Oh Marcello', 2.36, 'pop');

insert into song(songname, duration, genre)
values ('Don"t Leave Me (Ne me quitte pas)', 3.36, 'pop');

insert into song(songname, duration, genre)
values ('Firewood', 4.51, 'pop');

insert into song(songname, duration, genre)
values ('Patron Saint', 3.38, 'pop');

insert into song(songname, duration, genre)
values ('How', 4.44, 'pop');

insert into song(songname, duration, genre)
values ('All the Rowboats', 3.33, 'pop');

insert into song(songname, duration, genre)
values ('Ballad of a Politician', 2.12, 'pop');

insert into song(songname, duration, genre)
values ('Open', 4.27, 'pop');

insert into song(songname, duration, genre)
values ('The Party', 2.25, 'pop');

insert into song(songname, duration, genre)
values ('Jessica', 1.44, 'pop');

insert into song(songname, duration, genre)
values ('Speed Trials', 3.02, 'alternative');

insert into song(songname, duration, genre)
values ('Alameda', 3.42, 'alternative');

insert into song(songname, duration, genre)
values ('Ballad Of Big Nothing', 2.48, 'alternative');

insert into song(songname, duration, genre)
values ('Between The Bars', 2.21, 'alternative');

insert into song(songname, duration, genre)
values ('Pictures Of Me', 3.46, 'alternative');

insert into song(songname, duration, genre)
values ('No Name No.5', 3.42, 'alternative');

insert into song(songname, duration, genre)
values ('Rose Parade', 3.28, 'alternative');

insert into song(songname, duration, genre)
values ('Punch And Judy', 2.25, 'alternative');

insert into song(songname, duration, genre)
values ('Angeles', 2.56, 'alternative');

insert into song(songname, duration, genre)
values ('Cupid"s Trick', 3.04, 'alternative');

insert into song(songname, duration, genre)
values ('2:45 AM', 3.18, 'alternative');

insert into song(songname, duration, genre)
values ('Say Yes', 2.19, 'alternative');
