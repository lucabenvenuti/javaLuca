
interface Movie {
	String getName();
	void setName(String name);
	int length(); // or: int getLength(); //movie screening time in minutes
	int priceSurcharge();
	String getQualifier();
	void setScreens(Screen[] screens);
	Screen[] getScreens();
//<<<<<<< HEAD
	//String getScreeningTime();
//=======
//	String[] getScreeningTime();
//>>>>>>> branch 'master' of https://github.com/lucabenvenuti/javaLuca.git
}
