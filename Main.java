public class Main {

  public static void main(String[] args) {
    System.out.printf("%s, previous:%s, next:%s \n",
        SolarSystem.VENUS.getPlanetName(),
        SolarSystem.VENUS.getPreviousPlanet().getPlanetName(),
        SolarSystem.VENUS.getNextPlanet().getPlanetName());
    System.out.println("Planets:");
    for(SolarSystem c : SolarSystem.values())
      if (!c.isSatellite()) System.out.println(c.toString());
    System.out.println("Satellites:");
    for(SolarSystem c : SolarSystem.values())
      if (c.isSatellite()) System.out.println(c.toString());

  }

}
