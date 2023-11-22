package polyhedra;

import java.util.Scanner;

/**
 * Polyhedron representing a cylinder.
 */
public class Cylinder extends Polyhedron {
    /**
     * Height of the cylinder. It must be > 0.
     */
    private double height;

    /**
     * Radius of the cylinder. It must be > 0.
     */
    private double radius;

    /**
     * Default Constructor - set the radius and height to 1.
     */
    public Cylinder()
    {
        this(1, 1);
    }

    /**
     * Construct a cylinder with specified height and radius.
     *
     * @param r desired radius
     * @param h desired height
     */
    public Cylinder(double r, double h)
    {
        super("Cylinder");

        this.radius = r;
        this.height = h;

        double d = this.getDiameter();
        this.boundingBox.setUpperRightVertex(d, d, height);
    }

    /**
     * Retrieve the radius.
     *
     * @return current radius
     */
    public double getRadius()
    {
        return this.radius;
    }

    /**
     * Retrieve the height.
     *
     * @return current height
     */
    public double getHeight()
    {
        return this.height;
    }

    /**
     * Update the radius.
     *
     * @param r desired radius
     */
    public void setRadius(double r)
    {
        this.radius = r;
        boundingBox.setUpperRightVertex(getDiameter(), getDiameter(), getHeight());
    }

    /**
     * Update the height.
     *
     * @param h deisred height
     */
    public void setHeight(double h)
    {
        this.height = h;
        boundingBox.setUpperRightVertex(getDiameter(), getDiameter(), this.height);

    }

    /**
     * Compute diameter.
     *
     * @return diameter
     */
    public final double getDiameter()
    {
        return this.radius * 2;
    }

    @Override
    public Polyhedron clone()
    {
        Cylinder clonedCylinder = new Cylinder(this.radius, this.height);
        clonedCylinder.boundingBox.setUpperRightVertex(this.boundingBox.getUpperRightVertex());
        return clonedCylinder;
    }

    @Override
    public void read(Scanner scanner)
    {
        this.height = scanner.nextDouble();
        this.radius = scanner.nextDouble();

        double h = this.getHeight();
        double d = this.getDiameter();
        boundingBox.setUpperRightVertex(d, d, h);
    }

    @Override
    public void scale(double scalingFactor)
    {
        this.height *= scalingFactor;
        this.radius *= scalingFactor;
        boundingBox.setUpperRightVertex(this.radius * 2, this.radius * 2, this.height);
    }

    @Override
    public String toString() {
        return String.format(
            "%sRadius: %.1f Height: %.1f",
            super.toString(),
            this.radius,
            this.getHeight());
    }
}
