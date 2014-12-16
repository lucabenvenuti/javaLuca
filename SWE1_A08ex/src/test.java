
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	//	DoublyLinkedPlaceList DoublyLinkedPlaceListTest =  new DoublyLinkedPlaceList();
		ScreenRow screenRow1 = new ScreenRow(new Category(8, 'A'), "#X##X##########", 1);
		ScreenRow screenRow2 = new ScreenRow(new Category(10, 'B'), "###X###########", 2);
		ScreenRow screenRow3 = new ScreenRow(new Category(11, 'C'), "##X####", 3);
	//	System.out.println(screenRow1.isEmptySeat(5));
	//	System.out.println(screenRow1.book(7,3));
		
		Screen screen = new Screen(screenRow1, screenRow2, screenRow3);
		//singlyLinkedLinearListSeatRows.getTail().setScreenRow(three);
		//book(int row, int position, int seats) 
		System.out.println(screen.book(3,1,3));
		System.out.println(screen.singlyLinkedLinearListSeatRows.getHead().getNext().getNext().getScreenRow().getRowLayout());
		
	//	System.out.println(screenRow.getDoublyLinkedPlaceList().getSize()); //print();
	/*	for (int i=0; i<20; i++){
			Place newPlace = new Place((int)(Math.random()*20));
			DoublyLinkedPlace newDoublyLinkedPlace = new DoublyLinkedPlace(newPlace, i);
			DoublyLinkedPlaceListTest.add(newDoublyLinkedPlace);
			}*/

	}

}
