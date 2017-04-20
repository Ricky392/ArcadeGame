package bin;

import java.io.*;
import java.util.*;

class Timer{
	//Attributi
	int sec = 0;
	int min = 0;
	int hour = 0;

	//Metodi
	{
		for(hour=0;hour<3;hour++){
			for(min=0;min<60;min++){
				System.out.println(hour+":"+ min+":"+sec);
				for(sec=0;sec<60;sec++){
					try{
						Thread.sleep(1000);
					}
					catch(Exception e){}
				}
			}
		}
        }

	//Main
	public static void main(String args[]){
		Timer t = new Timer();
	}
}
