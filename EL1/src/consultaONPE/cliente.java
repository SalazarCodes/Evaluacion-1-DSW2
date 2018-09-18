package consultaONPE;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class cliente {

	public static void main(String[] args) {
		ServerSocket ss=null;
		try {
			ss=new ServerSocket(5052);
			System.out.println("Ingrese su numero de DNI : ");
			BufferedReader bf=new BufferedReader
					(new InputStreamReader(System.in));
			
			String dni;
			
			dni = bf.readLine();
			Socket sc1 = new Socket("localhost", 5051);
			OutputStream os1 = sc1.getOutputStream();
			DataOutput dos1 = new DataOutputStream(os1);
			dos1.writeUTF(dni);
			
			Socket s1=ss.accept();
			InputStream is=s1.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			System.out.println(dis.readUTF());
		
		}catch (IOException e) {
			System.out.println(e.getMessage().toString());
		}

	}
}
