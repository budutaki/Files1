import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File games = new File("Games");
        File src = new File(games, "src");
        File res = new File(games, "res");
        File savedgames = new File(games, "savedgames");
        File temp = new File(games, "temp");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");
        File tempTxt = new File(temp, "temp.txt");

        File[] dirs = {games, src, res, savedgames, temp, main, test, drawables, vectors, icons};
        File[] files = {mainJava, utilsJava, tempTxt};
        StringBuilder sb = new StringBuilder();

        for (File dir : dirs) {
            if (dir.mkdir()) {
                sb.append("Создана новая директория " + dir.getName() + "\n");
            } else {
                sb.append("Ошибка создания директории " + "\n");
            }
        }

        for (File file : files) {
            try {
                if (file.createNewFile()) {
                    sb.append("Создан новый файл " + file.getName() + "\n");
                } else {
                    sb.append("Ошибка создания файла" + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter fl = new FileWriter(tempTxt, true)) {
            fl.write(String.valueOf(sb));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

