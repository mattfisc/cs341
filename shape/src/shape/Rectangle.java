package shape;

public class Rectangle implements Shape{

	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double area() {
		
		return this.getLength() * this.getWidth();
	}

	@Override
	public double circumference() {
		
		return (this.getLength() * 2) + ( this.getWidth()*2);
	}
	
	
}
