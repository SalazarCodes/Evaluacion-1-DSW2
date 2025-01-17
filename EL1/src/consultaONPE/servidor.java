package consultaONPE;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import consultaONPE.*;

public class servidor {

	private static clienteONPE obj_onpe;
	private static ArrayList<clienteONPE> lst_onpe;
	
	public static void main(String[] args) {
	
		ArrayList<clienteONPE> dni;
		ServerSocket ss=null;
		String a;
		try
		{
			ss=new ServerSocket(5051);
			
			Socket sl=ss.accept();
			InputStream is=sl.getInputStream();
			DataInputStream dis=new DataInputStream(is);
			a=dis.readUTF();
			System.out.println("Su DNI es : "+a);
			
			dni = buscaOnpe(a);				
			
			Socket sc=new Socket("localhost",5052);
			OutputStream os=sc.getOutputStream();
			DataOutputStream dos=new DataOutputStream(os);
			dos.writeUTF("La informacion de su lugar de votacon es : \n Lugar : "+dni.get(0).getLugar()+
																	"\n Es miembro? "+dni.get(0).getMiembro()+
																	"\n Direccion : "+dni.get(0).getDireccion()+
																	"\n Ubicacion : "+dni.get(0).getUbicacion()+
																	"\n Nro de mesa :"+dni.get(0).getNromesa());

			
		}catch (IOException e) {
			System.out.println(e.getMessage().toString());
		}
	}
	
	private static void llenardatos() {
		lst_onpe=new ArrayList<clienteONPE>();
		obj_onpe=new clienteONPE("46551019","Colegio Marianistas","SI","Jiron Huaraz 1472 - Jesus Maria","Salon 931","Mesa 146");
		lst_onpe.add(obj_onpe);
		
		obj_onpe=new clienteONPE("84545974","Colegio Trilce","SI","Avenida la marina 2245 - San Miguel","Salon 5A","Mesa 11");
		lst_onpe.add(obj_onpe);
		
		obj_onpe=new clienteONPE("25594993","Colegio La Salle","NO","Avenida Arica 455 - Bre�a","Salon 1C","Mesa 93");
		lst_onpe.add(obj_onpe);
		
		obj_onpe=new clienteONPE("72501550","Colegio San Judas Tadeo","SI","Avenida Proceres 2873 - San Juan de Lurigancho","Salon abejitas","Mesa 11");
		lst_onpe.add(obj_onpe);
	
	}

	private static ArrayList<clienteONPE> buscaOnpe(String dni) {
		
		ArrayList<clienteONPE> lista = new ArrayList<>();
		llenardatos();
		for (clienteONPE o:lst_onpe){			
			if(o.getDni().equals(dni)){
				o.getLugar();
				o.getMiembro();
				o.getDireccion();
				o.getUbicacion();
				o.getNromesa();
				lista.add(o);
			}
		}
		return lista;
	}
}
