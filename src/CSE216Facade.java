import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 * Title: P2P Project</p>
 *
 * <p>
 * Description: This class handles 
 * processing of the message
 * sent to the CSE216 Subsystem.
 * </p>
 *
 * <p>
 * Copyright: none</p>
 *
 * <p>
 * Company: Lehigh University</p>
 *
 * @author Bill Phillips
 *
 */
public class CSE216Facade extends 
                              ProcessingFacadeBase 
{

   private final ServerTransactionLogger stl;
   
   private CSE216Crypto crypto;

   CSE216Facade() 
   {
      //
      // Instantiate the client in the
      // constructor.
      //
      stl = ServerTransactionLogger.Instance();

      //
      // Only one thread needed for the client.
      //
      ExecutorService CandS
              = Executors.newFixedThreadPool(1);

      //
      // Create the client.
      //
      CSE216Client pcm = new CSE216Client               
               (ConfigFile.Instance().getACSIP());
      
      crypto = new CSE216Crypto();
      
      //
      // Execute the client as a separate thread.
      //
      CandS.execute(pcm);
   }

   @Override
   synchronized public void processMsg(Object o) 
   {
      try 
      {
         stl.writeToLogger
                    ("Server received a message");
      } catch (Exception e) {
         stl.writeToLogger( "No request received "
                 + "(telnet test?) ");
         return;
      }

      //
      // Process the request. (write to logger)
      //
      CState c = getMsg(o);
      
      String up = c.getMessage();
      crypto.encrypt(up);
      up = crypto.getMsg();
      
      stl.writeToLogger("Received Message = " + up);
      

   }
}
