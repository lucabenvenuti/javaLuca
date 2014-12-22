
interface Movie {
	String getName();
	int length(); // or: int getLength(); //movie screening time in minutes
	int priceSurcharge();
	String getQualifier();
	void setScreens(Screen[] screens);
	Screen[] getScreens();
}
