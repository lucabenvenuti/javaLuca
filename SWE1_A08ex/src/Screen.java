public class Screen {
	
	public SinglyLinkedLinearListSeatRows singlyLinkedLinearListSeatRows;
	
	public Screen(ScreenRow one, ScreenRow two, ScreenRow three) {
	/*	rows=new ScreenRow[3];
		rows[0]=one;
		rows[1]=two;
		rows[2]=three;*/
		singlyLinkedLinearListSeatRows = new SinglyLinkedLinearListSeatRows();
		//ScreenRow screenRow = new ScreenRow(new Category('A'), "#X##X##########X");
	//	for (int i=0; i<3; i++){
	//		DoublyLinkedPlaceList newDoublyLinkedPlaceList = new DoublyLinkedPlaceList();
			singlyLinkedLinearListSeatRows.add(one.getDoublyLinkedPlaceList());
			singlyLinkedLinearListSeatRows.getTail().setScreenRow(one);
			singlyLinkedLinearListSeatRows.add(two.getDoublyLinkedPlaceList());
			singlyLinkedLinearListSeatRows.getTail().setScreenRow(two);
			singlyLinkedLinearListSeatRows.add(three.getDoublyLinkedPlaceList());
			singlyLinkedLinearListSeatRows.getTail().setScreenRow(three);
			
		//}
	}

	public Screen(ScreenRow one, ScreenRow two, ScreenRow three, ScreenRow four) {
		this(one, two, three);
				singlyLinkedLinearListSeatRows.add(four.getDoublyLinkedPlaceList());
				singlyLinkedLinearListSeatRows.getTail().setScreenRow(four);
		}
	
	public Screen(ScreenRow one, ScreenRow two, ScreenRow three, ScreenRow four, ScreenRow five) {
		this(one, two, three, four);
		singlyLinkedLinearListSeatRows.add(five.getDoublyLinkedPlaceList());
		singlyLinkedLinearListSeatRows.getTail().setScreenRow(five);
		}
	
	
	public boolean book(int row, int position, int seats){
		for ( DoublyLinkedPlaceList linkedPlaceList = singlyLinkedLinearListSeatRows.getHead(); 
				linkedPlaceList != null && linkedPlaceList.getRow()<=(row); 
				linkedPlaceList = linkedPlaceList.getNext()){
	//		System.out.println(linkedPlaceList.getRow());
			if (linkedPlaceList.getRow()==row){//-1){
				return linkedPlaceList.getScreenRow().book(position, seats);
				
			}
			
		}
		return false;
	}

/*	public boolean book(int row, int position, int seats, int trotaculo) {
		//return rows[row-1].book(position-1,seats);
	//	System.out.println(row+10);
	//	System.out.println(singlyLinkedLinearListSeatRows.getHead().getRow());
	//	int i =10;
		for ( DoublyLinkedPlaceList linkedPlaceList = singlyLinkedLinearListSeatRows.getHead(); 
				linkedPlaceList != null && linkedPlaceList.getRow()<=(row); 
				linkedPlaceList = linkedPlaceList.getNext()){
		//	System.out.println(linkedPlaceList.getRow());
		//	System.out.println("trota6");
		//	System.out.println(i);
			//i = i+1;
			
			if (linkedPlaceList.getRow()==row-1){
			//	System.out.println("trota5");
				//if (linkedPlaceList..getPosition()==position-1){}
				for ( DoublyLinkedPlace linkedPlace=linkedPlaceList.getHead(); linkedPlace !=
						null && linkedPlace.hasNext() && linkedPlace.getPosition()< position; 
						linkedPlace=linkedPlace.getNext()){
						//DO SOMETHING
						//linkedPlace = i
					
					//System.out.println(linkedPlace.getPosition());
					if (linkedPlace.getPosition()==position-1){
						if(linkedPlace.getPlace().getAvailability()==Place.EMPTY_SEAT){
							return true;
						//	System.out.println("trota5");
						}
				//	System.out.println(linkedPlace.getPlace().getAvailability());
					}
					
						}	
			}
		}
		
		return false;
		
	}*/
	
//	SinglyLinkedLinearListSeatRows newSinglyLinkedLinearListSeatRows = new SinglyLinkedLinearListSeatRows();
//	singlyLinkedLinearListSeatRows.add(doublyLinkedPlaceList);
	
	
}
