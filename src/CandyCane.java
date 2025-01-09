public class CandyCane extends Candy {

    CandyCane() {
        this.appearance = "⠀⠀⡠⠖⠋⠉⠙⣷⣶⡤⢄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⢀⣾⣷⣦⡀⠀⠀⢸⣿⣷⠀⠀⠉⣷⣶⡤⢄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⣸⠿⠿⢿⣷⡤⢤⣸⣿⡿⠀⠀⠀⢹⣿⡇⠀⠀⠙⣷⣶⠤⣄⣀⠀⠀⠀⠀⠀⠀\n" +
                "⠇⠀⠀⠀⢸⣀⠀⠀⠈⠙⠒⠢⢤⣿⣿⡇⠀⠀⠀⣿⣿⡆⠀⠀⢹⣿⡖⠤⢤⡀\n" +
                "⠸⡀⠀⣠⣾⣿⠏⠓⠲⡀⠀⠀⠀⠀⠈⠉⠓⠢⠤⣿⣿⠃⠀⠀⢀⣿⣿⠀⠀⢱\n" +
                "⠀⠑⢾⣿⣿⡟⠀⠀⢀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠒⠢⠼⣿⣿⠀⢀⠆\n" +
                "⠀⠀⠀⠉⠛⠦⠤⣀⠌⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀\n";
        this.flavor = "minty";
    }

    @Override
    public String inspect() {
        return this.appearance + "\nThis candy tastes very minty. The nutrition facts tells you the sugar contents are questionably high for a candy like this.";
    }
}
