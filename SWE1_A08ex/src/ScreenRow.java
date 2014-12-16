
public class ScreenRow {
	private Category category;

	private DoublyLinkedPlaceList doublyLinkedPlaceList; //must be initialized
	
	
	public DoublyLinkedPlaceList getDoublyLinkedPlaceList() {
		return doublyLinkedPlaceList;
	}

	public ScreenRow(Category category, String rowLayout) { //(){//
		this.setCategory(category);
		doublyLinkedPlaceList  =  new DoublyLinkedPlaceList();
		for (int i=0; i<rowLayout.length(); i++){
			//rowLayout.charAt(i);
			Place newPlace = new Place(rowLayout.charAt(i));
			//System.out.println(rowLayout.charAt(i));
			DoublyLinkedPlace newDoublyLinkedPlace = new DoublyLinkedPlace(newPlace, i);
			doublyLinkedPlaceList.add(newDoublyLinkedPlace);
			
			
		//	System.out.println("trota");
		//	newDoublyLinkedPlace = null;
		//	System.out.println(doublyLinkedPlaceList.getSize());
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
		//doublyLinkedPlaceList.getHead().getPlace().getAvailability();
	//	System.out.println(doublyLinkedPlaceList.getHead());
	//	System.out.println(doublyLinkedPlaceList.getHead().getNext());//.getPlace().getAvailability());
	//	System.out.println("trota6");
		for ( DoublyLinkedPlace linkedPlace=doublyLinkedPlaceList.getHead(); linkedPlace !=
				null && linkedPlace.hasNext() && linkedPlace.getPosition()< position; linkedPlace=linkedPlace.getNext()){
				//DO SOMETHING
				//linkedPlace = i
		//	System.out.println("trota5");
			//System.out.println(linkedPlace.getPosition());
			if (linkedPlace.getPosition()==position-1){
				if(linkedPlace.getPlace().getAvailability()==Place.EMPTY_SEAT){
					return true;
				}
			System.out.println(linkedPlace.getPlace().getAvailability());}
			
				}

		
		return false; //layout[position] == EMPTY_SEAT;
	}
	
	
}