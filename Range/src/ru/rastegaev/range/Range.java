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

    public Range getIntersection(Range range) {
        if ((range.from >= this.from) && (range.from <= this.to) && (range.to >= this.to)) {
            return new Range(range.from, this.to);
        } else if ((this.from >= range.from && this.from <= range.to) && (this.to < range.from || this.to > range.to)) {
            return new Range(this.from, range.to);
        } else if ((range.from >= this.from && range.from <= this.to) && (range.to >= this.from && range.to <= this.to)) {
            return new Range(range.from, range.to);
        } else if (range.from <= this.from && range.to >= this.to) {
            return new Range(this.from, this.to);
        } else {
            return null;
        }
    }

    public Range[] getUnion(Range range) {
        if ((range.from >= this.from) && (range.from <= this.to) && (range.to >= this.to)) {
            return new Range[]{new Range(this.from, range.to)};
        } else if ((this.from >= range.from && this.from <= range.to) && (this.to < range.from || this.to > range.to)) {
            return new Range[]{new Range(range.from, this.to)};
        } else if ((range.from >= this.from && range.from <= this.to) && (range.to >= this.from && range.to <= this.to)) {
            return new Range[]{new Range(this.from, this.to)};
        } else if (range.from <= this.from && range.to >= this.to) {
            return new Range[]{new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        }
    }

    public Range[] getDifference(Range range) {
        if ((range.from >= this.from) && (range.from <= this.to) && (range.to >= this.to)) {
            return new Range[]{new Range(this.from, range.from)};
        } else if ((range.from <= this.from && range.to >= this.from && range.to <= this.to)) {
            return new Range[]{new Range(range.to, this.to)};
        } else if ((this.from >= range.from && this.from <= range.to) && (this.to < range.from || this.to > range.to)) {
            return new Range[]{new Range(range.from, this.to)};
        } else if ((range.from >= this.from && range.from <= this.to) && (range.to >= this.from && range.to <= this.to)) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        } else if (range.from <= this.from && range.to >= this.to) {
            return new Range[0];
        } else {
            return new Range[]{new Range(this.from, this.to)};
        }
    }
}
