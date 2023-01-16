import java.util.Scanner;



public class Main {
    static class Luchador {
        String avatar;
        String nombre;

        int ataque;
        int defensa;
        int vida = 100;

        public Luchador(String avatar, String nombre, int ataque, int defensa) {
            this.avatar = avatar;
            this.nombre = nombre;
            this.ataque = ataque;
            this.defensa = defensa;
        }

        void atacar(int ataque, int defensa, Luchador other){
            this.ataque -= ataque;
            other.defensa -= defensa;

            if (ataque > defensa) {
                other.vida -= ataque - defensa;
            }
        }

        @Override
        public String toString() {
            return this.avatar + String.format(" %-10s",this.nombre) + String.format("  ❤ %-3d", vida) + String.format("  🗡 %-3d", ataque) + String.format("  🛡 %-3d", defensa);
        }
    }

    static class Pelea {
        Luchador luchador1;
        Luchador luchador2;

        public Pelea(Luchador luchador1, Luchador luchador2) {
            this.luchador1 = luchador1;
            this.luchador2 = luchador2;
        }
    }

    static class ConsoleFighters {
        Scanner scanner = new Scanner(System.in);

        Luchador manuel = new Luchador("🥷", "Manuel", 30, 70);
        Luchador hector = new Luchador("🎅","Hector", 40,60);
        Luchador carlos = new Luchador("🧛", "Carlos", 50,50);
        Luchador josep = new Luchador("🧟", "Josep", 60, 40);
        Luchador alex = new Luchador("🧙", "Alex", 70, 30);
        Luchador jp = new Luchador("🦸","JP", 80, 20);

        Luchador seleccionarLuchador(String player){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(manuel);
            System.out.println(hector);
            System.out.println(carlos);
            System.out.println(josep);
            System.out.println(alex);
            System.out.println(jp);

            System.out.println(player + " select:");

            switch (scanner.nextLine()){
                case "1":
                    return manuel;
                case "2":
                    return hector;
                case "3":
                    return carlos;
                case "4":
                    return josep;
                case "5":
                    return alex;
                default:
                    return jp;
            }
        }



        void start(){
            Luchador p1 = seleccionarLuchador("P1");
            Luchador p2 = seleccionarLuchador("P2");

            Pelea pelea = new Pelea(p1, p2);

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println(p1);
            System.out.println(p2);
            System.out.println();
            System.out.println();

            while (true) {

                System.out.print(p1.avatar + p1.nombre + "   ataque / defensa: ");
                int ataqueP1 = scanner.nextInt();
                int defensaP1 = scanner.nextInt();

                System.out.print(p2.avatar + p2.nombre + "   ataque / defensa: ");
                int ataqueP2 = scanner.nextInt();
                int defensaP2 = scanner.nextInt();

                pelea.luchador1.atacar(ataqueP1, defensaP2, p2);
                pelea.luchador2.atacar(ataqueP2, defensaP1, p1);

                System.out.print("\033[H\033[2J");
                System.out.flush();

//                soutTitle();
                System.out.println(p1);
                System.out.println(p2);
                System.out.println();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        new ConsoleFighters().start();
    }
}