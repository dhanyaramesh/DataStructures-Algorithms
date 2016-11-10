package com.UserBased;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import org.apache.commons.lang3.math.NumberUtils;

public class data_preprocess {
	
	public static String getAuditStatus(String status ){
		if(status.contains("Complied") || status.contains("Complied"))
			return "Complied";
		else if(status.contains("Did not comply")){
			return "Did not comply";
		}
		else if(status.contains("Exempt"))
			return "Exempt";
		return "Pending";
	}
	
	public static String getAuditYear(String year){
		char[] audit_year = new char[4];
		audit_year[0] = year.charAt(year.length()-2);
		audit_year[1] =	year.charAt(year.length()-1);
		
		String newyear=String.valueOf(audit_year);
		newyear = "20"+newyear;
		
		return newyear;

	}
	
	public static String getBenchmark(String s1, String s2, String s3, String s4){
		String[] b={s1,s2,s3,s4};
		int complied = 0;
		int exempt = 0;
		int violation = 0;
		int unavailable =0;
		for(int i=0;i<4;i++){
			if(b[i].equals("Complied"))
				complied++;
			else if(b[i].equals("Exempt"))
				exempt++;
			else if(b[i].contains("Violation"))
				violation++;
			else
				unavailable++;
		}
		
		if(complied >= exempt && complied>= violation && complied >=unavailable)
			return "Complied";
		else if (exempt >= complied && exempt>= violation && exempt >=unavailable)
			return "Exempt";
		else if(violation >= complied && violation >= exempt && violation >=unavailable )
			return "Violation";
		else
			return "Unavailable";	
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String csvFile = "data/Existing_Commercial_Buildings_Energy_Performance_Ordinance_Report.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		ArrayList<String[]> training_Data = new ArrayList<String[]>();
		ArrayList<String[]> test_Data = new ArrayList<String[]>();
		int j=0;
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
			
				String[] each_entry = {"","","","","","","","","","","","","","","","","","","",""};
				
				line = line.replaceAll(",,", ",0,");
				
				String[] entry = line.split(cvsSplitBy);
					
				if(entry.length<66){
					String[] newentry=(String[]) Array.newInstance(String.class, 66);
					for(int h=0;h<entry.length;h++)
						newentry[h] = entry[h];
					newentry[65]= "0";
					entry = newentry;
					
				}
				for(int t=0;t<66;t++){
//					
					if(entry[t]==null){
						entry[t]="0";
						}
				}
				
				
				for(int i=0;i<7;i++){
						each_entry[i] = String.valueOf(entry[i]);
					
				}
				each_entry[0] = entry[0]; //parcel(s)
				each_entry[1] = entry[1]; //building name
				each_entry[2] = entry[3]; //postal code
				each_entry[3] = entry[4]; //floor area
				each_entry[4] = entry[5]; //property type
				each_entry[5] = getAuditYear(entry[19]); // audit year
				each_entry[6] = getAuditStatus(entry[20]);//audit status
				each_entry[7] = getBenchmark(entry[9],entry[11],entry[13],entry[15]);   //benchmark voting
				
				//consolidation and normalisation across four years
				for(int k=1;k<=9;k++){
						each_entry[7+k]="0";
						int temp=0;
						for(int z=0;z<4;z++){
	
							if( entry[20+(9*z)+k] != "null"){
								
								if(!entry[20+(9*z)+k].isEmpty() ){
									
									if(entry[20+(9*z)+k].getClass().getName().equals("String")){
										temp = temp + (int) Integer.parseInt(each_entry[7+k]) + Integer.parseInt(entry[20+(9*z)+k]);
										
									}
									else{
										temp = temp +(int) Integer.parseInt(each_entry[7+k]) + (int) Float.parseFloat(entry[20+(9*z)+k]);
									
									}
									
								}
								
							}
						
						}
						temp=temp/4;
						each_entry[7+k] = String.valueOf(temp);
						
				}
				j++;
				training_Data.add(each_entry);
				

			
	// adding test data
				each_entry[7] = getBenchmark(entry[17],entry[17],entry[17],entry[17]);
				for(int k=1;k<=9;k++){
						if( entry[20+(9*4)+k] != "null"){
							
							if(!entry[20+(9*4)+k].isEmpty() ){
								
								if(entry[20+(9*4)+k].getClass().getName().equals("String")){
									each_entry[7+k] = entry[20+(9*4)+k];
								}
								else{
									each_entry[7+k] = String.valueOf(entry[20+(9*4)+k]);
								}
								
							}
							
						}
				}
			
				test_Data.add(each_entry);

	}
		System.out.println("j" + j);
		
		System.out.println(test_Data.size());
		System.out.println(training_Data.size());
		
		//----- writing training data to csv file--------//
		FileWriter writer = new FileWriter(new File("data/training_data.csv"));

		String[] col_names ={"Parcel(s)","Building Name","Postal Code","Floor Area","Property Type - Self Selected",
					"year","Energy Audit Status","Benchmark","ENERGY STAR Score","Site EUI (kBtu/ft2)",
					"Source EUI (kBtu/ft2)","Percent Better than National Median Site EUI","Percent Better than National Median Source EUI",
					"Total GHG Emissions (Metric Tons CO2e)","Total GHG Emissions Intensity (kgCO2e/ft2)",
					"Weather Normalized Site EUI (kBtu/ft2)","Weather Normalized Source EUI (kBtu/ft2)"};
		for(int i=0;i<col_names.length-1;i++){
			writer.append(col_names[i]);
			writer.append(',');
		}
		writer.append(col_names[col_names.length-1]);
		writer.append('\n');
		for(String[] item : training_Data){
			//user
			for(int i=0;i<item.length-1;i++){
				writer.append(item[i]);
				writer.append(',');
			}
			writer.append(item[item.length-1]);
			writer.append('\n');
			
			}

		writer.flush();
		writer.close();
		
//////////////////////////////////////
		
		//----- writing test data to csv file--------//
				FileWriter writer1 = new FileWriter(new File("data/test_data.csv"));
				for(int i=0;i<col_names.length-1;i++){
					writer1.append(col_names[i]);
					writer1.append(',');
				}
				writer1.append(col_names[col_names.length-1]);
				writer1.append('\n');
				for(String[] item : test_Data){
					//user
					for(int i=0;i<item.length-1;i++){
						writer1.append(item[i]);
						writer1.append(',');
					}
					writer1.append(item[item.length-1]);
					writer1.append('\n');
					
					}

				writer1.flush();
				writer1.close();
		
}

}
