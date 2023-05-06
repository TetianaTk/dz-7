/*
Написати enum для планети сонячної системи. Клас повинен містити такі дані:
порядковий номер від сонця (для супутників застосовується номер планети)
віддаленість від попередньої планети (для меркурія 0)
віддаленість від сонця
радіус
попередня планета
наступна планета
Відстань від попередньої планети вказується явно.
Відстань від сонця обчислюється в конструкторі.
Точність даних не є важливою, допускається застосування невеликих чисел.
 */

public enum SolarSystem {

  MERCURY("Mercury", 1, 0.0, 50.0, null, false),
  VENUS("Venus", 2, 1500.0, 100.0, MERCURY, false),
  EARTH("Earth", 3, 3000.0, 75.0, VENUS, false),
  MOON("Moon", 3, 300.0, 5.0, EARTH,true),
  MARS("Mars", 4, 6000, 50, EARTH, false),
  JUPITER("Jupiter", 5, 30000, 1000, MARS, false),
  GANYMEDE("Ganymede", 5, 550, 80, JUPITER,true),
  SATURN("Saturn", 6, 50000, 900, JUPITER, false),
  TITANIUM("Titanium", 6, 1000, 50, SATURN, true),
  URANUS("Uranus", 7, 90000, 400, SATURN, false),
  NEPTUNE("Neptune", 8, 200000, 380, URANUS, false),
  PLUTO("Pluto", 9, 400000, 100, NEPTUNE, false)
  ;

  final static double MERCURY_DISTANCE_TO_SUN = 1000.0;

  private String planetName;
  private int number;
  private double distanceToPrevious;
  private double distanceToSun;
  private double radius;
  private SolarSystem previousPlanet;
  private SolarSystem nextPlanet;
  private boolean satellite;

  SolarSystem() {
  }

  SolarSystem(String planetName, int number, double distanceToPrevious, double radius,
      SolarSystem previousPlanet, boolean satellite) {
    this.planetName = planetName;
    this.number = number;
    this.distanceToPrevious = distanceToPrevious; //Відстань від попередньої планети вказується явно
    this.radius = radius;
    this.satellite = satellite;
    this.previousPlanet = previousPlanet; // для супутника до його планети
    switch (planetName){    //Відстань від сонця обчислюється в конструкторі
      case "Mercury":
        this.distanceToSun = MERCURY_DISTANCE_TO_SUN; break;
      case "Venus":
      case "Earth":
      case "Mars":
      case "Jupiter":
      case "Saturn":
      case "Uranus":
      case "Neptune":
      case "Pluto":
        this.distanceToSun = previousPlanet.distanceToSun + distanceToPrevious; break;
      case "Moon":
      case "Ganymede":
      case "Titanium":
        this.distanceToSun = previousPlanet.distanceToSun; break;
    }
  }

  public SolarSystem getPreviousPlanet() {
    return previousPlanet;
  }

  public SolarSystem getNextPlanet() {
    if (nextPlanet != null) return nextPlanet;
    if (number < 9) {
      for (int i = values().length-1; i > 0; i--) {
        if (values()[i].number == number + 1 & !values()[i].satellite)
          return nextPlanet = values()[i];
      }
    }
    return null;
  }

  public boolean isSatellite() {
    return satellite;
  }

  public String getPlanetName() {
    return planetName;
  }

  public int getNumber() {
    return number;
  }

  public double getDistanceToPrevious() {
    return distanceToPrevious;
  }

  public double getDistanceToSun() {
    return distanceToSun;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public String toString() {
    return String.format("%s, num:%d, R:%.2f, to Sun:%.2f, to previous:%.2f",
        planetName, number, radius, distanceToSun, distanceToPrevious);
  }
}
