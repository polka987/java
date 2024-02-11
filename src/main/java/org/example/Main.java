package org.example;

import java.util.Scanner;

public class Main {
    // Радиус земли
    final static int rad = 6372795;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double llat1, llon1, llat2, llon2;
        // Координаты 1 точки
        System.out.println("Введите координаты первой географической точки(в градусах):");
        System.out.println("Широта: ");
        llat1 = scanner.nextDouble();
        System.out.println("Долгота: ");
        llon1 = scanner.nextDouble();

        // Координаты 2 точки
        System.out.println("Введите координаты второй географической точки(в градусах):");
        System.out.println("Широта: ");
        llat2 = scanner.nextDouble();
        System.out.println("Долгота: ");
        llon2 = scanner.nextDouble();

        // Вычисление расстояния между точками
        double distance = Math.round(calc(llat1, llon1, llat2, llon2) * 1000.0) / 1000.0;

        System.out.println("Расстояние между двумя точками составляет " + distance + " км");

        scanner.close();
    }
    public static double calc(double llat1, double llong1, double llat2, double llong2){
        // Из градусов в радианы
        double lat1Rad = Math.toRadians(llat1);
        double lon1Rad = Math.toRadians(llong1);
        double lat2Rad = Math.toRadians(llat2);
        double lon2Rad = Math.toRadians(llong2);

        // Косинусы и синусы сторон
        double cosLat1 = Math.cos(lat1Rad);
        double cosLat2 = Math.cos(lat2Rad);
        double sinLat1 = Math.sin(lat1Rad);
        double sinLat2 = Math.sin(lat2Rad);

        // Разница широт и долгот
        double delta = lon1Rad - lon2Rad;
        double cosDelta = Math.cos(delta);
        double sinDelta = Math.sin(delta);

        // Формула гаверсинусов
        double a = Math.sqrt(Math.pow(cosLat2 * sinDelta, 2) + Math.pow(cosLat1 * sinLat2 - sinLat1 * cosLat2 * cosDelta,2));
        double b = sinLat1 * sinLat2 + cosLat1 * cosLat2 * cosDelta;
        double c = Math.atan2(a, b);

        // Вычисление расстояния
        return rad * c;
    }
}