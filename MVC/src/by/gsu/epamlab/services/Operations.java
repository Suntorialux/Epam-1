package by.gsu.epamlab.services;

import by.gsu.epamlab.services.Operations.Operation;

public class Operations {
	public enum Operation{
		SUM{
            @Override
            double result(double ... num){
            	double result=0;
                for(int i=0;i<num.length;i++){
                    result+=num[i];
                }
                return result;
            }
        },
		MIN{
        	@Override
        	double result(double ... num){
        		double result=num[0];
                for(int i=0;i<num.length;i++){
                	 if(num[i]<result){
                         result = num[i];
                     }
                }
                return result;
        	}
        },
		MAX{
        	@Override
        	double result(double ... num){
        		double result=num[0];
                for(int i=0;i<num.length;i++){
                	 if(num[i]>result){
                         result = num[i];
                     }
                }
                return result;
        	}
        },
		AVG{
        	@Override
            double result(double ... num){
                double result=0;
                for(int i=0;i<num.length;i++){
                    result+=num[i];
                }
                return result/num.length;
            }
        };
		
		
		

		abstract double result(double ... num);
	}
	
	 public static boolean isDataOk(String... data){
	        for(int i=0;i<data.length;i++){
	            try{
	                double result= Double.parseDouble(data[i]);
	            }
	            catch (NumberFormatException e){
	                return false;
	            }
	            
	        }
	        return true;
	    }
	    
	    public static double getResult(String oper, String... data)
	    {
	        double result=0;
	        if(isDataOk(data))
	        {
	            double[] datas=new double[data.length];
	            for(int i=0;i<data.length;i++)
	            {
	                datas[i]=Double.parseDouble(data[i]);
	            }
	            result=Operation.valueOf(oper).result(datas);
	        }
	        return result;
	    }
	    
	    public static String arratToString(String... data)
	    {
	        StringBuilder result = new StringBuilder();
	        for(int i = 0;i<data.length;i++){
	        	result.append(data[i]);
	        	if(i == data.length -1){
	        		break;
	        	}
	        	result.append(", ");
	        }
	        return result.toString();
	    }
}
