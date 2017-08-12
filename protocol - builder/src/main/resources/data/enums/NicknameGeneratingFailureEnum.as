package data.enums
{
   [Trusted]
   public class NicknameGeneratingFailureEnum extends Object
   {
      
      public static const NICKNAME_GENERATOR_RETRY_TOO_SHORT:uint = 1;
      
      public static const NICKNAME_GENERATOR_UNAVAILABLE:uint = 2;
       
      public function NicknameGeneratingFailureEnum()
      {
         super();
      }
   }
}