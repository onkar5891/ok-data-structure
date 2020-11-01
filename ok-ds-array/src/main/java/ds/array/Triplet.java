package ds.array;

public class Triplet {
    final int first;
    final int second;
    final int third;

    public Triplet(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triplet triplet = (Triplet) o;

        if (first != triplet.first) return false;
        if (second != triplet.second) return false;
        return third == triplet.third;
    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + second;
        result = 31 * result + third;
        return result;
    }
}
