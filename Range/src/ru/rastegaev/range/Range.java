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
        double from = Math.max(this.from, range.from);
        double to = Math.min(this.to, range.to);

        if (from >= to) {
            return null;
        } else {
            return new Range(from, to);
        }
    }

    public Range[] getUnion(Range range) {
        if (Math.max(this.from, range.from) > Math.min(this.to, range.to)) {
            return new Range[]{new Range(this.from, this.to), new Range(range.from, range.to)};
        } else {
            return new Range[]{new Range(Math.min(this.from, range.from), Math.max(this.to, range.to))};
        }
    }

    public Range[] getDifference(Range range) {
        if (Math.max(this.from, range.from) > Math.min(this.to, range.to)) {
            return new Range[]{new Range(this.from, this.to)};
        } else if ((range.from > this.from) && (range.to < this.to)) {
            return new Range[]{new Range(this.from, range.from), new Range(range.to, this.to)};
        } else if (range.from > this.from) {
            return new Range[]{new Range(this.from, range.from)};
        } else if ((range.from < this.from) && (this.to > range.to)) {
            return new Range[]{new Range(range.to, this.to)};
        }
        return new Range[0];
    }
}
