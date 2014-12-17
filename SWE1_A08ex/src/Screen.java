public class Screen {
	public final static int MAXROWS = 5;
	public SinglyLinkedLinearListSeatRows singlyLinkedLinearListSeatRows;
	
	public Screen(ScreenRow one, ScreenRow two, ScreenRow three) {
		singlyLinkedLinearListSeatRows = new SinglyLinkedLinearListSeatRows();
			singlyLinkedLinearListSeatRows.add(one.getDoublyLinkedPlaceList());
			singlyLinkedLinearListSeatRows.getTail().setScreenRow(one);
			singlyLinkedLinearListSeatRows.add(two.getDoublyLinkedPlaceList());
			singlyLinkedLinearListSeatRows.getTail().setScreenRow(two);
			singlyLinkedLinearListSeatRows.add(three.getDoublyLinkedPlaceList());
			singlyLinkedLinearListSeatRows.getTail().setScreenRow(three);
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
			if (linkedPlaceList.getRow()==row){//-1){
				return linkedPlaceList.getScreenRow().book(position-1, seats);
			}
		}
		return false;
	}
}
