/*-----------------------------------------------------------------------------

        Module          : Util.AppContext

        Purpose         : Contextual info about app (file locations etc)

        Programmer      : Ted Dumitrescu

        Date Started    : 7/8/2011

        Updates         :

-----------------------------------------------------------------------------*/

package Util;

import java.io.*;
import java.net.*;
import javax.swing.JApplet;
public class AppContext
{
  public static final boolean CMME_OPT_TESTING=true,
   * Returns path to base running directory.
   * JAR path stuff horked from the internet
   *
   * @param o - object to use for getting base path
   * @return string with base path
   */
  static String getBaseAppPath()
  {
    /* jar path */
    Class c=new AppContext().getClass();
    String JARurl=c.getResource(
      "/"+c.getName().replaceAll("\\.","/")+".class").toString();
    JARurl=JARurl.substring(4).replaceFirst("/[^/]+\\.jar!.*$","/");
    try
      {
        File dir=new File(new URL(JARurl).toURI());
        JARurl=dir.getAbsolutePath();
      }
    catch (MalformedURLException mue)
      {
        JARurl=null;
      }
    catch (URISyntaxException ue)
      {
        JARurl=null;
      }

    /* regular running path */
    String DIRurl=null;
    try
      {
        DIRurl=new File(".").getCanonicalPath();
      }
    catch (Exception e)
      {
        DIRurl=null;
      }

    return JARurl==null ? DIRurl : JARurl;
  }
}