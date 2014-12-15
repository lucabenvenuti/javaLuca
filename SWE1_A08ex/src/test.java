
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DoublyLinkedPlaceList DoublyLinkedPlaceListTest =  new DoublyLinkedPlaceList();
		
		for (int i=0; i<20; i++){
			Place newPlace = new Place((int)(Math.random()*20));
			DoublyLinkedPlace newDoublyLinkedPlace = new DoublyLinkedPlace(newPlace, i);
			DoublyLinkedPlaceListTest.add(newDoublyLinkedPlace);
			}

	}

}
