package java2.homework1;

/*
        1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
        классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
        консоль).
        2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
        должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
        печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
        3. Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
        этот набор препятствий.
        4. * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
        на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
        препятствий не идет.
*/

public class Jump_and_run {
    public static void main(String[] args) {

        Cat serval = new Cat("Тигра", 1000,2);
        Human man = new Human("Петрович", 100,0.5);
        Robot robot = new Robot("C3PO",10000,0);
        //разминка перед стартами )
        Mobile[] arrMobile = {serval,man,robot};

        //создаем массив препятствий
        Prohibitive[] trail = new Prohibitive[6];
        for(int i = 0; i < 3; i++)
            trail[i] = new TreadMill(Math.random()*100);
        for(int i = 3;i < 6;i++ )
            trail[i] = new TheWall(Math.random()*10);

        //соревнования
        for(Prohibitive t: trail){
            for(Mobile m: arrMobile){
                if(t.getClass() == TheWall.class){
                    if(m.goJump(t.getWall()) >= 0)
                        System.out.println(m.getName() + " не преодолел стену, уносите");
                    else
                        System.out.println(m.getName() + " преодолел стену, герой!");
                }
                if(t.getClass() == TreadMill.class){
                    if(m.goRun(t.getTreadMill()) >= 0)
                        System.out.println(m.getName() + " не пробежал, фсё...");
                    else
                        System.out.println(m.getName() + " пробежал, красавчик!");
                }
            }
        }

    }

}
