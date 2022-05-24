CREATE TABLE Country(
	CountryID SERIAL,
	CountryName text,
	CreationDate date,
	LastUpdate timestamp,
	PRIMARY KEY (CountryID)
);

CREATE TABLE Categories(
	CategoryID SERIAL,
	Category text,
	CreationDate date,
	LastUpdate timestamp,
	PRIMARY KEY (CategoryID)
);

CREATE TABLE Users(
	UserID SERIAL,
	UserName text,
	Surname text,
	FK_Country int,
	PhoneNumber text,
	Email text,
	Birthday date,
	Followers int,
	"Following" int,
	CreationDate date,
	LastUpdate timestamp,
	PRIMARY KEY (UserID),
	FOREIGN KEY (FK_Country) REFERENCES Country (CountryID)
);

CREATE TABLE Shorts(
	Url text,
	FK_Category int,
	Description text,
	FK_User int,
	CreationDate date,
	LastUpdate timestamp,
	PRIMARY KEY (Url),
	FOREIGN KEY (FK_Category) REFERENCES Categories (CategoryID),
	FOREIGN KEY (FK_User) REFERENCES Users (UserID)
);

CREATE TABLE UserWatchesVideo(
	FK_User int,
	FK_Video text,
	FOREIGN KEY (FK_User) REFERENCES Users (UserID),
	FOREIGN KEY (FK_Video) REFERENCES Shorts (Url)
);