
public class ScreenRow {
	private Category category;
	public StringBuffer rowLayout;

	private DoublyLinkedPlaceList doublyLinkedPlaceList; //must be initialized
	
	
	public DoublyLinkedPlaceList getDoublyLinkedPlaceList() {
		return doublyLinkedPlaceList;
	}

	public ScreenRow(Category category, String rowLayout, int rowNumber) { //(){//
		this.setCategory(category);
		this.setRowLayout(new StringBuffer(rowLayout));
		doublyLinkedPlaceList  =  new DoublyLinkedPlaceList(rowNumber);
		for (int i=0; i<rowLayout.length(); i++){
			Place newPlace = new Place(rowLayout.charAt(i));
			DoublyLinkedPlace newDoublyLinkedPlace = new DoublyLinkedPlace(newPlace, i);
			doublyLinkedPlaceList.add(newDoublyLinkedPlace);
			}
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int calcPrice(int seats) {
		return category.getPrice() * seats;
	}
	
	public boolean isEmptySeat(int position) {

		for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getHead(); linkedPlace !=
				null && linkedPlace.hasNext() && linkedPlace.getPosition()< position; 
				linkedPlace=linkedPlace.getNext()){
			if (linkedPlace.getPosition()==position){
				if(linkedPlace.getPlace().getAvailability()==Place.EMPTY_SEAT){
					return true;
				}
			}
			
				}
		return false; 
	}
	
	public boolean isEmptySeat(DoublyLinkedPlace linkedPlace) {
		return linkedPlace.getPlace().getAvailability()==Place.EMPTY_SEAT;
	}
	
	private void bookSeat(DoublyLinkedPlace linkedPlace) {
		linkedPlace.getPlace().setAvailability(Place.TAKEN_SEAT);
		}
	
	public boolean book(int position, int seats) {
		int i =0;
		if(position+seats>doublyLinkedPlaceList.getSize()){
			System.out.println("ERROR1");
			return false;
			}
		//DoublyLinkedPlace linkedPlace = doublyLinkedPlaceList.getTail();
		if (position> (int)(Math.round(doublyLinkedPlaceList.getSize())/2) ){
			DoublyLinkedPlace linkedPlaceEnd =doublyLinkedPlaceList.getTail();
			i = seats;
			position--;
			for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getTail();linkedPlace !=
					null&& linkedPlace.hasPrev()  && linkedPlace.getPosition()>position; //
					linkedPlace=linkedPlace.getPrev()){
				if (linkedPlace.getPosition()==position+seats){linkedPlaceEnd =linkedPlace;} 
				if (linkedPlace.getPosition()==position+i){
					if(!isEmptySeat(linkedPlace)){
						System.out.println("ERROR2");
						return false;
					}else{
						i--;	}
				}//else{return false;}
					}
			i = seats;
			for ( DoublyLinkedPlace linkedPlace=linkedPlaceEnd
					//doublyLinkedPlaceList.getTail()
					;linkedPlace !=
					null && linkedPlace.hasPrev() && linkedPlace.getPosition()>position; //
					linkedPlace=linkedPlace.getPrev()){
				if (linkedPlace.getPosition()==position+i){
					bookSeat(linkedPlace);i--;
					rowLayout.replace(linkedPlace.getPosition(), linkedPlace.getPosition()+1, 
							String.valueOf(linkedPlace.getPlace().getAvailability()));
				}
				}
			
		}
		else{DoublyLinkedPlace linkedPlaceStart=doublyLinkedPlaceList.getHead();
		
		for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getHead(); linkedPlace !=
				null && linkedPlace.hasNext()  && linkedPlace.getPosition()< position+seats; //
				linkedPlace=linkedPlace.getNext()){
			if (linkedPlace.getPosition()==position){linkedPlaceStart =linkedPlace;} 
			if (linkedPlace.getPosition()==position+i){
				if(!isEmptySeat(linkedPlace)){
					return false;
				}else{	i++;	}
			}
				}
		i=0;
		for ( DoublyLinkedPlace linkedPlace=linkedPlaceStart
				//doublyLinkedPlaceList.getHead()
				; linkedPlace !=
				null && linkedPlace.hasNext() && linkedPlace.getPosition()< position+seats; //
				linkedPlace=linkedPlace.getNext()){
			if (linkedPlace.getPosition()==position+i){
				bookSeat(linkedPlace);i++;
				rowLayout.replace(linkedPlace.getPosition(), linkedPlace.getPosition()+1, 
						String.valueOf(linkedPlace.getPlace().getAvailability()));
				}
			}
		}
		return true;
	}

	public StringBuffer getRowLayout() {
		return rowLayout;
	}

	public void setRowLayout(StringBuffer rowLayout) {
		this.rowLayout = rowLayout;
	}
	
}