
public class BigFews {
   private String name;
   private int numbers;
   private boolean statement = true;
   int something[] = {1,2,3,4,5,6};
   
   public BigFews() {
	   System.out.println("Empty Constructor");
   }
   
   public BigFews(String name, int numbers, boolean statement) {
	   this.name = name;
	   this.numbers = numbers;
	   this.statement = statement;
   }
   
   public void setName(String name) {
	   this.name = name;
   }
   
   public String getName() {
	   return name;
   }
   
   public void setNumbers(int numbers) {
	   this.numbers = numbers;
   }
   
   public int getNumbers() {
	   return numbers;
   }
   public void setStatement(boolean statement) {
	   this.statement = statement;
   }
   public boolean getStatement( ) {
	   return statement;
   }
}
