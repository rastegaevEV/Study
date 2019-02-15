package ru.rastegaev.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void print() {
        System.out.printf("Задан диапазон чисел от %.2f до %.2f%n", from, to);
    }

    public String toString() {
        return "от " + from + " до " + to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range[] getIntersectionInterval(Range range2) {
        if ((range2.from >= this.from) && (range2.from <= this.to) && (range2.to >= this.to)) {
            Range[] intersectionRange = new Range[1];
            intersectionRange[0] = new Range (range2.from, this.to);
            return intersectionRange;
        } else if ((this.from >= range2.from && this.from <= range2.to) && !(this.to >= range2.from && this.to <= range2.to)) {
            Range[] intersectionRange = new Range[1];
            intersectionRange[0] = new Range (this.from, range2.to);
            return intersectionRange;
        } else if ((range2.from >= this.from && range2.from <= this.to) && (range2.to >= this.from && range2.to <= this.to)) {
            Range[] intersectionRange = new Range[1];
            intersectionRange[0] = range2;
            return intersectionRange;
        } else if (range2.from <= this.from && range2.to >= this.to) {
            Range[] intersectionRange = new Range[1];
            intersectionRange[0] = this;
            return intersectionRange;
        } else {
            return null;
        }
    }

    public Range[] getIntervalSplicing(Range range2) {

        if ((range2.from >= this.from) && (range2.from <= this.to) && (range2.to >= this.to)) {
            Range[] splicingRange = new Range[1];
            splicingRange[0] = new Range(this.from, range2.to);
            return splicingRange;
        } else if ((this.from >= range2.from && this.from <= range2.to) && !(this.to >= range2.from && this.to <= range2.to)) {
            Range[] splicingRange = new Range[1];
            splicingRange[0] = new Range(range2.from, this.to);
            return splicingRange;
        } else if ((range2.from >= this.from && range2.from <= this.to) && (range2.to >= this.from && range2.to <= this.to)) {
            Range[] splicingRange = new Range[1];
            splicingRange[0] = this;
            return splicingRange;
        } else if (range2.from <= this.from && range2.to >= this.to) {
            Range[] splicingRange = new Range[1];
            splicingRange[0] = range2;
            return splicingRange;
        } else {
            Range[] splicingRange = new Range[2];
            splicingRange[0] = this;
            splicingRange[1] = range2;
            return splicingRange;
        }
    }

    public Range[] getDifferenceInterval(Range range2) {
        if ((range2.from >= this.from) && (range2.from <= this.to) && (range2.to >= this.to)) {
            Range[] differenceRange = new Range[1];
            differenceRange[0] = new Range (this.from, range2.from);
            return differenceRange;
        } else if ((this.from >= range2.from && this.from <= range2.to) && !(this.to >= range2.from && this.to <= range2.to)) {
            Range[] differenceRange = new Range[1];
            differenceRange[0] = new Range (range2.from, this.to);
            return differenceRange;
        } else if ((range2.from >= this.from && range2.from <= this.to) && (range2.to >= this.from && range2.to <= this.to)) {
            Range[] differenceRange = new Range[2];
            differenceRange[0] = new Range (this.from, range2.from);
            differenceRange[1] = new Range (range2.to, this.to);
            return differenceRange;
        }  else if (range2.from <= this.from && range2.to >= this.to) {
            Range[] differenceRange = new Range[2];
            differenceRange[0] = new Range (range2.from, this.from);
            differenceRange[1] = new Range (this.to, range2.to);
            return differenceRange;
        } else {
            Range[] differenceRange = new Range[1];
            differenceRange[0] = this;
            return differenceRange;
        }
    }
}
