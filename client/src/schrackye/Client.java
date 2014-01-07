package schrackye;

import java.util.Properties;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.InvalidName;

public class Client {
	private static String id = "Echo";
	private static String kind = "Object";
	
	public static void main(String[] args){
		Echo echo;
    System.out.println("args: "+args[0]);
		try{
			// get a reference to the naming service
			org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
			org.omg.CORBA.Object o = orb.resolve_initial_references("NameService");
		
			NamingContextExt rootContext = NamingContextExtHelper.narrow( o );
			
			NameComponent[] name = new NameComponent[2];
			name[0] = new NameComponent("test","my_context");
			name[1] = new NameComponent(id, kind);
		
			echo = EchoHelper.narrow(rootContext.resolve(name));
			System.out.println("Server says : " + echo.echoString("Juhu funktioniert!"));
		} catch(InvalidName e){
			System.err.println("InvalidNameException occured : " + e.getMessage());
		} catch(Exception e){
			System.err.println("Unknown exception occured : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
