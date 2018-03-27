package com.e1b.creators;

import java.util.Date;

import com.e1b.entities.Incidencia;
import com.e1b.entities.utils.Status;

public class InciCreator 
{

	public static Incidencia parseIncidence(String data) throws Exception
	{
		Incidencia inci = new Incidencia();
		
		String[] values =  data.split(":|,");
		
		for(int i = 0; i< values.length; i++)
		{
			if(values[i] == "name")
				inci.setName(values[i+1]);
			if(values[i] == "description")
				inci.setDescription(values[i+1]);
			if(values[i] == "expireAt")
			{
				//TODO parsear fechas cuando nos las manden en formato legible
				inci.setExpirationgDate(new Date());
			}
			if(values[i] == "state")
			{
				switch(values[i+1])
				{
				case "OPEN":
					inci.setStatus(Status.ABIERTA);
					break;
				case "CLOSED":
					inci.setStatus(Status.CERRADA);
					break;
				case "ANNULATED":
					inci.setStatus(Status.ANULADA);
					break;
				case "IN_PROCESS":
					inci.setStatus(Status.EN_PROCESO);
					break;
				default:
					throw new Exception("Error error asignando estados a la incidencia");
					
				}
			}
			if(values[i] == "notifcation")
				if(values[i+1] == "yes")
					inci.setHasNoti(true);
			
		}
		
		inci.setOperario(null);
		
		return inci;
	}
	
}
