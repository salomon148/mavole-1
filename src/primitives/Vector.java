package primitives;

import static primitives.Point3D.ZERO;
import static primitives.Util.isZero;

public class Vector {
    Point3D _head;

    /**
     * mainly used constructor
     *
     * @param head
     */
    public Vector(Point3D head) {
        if (head.equals(ZERO)) {
            throw new IllegalArgumentException("vector head cannot be Point(0,0,0)");
        }
        _head = head;
    }

    public Vector(Vector v) {
        _head = v._head;
    }

    /**
     * Vector constructor that gets 3 double numb1ers and create a new vector from them
     *
     * @param x x coordinate value
     * @param y y coordinate value
     * @param z z coordinate value
     */
    public Vector(double x, double y, double z) {

        /**if (new Point3D(new Coordinate(_x), new Coordinate(_y), new Coordinate(_z)).equals(Point3D.ZERO)) {
         throw new IllegalArgumentException("vector cannot be the zero vector");
         }
         this._head = new Point3D(new Coordinate(_x), new Coordinate(_y), new Coordinate(_z));
         **/
        this(new Point3D(x, y, z));
    }

    /**
     * get head
     *
     * @return Point3D which is the vector's head
     */
    public Point3D getHead() {
        return new Point3D(_head._x._coord, _head._y._coord, _head._z._coord);
    }


    /**
     * subtract function
     *
     * @param v-Vector
     * @return vector- subtracts one vector from the other and returns the result
     */
    public Vector subtract(Vector v) {
        return new Vector(
                _head._x._coord - v._head._x._coord,
                _head._y._coord - v._head._y._coord,
                _head._z._coord - v._head._z._coord
        );
    }

    /**
     * add function
     *
     * @param v-Vector
     * @return vector- adds to vectors together and returns the result
     */
    public Vector add(Vector v) {
        return new Vector(
                _head._x._coord + v._head._x._coord,
                _head._y._coord + v._head._y._coord,
                _head._z._coord + v._head._z._coord
        );
    }

    /**
     * scale function
     *
     * @param d-double
     * @return vector- returns a vector multiplied by a scalar=a*v=(a*v1,a*v2,a*v3)
     */
    public Vector scale(double d) {
        return new Vector(_head._x._coord * d, _head._y._coord * d, _head._z._coord * d);
    }

    public double dotProduct(Vector v) {
        double u1 = _head._x._coord;
        double u2 = _head._y._coord;
        double u3 = _head._z._coord;
        double v1 = v._head._x._coord;
        double v2 = v._head._y._coord;
        double v3 = v._head._z._coord;

        return (u1 * v1 + u2 * v2 + u3 * v3);
    }

    public Vector crossProduct(Vector v) {
        double u1 = _head._x._coord;
        double u2 = _head._y._coord;
        double u3 = _head._z._coord;
        double v1 = v._head._x._coord;
        double v2 = v._head._y._coord;
        double v3 = v._head._z._coord;

        return new Vector(new Point3D(
                u2 * v3 - u3 * v2,
                u3 * v1 - u1 * v3,
                u1 * v2 - u2 * v1
        ));
    }

    /**
     * *
     *
     * @return the squared vector's length
     */
    public double lengthSquared() {
        return (_head._x._coord * _head._x._coord +
                _head._y._coord * _head._y._coord +
                _head._z._coord * _head._z._coord);
    }

    /**
     * @return the vector's length
     */
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    /**
     * Normalizes this vector and return it
     *
     * @return
     */
    public Vector normalize() {
        double length = this.length();

        //cannot divide by 0
        if (isZero(length)) {
            throw new ArithmeticException("divide by Zero");
        }

        double x = this._head._x._coord;
        double y = this._head._y._coord;
        double z = this._head._z._coord;

        this._head = new Point3D(x / length, y / length, z / length);

        return this;

    }

    /**
     * @return a new normalized vector corresponding to head
     */
    public Vector normalized() {
        Vector myVector = new Vector(_head);
        return myVector.normalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return _head.equals(vector._head);
    }

    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }
}
