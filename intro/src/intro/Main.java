package intro;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//TODO Test
		//camelCase 
		//FIXME
		
		double LastCurValue = 7.15;
		double CurrentCurValue = 7.95;
		int counter = 0;
		
		String subeButonu = "Test111";
		System.out.println(subeButonu);
		System.out.println(LastCurValue);
		
		System.out.println("---------------------------------");

		if (LastCurValue > CurrentCurValue ) {
			System.out.println("Kur d���m�");
		}else if (LastCurValue < CurrentCurValue ) {
			System.out.println("Kur art���");
		}else {
			System.out.println("Kur e�itli�i");
		}
		
		System.out.println("-----------------------------------");

		
		String[] Credits = {"H�zl� Kredi", "Konut Kredisi", "�if�i Kredisi"};
		
		for (String credit : Credits) {
			System.out.println(credit);

		}
		
		
	}

}
