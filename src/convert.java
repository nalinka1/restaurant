//original


public class convert {
        public String contry;
        public double value;
        public double converted=0;

    convert(String con, double val) {
        this.contry = con;
        this.value = val;
    }
        
        
    public void functions(){
        if (contry.equalsIgnoreCase("Sri Lanka")){
            this.setConverted(value);
        }
        else if(contry.equalsIgnoreCase("America")){
            this.value= value*0.0066;
            this.setConverted(value);
        }
        else if(contry.equalsIgnoreCase("India")){
            this.value=value*0.42;
            this.setConverted(value);
        }
        else if(contry.equalsIgnoreCase("China")){
            this.value=value*0.043;
            this.setConverted(value);

        }
        else if(contry.equalsIgnoreCase("japan")){
            this.value=value*0.72;
            this.setConverted(value);
        }

    }

    public double getConverted() {
        return this.converted;
    }

    public void setConverted(double converted) {
        this.converted = converted;
    }
    
    
    
}
