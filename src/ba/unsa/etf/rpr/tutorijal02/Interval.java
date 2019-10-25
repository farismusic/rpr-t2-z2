package ba.unsa.etf.rpr.tutorijal02;

public class Interval {

    private double pocetna, krajnja;
    private boolean pripadaLiPocetna, pripadaLiKrajnja;


    public Interval(double v, double v1, boolean b, boolean b1) {

        if(v > v1) throw new IllegalArgumentException();

        pocetna = v;
        krajnja = v1;
        pripadaLiPocetna = b;
        pripadaLiKrajnja = b1;
    }

    public Interval() {
        pocetna = 0;
        krajnja = 0;

        pripadaLiPocetna = false;
        pripadaLiKrajnja = false;

    }

    public boolean isIn(double v) {
        if(v > pocetna && v < krajnja) return true;
        else if(v == pocetna && pripadaLiPocetna) return true;
        else if(v == krajnja && pripadaLiKrajnja) return true;
        else return false;

    }

    public boolean isNull() {
        if(pocetna == 0 && krajnja == 0 && pripadaLiPocetna == false && pripadaLiKrajnja == false) return true;
        else return  false;
    }

    public Interval intersect(Interval interval) {

        if(pocetna < interval.pocetna){
            if(krajnja < interval.krajnja){
                return new Interval(interval.pocetna, krajnja, interval.pripadaLiPocetna, pripadaLiKrajnja);
            }else if( krajnja > interval.krajnja){
                return interval;
            }
        } else if (pocetna > interval.pocetna) {

            if(krajnja < interval.pocetna){
                return new Interval(pocetna, interval.krajnja, pripadaLiPocetna, interval.pripadaLiKrajnja);
            }else if( krajnja > interval.pocetna){
                return this;
            }

        } else if(pocetna == interval.pocetna){
            if(krajnja > interval.krajnja){
                return new Interval(pocetna, interval.krajnja, pripadaLiPocetna & interval.pripadaLiPocetna, interval.pripadaLiKrajnja);
            }else if(krajnja < interval.krajnja){
                return new Interval(pocetna, krajnja, pripadaLiPocetna & interval.pripadaLiPocetna, pripadaLiKrajnja);
            }else {
                return new Interval(pocetna, krajnja, pripadaLiPocetna & interval.pripadaLiPocetna, pripadaLiKrajnja & interval.pripadaLiKrajnja);
            }

        } else if (krajnja == interval.krajnja){

            if(pocetna > interval.pocetna){
                return new Interval(pocetna, krajnja, pripadaLiPocetna,pripadaLiKrajnja & interval.pripadaLiKrajnja);
            }else if(pocetna < interval.pocetna){
                return new Interval(interval.pocetna, krajnja, interval.pripadaLiPocetna, pripadaLiKrajnja & interval.pripadaLiKrajnja);
            }else {
                return new Interval(pocetna, krajnja, pripadaLiPocetna & interval.pripadaLiPocetna, pripadaLiKrajnja & interval.pripadaLiKrajnja);
            }

        }

        return new Interval();

    }

    public static Interval intersect(Interval interval, Interval interval2) {
        if(interval.pocetna < interval2.pocetna){
            if(interval.krajnja < interval2.krajnja){
                return new Interval(interval2.pocetna, interval.krajnja, interval2.pripadaLiPocetna, interval.pripadaLiKrajnja);
            }else if(interval.krajnja > interval2.krajnja){
                return interval2;
            }
        } else if (interval.pocetna > interval2.pocetna) {

            if(interval.krajnja < interval2.pocetna){
                return new Interval(interval.pocetna, interval2.krajnja, interval.pripadaLiPocetna, interval2.pripadaLiKrajnja);
            }else if(interval.krajnja > interval2.pocetna){
                return interval;
            }

        } else if(interval.pocetna == interval2.pocetna){
            if(interval.krajnja > interval2.krajnja){
                return new Interval(interval.pocetna, interval2.krajnja, interval.pripadaLiPocetna & interval2.pripadaLiPocetna, interval2.pripadaLiKrajnja);
            }else if(interval.krajnja < interval2.krajnja){
                return new Interval(interval.pocetna, interval.krajnja, interval.pripadaLiPocetna & interval2.pripadaLiPocetna, interval.pripadaLiKrajnja);
            }else {
                return new Interval(interval.pocetna, interval.krajnja, interval.pripadaLiPocetna & interval2.pripadaLiPocetna, interval.pripadaLiKrajnja & interval2.pripadaLiKrajnja);
            }

        } else if (interval.krajnja == interval2.krajnja){

            if(interval.pocetna > interval2.pocetna){
                return new Interval(interval.pocetna, interval.krajnja, interval.pripadaLiPocetna,interval.pripadaLiKrajnja & interval2.pripadaLiKrajnja);
            }else if(interval.pocetna < interval2.pocetna){
                return new Interval(interval2.pocetna, interval.krajnja, interval2.pripadaLiPocetna, interval.pripadaLiKrajnja & interval2.pripadaLiKrajnja);
            }else {
                return new Interval(interval.pocetna, interval.krajnja, interval.pripadaLiPocetna & interval2.pripadaLiPocetna, interval.pripadaLiKrajnja & interval2.pripadaLiKrajnja);
            }

        }

        return new Interval();
    }

    @Override
    public String toString() {
        String format = "";

        if(isNull()) {
            return new String("()");
        }
        if (pripadaLiPocetna) format += "[";
        else format += "(";

        format += pocetna + "," + krajnja;

        if (pripadaLiKrajnja) format += "]";
        else format += ")";

        return format;
    }

    @Override
    public boolean equals(Object obj) {
        Interval i = (Interval) obj;

        if(this.pocetna == i.pocetna && this.krajnja == i.krajnja && this.pripadaLiPocetna == i.pripadaLiPocetna && this.pripadaLiKrajnja == i.pripadaLiKrajnja) return true;
        else return false;
    }
}
