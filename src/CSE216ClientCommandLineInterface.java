public class CSE216ClientCommandLineInterface {
   
   private final RunTimeVars rtv = 
                           RunTimeVars.Instance();
   private final ConfigFile cf   =  
                            ConfigFile.Instance(); 
   private final String hostname = 
                               cf.getMyHostName();
   private final int portnumber  = 
                              rtv.getServerPort();
   


   private final String prompt;
   
   private final Scanner    sc;
   
   private int             sel;
   
   public CSE216ClientCommandLineInterface
              (final String hname, final String m) 
   {

      prompt = "Host: " + hostname
              +        "     Node ID: " + m + "\n"
              + "1) Add Grade\n"
              + "2)  Change Grade \n"
              + "3)  Calculate Average Student Grade\n"  
              + "4) Calcuate Gradebook Class Average\n"; 
      
      
      sc = new Scanner(System.in);
     
   }
      
     
   
   //
   // This function prompts
   // the user to enter a string
   // to be encrypted and sent to
   // the server.  If "quit" is
   // entered System.exit(0) is
   // called to terminate the
   // program.
   //
   public CState getUserSelection() 
   {
      CState cs =  new CState();
      cs.mid    = MessageID.MSG;
      String enteredString = "abcdefg";
      
      System.out.print(prompt);
       try {
             sel = sc.nextInt();
       }
      catch(Exception e){
                  System.exit(0);
      }

         
         if(sel > 4 || sel < 0)
      {
         do{
         System.out.println("Invalid input, Please choose from one of the menu items.");  
          System.out.print(prompt);
         }
         while(sel > 4 || sel < 0 ); 
      }
         
       if(sel == 1){ 
          cs.setV(1);
       }
       if(sel == 2){
          cs.setV(2); 
       }
       if(sel == 3){ 
          cs.setV(3); 
       } 
       
       System.out.println("Enter the students name.");
       
       if(sel == 4){ 
          cs.setV(4); 
       }
       
      // Get the string from the user //
      enteredString = sc.nextLine();
      
      // If the string is "quit"
      if ("quit".equals(enteredString))
         System.exit(0);

      cs.setMessage(enteredString);
      return cs;
      
   }
   
}
