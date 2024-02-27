package maven_Demo.dto;

public class Gadgets {
	    private int id;
        private String gname;
        private String gbrand;
        private double price;
        private int warranty;
        private String colour;
        private String upGName;
        private String dGName;
		public String getdGName() {
			return dGName;
		}
		public void setdGName(String dGName) {
			this.dGName = dGName;
		}
		public String getUpGName() {
			return upGName;
		}
		public void setUpGName(String upGName) {
			this.upGName = upGName;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getGname() {
			return gname;
		}
		public void setGname(String gname) {
			this.gname = gname;
		}
		public String getgbrand() {
			return gbrand;
		}
		public void setgBrand(String gbrand) {
			this.gbrand = gbrand;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getWarranty() {
			return warranty;
		}
		public void setWarrantry(int warranty) {
			this.warranty = warranty;
		}
		public String getColour() {
			return colour;
		}
		public void setColour(String colour) {
			this.colour = colour;
		}
		
		public Gadgets(int id, String gname, String gbrand, double price, int warranty, String colour) {
			super();
			this.id = id;
			this.gname = gname;
			this.gbrand = gbrand;
			this.price = price;
			this.warranty = warranty;
			this.colour = colour;
		}
		public Gadgets(int id, String gname, String gbrand, double price, int warranty, String colour,String upGName,String dGName) {
			super();
			this.id = id;
			this.gname = gname;
			this.gbrand = gbrand;
			this.price = price;
			this.warranty = warranty;
			this.colour = colour;
			this.upGName = upGName;
			this.dGName = dGName;
		}
		public Gadgets(int id2, String gName2, String gBrand2, double price2, int warranty2, String colour2, String upGName) {
			super();
			this.id=id2;
			this.gname = gName2;
			this.gbrand = gBrand2;
			this.price = price2;
			this.warranty = warranty2;
			this.colour = colour2;
			this.upGName=upGName;
		}
		public Gadgets(String dGName) {
			super();
			this.setdGName(dGName);
		}
		@Override
		public String toString() {
			return "Gadgets [id=" + id + ", gname=" + gname + ", gbrand=" + gbrand + ", price=" + price + ", warranty="
					+ warranty + ", colour=" + colour + ", upGName=" + upGName + ", dGName=" + dGName + "]";
		}
	
		  
}
