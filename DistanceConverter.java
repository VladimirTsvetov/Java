public class DistanceConverter {
    @BeforeSuite
    public double metersToFoot(double a){
        return a*0.3048;
    }
    @Test(priority = 1)
    public double kmToMils(double a){
        return a*1.853257;
    }
    @Test(priority = 2)
    public double metersToYard(double a){
        return a*0.9144;
    }
    @AfterSuite
    public double smToInch(double a){
        return a*2.54;
    }
}
