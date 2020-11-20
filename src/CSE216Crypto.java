/**
 * <p>
 * Title: CSE216Crypto</p>
 *
 * <p>
 * Description: This class handles
 * the crypto operations for the
 * CSE216 Subsystem.
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

import java.math.BigInteger;
import java.nio.charset.Charset;

public class CSE216Crypto 
{
   private String tStr = " ";
   
   private BigInteger p = new BigInteger(
 		  "23973131022914996346071393858876827486275304524239358526904124826518948010013");
   private BigInteger q = new BigInteger(
 		  "47682209267361752906439234498452546764741727765730925307147436953319593264669");
   private BigInteger n = new BigInteger(
 		  "11430918502285149779499046340017015199914441182466056855548973758723371013526"
 		  + "03883289432913006822644664798203011634939049630050313222214071696535571130697");
   private BigInteger tot = new BigInteger(
 		  "28577296255712874448747615850042537999786102956165142138872434396808427533813"
 		  + "3056987285659064392533509110218409345980504335020007347040627479174257464004");
   
   private BigInteger e = new BigInteger("65537");
   private BigInteger d = e.modInverse(tot);
   
   public void encrypt(String s) { 
	  BigInteger m = new BigInteger(s.getBytes(Charset.defaultCharset()));
	  BigInteger c = m.modPow(e, n);
	      
      tStr = c.toString();
   }
   
   public void decrypt(String s) { 
	  BigInteger c = new BigInteger(s);
      BigInteger m = c.modPow(d, n);
      
      tStr = new String(m.toByteArray(), Charset.defaultCharset());
   }
   
   public String getMsg()    { return tStr; }
   
}
