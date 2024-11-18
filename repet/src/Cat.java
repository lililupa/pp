public class  Cat extends Animal implements Voice{
   private String name;

   @Override
   public String say() {
      return "мяу";
   }
}
