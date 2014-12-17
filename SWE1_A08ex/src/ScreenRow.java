
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
			if (linkedPlace.getPosition()==position-1){
				if(linkedPlace.getPlace().getAvailability()==Place.EMPTY_SEAT){
					return true;
				}
			}
			
				}
		return false; 
	}
	
	public boolean isEmptySeat(DoublyLinkedPlace linkedPlace) {
		System.out.println("trota3");

		return linkedPlace.getPlace().getAvailability()==Place.EMPTY_SEAT;
	}
	
	private void bookSeat(DoublyLinkedPlace linkedPlace) {
		linkedPlace.getPlace().setAvailability(Place.TAKEN_SEAT);
		}
	
	public boolean book(int position, int seats) {
		int i =0;
		/*System.out.println("trota1");
		System.out.println(doublyLinkedPlaceList.getSize());
		System.out.println(position);
		System.out.println("trota2");*/
		if(position+seats-1>doublyLinkedPlaceList.getSize()){
			//System.out.println("trota2");
			return false;
			}
	//	System.out.println(doublyLinkedPlaceList.getSize());
		if (position> (int)(Math.round(doublyLinkedPlaceList.getSize())/2) ){
			i = seats;
		//	System.out.println("trota3");
			for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getTail();linkedPlace !=
					null && linkedPlace.getPosition()>position-1; //&& linkedPlace.hasPrev() 
					linkedPlace=linkedPlace.getPrev()){
				
				if (linkedPlace.getPosition()==position+i-1){
					if(!isEmptySeat(linkedPlace)){
					//	System.out.println("trota3");
						return false;
					}else{	//System.out.println("trota6");
						i--;	}
				}else{return false;}
					}
			i = seats;
			for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getTail();linkedPlace !=
					null && linkedPlace.getPosition()>position-1; //&& linkedPlace.hasPrev() 
					linkedPlace=linkedPlace.getPrev()){
				if (linkedPlace.getPosition()==position+i-1){
					bookSeat(linkedPlace);i--;
					rowLayout.replace(linkedPlace.getPosition(), linkedPlace.getPosition()+1, 
							String.valueOf(linkedPlace.getPlace().getAvailability()));
				}
				}
			
		}
		else{
		
		for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getHead(); linkedPlace !=
				null && linkedPlace.getPosition()< position-1+seats; //&& linkedPlace.hasNext() 
				linkedPlace=linkedPlace.getNext()){
		//	System.out.println("trota3");
		//	System.out.println(linkedPlace.getPosition());
			if (linkedPlace.getPosition()==position+i-1){
				if(!isEmptySeat(linkedPlace)){
				//	System.out.println(!isEmptySeat(linkedPlace));
					
					return false;
				}else{	i++;	}
			}
		//	else{System.out.println("trota4");
		//		return false;}
				}
		i=0;
		for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getHead(); linkedPlace !=
				null && linkedPlace.getPosition()< position-1+seats; //&& linkedPlace.hasNext() 
				linkedPlace=linkedPlace.getNext()){
			if (linkedPlace.getPosition()==position+i-1){
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