package com.ll.level2.p87377;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] solution(int[][] line) {
        // 교점들 구하고
        Points points = intersections(line);
        // 매트릭스로 옮긴다.
        char[][] matrix = transformToMatrix(points);
        return drawOnCoordinate(matrix);
    }

    public Point intersection(int[] line1, int[] line2) {
        double A = line1[0];
        double B = line1[1];
        double E = line1[2];

        double C = line2[0];
        double D = line2[1];
        double F = line2[2];

        double divisor = (A * D - B * C);

        if (divisor == 0) {
            return null;
        }


        double x = (B * F - E * D) / divisor;
        double y = (E * C - A * F) / divisor;

        if (x != (long) x) {
            return null;
        }
        if (y != (long) y) {
            return null;
        }
        return Point.of(x, y);
    }

    public Points intersections(int[][] line) {
        Points points = Points.of();

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] line1 = line[i];
                int[] line2 = line[j];

                Point point = intersection(line1, line2);

                if (point != null) {
                    points.add(point);
                }
            }
        }
        return points;
    }



    public char[][] emptyMatrix(Points points) {
        Point minPoint = points.getMinPoint();
        Point maxPoint = points.getMaxPoint();

        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);

        char[][] matrix = new char[height][width];

        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, '.'));
        return matrix;
    }

    public Points positivePoints(Points points) {
        Point minPoint = points.getMinPoint();
        return Points.of(
                points.stream()
                        .map(p -> Point.of(p.x - minPoint.x, p.y - minPoint.y))
                        .toArray(Point[]::new)
        );
    }

    public char[][] transformToMatrix(Points points) {
        char[][] matrix = emptyMatrix(points);
        points = positivePoints(points);

        points.forEach(p -> matrix[(int) p.y][(int) p.x] = '*');
        return matrix;
    }

    public String[] drawOnCoordinate(char[][] matrix) {
        return Ut.revRange(0, matrix.length)
                .boxed()
                .map(i -> matrix[i])
                .map(row -> new String(row))
                .toArray(String[]::new);
    }
}

class Point {
    public final long x;
    public final long y;

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(long x, long y) {
        return new Point(x, y);
    }

    public static Point of(double x, double y) {
        return of((long) x, (long) y);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
class Points implements Iterable<Point>{
    private final Set<Point> data;

    private Points(Set<Point> data) {
        this.data = data;
    }

    // Point... 는 Point[] 와 같은 뜻
    // Point... 의 특수기능 : 가변인자
    // Points.of(arg1);
    // Points.of(arg1, arg2);
    // Points.of(arg1, arg2, agr3);
    public static Points of(Point... pointArray) {
        // 입력받은 배열을 HashSet 형태로 하다.
        // Collectors.toSet() 를 사용하지 않는 이유 : 우리는 mutable 한것을 원한다.
        // mutable : 수정가능
        // immutable : 수정불가능(add, remove 등이 안됨)
        return new Points(
                Arrays.stream(pointArray)
                        .collect(Collectors.toCollection(HashSet::new))
        );
    }
    public boolean add(Point point) {
        return data.add(point);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Points points = (Points) o;
        return Objects.equals(data, points.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public Iterator<Point> iterator() {
        return data.iterator();
    }
    public Stream<Point> stream(){
        return data.stream();
    }
    public Point getMinPoint() {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point point :
                data) {
            x = Math.min(x, point.x);
            y = Math.min(y, point.y);
        }
        return Point.of(x, y);
    }

    public Point getMaxPoint() {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;

        for (Point point :
                data) {
            x = Math.max(x, point.x);
            y = Math.max(y, point.y);
        }
        return Point.of(x, y);
    }
}
class Ut {
    static IntStream revRange(int from, int to) {
        return IntStream.range(from, to).map(i -> to - i + from - 1);
    }
}
